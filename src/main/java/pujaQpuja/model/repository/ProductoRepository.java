package pujaQpuja.model.repository;

import pujaQpuja.controller.modelos.PujaController;
import pujaQpuja.model.entities.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepository extends DB {

    public ProductoRepository() {
        PujaController pujaController;
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

    /*
    public List<Producto> listaProducto() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        List<Producto> respuesta = new ArrayList<>();

        String sql = "";
        sql += "SELECT * FROM Producto ";
        sql += "WHERE categoria = ?";

        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, String.valueOf(Categoria.DEPORTE));
            rs = ps.executeQuery();

            if (rs.next()) {

                producto.setId(rs.getLong("id"));

                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setFoto(null);
                producto.setCondicion(Condicion.valueOf(rs.getString("condicion")));
                producto.setPrecioInicial(rs.getDouble("id"));
                producto.setCategoria(Categoria.valueOf(rs.getString("categoria")));

                return respuesta;
            }
            return respuesta;
        } catch (SQLException e) {
            System.err.println(e);
            return respuesta;
        } finally {
            try {
                desconectar();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }*/


}
