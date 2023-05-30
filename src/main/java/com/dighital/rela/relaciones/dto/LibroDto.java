
package com.dighital.rela.relaciones.dto;

import com.dighital.rela.relaciones.entity.Autor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LibroDto {
    private Long id;
    private String titulo;
    private int paginas;
    private String deposito;
    private Autor autor;
   
    //constructor

    public LibroDto() {
    }

    public LibroDto(String titulo, int paginas, String deposito, Autor autor) {
        this.titulo = titulo;
        this.paginas = paginas;
        this.deposito = deposito;
        this.autor = autor;
    }

    
}
