package pujaQpuja.model.repository;

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

public class ProductoRepository {

    private DB db;

    public ProductoRepository() {
        db = DB.getInstance();
    }

    public boolean crear(Producto producto, String rutaImagen) {

        Connection con = db.getConexion();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "";
        sql += "INSERT INTO Producto ";
        sql += "(nombre, descripcion, condicion, precioInicial, categoria, foto) ";
        sql += "VALUES (?,?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

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

            if (rs.next()) {
                int generatedKey = rs.getInt(1);
                producto.setId(generatedKey);
                return true;
            }
            return false;
        } catch (SQLException | FileNotFoundException e) {
            System.err.println(e);
            return false;
        }
    }

    public Producto buscarProductoPorId(long id) {

        Connection con = db.getConexion();
        PreparedStatement ps;
        ResultSet rs;

        Producto producto = new Producto();

        String sql = "";
        sql += "SELECT * FROM Producto ";
        sql += "WHERE id = ?";

        try {
            ps = con.prepareStatement(sql);

            ps.setLong(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {

                producto.setId(rs.getLong("id"));

                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setCondicion(Condicion.valueOf(rs.getString("condicion")));
                producto.setPrecioInicial(rs.getDouble("id"));
                producto.setCategoria(Categoria.valueOf(rs.getString("categoria")));

                //Inicio proceso para cargar imagen
                File file = new File("imagen_obtenida_DB.jpg");
                byte[] buffer = new byte[1024];
                InputStream input = rs.getBinaryStream("foto");
                FileOutputStream output = new FileOutputStream(file);
                //System.out.println("Leyendo archivo desde la base de datos...");
                while (input.read(buffer) > 0) {
                    output.write(buffer);
                }
                //System.out.println("> Archivo guardado en : " + file.getAbsolutePath());
                //Fin proceso para cargar imagen

                producto.setFoto(Utiles.cargarImagenConRuta(file.getAbsolutePath()));

                return producto;
            }
            return producto;
        } catch (SQLException | IOException e) {
            System.err.println(e);
            return producto;
        }
    }

    public boolean eliminarPujaPorId(long idProductoAEliminar) {
        Connection con = db.getConexion();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "";
        sql += "DELETE FROM Producto ";
        sql += "WHERE id = ?";

        try {
            ps = con.prepareStatement(sql);

            ps.setLong(1, idProductoAEliminar);

            return ps.execute();

        } catch (SQLException e) {
            System.err.println(e);
            return false;

        }

    }

    public boolean modificarProducto(Producto productoASubastar) {
        Connection con = db.getConexion();
        PreparedStatement ps;

        String sql = "";
        sql += "UPDATE Producto ";
        sql += "SET nombre = ?, descripcion = ?, categoria = ? ";
        sql += "WHERE id = ?";

        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, productoASubastar.getNombre());
            ps.setString(2,productoASubastar.getDescripcion());
            ps.setString(3, String.valueOf(productoASubastar.getCategoria()));
            ps.setLong(4, productoASubastar.getId());
            return ps.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }
}
