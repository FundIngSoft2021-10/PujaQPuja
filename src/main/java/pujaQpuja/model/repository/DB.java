package pujaQpuja.model.repository;

import pujaQpuja.controller.modelos.AutenticacionController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

    // ----------------------------------------------------------
    // ----------------------- Singleton ------------------------
    // ----------------------------------------------------------

    private static DB conexion = null;

    public static DB getInstance() {
        if (conexion == null) {
            conexion = new DB();
        }
        return conexion;
    }

    // ----------------------------------------------------------
    // ---------------- Conexión Base de Datos ------------------
    // ----------------------------------------------------------

    public DB() {
    }

    private Connection conn;
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String usuario = "oEfG6GXUek";
    private static final String contra = "K6JclSHrlp";
    private static final String url = "jdbc:mysql://remotemysql.com:3306/oEfG6GXUek";

    public Connection getConexion() {
        if (conn == null) {
            try {
                Class.forName(driver);
                conn = DriverManager.getConnection(url, usuario, contra);
                if (conn != null)
                    System.out.println("Conexión creada correctamente");
            } catch (Exception e) {
                System.out.println("Error al conectar con la base de datos: " + e);
                return null;
            }
        }
        return conn;
    }

    public void desconectar() {
        try {
            if (conn != null) {
                conn.close();
            }
            conn = null;
            if (conn == null)
                System.out.println("Conexión terminada correctamente");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
