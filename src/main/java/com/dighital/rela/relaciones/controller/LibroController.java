
package com.dighital.rela.relaciones.controller;

import com.dighital.rela.relaciones.dto.LibroDto;
import com.dighital.rela.relaciones.entity.Autor;
import com.dighital.rela.relaciones.entity.Libro;
import com.dighital.rela.relaciones.service.AutorService;
import com.dighital.rela.relaciones.service.LibroService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/libro")
@CrossOrigin(origins = "http://localhost:4200")
public class LibroController {
    
    @Autowired
    LibroService libroService;
    
    @Autowired
    AutorService autorService;
    
    
    @GetMapping("/lista")
    public List<Libro> list(){
        return libroService.findAll();
    }
    
    @PostMapping("/nuevo/{id}")
    public String save(@PathVariable ("id") Long id, @RequestBody LibroDto libroDto){
        Autor autor = autorService.findById(id).get();
        if(autor == null){
            return "No se encontro el id expecificado";
        }
        autor.setId(id);
        Libro libro = new Libro (libroDto.getTitulo(), libroDto.getPaginas(), libroDto.getDeposito(), libroDto.getAutor());
        libro.setAutor(autor);
        libroService.save(libro);
        return "Libro creado correctamente";
    }
    
    @DeleteMapping("/eliminar/{id}")
    public String delete(@PathVariable ("id") Long id){
        libroService.deleteById(id);
        return "Libro eliminado correctamente";
    }
    
    @PutMapping("/actualizar/{id}")
    public String update(@PathVariable ("id") Long id, @RequestBody LibroDto libroDto){
        Libro libro = libroService.findById(id).get();
        libro.setTitulo(libroDto.getTitulo());
        libro.setPaginas(libroDto.getPaginas());
        libro.setDeposito(libroDto.getDeposito());
        libroService.save(libro);
        return "Libro Actualizado correctamente";
    }
    
    @GetMapping("/detalle/{id}")
    public Optional<Libro> detail(@PathVariable ("id") Long id){
        return libroService.findById(id);
    }
    
    
}
