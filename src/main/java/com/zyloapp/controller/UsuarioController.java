package com.zyloapp.controller;

import com.zyloapp.dto.UsuarioDTO;
import com.zyloapp.dto.UsuarioRequestDTO;
import com.zyloapp.dto.UsuarioResponseDTO;
import com.zyloapp.mapper.UsuarioMapper;
import com.zyloapp.model.Usuario;
import com.zyloapp.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    public UsuarioResponseDTO cadastrar(@Valid @RequestBody UsuarioRequestDTO dto) {
        return usuarioService.cadastrar(dto);
    }

    @PutMapping("/{id}")
    public UsuarioDTO atualizar(@PathVariable Long id, @Valid @RequestBody UsuarioRequestDTO dto) {
        return UsuarioMapper.toDTO(usuarioService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        usuarioService.deletar(id);
    }

    @GetMapping("/me")
    public ResponseEntity<UsuarioDTO> buscarPerfil(@AuthenticationPrincipal Usuario usuario) {
        return ResponseEntity.ok(UsuarioMapper.toDTO(usuario));
    }
    @PutMapping("/me")
    public ResponseEntity<UsuarioDTO> atualizarPerfil(
            @AuthenticationPrincipal Usuario usuario,
            @Valid @RequestBody UsuarioRequestDTO dto) {
        Usuario atualizado = usuarioService.atualizar(usuario.getIdUsuario(), dto);
        return ResponseEntity.ok(UsuarioMapper.toDTO(atualizado));
    }

    @DeleteMapping("/me")
    public ResponseEntity<Void> deletarPerfil(@AuthenticationPrincipal Usuario usuario) {
        usuarioService.deletar(usuario.getIdUsuario());
        return ResponseEntity.noContent().build();
    }

}
