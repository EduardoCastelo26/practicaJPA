/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author eduar
 */
public class Conexion {

    public Connection conectar() throws SQLException {
        String driver = "com.mysql.cj.jdbc.Driver";
        String u = "jdbc:mysql://127.0.0.1:3306/?user=root"; 
        String url = "jdbc:mysql://127.0.0.1/PizzeriaBDA?autoReconnect=true&useSSL=false";
        String user = "root";
        String password = "072026";
        String i = "INSERT INTO productos(nombre,precio,descripcion) VALUES(?,?,?)";
        String empleados = "INSERT INTO Empleados(nombre,fecha_nac,puesto,telefono) VALUES (?,?,?,?)";

        try {

            // Registrar el Driver
            Class.forName(driver);
            // Obtener la conexión,pasamos argumentos (url, user y password) para establecer una conexion con la basse de datos
            Connection conexion = DriverManager.getConnection(url, user, password);
            JOptionPane.showMessageDialog(null, "Conexion realizada con exito");
            PreparedStatement insert = conexion.prepareStatement(i, Statement.RETURN_GENERATED_KEYS);
            insert.setString(1, "Pizza de peperoni");
            insert.setFloat(2, (float) 89.0);
            insert.setString(3, "Pizza sencilla con base de tomate");
            insert.executeUpdate();

            /*Para insertar un dato tipo fecha
            Primero se importa la clase sql.date (import java.sql.Date;)
            Seguido se define una variable tipo String con la fecha en formato yyyy-MM-dd
            (String fechaStr = "2002-02-26";)
            Despues se convierte la variable tipo String a un objeto java.sql.Date 
            O en resumen convertimos la variable tipo String un objeto 
            tipo fecha de sql (sql.date)de la siguiente manera= 
            
            String fechaStr = "2002-02-26";
            Date fecha = Date.valueOf(fechaStr);
             */
            
            // Fecha en formato yyyy-MM-dd
            String fechaStr = "2002-02-26";
            // Convertimos la fecha a un objeto java.sql.Date
            Date fecha = Date.valueOf(fechaStr);
            
            
            PreparedStatement insertar = conexion.prepareStatement(empleados, Statement.RETURN_GENERATED_KEYS);
            insertar.setString(1, "Lalo Mendoza");
            insertar.setDate(2, fecha);
            insertar.setString(3, "Hoster");
            insertar.setString(4, "6441197321");
            insertar.executeUpdate();

            return conexion;

        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error CLASE NO ENCONTRADA: " + e.getMessage());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos: " + e.getMessage());
            throw e; // Para que el error sea visible en la clase principal
        }
        return null;
    }
}
