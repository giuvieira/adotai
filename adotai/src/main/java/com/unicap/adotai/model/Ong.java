package com.unicap.adotai.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Ong")
@Data
@EqualsAndHashCode(callSuper = true)
public class Ong extends Usuario {

    /*
    ong_id: int ong_nome: string
    ong_cnpj: int
    ong_email: string
    ong_endereço: string
    ong_idanimais: int
    ong_descanimais: string
    */

    private String endereco;
    private int idAnimais;
    private String descricaoAnimais;

    @OneToMany(mappedBy = "ong", cascade = CascadeType.ALL)
    private List<Animal> animais = new ArrayList<>();
    @OneToMany(mappedBy = "ong", cascade = CascadeType.ALL)
    private List<Adocao> adocoes = new ArrayList<>(); 
    @OneToMany(mappedBy = "ong", cascade = CascadeType.ALL)
    private List<Adotante> adotantes = new ArrayList<>();
    
}
