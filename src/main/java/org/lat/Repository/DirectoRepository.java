package org.lat.Repository;

import org.lat.domain.Directo;
import org.lat.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectoRepository extends JpaRepository<Directo,Long> {

}
