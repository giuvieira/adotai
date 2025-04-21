package com.unicap.adotai.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    /*
    anl_id: int*
    anl_nome: string*
    anl_especie: string*
    anl_idade: int*
    anl_sexo: string*
    anl_dtentrada: date*
    anl_castrado: boolean*
    */

    private Long id;
    private String nome;
    private String especie;
    private int idade;
    private String sexo;
    private String dtEntrada;
    private boolean castrado;

    @ManyToOne
    @JoinColumn(name = "ong_id")
    private Ong ong;
}
