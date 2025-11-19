package com.example.spring_gym.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "detalles")

public class DetalleVenta {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private int idDetalle;
    private int idVenta;
    private String nombre;
    private int idInventario;   // Relación con Inventario o Producto
    private int cantidad;
    private double precioUnitario;
    private double total;
    
    @ManyToOne
    private Venta venta;
    
    @ManyToOne
    private Inventario inventario;


    public DetalleVenta() {
    }

    public DetalleVenta(int cantidad, int idDetalle, int idProducto, int idVenta, Inventario inventario, String nombre, double precioUnitario, double total, Venta venta) {
        this.cantidad = cantidad;
        this.idDetalle = idDetalle;
        this.idInventario = idProducto;
        this.idVenta = idVenta;
        this.inventario = inventario;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.total = total;
        this.venta = venta;
    }
    
    

    



    public int getIdDetalle() {
        return idDetalle;
    }
    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }
    public int getIdVenta() {
        return idVenta;
    }
    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }
    public int getIdInventario() {
        return idInventario;
    }
    public void setIdInventario(int idProducto) {
        this.idInventario = idProducto;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public double getPrecioUnitario() {
        return precioUnitario;
    }
    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

       // Subtotal = cantidad * precio unitario
    public double getSubtotal() {
        return cantidad * precioUnitario;
    }
    
    

    @Override
    public String toString() {
        return "DetalleVenta [idDetalle=" + idDetalle + ", idVenta=" + idVenta + ", nombre=" + nombre + ", idProducto="
                + idInventario + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + ", total=" + total
                + ", venta=" + venta + ", inventario=" + inventario + "]";
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    
}
