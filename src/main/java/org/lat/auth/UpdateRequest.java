package org.lat.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.lat.domain.Role;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRequest {

   	String pais;

    String respuesta;

    String img;

    String descripcion;

    String subtitulo;

    Set<String> habilidades;

    Set<String> idiomas;

    Role role;
}
