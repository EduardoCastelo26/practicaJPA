package Entidades;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import java.util.List;

@Entity
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Basic
    private double total;
    private LocalDate fecha;
    

    // Relación muchos a uno con Empleado
    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    // Relación muchos a muchos con Producto
    @ManyToMany
    @JoinTable(
        name = "Producto_Venta",
        joinColumns = @JoinColumn(name = "id_venta"),
        inverseJoinColumns = @JoinColumn(name = "id_producto")
    )
    private List<Producto> productos;

    public Venta() {}

    public Venta(LocalDate fecha, double total, Empleado empleado) {
        this.fecha = fecha;
        this.total = total;
        this.empleado = empleado;
    }

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Venta{" + "id=" + id + ", total=" + total + ", fecha=" + fecha + ", empleado=" + empleado + ", productos=" + productos + '}';
    }


}
