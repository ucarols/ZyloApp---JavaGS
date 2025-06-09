package com.zyloapp.dto;

public class UsuarioResponseDTO {

    private Long idUsuario;
    private String nome;
    private String email;
    private String localizacaoUsuario;

    public UsuarioResponseDTO(Long idUsuario, String nome, String email, String localizacaoUsuario) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.localizacaoUsuario = localizacaoUsuario;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getLocalizacaoUsuario() {
        return localizacaoUsuario;
    }
}
