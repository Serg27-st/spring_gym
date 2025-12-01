package com.example.spring_gym.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="ventas")
public class Venta {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idVenta;
    private String numero;
    private Date fechaCreacion;
	private Date fechaRecibida;
    private double montoTotal;
    private String estado;


    	@ManyToOne
	private Socio socio;
	
	@OneToMany(mappedBy = "venta")
    // Lista de productos vendidos (detalle)
    private List<DetalleVenta> detalle;

    // Constructor vacío
    public Venta() {
    }

    public Venta(Date fechaCreacion, Date fechaRecibida, Integer idVenta, double montoTotal, String numero) {
        this.fechaCreacion = fechaCreacion;
        this.fechaRecibida = fechaRecibida;
        this.idVenta = idVenta;
        this.montoTotal = montoTotal;
        this.numero = numero;
    }

   


 public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
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


    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public List<DetalleVenta> getDetalles() {
        return detalle;
    }

    public void setDetalles(List<DetalleVenta> detalles) {
        this.detalle = detalles;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Venta{");
        sb.append("idVenta=").append(idVenta);
        sb.append(", numero=").append(numero);
        sb.append(", fechaCreacion=").append(fechaCreacion);
        sb.append(", fechaRecibida=").append(fechaRecibida);
        sb.append(", montoTotal=").append(montoTotal);
        sb.append(", socio=").append(socio);
        sb.append(", detalle=").append(detalle);
        sb.append('}');
        return sb.toString();
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

   



    
   

    
}
