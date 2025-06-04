package com.zyloapp.dto;

public class UsuarioDTO {
    private Long id;
    private String nome;
    private String email;
    private String cidade;
    public UsuarioDTO() {}
    public UsuarioDTO(Long id, String nome, String email, String cidade) {
        this.id = id; this.nome = nome; this.email = email; this.cidade = cidade;
    }
    public UsuarioDTO(com.zyloapp.model.Usuario u) {
        this(u.getId(), u.getNome(), u.getEmail(), u.getCidade());
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
