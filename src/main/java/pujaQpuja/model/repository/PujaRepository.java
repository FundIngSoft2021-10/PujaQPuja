package pujaQpuja.model.repository;

import pujaQpuja.controller.UsuarioController;
import pujaQpuja.controller.modelos.ProductoController;
import pujaQpuja.model.entities.*;

import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class PujaRepository extends DB {
    UsuarioController usuarioController;
    ProductoController productoController;


    public PujaRepository() {
        usuarioController = new UsuarioController();
        productoController = new ProductoController();

    }

    public Puja buscarPuja(long id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        Puja temp = new Puja();

        String sql = "";
        sql += "SELECT * FROM Puja ";
        sql += "WHERE id = ?";

        try {
            ps = con.prepareStatement(sql);

            ps.setLong(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                temp.setId(rs.getLong("id"));
                temp.setEstado(EstadoPuja.valueOf(rs.getString("estado")));
                temp.setPrecioFinal(rs.getDouble("precioFinal"));
                temp.setFecha(rs.getDate("fecha"));
                temp.setProducto(productoController.buscarPorID(rs.getLong("idProducto")));

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

            }
        }


    }

    public List<Puja> getPujasActivasByEstadoPujaYCategoriaProducto(EstadoPuja estado, Categoria categoria) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        List<Puja> respuesta = new ArrayList<>();

        String sql = "";
        sql += "SELECT p.* ";
        sql += "FROM Puja p, Producto pr ";
        sql += "WHERE p.idProducto = pr.id ";
        sql += "AND p.estado = ? ";
        if (categoria != null)
            sql += "AND pr.categoria = ?";

        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, String.valueOf(estado));
            if (categoria != null)
                ps.setString(2, String.valueOf(categoria));

            rs = ps.executeQuery();


            while (rs.next()) {
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


    public int ContadorPujantes(Long parametro) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        int temp = 5;

        String sql = "";
        sql += "SELECT COUNT(c.idComprador) numPujantes ";
        sql += "FROM CompradorXPuja c ";
        sql += "WHERE c.idPuja = ?";


        try {
            ps = con.prepareStatement(sql);

            ps.setLong(1, parametro);
            rs = ps.executeQuery();

            if (rs.next()) {
                temp = rs.getInt("numPujantes");
                System.out.println(temp + "bandera");

                return temp;
            }

            return 0;
        } catch (SQLException e) {
            System.err.println(e);
            return temp;

        } finally {
            try {
                desconectar();
            } catch (SQLException e) {

            }
        }


    }


    public boolean añadirPujante(Long idPuja, Long idComprador,Double nuevoprecio) {
        PreparedStatement ps = null;
        //ResultSet rs = null;
        Connection con = getConexion();
        int temp = 0;

        String sql = "";
        sql += "INSERT INTO CompradorXPuja(idComprador,  idPuja, fechaComprador) ";
        sql += "VALUES (?, ?, ?)";

        try {
            ps = con.prepareStatement(sql);

            ps.setLong(1, idComprador);
          //  ps.setDouble(2, nuevoprecio);
            ps.setLong(2, idPuja);
            LocalDate localDate = LocalDate.now();
            ps.setDate(3,java.sql.Date.valueOf(localDate));
            System.out.println(localDate.toString());
            return ps.execute();


        } catch (SQLException e) {
            System.err.println(e);
            return false;

        } finally {
            try {
                desconectar();
            } catch (SQLException e) {

            }
        }


    }


}



