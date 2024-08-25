package med.voll.api.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarPaciente(){
        var paciente =
                repository.save();

        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    public ResponseEntity listarPaciente(@RequestBody @Valid ){
        return ResponseEntity.ok();
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarPaciente(){

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirPaciente(){

    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity detalharPaciente(){

    }
}
