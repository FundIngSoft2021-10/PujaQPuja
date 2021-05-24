package pujaQpuja.model.repository;

import pujaQpuja.model.entities.*;
import pujaQpuja.controller.modelos.UsuarioController;
import pujaQpuja.controller.modelos.ProductoController;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MensajeRepository extends DB {
    private UsuarioController usuarioController;
    private ProductoController productoController;
    public MensajeRepository() {
        usuarioController = new UsuarioController();
        productoController = new ProductoController();
    }

    public boolean crear(Mensaje mensaje) {

        Connection con = getConexion();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "";
        sql += "INSERT INTO Mensaje ";
        sql += "(idPuja, cuerpo, idEmisor, idReceptor) ";
        sql += "VALUES (?,?,?,?)";

        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setLong(1, mensaje.getIdPuja());
            ps.setString(2, mensaje.getCuerpo());
            ps.setLong(3, mensaje.getEmisor());
            ps.setLong(4, mensaje.getReceptor());

            ps.execute();
            rs = ps.getGeneratedKeys();

            if (rs.next()) {
                int generatedKey = rs.getInt(1);
                mensaje.setId(generatedKey);
                return true;
            }
            return false;
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

    public List<Mensaje> getPreguntasYRespuestas(long id) {

        Connection con = getConexion();
        PreparedStatement ps;
        ResultSet rs;

        List<Mensaje> respuesta = new ArrayList<>();

        String sql = "";
        sql += "SELECT * ";
        sql += "FROM Mensaje ";
        sql += "WHERE idEmisor = ? ";

        try {
            ps = con.prepareStatement(sql);

            ps.setLong(1, id);

            rs = ps.executeQuery();

            while (rs.next()) {
                Mensaje temp = new Mensaje();

                temp.setId(rs.getLong("id"));
                temp.setIdPuja(rs.getLong("idPuja"));
                temp.setCuerpo(rs.getString("cuerpo"));
                temp.setRespuesta(rs.getString("respuesta"));
                temp.setEmisor(rs.getLong("idEmisor"));
                temp.setReceptor(rs.getLong("idReceptor"));

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

    public Puja getPujaXMensaje(long id) {
        Connection con = getConexion();
        PreparedStatement ps;
        ResultSet rs;

        Puja temp = new Puja();

        String sql = "";
        sql += "SELECT p.* FROM Mensaje m, Puja p ";
        sql += "WHERE p.id = ? AND m.idPuja = p.id ";
        sql += "GROUP BY p.id";

        try {
            ps = con.prepareStatement(sql);

            ps.setLong(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                temp.setId(rs.getLong("id"));
                temp.setEstado(EstadoPuja.valueOf(rs.getString("estado")));
                temp.setPrecioFinal(rs.getDouble("precioFinal"));
                temp.setFecha(rs.getDate("fecha"));
                temp.setProducto(productoController.buscarPorId(rs.getLong("idProducto")));
                temp.setVendedor(usuarioController.buscarPorId(rs.getLong("idHistorialVentas")));

                return temp;
            }
            return temp;

        } catch (SQLException e) {
            System.err.println(e);
            return temp;

        } finally {
            try {
                desconectar();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean respuesta(String respuesta, long id) {

        Connection con = getConexion();
        PreparedStatement ps;

        String sql = "";
        sql += "UPDATE Mensaje ";
        sql += "SET respuesta = ? ";
        sql += "WHERE id = ?";

        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, respuesta);
            ps.setLong(2, id);

            return !ps.execute();
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

    public Mensaje buscarPorId(long id) {

        Connection con = getConexion();
        PreparedStatement ps;
        ResultSet rs;

        Mensaje temp = new Mensaje();

        String sql = "";
        sql += "SELECT * FROM Mensaje ";
        sql += "WHERE id = ?";

        try {
            ps = con.prepareStatement(sql);

            ps.setLong(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                temp.setId(rs.getLong("id"));
                temp.setIdPuja(rs.getLong("idPuja"));
                temp.setEmisor(rs.getLong("idEmisor"));
                temp.setReceptor(rs.getLong("idReceptor"));
                temp.setCuerpo(rs.getString("cuerpo"));
                temp.setRespuesta(rs.getString("respuesta"));

                return temp;
            }
            return temp;

        } catch (SQLException e) {
            System.err.println(e);
            return temp;

        } finally {
            try {
                desconectar();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public List<Mensaje> getPreguntasIdPuja(long id) {

        Connection con = getConexion();
        PreparedStatement ps;
        ResultSet rs;

        List<Mensaje> respuesta = new ArrayList<>();

        String sql = "";
        sql += "SELECT * ";
        sql += "FROM Mensaje ";
        sql += "WHERE idPuja = ? ";

        try {
            ps = con.prepareStatement(sql);

            ps.setLong(1, id);

            rs = ps.executeQuery();

            while (rs.next()) {
                Mensaje temp = new Mensaje();

                temp.setId(rs.getLong("id"));
                temp.setIdPuja(rs.getLong("idPuja"));
                temp.setCuerpo(rs.getString("cuerpo"));
                temp.setRespuesta(rs.getString("respuesta"));
                temp.setEmisor(rs.getLong("idEmisor"));
                temp.setReceptor(rs.getLong("idReceptor"));

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
}
