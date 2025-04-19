package com.unicap.adotai.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Mensagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String remetente;
    private String destinatario;
    private String conteudo;
    private String dataEnvio;
    

    @Override
    public String toString() {
        return "Mensagem{" +
                "id=" + id +
                ", remetente='" + remetente + '\'' +
                ", destinatario='" + destinatario + '\'' +
                ", conteudo='" + conteudo + '\'' +
                ", dataEnvio='" + dataEnvio + '\'' +
                '}';
    }

}
