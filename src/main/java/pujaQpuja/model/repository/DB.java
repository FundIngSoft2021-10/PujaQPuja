package pujaQpuja.model.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class DB {
    private static Connection conn;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String usuario = "oEfG6GXUek";
    private static final String contra = "K6JclSHrlp";
    private static final String url = "jdbc:mysql://remotemysql.com:3306/oEfG6GXUek";

    public Connection getConexion() {
        conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, contra);
            if (conn != null)
                System.out.println("Conexión creada correctamente");
            return conn;
        } catch (Exception e) {
            System.out.println("Error al conectar con la base de datos: " + e);
            return null;
        }
    }

    public void desconectar() {
        conn = null;
        if (conn == null)
            System.out.println("Conexión terminada correctamente");
    }
}
