/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author josue
 */
public class Conexion {

    private Connection cnx;
//Oracle Connection

    public Connection conectar() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            cnx = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "PickList", "PickList");
            System.out.println("Conectado");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: " + e);
        }
        return cnx;
    }

    public void cerrar() throws Exception {
        try {
            if (cnx != null) {
                if (cnx.isClosed() == false) {
                    cnx.close();
                }
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        try {
            Conexion dao = new Conexion();
            dao.conectar();
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
    }
}
