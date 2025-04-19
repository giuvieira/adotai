package com.unicap.adotai.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Table(name = "adotante")
@EqualsAndHashCode(callSuper = false)
public class Adotante extends Usuario {

    private String preferencia;
    private Integer pontuacao;
}
