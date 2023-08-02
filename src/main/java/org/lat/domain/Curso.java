package org.lat.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.w3c.dom.Text;

import java.math.BigDecimal;
import java.util.*;

@Entity
@Table(name="curso")
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

    @Column(nullable = true)
    private String subtitulo;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String descripcion;

    @ManyToMany(mappedBy = "cursos")
    @JsonIgnore
    private List<Usuario> usuarios = new ArrayList<>();

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<Video> videos = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

}