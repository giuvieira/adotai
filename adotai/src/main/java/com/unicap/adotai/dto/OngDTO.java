package com.unicap.adotai.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class OngDTO {

    @NotBlank(message = "O nome da ONG é obrigatório")
    private String nome;

    @NotBlank(message = "A data de nascimento é obrigatória")
    private String dtnascimento;

    @NotBlank(message = "O CPF/CNPJ é obrigatório")
    private String cpfCnpj;

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @NotBlank(message = "A senha é obrigatória")
    private String senha;

    @NotBlank(message = "O telefone é obrigatório")
    private String telefone;

    @NotBlank(message = "O endereço é obrigatório")
    private String endereco;

    private int idAnimais;
    private String descricaoAnimais;
}
