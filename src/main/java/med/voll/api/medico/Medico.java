package med.voll.api.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;

@Table(name = "medicos")//determina o nome da tabela dentro do banco de dados
@Entity(name = "Medico")// Define a classe como uma entidade JPA, o que significa que ela será mapeada para uma tabela no banco de dados.
@Getter//gera os metodos acessores dos atributos dessa classe
@NoArgsConstructor//gera automaticamente um construtor padrao, sem parametros
@AllArgsConstructor//gera automaticamente um construtor com todos os parametros
@EqualsAndHashCode(of = "id")//compara se um obj que foi criado duas instancias, é o mesmo

public class Medico {

    @Id //marca o campo como chave primaria da entidade de um medico
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;


    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco enredeco;

    private Boolean ativo;

    public Medico(DadosCadastroMedico dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.enredeco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(DadosAtualizarMedicos dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.endereco() != null) {
            this.enredeco.atualizarInformacoes(dados.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
