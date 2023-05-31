package org.lat.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = "nombre")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private long id;

    private String nombre;

    private String contraseña;

    private String email;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    @ManyToMany(
            mappedBy = "usuarios")
    @JsonIgnore
    Set<Curso> cursos = new HashSet<>();

}
