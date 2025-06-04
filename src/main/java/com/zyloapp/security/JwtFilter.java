package com.zyloapp.security;

import com.zyloapp.model.Usuario;
import com.zyloapp.service.UsuarioService;
import com.zyloapp.util.JwtUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.Collections;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UsuarioService service;

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain fc) throws IOException, ServletException {
        String h = req.getHeader(HttpHeaders.AUTHORIZATION);
        if (h != null && h.startsWith("Bearer ")) {
            String t = h.substring(7);
            String e = jwtUtil.extrairEmail(t);
            if (e != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                Usuario u = service.buscarPorEmail(e);
                if (jwtUtil.validarToken(t, e)) {
                    UsernamePasswordAuthenticationToken aut = new UsernamePasswordAuthenticationToken(u, null, Collections.emptyList());
                    SecurityContextHolder.getContext().setAuthentication(aut);
                }
            }
        }
        fc.doFilter(req, res);
    }
}
