package com.example.spring_gym.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reportes")
public class Reporte {
  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private int idReporte;
    private String tipoReporte;   // "Ingresos", "Asistencia", "Ventas", "Inventario"
    private LocalDateTime fechaGeneracion;
    private String descripcion;   // Breve detalle del reporte
    private String generadoPor;
    public Reporte() {
    }
    
    public Reporte(String tipoReporte, LocalDateTime fechaGeneracion, String descripcion, String generadoPor) {
        this.tipoReporte = tipoReporte;
        this.fechaGeneracion = fechaGeneracion;
        this.descripcion = descripcion;
        this.generadoPor = generadoPor;
    }

    public int getIdReporte() {
        return idReporte;
    }
    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
    }
    public String getTipoReporte() {
        return tipoReporte;
    }
    public void setTipoReporte(String tipoReporte) {
        this.tipoReporte = tipoReporte;
    }
    public LocalDateTime getFechaGeneracion() {
        return fechaGeneracion;
    }
    public void setFechaGeneracion(LocalDateTime fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getGeneradoPor() {
        return generadoPor;
    }
    public void setGeneradoPor(String generadoPor) {
        this.generadoPor = generadoPor;
    } 
    
    public String generarResumen() {
        return "Reporte{" +
                "tipo='" + tipoReporte + '\'' +
                ", fecha=" + fechaGeneracion +
                ", descripcion='" + descripcion + '\'' +
                ", generadoPor='" + generadoPor + '\'' +
                '}';
    }
}
