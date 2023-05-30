
package com.dighital.rela.relaciones.repository;

import com.dighital.rela.relaciones.entity.Autor;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long>{

   
}
