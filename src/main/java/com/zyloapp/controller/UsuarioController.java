package com.zyloapp.controller;

import com.zyloapp.dto.UsuarioDTO;
import com.zyloapp.dto.UsuarioRequestDTO;
import com.zyloapp.mapper.UsuarioMapper;
import com.zyloapp.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public Page<UsuarioDTO> listar(Pageable pageable) {
        return usuarioService.listarTodos(pageable).map(UsuarioMapper::toDTO);
    }

    @GetMapping("/{id}")
    public UsuarioDTO buscarPorId(@PathVariable Long id) {
        return UsuarioMapper.toDTO(usuarioService.buscarPorId(id));
    }

    @PostMapping
    public UsuarioDTO cadastrar(@Valid @RequestBody UsuarioRequestDTO dto) {
        return UsuarioMapper.toDTO(usuarioService.cadastrar(dto));
    }

    @PutMapping("/{id}")
    public UsuarioDTO atualizar(@PathVariable Long id, @Valid @RequestBody UsuarioRequestDTO dto) {
        return UsuarioMapper.toDTO(usuarioService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        usuarioService.deletar(id);
    }


}
