package com.aluracursos.ForoHub.domain.usuario;

import jakarta.persistence.*;
import jakarta.validation.Valid;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(unique = true)
    private String nombre;
    private String email;
    private String password;

    public Usuario() {
    }

    public Usuario(@Valid DatosRegistroUsuario datosRegistro) {
        this.nombre = datosRegistro.nombre();
        this.email = datosRegistro.email();
        this.password = datosRegistro.password();
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
