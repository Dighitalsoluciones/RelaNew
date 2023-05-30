
package com.dighital.rela.relaciones.service;

import com.dighital.rela.relaciones.entity.Libro;
import com.dighital.rela.relaciones.repository.LibroRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class LibroService {
    
    @Autowired
    LibroRepository libroRepository;

    public List<Libro> findAll() {
        return libroRepository.findAll();
    }

    public void save(Libro libro) {
        libroRepository.save(libro);
    }

    public Optional<Libro> findById(Long id) {
        return libroRepository.findById(id);
    }

    public boolean existsById(Long id) {
        return libroRepository.existsById(id);
    }

    public void deleteById(Long id) {
        libroRepository.deleteById(id);
    }
    
    
}
