package com.adso.el_taller_de_adso.inventario;

public class Producto {
    private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;
    private int umbralBajoStock = 10; // Valor predeterminado para el umbral

    // Constructor vacío
    public Producto() {}

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getUmbralBajoStock() {
        return umbralBajoStock;
    }

    public void setUmbralBajoStock(int umbralBajoStock) {
        this.umbralBajoStock = umbralBajoStock;
    }
}