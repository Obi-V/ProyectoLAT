package org.lat.Repository;

import org.lat.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    Optional<Usuario> findByUsername(String username);

     /*
     public List<Usuario> findByUsernameContainingIgnoreCaseOrderByIdAsc(String nombre);

    @Query(value="SELECT * from usuarios where usuario.username like %:nombre%", nativeQuery = true)
    public List<Usuario> buscarPorNombre(@Param("nombre") String nombre);
    */

}
