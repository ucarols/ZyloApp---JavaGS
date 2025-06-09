package com.zyloapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Clima {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String localizacao;

    private Double temperatura;

    private Integer probabilidadeChuva;

    private Double velocidadeVento;

    private LocalDateTime dataHora;
}
