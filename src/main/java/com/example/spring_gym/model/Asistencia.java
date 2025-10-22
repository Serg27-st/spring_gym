package com.example.spring_gym.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "asistencias")
public class Asistencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAsistencia;
    private int idSocio;        // Relación con Socio
    private int idReserva;      // Relación con Reserva (si aplica a clase grupal o entrenamiento)
    private LocalDateTime fechaHoraEntrada;
    private LocalDateTime fechaHoraSalida;
    private String observacion;
    

     @ManyToOne
    //@JoinColumn(name = "idSocio", nullable = false)
    private Socio socio;
     @ManyToOne
    //@JoinColumn(name = "idReserva", nullable = false)
    private Reserva reserva;
    
    public Asistencia() {
    }
    
    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Asistencia(int idAsistencia, int idSocio, int idReserva, LocalDateTime fechaHoraEntrada,
            LocalDateTime fechaHoraSalida, String observacion) {
        super();
                this.idAsistencia = idAsistencia;
        this.idSocio = idSocio;
        this.idReserva = idReserva;
        this.fechaHoraEntrada = fechaHoraEntrada;
        this.fechaHoraSalida = fechaHoraSalida;
        this.observacion = observacion;
    }
    public int getIdAsistencia() {
        return idAsistencia;
    }
    public void setIdAsistencia(int idAsistencia) {
        this.idAsistencia = idAsistencia;
    }
    public int getIdSocio() {
        return idSocio;
    }
    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }
    public int getIdReserva() {
        return idReserva;
    }
    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }
    public LocalDateTime getFechaHoraEntrada() {
        return fechaHoraEntrada;
    }
    public void setFechaHoraEntrada(LocalDateTime fechaHoraEntrada) {
        this.fechaHoraEntrada = fechaHoraEntrada;
    }
    public LocalDateTime getFechaHoraSalida() {
        return fechaHoraSalida;
    }
    public void setFechaHoraSalida(LocalDateTime fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }
    public String getObservacion() {
        return observacion;
    }
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public long calcularDuracionEnMinutos() {
        if (fechaHoraEntrada != null && fechaHoraSalida != null) {
            return java.time.Duration.between(fechaHoraEntrada, fechaHoraSalida).toMinutes();
        }
        return 0;
    }
    @Override
    public String toString() {
        return "Asistencia [idAsistencia=" + idAsistencia + ", idSocio=" + idSocio + ", idReserva=" + idReserva
                + ", fechaHoraEntrada=" + fechaHoraEntrada + ", fechaHoraSalida=" + fechaHoraSalida + ", observacion="
                + observacion + "]";
    }

    

}
