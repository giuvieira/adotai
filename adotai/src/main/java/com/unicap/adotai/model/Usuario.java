package com.unicap.adotai.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@MappedSuperclass
public abstract class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /* user_id: int
    user_name: varchar(50)
    user_dtnascimento: smallint*
    user_cpf/cnpj: char(14)
    user_email: string
    user_telefone: string
    */
    private Long id;
    
    private String nome;
    private String dtnascimento;
    private String cpfCnpj;
    private String email;
    private String senha;
    private String telefone;
    
}
