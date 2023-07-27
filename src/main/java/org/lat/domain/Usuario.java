package org.lat.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "usuario", uniqueConstraints = {
        @UniqueConstraint(columnNames="username"),
        @UniqueConstraint(columnNames="email")
        })
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    @EqualsAndHashCode.Include
    private long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    /* Añadidos al completar el perfil */
    @Column
    private String pais;

    /* Hay que hacerlas colecciones*/
    @ElementCollection
    @CollectionTable(name = "usuario_habilidades", joinColumns = @JoinColumn(name = "usuario_id"))
    @Column(name="habilidad")
    private Set<String> habilidades = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "usuario_idiomas", joinColumns = @JoinColumn(name = "usuario_id"))
    @Column(name = "idioma")
    private Set<String> idiomas = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "usuario_respuestas", joinColumns = @JoinColumn(name = "usuario_id"))
    @Column(name = "respuesta")
    private Set<String> respuesta = new HashSet<>();

    @ManyToMany()
    @JsonIgnore
    Set<Curso> cursos = new HashSet<>();

    @ManyToMany()
    @JsonIgnore
    Set<Categoria> categorias = new HashSet<>();

    /* USERDETAILS */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
