package com.unicap.adotai.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class Adocao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    /*
     * 
    adoc_id*
    adoc_adotante: int*
    adoc_cpf: int
    adoc_enduser: string*
    adoc_data: date*
    adoc_animal: string*
    adoc_especie: string*
    adoc_sexo: string*
    adoc_idade: int*
    adoc_observacao: string*
    adoc_status: string*
     */

    private Integer adocId;

    @ManyToOne
    @JoinColumn(name = "adotante_id", nullable = false)
    private Adotante adotante;  
 
    private String adocCpf;     
    private String adocEnduser; 
    private LocalDate adocData; 
 
    @ManyToOne
    @JoinColumn(name = "animal_id", nullable = false)
    private Animal animal;      
 
    private String adocObservacao; 
    private String adocStatus;    

}
