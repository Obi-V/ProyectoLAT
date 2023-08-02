package org.lat.auth;

import lombok.*;
import org.lat.domain.Usuario;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
    UserDetails usuario;
    String token;
}
