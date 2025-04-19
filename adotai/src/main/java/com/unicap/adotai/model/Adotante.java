package com.unicap.adotai.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Table(name = "adotante")
@EqualsAndHashCode(callSuper = true)
public class Adotante extends Usuario {

    private String preferencia;
    private Integer pontuacao;

}
