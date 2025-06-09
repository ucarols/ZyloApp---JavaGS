package com.zyloapp.mapper;

import com.zyloapp.dto.UsuarioResponseDTO;
import com.zyloapp.dto.UsuarioDTO;
import com.zyloapp.model.Usuario;

public class UsuarioMapper {

    public static UsuarioDTO toDTO(Usuario usuario) {
        return new UsuarioDTO(
                usuario.getIdUsuario(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getLocalizacaoUsuario()
        );
    }

    public static UsuarioResponseDTO toResponseDTO(Usuario usuario) {
        return new UsuarioResponseDTO(
                usuario.getIdUsuario(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getLocalizacaoUsuario()
        );
    }
}
