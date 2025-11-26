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
    private String nombre;
    private int cantidad;
    private double precioUnitario;
    private double total;
    
    @ManyToOne
    private Venta venta;
    
    @ManyToOne
    private Inventario inventario;


    public DetalleVenta() {
    }

    public DetalleVenta(int cantidad, int idDetalle, String nombre, double precioUnitario, double total) {
        this.cantidad = cantidad;
        this.idDetalle = idDetalle;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.total = total;
    }

    public int getIdDetalle() {
        return idDetalle;
    }
    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DetalleVenta{");
        sb.append("idDetalle=").append(idDetalle);
        sb.append(", nombre=").append(nombre);
        sb.append(", cantidad=").append(cantidad);
        sb.append(", precioUnitario=").append(precioUnitario);
        sb.append(", total=").append(total);
        sb.append(", venta=").append(venta);
        sb.append(", inventario=").append(inventario);
        sb.append('}');
        return sb.toString();
    }



    
}
