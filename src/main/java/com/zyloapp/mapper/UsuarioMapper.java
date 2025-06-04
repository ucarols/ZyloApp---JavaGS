package com.zyloapp.mapper;

import com.zyloapp.dto.UsuarioDTO;
import com.zyloapp.model.Usuario;

public class UsuarioMapper {
    public static UsuarioDTO toDTO(Usuario u) {
        return new UsuarioDTO(u);
    }
}
