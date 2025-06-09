package com.zyloapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClimaRequest {
    @NotBlank
    private String localizacao;

    @NotNull
    private Double temperatura;

    @NotNull
    private Integer probabilidadeChuva;

    @NotNull
    private Double velocidadeVento;
}
