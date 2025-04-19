package com.unicap.adotai.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
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

    @Override
    public String toString() {
        return "Animal{" +
                "id =" + id +
                ", nome ='" + nome + '\'' +
                ", especie ='" + especie + '\'' +
                ", idade =" + idade +
                ", sexo ='" + sexo + '\'' +
                ", data de entrada ='" + dtEntrada + '\'' +
                ", castrado =" + castrado +
                '}';
    }
}
