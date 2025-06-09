package com.zyloapp.service;

import com.zyloapp.dto.UsuarioRequestDTO;
import com.zyloapp.dto.UsuarioResponseDTO;
import com.zyloapp.mapper.UsuarioMapper;
import com.zyloapp.model.Usuario;
import com.zyloapp.repository.UsuarioRepository;
import com.zyloapp.util.JwtUtil;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private JwtUtil jwtUtil;

    public Page<Usuario> listarTodos(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Usuario buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));
    }

    public Usuario buscarPorEmail(String email) {
        return repository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("Email não encontrado"));
    }

    public UsuarioResponseDTO cadastrar(UsuarioRequestDTO dto) {
        if (repository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email já cadastrado");
        }

        Usuario usuario = new Usuario(
                null,
                dto.getNome(),
                dto.getEmail(),
                encoder.encode(dto.getSenha()),
                dto.getLocalizacaoUsuario()
        );

        return UsuarioMapper.toResponseDTO(repository.save(usuario));
    }

    public Usuario atualizar(Long id, UsuarioRequestDTO dto) {
        Usuario usuario = buscarPorId(id);
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(encoder.encode(dto.getSenha()));
        usuario.setLocalizacaoUsuario(dto.getLocalizacaoUsuario());
        return repository.save(usuario);
    }

    public Usuario buscarPorToken(String token) {
        String email = jwtUtil.extractUsername(token);
        return buscarPorEmail(email);
    }

    public Usuario atualizarPorToken(String token, UsuarioRequestDTO dto) {
        Usuario usuario = buscarPorToken(token);
        if (dto.getNome() != null) usuario.setNome(dto.getNome());
        if (dto.getEmail() != null) usuario.setEmail(dto.getEmail());
        if (dto.getSenha() != null) usuario.setSenha(encoder.encode(dto.getSenha()));
        if (dto.getLocalizacaoUsuario() != null) usuario.setLocalizacaoUsuario(dto.getLocalizacaoUsuario());
        return repository.save(usuario);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Usuário não existe");
        }
        repository.deleteById(id);
    }

    public void deletarPorToken(String token) {
        Usuario usuario = buscarPorToken(token);
        repository.delete(usuario);
    }

    public boolean verificarSenha(String senhaDigitada, String senhaCriptografada) {
        return encoder.matches(senhaDigitada, senhaCriptografada);
    }
}
