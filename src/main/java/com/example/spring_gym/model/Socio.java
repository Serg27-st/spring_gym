package com.example.spring_gym.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="socios")
public class Socio {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idSocio;
	private String nombre;
	private String username;
	private String email;
	private String direccion;
	private String telefono;
	private String tipo;
	private String password;
    @OneToMany(mappedBy= "socio")
    private List<Inventario> inventarios;

    @OneToMany(mappedBy = "socio")
    private List<Venta> ventas;
    

    
    public Socio() {
    }

    public Socio(Integer idSocio, String nombre, String username, String email, String direccion, String telefono,
            String tipo, String password) {
                super();
        this.idSocio = idSocio;
        this.nombre = nombre;
        this.username = username;
        this.email = email;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tipo = tipo;
        this.password = password;
    }

    public Integer getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(Integer id) {
        this.idSocio = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
     public List<Inventario> getInventario() {
        return inventarios;
    }

    public void setInventario(List<Inventario> inventario) {
        this.inventarios = inventario;
    }

    @Override
    public String toString() {
        return "Usuario [id=" + idSocio + ", nombre=" + nombre + ", username=" + username + ", email=" + email
                + ", direccion=" + direccion + ", telefono=" + telefono + ", tipo=" + tipo + ", password=" + password
                + "]";
    }

    public List<Inventario> getInventarios() {
        return inventarios;
    }

    public void setInventarios(List<Inventario> inventarios) {
        this.inventarios = inventarios;
    }


    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

   
    

}
