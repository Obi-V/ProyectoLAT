package org.lat.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="videos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_video")
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String url;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;
}
