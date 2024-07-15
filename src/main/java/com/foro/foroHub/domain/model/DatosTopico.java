package com.foro.foroHub.domain.model;

import com.foro.foroHub.domain.topico.DatosActualiszarTopico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topico")
@Entity(name = "DatosTopico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class DatosTopico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private String autor;
    private String curso;
    private LocalDateTime date;

    public DatosTopico(com.foro.foroHub.domain.topico.DatosTopico datosTopico) {
        this.titulo = datosTopico.titulo();
        this.mensaje = datosTopico.mensaje();
        this.curso = datosTopico.curso();
        this.autor = datosTopico.autor();
        this.date = LocalDateTime.now(); // Asignar la fecha actual
    }

    public void actualizarTopico(DatosActualiszarTopico datosActualiszarTopico) {
        if (datosActualiszarTopico.titulo() != null){
            this.titulo = datosActualiszarTopico.titulo();
        }
        if(datosActualiszarTopico.mensaje() != null) {
            this.mensaje = datosActualiszarTopico.mensaje();
        }
    }
}
