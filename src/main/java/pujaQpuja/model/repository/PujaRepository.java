package pujaQpuja.model.repository;

import pujaQpuja.controller.modelos.AutenticacionController;
import pujaQpuja.controller.modelos.UsuarioController;
import pujaQpuja.controller.modelos.ProductoController;
import pujaQpuja.model.entities.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PujaRepository extends DB {

    private UsuarioController usuarioController;
    private ProductoController productoController;

    public PujaRepository() {
        usuarioController = new UsuarioController();
        productoController = new ProductoController();
    }

    public boolean crear(Puja puja, Long usuarioId, Long productoId) {

        Connection con = getConexion();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "";
        sql += "INSERT INTO Puja ";
        sql += "(precioFinal, fecha,idHistorialVentas, idProducto, estado) ";
        sql += "VALUES (?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setDouble(1, puja.getPrecioFinal());
            ps.setDate(2, puja.getFecha());
            ps.setLong(3, usuarioId);
            ps.setLong(4, productoId);
            ps.setString(5, String.valueOf(EstadoPuja.ACTIVO));

            ps.execute();
            rs = ps.getGeneratedKeys();

            if (rs.next()) {
                int generatedKey = rs.getInt(1);
                puja.setId(generatedKey);
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

    public Puja buscarPujaPorId(long id) {

        Connection con = getConexion();
        PreparedStatement ps;
        ResultSet rs;

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
                temp.setProducto(productoController.buscarPorId(rs.getLong("idProducto")));

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

    public List<Puja> getPujasActivasByEstadoPujaYCategoriaProducto(EstadoPuja estado, Categoria categoria) {

        Connection con = getConexion();
        PreparedStatement ps;
        ResultSet rs;

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
                temp.setProducto(productoController.buscarPorId(rs.getLong("idProducto")));

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

    public List<Puja> getPujasPropiasDB(Categoria categoria, long id) {

        Connection con = getConexion();
        PreparedStatement ps;
        ResultSet rs;

        List<Puja> respuesta = new ArrayList<>();

        String sql = "";
        sql += "SELECT p.* ";
        sql += "FROM Puja p, Producto pr ";
        sql += "WHERE p.idProducto = pr.id ";
        sql += "AND p.idHistorialVentas = ? ";
        if (categoria != null)
            sql += "AND pr.categoria = ?";

        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, String.valueOf(id));
            if (categoria != null)
                ps.setString(2, String.valueOf(categoria));

            rs = ps.executeQuery();

            while (rs.next()) {
                Puja temp = new Puja();

                temp.setId(rs.getLong("id"));
                temp.setEstado(EstadoPuja.valueOf(rs.getString("estado")));
                temp.setPrecioFinal(rs.getDouble("precioFinal"));
                temp.setFecha(rs.getDate("fecha"));
                temp.setProducto(productoController.buscarPorId(rs.getLong("idProducto")));

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

    public int getNumeroPujantesPorPujaId(Long id) {

        Connection con = getConexion();
        PreparedStatement ps;
        ResultSet rs;

        int temp = -1;

        String sql = "";
        sql += "SELECT COUNT(c.idComprador) numPujantes ";
        sql += "FROM CompradorXPuja c ";
        sql += "WHERE c.idPuja = ?";

        try {
            ps = con.prepareStatement(sql);

            ps.setLong(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                temp = rs.getInt("numPujantes");
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

    public List<Puja> getPujasGanadasDB(Categoria categoria, long id){
        Connection con = getConexion();
        PreparedStatement ps;
        ResultSet rs;

        List<Puja> respuesta = new ArrayList<>();

        String sql = "";
        sql += "SELECT p.* ";
        sql += "FROM Puja p ";
        sql += "WHERE p.idHistorialCompras = ? ";
        sql += "AND p.estado = 'INACTIVO' ";

        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, String.valueOf(id));
            if (categoria != null)
                ps.setString(2, String.valueOf(categoria));

            rs = ps.executeQuery();

            while (rs.next()) {
                Puja temp = new Puja();

                temp.setId(rs.getLong("id"));
                temp.setEstado(EstadoPuja.valueOf(rs.getString("estado")));
                temp.setPrecioFinal(rs.getDouble("precioFinal"));
                temp.setFecha(rs.getDate("fecha"));
                temp.setProducto(productoController.buscarPorId(rs.getLong("idProducto")));

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

    public boolean agregarPujante(Long idPuja, Long idComprador, Double precioPujado) {

        Connection con = getConexion();
        PreparedStatement ps;

        String sql = "";
        sql += "INSERT INTO CompradorXPuja(idComprador,  idPuja, fechaComprador, precioPujado) ";
        sql += "VALUES (?, ?, ?, ?)";

        try {
            ps = con.prepareStatement(sql);

            ps.setLong(1, idComprador);
            ps.setLong(2, idPuja);
            ps.setDate(3, java.sql.Date.valueOf(LocalDate.now()));
            ps.setDouble(4, precioPujado);

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

    public boolean actualizarPrecio(Double nuevoprecio, long idPuja) {

        Connection con = getConexion();
        PreparedStatement ps;

        String sql = "";
        sql += "UPDATE Puja SET precioFinal = ? ";
        sql += "WHERE id = ?";

        try {
            ps = con.prepareStatement(sql);

            ps.setDouble(1, nuevoprecio);
            ps.setLong(2, idPuja);

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

    public boolean reanudarPujaPorPuja(long idPuja) {

        Connection con = getConexion();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "";
        sql += "UPDATE Puja ";
        sql += "SET estado = 'ACTIVO' ";
        sql += "WHERE id = ? ";

        try {
            ps = con.prepareStatement(sql);

            ps.setLong(1, idPuja);

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

    public boolean pausarPuja(long idPuja) {
        Connection con = getConexion();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "";
        sql += "UPDATE Puja ";
        sql += "SET estado = 'PAUSADO' ";
        sql += "WHERE id = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setLong(1, idPuja);

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

    public boolean eliminarPujaPorId(long id) {

        Connection con = getConexion();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "";
        sql += "DELETE FROM Puja ";
        sql += "WHERE id = ?";

        try {
            ps = con.prepareStatement(sql);

            ps.setLong(1, id);

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
