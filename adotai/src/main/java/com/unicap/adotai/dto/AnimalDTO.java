package com.unicap.adotai.dto;

import lombok.Data;
import jakarta.validation.constraints.*;

@Data
public class AnimalDTO {
    @NotBlank(message = "O nome não pode estar em branco.")
    private String nome;

    @NotBlank(message = "A espécie não pode estar em branco.")
    private String especie;

    @NotNull(message = "A idade não pode ser nula.")
    private int idade;

    @NotBlank(message = "O sexo não pode estar em branco.")
    private String sexo;

    @NotBlank(message = "A data de entrada não pode estar em branco.")
    private String dtEntrada;

    private boolean castrado;

    @NotNull(message = "O ID da ONG não pode ser nulo.")
    private Long ongId; 
}