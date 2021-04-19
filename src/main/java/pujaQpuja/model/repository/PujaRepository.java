package pujaQpuja.model.repository;

import pujaQpuja.controller.UsuarioController;
import pujaQpuja.controller.modelos.ProductoController;
import pujaQpuja.model.entities.EstadoPuja;
import pujaQpuja.model.entities.Producto;
import pujaQpuja.model.entities.Puja;
import pujaQpuja.model.entities.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pujaQpuja.controller.GeneralController;

public class PujaRepository extends DB {
    UsuarioController usuarioController;
    ProductoController productoController;

    public PujaRepository()
    {
        usuarioController = new UsuarioController();
        productoController = new ProductoController();
    }

    public List<Puja> getPujasActivas() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        List<Puja> respuesta = new ArrayList<>();

        String sql = "";
        sql += "SELECT * FROM Puja ";
        sql += "WHERE estado = ?";

        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, String.valueOf(EstadoPuja.ACTIVO));
            rs = ps.executeQuery();


            while(rs.next())
            {
                Puja temp = new Puja();

                temp.setId(rs.getLong("id"));
                temp.setEstado(EstadoPuja.valueOf(rs.getString("estado")));
                temp.setPrecioFinal(rs.getDouble("precioFinal"));
                temp.setFecha(rs.getDate("fecha"));
                temp.setProducto(productoController.buscarPorID(rs.getLong("idProducto")));

                respuesta.add(temp);
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
    }
    public boolean crear(Puja puja, Long usuarioId, Long productoId) {

        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "";
        sql += "INSERT INTO Puja ";
        sql += "(precioFinal, fecha,idHistorialVentas, idProducto, estado) ";
        sql += "VALUES (?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);

            ps.setDouble(1, puja.getPrecioFinal());
            ps.setDate(2, puja.getFecha());
            ps.setLong(3, usuarioId);
            ps.setLong(4, productoId);
            ps.setString(5, String.valueOf(EstadoPuja.ACTIVO));
 

            return ps.execute();
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                desconectar();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

}
