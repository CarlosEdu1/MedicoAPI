package med.voll.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello") //se utilizarem "/hello" para requisicao vai cair nesse endpoint
public class HelloController {

    @GetMapping //chegou uma requisicao e ela é do tipo get, chama esse metodo olaMundo
    public String olaMundo(){
        return "Hello World String";
    }
    @PostMapping
    public String cadastroMedico(String nome, String cpf, String sobrenome){
        return cadastroMedico(nome, cpf, sobrenome);    
    }
}
