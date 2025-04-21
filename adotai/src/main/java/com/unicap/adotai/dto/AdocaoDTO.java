package com.unicap.adotai.dto;

import lombok.Data;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Data
public class AdocaoDTO {
    @NotNull(message = "O ID do adotante não pode ser nulo.")
    private Long adotanteId;

    @NotBlank(message = "O CPF não pode estar em branco.")
    @Pattern(regexp = "\\d{11}", message = "O CPF deve conter exatamente 11 dígitos.")
    private String adocCpf;

    @NotBlank(message = "O endereço do usuário não pode estar em branco.")
    @Size(max = 255, message = "O endereço do usuário não pode exceder 255 caracteres.")
    private String adocEnduser;

    @NotNull(message = "A data de adoção não pode ser nula.")
    @PastOrPresent(message = "A data de adoção não pode ser no futuro.")
    private LocalDate adocData;

    @NotNull(message = "O ID do animal não pode ser nulo.")
    private Long animalId;

    @Size(max = 500, message = "A observação não pode exceder 500 caracteres.")
    private String adocObservacao;

    @NotBlank(message = "O status da adoção não pode estar em branco.")
    @Size(max = 50, message = "O status da adoção não pode exceder 50 caracteres.")
    private String adocStatus;
}