package com.university.inventory.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "suplidores")
public class Suplidor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "suplidor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ContactoSuplidor> contactos = new ArrayList<>();

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public List<ContactoSuplidor> getContactos() { return contactos; }
}

