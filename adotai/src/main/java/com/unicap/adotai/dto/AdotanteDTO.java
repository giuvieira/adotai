package com.unicap.adotai.dto;

import lombok.Data;

@Data
public class AdotanteDTO {

    private String nome;
    private String dtnascimento;
    private String cpfCnpj;
    private String email;
    private String senha;
    private String telefone;

    private String endereco;
    private String cidade;
    private String estado;
}
