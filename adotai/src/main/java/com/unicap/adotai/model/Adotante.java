package com.unicap.adotai.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "adotante")
@EqualsAndHashCode(callSuper = false)
public class Adotante extends Usuario {

    private String preferencia;
    private Integer pontuacao;
}
