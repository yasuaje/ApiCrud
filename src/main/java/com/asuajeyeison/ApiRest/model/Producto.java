package com.asuajeyeison.ApiRest.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String nombre;
    private float precio;

    public Producto(Integer id, String nombre, float precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Producto(String nombre, float precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public Producto() {
    }
}