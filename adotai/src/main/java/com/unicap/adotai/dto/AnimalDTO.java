package com.unicap.adotai.dto;

import lombok.Data;

@Data
public class AnimalDTO {
    private String nome;
    private String especie;
    private int idade;
    private String sexo;
    private String dtEntrada;
    private boolean castrado;
    private Long ongId; 
}