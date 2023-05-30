
package com.dighital.rela.relaciones.service;

import com.dighital.rela.relaciones.entity.Autor;
import com.dighital.rela.relaciones.repository.AutorRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AutorService {
    
    @Autowired
    AutorRepository autorRepository;

    public List<Autor> findAll() {
        return autorRepository.findAll();
    }

    public void save(Autor autor) {
        autorRepository.save(autor);
    }

    public Optional<Autor> findById(Long id) {
        return autorRepository.findById(id);
    }

    public boolean existsById(Long id) {
        return autorRepository.existsById(id);
    }

    public void deleteById(Long id) {
        autorRepository.deleteById(id);
    }
    
    
}
