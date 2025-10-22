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
    private int idProducto;   // Relación con Inventario o Producto
    private int cantidad;
    private double precioUnitario;
    
    @ManyToOne
    private Venta venta;
    
    @ManyToOne
    private Inventario inventario;


    public DetalleVenta() {
    }
    
    

    public DetalleVenta(int idDetalle, int idVenta, int idProducto, int cantidad, double precioUnitario, Venta venta,
            Inventario inventario) {
        this.idDetalle = idDetalle;
        this.idVenta = idVenta;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.venta = venta;
        this.inventario = inventario;
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
    public int getIdProducto() {
        return idProducto;
    }
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
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
        return "DetalleVenta [idDetalle=" + idDetalle + ", idVenta=" + idVenta + ", idProducto=" + idProducto
                + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + "]";
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



    
}
