package pujaQpuja.model.repository;

import pujaQpuja.model.entities.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductoRepository extends DB {

    public ProductoRepository() {
    }

    public Producto buscarPorID(long idProducto) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        Producto producto = new Producto();

        String sql = "";
        sql += "SELECT * FROM Producto ";
        sql += "WHERE id = ?";

        try {
            ps = con.prepareStatement(sql);

            ps.setLong(1, idProducto);
            rs = ps.executeQuery();

            if (rs.next()) {

                producto.setId(rs.getLong("id"));

                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setFoto(null);
                producto.setCondicion(Condicion.valueOf(rs.getString("condicion")));
                producto.setPrecioInicial(rs.getDouble("id"));
                producto.setCategoria(Categoria.valueOf(rs.getString("categoria")));

                return producto;
            }
            return producto;
        } catch (SQLException e) {
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

    public Producto crear(Producto producto) throws SQLException {
        //PreparedStatement ps = null;
        Connection con = getConexion();
        ResultSet rs;
        String sql = "";
        sql += "INSERT INTO Producto ";
        sql += "(nombre,descripcion,condicion,precioInicial,categoria) ";
        sql += "VALUES (?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS);

        try {
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            //ps.setBlob(3, producto.getFoto());
            ps.setString(3, String.valueOf(producto.getCondicion()));
            ps.setDouble(4, producto.getPrecioInicial());
            ps.setString(5, String.valueOf(producto.getCategoria()));

            ps.execute();
            rs = ps.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
            producto.setId(generatedKey);
            return producto;

        } catch (SQLException e) {
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
