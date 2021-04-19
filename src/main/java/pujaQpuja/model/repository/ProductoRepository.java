package pujaQpuja.model.repository;

import pujaQpuja.model.entities.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

}
