package med.voll.api.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.DadosEndereco;

public record DadosAtualizarMedicos(
        @NotNull
        Long id,
        String telefone,
        String nome,
        DadosEndereco endereco) {
}
