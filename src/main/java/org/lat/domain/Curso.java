package org.lat.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.*;

@Entity
@Table(name="cursos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name="id_curso")
    private long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String direccion;

    @ManyToMany(mappedBy = "cursos")
    @JsonIgnore
    private Set<Usuario> usuarios = new HashSet<>();

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<Video> videos = new ArrayList<>();

}
