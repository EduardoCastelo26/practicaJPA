package Entidades;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import java.util.List;

@Entity
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;
    private LocalDate fecha_nac;
    private String puesto;
    private String telefono;

    // Relación uno a muchos con Venta
    @OneToMany(mappedBy = "empleado")
    private List<Venta> ventas;

    public Empleado() {}

    public Empleado(String nombre, LocalDate fecha_nac, String puesto, String telefono) {
        this.nombre = nombre;
        this.fecha_nac = fecha_nac;
        this.puesto = puesto;
        this.telefono = telefono;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(LocalDate fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nombre='" + nombre + '\'' + ", fecha_nac=" + fecha_nac + ", puesto='" + puesto + '\'' + ", telefono='" + telefono + '\'' + '}';
    }
}
