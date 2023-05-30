
package com.dighital.rela.relaciones.controller;

import com.dighital.rela.relaciones.dto.AutorDto;
import com.dighital.rela.relaciones.entity.Autor;
import com.dighital.rela.relaciones.entity.Libro;
import com.dighital.rela.relaciones.service.AutorService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/autor")

public class AutorController {
    
    @Autowired
    AutorService autorService;
    
    
   @GetMapping("/lista")
   public List<Autor> list(){
       return autorService.findAll();
   }
   
   @PostMapping("/nuevo")
   public String save(@RequestBody Autor autor){
       autorService.save(autor);
       return "Autor creado correctamente";
   }
   
   @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody AutorDto autorDto) {
      
        Autor autor = new Autor(
                autorDto.getNombre(), autorDto.getApellido(), autorDto.getEdad());
        autorService.save(autor);
        return new ResponseEntity("ok", HttpStatus.OK);
    }
   
   @DeleteMapping("/eliminar/{id}")
   public String deleteById(@PathVariable Long id){
       autorService.deleteById(id);
       return "Autor eliminado correctamente";
   }
   
   @PutMapping("/editar/{id}")
   public String editarAutor(@PathVariable ("Id") Long id, @RequestBody AutorDto autorDto){
       Autor autor = autorService.findById(id).get();
       autor.setNombre(autorDto.getNombre());
       autor.setApellido(autorDto.getApellido());
       autor.setEdad(autorDto.getEdad());
       autorService.save(autor);
       return "Autor modificado correctamente";
   }
   
   @GetMapping("/detalle/{id}")
   public Optional<Autor> findById(@PathVariable ("id") Long id){
       return autorService.findById(id);
       
   }
   
           
    
   
  
}
