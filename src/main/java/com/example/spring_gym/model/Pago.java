package com.example.spring_gym.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "pagos")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPago;
    private int idSocio;       // Relación con Socio
    private int idMembresia;   // Relación con Membresía (opcional si aplica a productos)
    private double monto;
    private LocalDate fechaPago;
    private String metodoPago; // Efectivo, Tarjeta, Transferencia, Yape, etc.
    private String estado;
    
    @ManyToOne
    //@JoinColumn(name = "idSocio", nullable = false)
    private Socio socio;

     @ManyToOne
    //@JoinColumn(name = "idMembresia", nullable = true) // null si es pago por venta de producto
    private Membresia membresia;

    @OneToOne(mappedBy = "pago")
    private Venta venta;
    
    public Pago() {
    }
    
    public Pago(int idPago, int idSocio, int idMembresia, double monto, LocalDate fechaPago, String metodoPago,
            String estado) {
        super();
                this.idPago = idPago;
        this.idSocio = idSocio;
        this.idMembresia = idMembresia;
        this.monto = monto;
        this.fechaPago = fechaPago;
        this.metodoPago = metodoPago;
        this.estado = estado;
    }

    public int getIdPago() {
        return idPago;
    }
    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }
    public int getIdSocio() {
        return idSocio;
    }
    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }
    public int getIdMembresia() {
        return idMembresia;
    }
    public void setIdMembresia(int idMembresia) {
        this.idMembresia = idMembresia;
    }
    public double getMonto() {
        return monto;
    }
    public void setMonto(double monto) {
        this.monto = monto;
    }
    public LocalDate getFechaPago() {
        return fechaPago;
    }
    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }
    public String getMetodoPago() {
        return metodoPago;
    }
    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
        // Método auxiliar para saber si está pagado
    public boolean estaPagado() {
        return "Pagado".equalsIgnoreCase(estado);
    }

    @Override
    public String toString() {
        return "Pago [idPago=" + idPago + ", idSocio=" + idSocio + ", idMembresia=" + idMembresia + ", monto=" + monto
                + ", fechaPago=" + fechaPago + ", metodoPago=" + metodoPago + ", estado=" + estado + "]";
    } 

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Membresia getMembresia() {
        return membresia;
    }

    public void setMembresia(Membresia membresia) {
        this.membresia = membresia;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    
}


