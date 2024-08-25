package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController //serve para identificar que esta classe é uma controladora de api e que lida com requisições
@RequestMapping("/medicos")//serve para mapear a URL que vai receber as requisições
public class MedicoController {

    @Autowired//cria o objeto pra mim sem que eu precise passar ele dentro de um construtor
    private MedicoRepository repository;

    @PostMapping
    @Transactional//garante que todas as informações que estão dentro do metodo sejam enviadas corretamente, caso uma não seja enviada, todas as outras também não vão ser
    public ResponseEntity cadastrarMedico(@RequestBody @Valid DadosCadastroMedico dados, UriComponentsBuilder uriBuilder) {//cadastrar um medico
      var medico = (new Medico(dados)); //o novo obj de medico criado fica guardado dentro de uma variavel
      repository.save(medico);//o novo médico é salvo
      var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
      //esse caminho uri vai ser substituido pelo getId do medico e transformado em uma Uri
      return ResponseEntity.created(uri).body(new DadosDetalhamentoMedico(medico));
      //retorna um obj responseEntity do tipo created com a uri e no corpo da requisição mostra os detalhes do medico
    }

    @GetMapping
    public ResponseEntity <Page<DadosListagemMedico>> listarMedico(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        //interface Pageable que é utilizada para criar paginas dentro dos Jsons
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);

        return ResponseEntity.ok(page);
        //vai retornar um codigo 200 e junto na resposta o objeto de paginação com os dados do medico
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarMedico(@RequestBody @Valid DadosAtualizarMedicos dados) {
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirMedico(@PathVariable Long id) { //excluir é erro 204
        var medicos = repository.getReferenceById(id);
        medicos.excluir();
        return ResponseEntity.noContent().build();
        //ResponseEntity serve para controlar a resposta devolvida
        //essa anotação (PathVariable) serve para identificar que a variavel
        //Long id é a mesma que ta sendo passada na anotation DeleteMapping
    }

    @GetMapping("/{id}")
    public ResponseEntity detalharMedico(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }
}



