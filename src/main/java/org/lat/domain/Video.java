package org.lat.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="videos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Video {

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
