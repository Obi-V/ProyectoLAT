package org.lat.Repository;

import org.lat.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    public List<Usuario> findByNombreContainingIgnoreCaseOrderByIdAsc(String nombre);

    @Query(value="SELECT * from usuarios where usuarios.nombre like %:nombre%", nativeQuery = true)
    public List<Usuario> buscarPorNombre(@Param("nombre") String nombre);

}
