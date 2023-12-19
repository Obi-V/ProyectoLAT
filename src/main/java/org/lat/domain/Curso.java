package org.lat.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.w3c.dom.Text;

import java.math.BigDecimal;
import java.util.*;

@Entity
@Table(name="curso")
@Data
@Builder
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

    @Column(nullable = true)
    private String subtitulo;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String descripcion;

    @ManyToMany(mappedBy = "cursos")
    @JsonIgnore
    private Set<Usuario> usuarios = new HashSet<>();

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "categoria")
    private Categoria categoria;

}