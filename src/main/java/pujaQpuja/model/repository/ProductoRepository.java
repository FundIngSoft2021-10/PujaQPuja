package pujaQpuja.model.repository;

import pujaQpuja.controller.modelos.PujaController;
import pujaQpuja.model.entities.*;
import pujaQpuja.utilities.Utiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductoRepository extends DB {

    public ProductoRepository() {
        PujaController pujaController;
    }

    public Producto buscarPorID(long idProducto) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        Producto producto = new Producto();

        InputStream input = null;
        FileOutputStream output = null;

        String sql = "";
        sql += "SELECT * FROM Producto ";
        sql += "WHERE id = ?";

        try {
            ps = con.prepareStatement(sql);

            ps.setLong(1, idProducto);
            rs = ps.executeQuery();
            File file = new File("reporte_db.jpg");
            output = new FileOutputStream(file);

            if (rs.next()) {

                producto.setId(rs.getLong("id"));

                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setCondicion(Condicion.valueOf(rs.getString("condicion")));
                producto.setPrecioInicial(rs.getDouble("id"));
                producto.setCategoria(Categoria.valueOf(rs.getString("categoria")));


                input = rs.getBinaryStream("foto");
                System.out.println("Leyendo archivo desde la base de datos...");
                byte[] buffer = new byte[1024];
                while (input.read(buffer) > 0) {
                    output.write(buffer);
                }
                System.out.println("> Archivo guardado en : " + file.getAbsolutePath());
                producto.setFoto(Utiles.cargarImagenConRuta(file.getAbsolutePath()));

                return producto;
            }
            return producto;
        } catch (SQLException | IOException e) {
            System.err.println(e);
            return producto;
        } finally {
            try {
                desconectar();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public Producto crear(Producto producto, String rutaImagen) throws SQLException {
        // PreparedStatement ps = null;
        Connection con = getConexion();
        ResultSet rs;
        String sql = "";
        sql += "INSERT INTO Producto ";
        sql += "(nombre, descripcion, condicion, precioInicial, categoria, foto) ";
        sql += "VALUES (?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        try {
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setString(3, String.valueOf(producto.getCondicion()));
            ps.setDouble(4, producto.getPrecioInicial());
            ps.setString(5, String.valueOf(producto.getCategoria()));

            File imagen = new File(rutaImagen);
            FileInputStream fis = new FileInputStream(imagen);
            ps.setBinaryStream(6, fis, (int) imagen.length());

            ps.execute();
            rs = ps.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
            producto.setId(generatedKey);
            return producto;

        } catch (SQLException | FileNotFoundException e) {
            System.err.println(e);
            return null;
        } finally {
            try {
                desconectar();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

}
