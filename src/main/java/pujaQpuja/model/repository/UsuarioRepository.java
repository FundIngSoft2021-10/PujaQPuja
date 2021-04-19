package pujaQpuja.model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pujaQpuja.model.entities.Usuario;

public class UsuarioRepository extends DB {

    public boolean crear(Usuario usuario) {

        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "";
        sql += "INSERT INTO Usuario ";
        sql += "(password, nombres, apellidos, correo, direccion, telefono, documento, calificacion) ";
        sql += "VALUES (?,?,?,?,?,?,?,?)";

        //INSERT INTO `Usuario` (`id`, `nombres`, `apellidos`, `password`, `correo`, `direccion`, `telefono`, `documento`, `calificacion`) VALUES ('0', 'Kenneth', 'Leonel', 'contra', 'ken@hotmail.com', 'Carrear 1 # 1-1', '3542875398', '1222986475', NULL);

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

    public boolean modificar(Usuario usuario) {

        PreparedStatement ps = null;
        Connection con = getConexion();

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
                desconectar();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public Usuario buscarPorID(long id) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
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
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "";
        sql += "SELECT * FROM Usuario ";
        sql += "WHERE correo = ?";

        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, usuario.getCorreo());

            rs = ps.executeQuery();

            if(rs.next()) {
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
 }
