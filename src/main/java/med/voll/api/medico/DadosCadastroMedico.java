package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.DadosEndereco;

public record DadosCadastroMedico(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String telefone,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}") //expressao regular de 4 a 6 numeros
        String crm,
        @NotNull
        Especialidade especialidade,
        @NotNull
        @Valid //valida tb esse obj que vai ter anotation do bean validation
        DadosEndereco endereco) {
}
