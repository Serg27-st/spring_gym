package com.example.spring_gym.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "membresias")
public class Membresia {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
    private int idMembresia;
    private int idSocio;
    private String tipo; // Mensual, Trimestral, Anual
    private double costo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String estado;

    @ManyToOne
	private Socio socio;
	
    @OneToMany(mappedBy = "membresia")
    private List<Pago> pagos;
    
    public Membresia() {
    }
    
   

    public Membresia(int idMembresia, int idSocio, String tipo, double costo, LocalDate fechaInicio, LocalDate fechaFin,
            String estado) {
       super();
                this.idMembresia = idMembresia;
        this.idSocio = idSocio;
        this.tipo = tipo;
        this.costo = costo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
    }



    public int getIdMembresia() {
        return idMembresia;
    }
    public void setIdMembresia(int id) {
        this.idMembresia = id;
    }
    
    public int getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }
    
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public double getCosto() {
        return costo;
    }
    public void setCosto(double costo) {
        this.costo = costo;
    }
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public LocalDate getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public boolean estaActiva() {
        return "Activa".equalsIgnoreCase(estado) && 
               fechaFin.isAfter(LocalDate.now());
    }

    @Override
    public String toString() {
        return "Membresia [id=" + idMembresia + ", tipo=" + tipo + ", costo=" + costo + ", fechaInicio=" + fechaInicio
                + ", fechaFin=" + fechaFin + ", estado=" + estado + "]";
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public List<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(List<Pago> pagos) {
        this.pagos = pagos;
    }




    

}
