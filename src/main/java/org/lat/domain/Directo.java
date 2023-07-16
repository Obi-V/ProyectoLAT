package org.lat.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="directos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Directo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_directo")
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private String img;

    @Column(nullable = false)
    private String url;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;
}
