/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import static java.lang.Class.forName;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import static java.sql.DriverManager.getConnection;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class ConexionBD {

    public String driver, bd, url, user, pass;
    public Connection conexion;

    public ConexionBD() {

        driver = "com.mysql.jdbc.Driver";
        bd = "Biovet";
        user = "root";
        pass = "";
        url = "jdbc:mysql://localhost:3306/" + bd;

        try {
            forName(driver).newInstance();
            conexion = getConnection(url, user, pass);
            out.println("Conexión OK!");

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            out.println("Error al conectarse" + e);
        }

    }

    public Connection obtenerConexion() {
        return conexion;
    }

    public Connection cerrarConexion() throws SQLException {
        conexion.close();
        conexion = null;
        return conexion;
    }

//    public static void main(String[] args) {
//        new ConexionBD();
//    }
}
