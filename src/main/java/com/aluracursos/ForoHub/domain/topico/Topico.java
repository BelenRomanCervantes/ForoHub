package com.aluracursos.ForoHub.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "topicos")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column (unique = true)
    private String titulo;
    @Column (unique = true)
    private String mensaje;
    private LocalDateTime fechaCreacion;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario usuario;
    private String curso;

    public Topico() {
    }

    public Topico(DatosRegistroTopico datosRegistro) {
        this.status = Status.ACTIVO;
        this.titulo = datosRegistro.titulo();
        this.mensaje = datosRegistro.mensaje();
        this.fechaCreacion = LocalDateTime.now();
        this.usuario = usuario;
        this.curso = datosRegistro.curso();
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Usuario getAutor() {
        return usuario;
    }

    public void setAutor(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
