package com.zyloapp.dto;

import com.zyloapp.model.Usuario;

public class UsuarioDTO {
    private Long id;
    private String nome;
    private String email;
    private String cidade;

    public UsuarioDTO() {}

    public UsuarioDTO(Long id, String nome, String email, String cidade) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cidade = cidade;
    }

    public UsuarioDTO(Usuario u) {
        this.id = u.getIdUsuario();
        this.nome = u.getNome();
        this.email = u.getEmail();
        this.cidade = u.getLocalizacaoUsuario();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }
}
