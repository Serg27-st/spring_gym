package com.example.spring_gym.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="inventarios")
public class Inventario {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idInventario;
	private String nombre;
	private String descripcion;
	private String imagen;
	private double precio;
	private int cantidad;
    
    @ManyToOne
    private Socio socio;
    
    @OneToMany(mappedBy = "inventario")
    private List<DetalleVenta> detalles;


    public Inventario() {
    }
    
   

    public Inventario(Integer idInventario, String nombre, String descripcion, String imagen, double precio,
            int cantidad, Socio socio) {
        super();
        this.idInventario = idInventario;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.precio = precio;
        this.cantidad = cantidad;
        this.socio = socio;
    }



    public Integer getIdInventario() {
        return idInventario;
    }
    public void setIdInventario(Integer id) {
        this.idInventario = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getImagen() {
        return imagen;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
     public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    @Override
    public String toString() {
        return "Producto [id=" + idInventario + ", nombre=" + nombre + ", descripcion=" + descripcion + ", imagen=" + imagen
                + ", precio=" + precio + ", cantidad=" + cantidad + "]";
    }

    public List<DetalleVenta> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleVenta> detalles) {
        this.detalles = detalles;
    }

   
    
    
}
