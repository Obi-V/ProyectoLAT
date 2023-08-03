package org.lat.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.AuthProvider;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(value="/login")
    public ResponseEntity<AuthResponse> Login(@RequestBody LoginRequest request){

        return ResponseEntity.ok(authService.login(request));
    }


    @PostMapping(value="/register")
    public ResponseEntity<AuthResponse> Register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping(value="/check-token")
    public ResponseEntity<AuthResponse> CheckToken(@RequestHeader("Authorization") String authorizationHeader){

        String token = authService.extractTokenFromAuthorizationHeader(authorizationHeader);

        return ResponseEntity.ok(authService.checkToken(token));
    }
}
