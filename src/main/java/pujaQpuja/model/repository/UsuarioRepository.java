package pujaQpuja.model.repository;

import java.sql.*;

import pujaQpuja.controller.modelos.AutenticacionController;
import pujaQpuja.model.entities.Usuario;

public class UsuarioRepository extends DB {

    private SQLException e;

    public UsuarioRepository() {

    }

    public boolean crear(Usuario usuario) {

        Connection con = getConexion();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "";
        sql += "INSERT INTO Usuario ";
        sql += "(password, nombres, apellidos, correo, direccion, telefono, documento, calificacion) ";
        sql += "VALUES (?,?,?,?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, usuario.getPassword());
            ps.setString(2, usuario.getNombres());
            ps.setString(3, usuario.getApellidos());
            ps.setString(4, usuario.getCorreo());
            ps.setString(5, usuario.getDireccion());
            ps.setString(6, usuario.getTelefono());
            ps.setString(7, usuario.getDocumento());
            ps.setDouble(8, usuario.getCalificacion());

            ps.execute();
            rs = ps.getGeneratedKeys();

            if (rs.next()) {
                int generatedKey = rs.getInt(1);
                usuario.setId(generatedKey);
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

    public boolean modificar(Usuario usuario) {

        Connection con = getConexion();
        PreparedStatement ps;

        String sql = "";
        sql += "UPDATE Usuario ";
        sql += "SET password = ?, nombres = ?, apellidos = ?, correo = ?, direccion = ?, telefono = ?, documento = ?, calificacion = ? ";
        sql += "WHERE id = ?";

        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, usuario.getPassword());
            ps.setString(2, usuario.getNombres());
            ps.setString(3, usuario.getApellidos());
            ps.setString(4, usuario.getCorreo());
            ps.setString(5, usuario.getDireccion());
            ps.setString(6, usuario.getTelefono());
            ps.setString(7, usuario.getDocumento());
            ps.setDouble(8, usuario.getCalificacion());
            ps.setLong(9, usuario.getId());

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

    public boolean eliminar(Usuario usuario) {

        Connection con = getConexion();
        PreparedStatement ps;

        String sql = "";
        sql += "DELETE FROM Usuario ";
        sql += "WHERE id = ?";

        try {
            ps = con.prepareStatement(sql);

            ps.setLong(1, usuario.getId());

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

    public Usuario buscarPorIdUsuario(long id) {

        Connection con = getConexion();
        PreparedStatement ps;
        ResultSet rs;

        Usuario usuario = new Usuario();

        String sql = "";
        sql += "SELECT * FROM Usuario ";
        sql += "WHERE id = ?";

        try {
            ps = con.prepareStatement(sql);

            ps.setLong(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {

                usuario.setId(rs.getLong("id"));

                usuario.setPassword(rs.getString("password"));
                usuario.setNombres(rs.getString("nombres"));
                usuario.setApellidos(rs.getString("apellidos"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setDireccion(rs.getString("direccion"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setDocumento(rs.getString("documento"));
                usuario.setCalificacion(rs.getDouble("calificacion"));
                return usuario;
            }
            return usuario;
        } catch (SQLException e) {
            System.err.println(e);
            return usuario;
        } finally {
            try {
                desconectar();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean buscarPorCorreo(Usuario usuario) {

        Connection con = getConexion();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "";
        sql += "SELECT * FROM Usuario ";
        sql += "WHERE correo = ?";

        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, usuario.getCorreo());

            rs = ps.executeQuery();

            if (rs.next()) {
                usuario.setId(rs.getLong("id"));

                usuario.setPassword(rs.getString("password"));
                usuario.setNombres(rs.getString("nombres"));
                usuario.setApellidos(rs.getString("apellidos"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setDireccion(rs.getString("direccion"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setDocumento(rs.getString("documento"));
                usuario.setCalificacion(rs.getDouble("calificacion"));
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

    public double getCalificacionV(long id) {
        Connection con = getConexion();
        PreparedStatement ps;
        ResultSet rs;

        double temp = -1;

        String sql = "";
        sql += "SELECT u.calificacion ";
        sql += "FROM Usuario u ";
        sql += "WHERE u.id = ?";

        try {
            ps = con.prepareStatement(sql);

            ps.setLong(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                temp = rs.getDouble("calificacion");
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

    public boolean calificarVendedor(double calificacion, long id) {
        Connection con = getConexion();
        PreparedStatement ps;

        String sql = "";
        sql += "UPDATE Usuario ";
        sql += "SET calificacion = ?";
        sql += "WHERE id = ?";

        try {
            ps = con.prepareStatement(sql);

            ps.setDouble(1, calificacion);
            ps.setLong(2,id);

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
}
