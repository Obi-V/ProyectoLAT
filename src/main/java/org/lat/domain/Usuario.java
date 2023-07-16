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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    @EqualsAndHashCode.Include
    private long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    /* Añadidos al completar el perfil */
    @Column
    private String pais;

    /* Hay que hacerlas colecciones*/
    @Column
    private String habilidades;

    @Column
    private String idiomas;

    @Column
    private String respuesta;

    @ManyToMany()
    @JsonIgnore
    Set<Curso> cursos = new HashSet<>();

}
