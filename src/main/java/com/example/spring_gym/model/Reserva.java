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
@Table(name = "reservas")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReserva;
    private Date fechaReserva;
    private String tipo; // clase grupal o personal
    private String estado; // Fendiente, confirmada, cancelada
    private int idSocio;
    private int idEntrenador;

    @ManyToOne
    //@JoinColumn(name = "idSocio")
    private Socio socio;

    // Relación con Entrenador (opcional)
    @ManyToOne
    //@JoinColumn(name = "idEntrenador")
    private Entrenador entrenador;

    @OneToMany(mappedBy = "reserva")
    //@JoinColumn(name = "idEntrenador")
    private List<Asistencia> asistencias;

    

public Reserva() {
}

public Reserva(Integer idReserva, Date fechaReserva, String tipo, String estado, int idSocio, int idEntrenador) {
    super();
    this.idReserva = idReserva;
    this.fechaReserva = fechaReserva;
    this.tipo = tipo;
    this.estado = estado;
    this.idSocio = idSocio;
    this.idEntrenador = idEntrenador;
}

public Integer getIdReserva() {
    return idReserva;
}
public void setIdReserva(Integer idReserva) {
    this.idReserva = idReserva;
}
public Date getFechaReserva() {
    return fechaReserva;
}
public void setFechaReserva(Date fechaReserva) {
    this.fechaReserva = fechaReserva;
}
public String getTipo() {
    return tipo;
}
public void setTipo(String tipo) {
    this.tipo = tipo;
}
public String getEstado() {
    return estado;
}
public void setEstado(String estado) {
    this.estado = estado;
}
public int getIdSocio() {
    return idSocio;
}
public void setIdSocio(int idSocio) {
    this.idSocio = idSocio;
}
public int getIdEntrenador() {
    return idEntrenador;
}
public void setIdEntrenador(int idEntrenador) {
    this.idEntrenador = idEntrenador;
}

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public List<Asistencia> getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(List<Asistencia> asistencias) {
        this.asistencias = asistencias;
    }


}
