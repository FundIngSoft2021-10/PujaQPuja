package pujaQpuja.model.repository;

import pujaQpuja.model.entities.Categoria;
import pujaQpuja.model.entities.EstadoPuja;
import pujaQpuja.model.entities.Mensaje;
import pujaQpuja.model.entities.Puja;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MensajeRepository extends DB {
    public MensajeRepository() {
    }

    public boolean crear(Mensaje mensaje) {

        Connection con = getConexion();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "";
        sql += "INSERT INTO Mensaje ";
        sql += "(cuerpo, idEmisor, idReceptor) ";
        sql += "VALUES (?,?,?)";

        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, mensaje.getCuerpo());
            ps.setLong(2, mensaje.getEmisor());
            ps.setLong(3, mensaje.getReceptor());

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
        sql += "SELECT m.* ";
        sql += "FROM Mensaje m";
        sql += "WHERE m.idEmisor = ? ";

        try {
            ps = con.prepareStatement(sql);

            ps.setLong(1, id);

            rs = ps.executeQuery();

            while (rs.next()) {
                Mensaje temp = new Mensaje();

                temp.setId(rs.getLong("id"));
                temp.setCuerpo(rs.getString("cuerpo"));
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
