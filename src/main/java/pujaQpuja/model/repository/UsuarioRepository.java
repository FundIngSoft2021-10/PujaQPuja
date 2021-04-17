package pujaQpuja.model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pujaQpuja.model.Usuario;

public class UsuarioRepository extends DB {

    public boolean crear(Usuario usuario) {

        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "";
        sql += "INSERT INTO Usuario ";
        sql += "(user, password, nombres, apellidos, correo, direccion, telefono, documento, calificacion) ";
        sql += "VALUES (?,?,?,?,?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, usuario.getUser());
            ps.setString(2, usuario.getPassword());
            ps.setString(3, usuario.getNombres());
            ps.setString(4, usuario.getApellidos());
            ps.setString(5, usuario.getCorreo());
            ps.setString(6, usuario.getDireccion());
            ps.setString(7, usuario.getTelefono());
            ps.setString(8, usuario.getDocumento());
            ps.setDouble(9, usuario.getCalificacion());

            return ps.execute();
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean modificar(Usuario usuario) {

        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "";
        sql += "UPDATE Usuario ";
        sql += "SET user = ?, password = ?, nombres = ?, apellidos = ?, correo = ?, direccion = ?, telefono = ?, documento = ?, calificacion = ? ";
        sql += "WHERE id = ?";

        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, usuario.getUser());
            ps.setString(2, usuario.getPassword());
            ps.setString(3, usuario.getNombres());
            ps.setString(4, usuario.getApellidos());
            ps.setString(5, usuario.getCorreo());
            ps.setString(6, usuario.getDireccion());
            ps.setString(7, usuario.getTelefono());
            ps.setString(8, usuario.getDocumento());
            ps.setDouble(9, usuario.getCalificacion());
            ps.setLong(10, usuario.getId());

            return ps.execute();
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean eliminar(Usuario usuario) {

        PreparedStatement ps = null;
        Connection con = getConexion();

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
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean buscarPorID(Usuario usuario) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "";
        sql += "SELECT * FROM Usuario ";
        sql += "WHERE id = ?";

        try {
            ps = con.prepareStatement(sql);

            ps.setLong(1, usuario.getId());
            rs = ps.executeQuery();

            if (rs.next()) {
                usuario.setId(rs.getLong("id"));

                usuario.setUser(rs.getString("user"));
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
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean buscarUsuarioCorreo(String correo) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "";
        sql += "SELECT * FROM Usuario ";
        sql += "WHERE correo = ?";
        
        return false;
    }
}