package org.lat.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="directos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Directo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_directo")
    private Long id;

    private String nombre;

    private String url;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;
}
