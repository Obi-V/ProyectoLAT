package org.lat.auth;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class DemoController {
    //Este endpoint era para testear el JWT
    @PostMapping(value = "demo")
    public String demo(){
        return "Estás dentro porque el token era válido";
    }
}
