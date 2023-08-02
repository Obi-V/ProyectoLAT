package org.lat.auth;

import lombok.RequiredArgsConstructor;
import org.lat.Repository.UsuarioRepository;
import org.lat.domain.Role;
import org.lat.domain.Usuario;
import org.lat.exception.DuplicadoException;
import org.lat.jwt.JwtService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final List<Role> rolesPermitidos;

    public AuthResponse login(LoginRequest request){
       authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));

        UserDetails user = usuarioRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(user);

        return AuthResponse.builder()
                .usuario(user)
                .token(token)
                .build();
    }

    public AuthResponse register(RegisterRequest request){

        rolesPermitidos.add(Role.ALUMNO);
        rolesPermitidos.add(Role.PROFESOR);

        Usuario newUsuario = Usuario.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode( request.getPassword()))
                .role(request.getRole())
                .build();

        if(!rolesPermitidos.contains(newUsuario.getRole()) ){
            throw new RuntimeException("Rol no admitido");
        }

        try {
            usuarioRepository.save(newUsuario);
        }  catch (
                DataIntegrityViolationException e) {
            if (e.getMessage().contains("constraint [email]")) {
                throw new DuplicadoException("El email ya está registrado, por favor, usa otro email.");
            } else {
                throw new DuplicadoException("El nombre de usuario ya está registrado, por favor, elige otro nombre de usuario.");
            }
        }

        UserDetails user = usuarioRepository.findByUsername(request.getUsername()).orElseThrow();

        return AuthResponse.builder()
                .usuario(user)
                .token(jwtService.getToken(newUsuario))
                .build();
    }

    public AuthResponse checkToken(String username){

        UserDetails user = usuarioRepository.findByUsername(username).orElseThrow();
        String token = jwtService.getToken(user);

        return AuthResponse.builder()
                .usuario(user)
                .token(token)
                .build();
    }
}
