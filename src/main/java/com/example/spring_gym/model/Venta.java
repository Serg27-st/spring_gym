package com.example.spring_gym.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    private LocalDateTime fechaVenta;
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



    public Venta(Integer idVenta, int idSocio, LocalDateTime fechaVenta, double montoTotal, Pago pago, Socio socio,
            List<DetalleVenta> detalles) {
        this.idVenta = idVenta;
        this.idSocio = idSocio;
        this.fechaVenta = fechaVenta;
        this.montoTotal = montoTotal;
        this.pago = pago;
        this.socio = socio;
        this.detalles = detalles;
    }







    // Getters y Setters
    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }

    public LocalDateTime getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDateTime fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    // Métodos para manejar los detalles
    public List<DetalleVenta> getDetalles() {
        return detalles;
    }
    

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
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

    public void setDetalles(List<DetalleVenta> detalles) {
        this.detalles = detalles;
    }

    public void agregarDetalle(DetalleVenta detalle) {
        if (detalle != null) {
            this.detalles.add(detalle);
            calcularMontoTotal();
        }
    }

    public void eliminarDetalle(DetalleVenta detalle) {
        if (detalle != null && this.detalles.remove(detalle)) {
            calcularMontoTotal();
        }
    }

    // Recalcular monto total en base a los detalles
    private void calcularMontoTotal() {
        this.montoTotal = this.detalles.stream()
                .mapToDouble(DetalleVenta::getSubtotal)
                .sum();
    }

     public void generarPago(String metodoPago) {
        this.pago = new Pago();
        pago.setIdSocio(this.idSocio);
        pago.setIdMembresia(0); // 0 porque no está asociado a membresía
        pago.setMonto(this.montoTotal);
        pago.setFechaPago(this.fechaVenta.toLocalDate());
        pago.setMetodoPago(metodoPago);
        pago.setEstado("Pagado");
        }

    @Override
    public String toString() {
        return "Venta [idVenta=" + idVenta + ", idSocio=" + idSocio + ", fechaVenta=" + fechaVenta + ", montoTotal="
                + montoTotal + ", detalles=" + detalles + "]";
    }


    
}
