package com.example.spring_gym.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="ventas")
public class Venta {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idVenta;
    private int idSocio;             // Relación con Socio (quién compra)
    private String numero;
    private Date fechaCreacion;
	private Date fechaRecibida;
    private double montoTotal;
 @OneToOne
    private Pago pago;

    	@ManyToOne
	private Socio socio;
	
	@OneToMany(mappedBy = "venta")
    // Lista de productos vendidos (detalle)
    private List<DetalleVenta> detalles;

    // Constructor vacío
    public Venta() {
        this.detalles = new ArrayList<>();
    }

    public Venta(List<DetalleVenta> detalles, Date fechaCreacion, Date fechaRecibida, int idSocio, Integer idVenta, double montoTotal, String numero, Pago pago, Socio socio) {
        this.detalles = detalles;
        this.fechaCreacion = fechaCreacion;
        this.fechaRecibida = fechaRecibida;
        this.idSocio = idSocio;
        this.idVenta = idVenta;
        this.montoTotal = montoTotal;
        this.numero = numero;
        this.pago = pago;
        this.socio = socio;
    }
 public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaRecibida() {
        return fechaRecibida;
    }

    public void setFechaRecibida(Date fechaRecibida) {
        this.fechaRecibida = fechaRecibida;
    }
public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public List<DetalleVenta> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleVenta> detalles) {
        this.detalles = detalles;
    }

    @Override
    public String toString() {
        return "Venta [idVenta=" + idVenta + ", idSocio=" + idSocio + ", numero=" + numero + ", fechaCreacion="
                + fechaCreacion + ", fechaRecibida=" + fechaRecibida + ", montoTotal=" + montoTotal + ", pago=" + pago
                + ", socio=" + socio + ", detalles=" + detalles + "]";
    }




    
   

    
}
