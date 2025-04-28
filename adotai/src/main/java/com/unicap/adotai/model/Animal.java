package com.unicap.adotai.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
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
    private boolean castrado;

    @Temporal(TemporalType.DATE)
    private java.util.Date dtEntrada;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adotante_id")
    private Adotante adotante;
    @JoinColumn(name = "adocao_id")
    private Adocao adocao;
    @JoinColumn(name = "ong_id")
    private Ong ong;

    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL)
    private List<Adocao> adocoes = new ArrayList<>(); 
    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL)
    private List<Adotante> adotantes = new ArrayList<>(); 
    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL)
    private List<Animal> animais = new ArrayList<>();


}
