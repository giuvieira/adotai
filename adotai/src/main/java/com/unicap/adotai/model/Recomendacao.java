package com.unicap.adotai.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Recomendacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    /*
     * 
    recomen_id
    recomen_animal
    recomen_sexo
    recomen_idade
    recomen_curiosidade
    recomend_criterios
     */

    private Long id;
    private String animal;
    private String sexo;
    private int idade;
    private String curiosidade;
    private String criterios;


    
}
