
package com.dighital.rela.relaciones.repository;

import com.dighital.rela.relaciones.entity.Libro;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LibroRepository extends JpaRepository<Libro, Long> {

  
}
