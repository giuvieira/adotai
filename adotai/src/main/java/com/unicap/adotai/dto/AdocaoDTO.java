package com.unicap.adotai.dto;


import lombok.Data;

import java.time.LocalDate;

@Data
public class AdocaoDTO {
    private Long adotanteId;
    private String adocCpf;
    private String adocEnduser;
    private LocalDate adocData;
    private Long animalId;
    private String adocObservacao;
    private String adocStatus;
}