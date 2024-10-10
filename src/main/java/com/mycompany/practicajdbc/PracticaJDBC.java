package com.mycompany.practicajdbc;

import DAO.Conexion;
import DAO.ProdDAO;
import DAO.IngredienteDAO;
import DAO.VentaDAO;
import java.sql.Connection;
import java.sql.SQLException;
import Entidades.*;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author eduar
 */
public class PracticaJDBC {

    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PizzeriaBDA");
        EntityManager em = emf.createEntityManager();

        ProdDAO prodDAO = new ProdDAO();
        IngredienteDAO ingredienteDAO = new IngredienteDAO(em);
        VentaDAO ventaDAO = new VentaDAO();
        LocalDate fechaInicio = LocalDate.of(2024, 8, 1);
        LocalDate fechaFin = LocalDate.of(2024, 9, 30);

        try {
            Connection cnx = conexion.conectar();
            System.out.println("Conexion realizada");
            // Iniciar una transacción
            em.getTransaction().begin();

            // Ejemplo: Crear y guardar un nuevo producto
            Producto nuevoProducto = new Producto("Pizza Margherita", "Pizza clásica con tomate y mozzarella", 300);
            em.persist(nuevoProducto);
            em.getTransaction().commit();

            // Consultar productos con precio mayor a 250
            System.out.println("Consula de productos");
            List<Producto> productosCaros = prodDAO.buscarProductosPorPrecioMayorA(em, 250);
            System.out.println("Productos con precio mayor a 250:");
            for (Producto producto : productosCaros) {
                System.out.println(producto);
            }

            // Consultar ingredientes cuyo nombre inicia o termina con "A"
            System.out.println("Consulta de ingredientes");
            List<Ingrediente> ingredientes = ingredienteDAO.buscarIngredientesPorNombre("A");  // Usar la instancia
            System.out.println("Ingredientes cuyo nombre inicia o termina con 'A':");
            for (Ingrediente ingrediente : ingredientes) {
                System.out.println(ingrediente);
            }

            // Consultar ventas entre agosto y septiembre de 2024
            System.out.println("Consulta de ventas");
            List<Venta> ventas = ventaDAO.buscarVentasPorRangoDeFechas(em, fechaInicio, fechaFin); // Llama al método desde la instancia
            System.out.println("Ventas entre agosto y septiembre de 2024:");
            for (Venta venta : ventas) {
                System.out.println(venta);
            }

            // Cerrar el EntityManager y la fábrica
            em.close();
            emf.close();
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }

    }
}
