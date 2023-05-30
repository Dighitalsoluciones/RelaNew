
package com.dighital.rela.relaciones.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private int paginas;
    private String deposito;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Autor")
    private Autor autor;
    //constructor

    public Libro() {
    }

    public Libro(String titulo, int paginas, String deposito, Autor autor) {
        this.titulo = titulo;
        this.paginas = paginas;
        this.deposito = deposito;
        this.autor = autor;
    }

   

    
    
}
