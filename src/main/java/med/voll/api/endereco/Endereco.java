package med.voll.api.endereco;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable//essa anotation indica que essa classe não é uma tabela no banco de dados, mas pode ser usado por uma entidade
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {


    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(DadosEndereco dados) { //esse construtor recebe um parametro que é do tipo DadosEndereco, onde tem os dados imutaveis
        this.bairro = dados.bairro();//o atributo bairro dessa classe, vai receber as regras do atributo dado que está dentro da record DadosEndereco
        this.logradouro = dados.logradouro();
        this.cep = dados.cep();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
        this.cidade = dados.cidade();
        this.uf = dados.uf();
    }

    public void atualizarInformacoes(DadosEndereco dadosEndereco) {
        if (dadosEndereco.logradouro() != null) {
            this.logradouro = dadosEndereco.logradouro();
        }
        if (dadosEndereco.logradouro() != null) {
            this.bairro = dadosEndereco.bairro();
        }
        if (dadosEndereco.logradouro() != null) {
            this.cep = dadosEndereco.cep();
        }
        if (dadosEndereco.logradouro() != null) {
            this.numero = dadosEndereco.numero();
        }
        if (dadosEndereco.logradouro() != null) {
            this.complemento = dadosEndereco.complemento();
        }
        if (dadosEndereco.logradouro() != null) {
            this.cidade = dadosEndereco.cidade();
        }
        if (dadosEndereco.logradouro() != null) {
            this.uf = dadosEndereco.uf();
        }
    }
}
