package com.challenge.forum.hub.security;

import com.challenge.forum.hub.repository.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    TokenService tokenService;

    private UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("-> CHAMANDO FILTER!!!");
        var tokenJWT = recuperarToken(request);

        if (tokenJWT !=null){
            var subject = tokenService.getSubject(tokenJWT);
            var usuario = usuarioRepository.findByLogin(subject);
            var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authentication);
            System.out.println("-> LOGADO NO FORUM!!!");
        }

//        System.out.println(subject);
//        System.out.println(tokenJWT);
//        System.out.println("FILTRO CHAMADO!!!!");

        filterChain.doFilter(request, response);
    }

    private String recuperarToken(HttpServletRequest request) {
        var autorizationHeader = request.getHeader("Authorization");
        if (autorizationHeader != null) {
            return autorizationHeader.replace("Bearer", "");
        }
        return null;
    }
}