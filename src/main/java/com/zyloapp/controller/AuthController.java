package com.zyloapp.controller;

import com.zyloapp.dto.LoginRequest;
import com.zyloapp.dto.LoginResponse;
import com.zyloapp.dto.UsuarioRequestDTO;
import com.zyloapp.dto.UsuarioResponseDTO;
import com.zyloapp.mapper.UsuarioMapper;
import com.zyloapp.model.Usuario;
import com.zyloapp.service.UsuarioService;
import com.zyloapp.util.JwtUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "auth-controller", description = "Autenticação e registro de usuários")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    @Operation(summary = "Realiza login e retorna o token JWT")
    public LoginResponse login(@Valid @RequestBody LoginRequest request) {
        Usuario usuario = usuarioService.buscarPorEmail(request.getEmail());
        if (!usuarioService.verificarSenha(request.getSenha(), usuario.getSenha())) {
            throw new RuntimeException("Credenciais inválidas");
        }
        String token = jwtUtil.gerarToken(usuario.getEmail());
        return new LoginResponse(token);
    }

    @PostMapping("/register")
    @Operation(summary = "Registra um novo usuário")
    public UsuarioResponseDTO register(@Valid @RequestBody UsuarioRequestDTO dto) {
        return usuarioService.cadastrar(dto);
    }
}
