package pujaQpuja.model;

import java.util.List;
import java.util.Objects;

public class Usuario {

    private Long id;
    private String user;
    private String password;
    private String nombres;
    private String apellidos;
    private String correo;
    private String direccion;
    private String telefono;
    private String documento;
    private double calificacion;
    private List<Puja> historialCompras;
    private List<Puja> historialVentas;
    private List<Mensaje> mensajes;

    public Usuario() {

    }

    public Usuario(Long id, String user, String password, String nombres, String apellidos, String correo, String direccion, String telefono, String documento, double calificacion) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.documento = documento;
        this.calificacion = calificacion;
        
    }

    public Usuario(String user, String password, String nombres, String apellidos, String correo, String direccion, String telefono, String documento, double calificacion, List<Puja> historialCompras, List<Puja> historialVentas,List<Mensaje> mensajes) {
        this.user = user;
        this.password = password;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.documento = documento;
        this.calificacion = calificacion;
        this.historialCompras = historialCompras;
        this.historialVentas = historialVentas;
        this.mensajes= mensajes;
    }


    public Usuario(Long id, String user, String password, String nombres, String apellidos, String correo, String direccion, String telefono, String documento, double calificacion, List<Puja> historialCompras, List<Puja> historialVentas) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.documento = documento;
        this.calificacion = calificacion;
        this.historialCompras = historialCompras;
        this.historialVentas = historialVentas;
    }


    public List<Mensaje> getMensajes() {
        return this.mensajes;
    }

    public void setMensajes(List<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombres() {
        return this.nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDocumento() {
        return this.documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public double getCalificacion() {
        return this.calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public List<Puja> getHistorialCompras() {
        return this.historialCompras;
    }

    public void setHistorialCompras(List<Puja> historialCompras) {
        this.historialCompras = historialCompras;
    }

    public List<Puja> getHistorialVentas() {
        return this.historialVentas;
    }

    public void setHistorialVentas(List<Puja> historialVentas) {
        this.historialVentas = historialVentas;
    }

    public Usuario id(Long id) {
        setId(id);
        return this;
    }

    public Usuario user(String user) {
        setUser(user);
        return this;
    }

    public Usuario password(String password) {
        setPassword(password);
        return this;
    }

    public Usuario nombres(String nombres) {
        setNombres(nombres);
        return this;
    }

    public Usuario apellidos(String apellidos) {
        setApellidos(apellidos);
        return this;
    }

    public Usuario correo(String correo) {
        setCorreo(correo);
        return this;
    }

    public Usuario direccion(String direccion) {
        setDireccion(direccion);
        return this;
    }

    public Usuario telefono(String telefono) {
        setTelefono(telefono);
        return this;
    }

    public Usuario documento(String documento) {
        setDocumento(documento);
        return this;
    }

    public Usuario calificacion(double calificacion) {
        setCalificacion(calificacion);
        return this;
    }

    public Usuario historialCompras(List<Puja> historialCompras) {
        setHistorialCompras(historialCompras);
        return this;
    }

    public Usuario historialVentas(List<Puja> historialVentas) {
        setHistorialVentas(historialVentas);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Usuario)) {
            return false;
        }
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id) && Objects.equals(user, usuario.user) && Objects.equals(password, usuario.password) && Objects.equals(nombres, usuario.nombres) && Objects.equals(apellidos, usuario.apellidos) && Objects.equals(correo, usuario.correo) && Objects.equals(direccion, usuario.direccion) && Objects.equals(telefono, usuario.telefono) && Objects.equals(documento, usuario.documento) && calificacion == usuario.calificacion && Objects.equals(historialCompras, usuario.historialCompras) && Objects.equals(historialVentas, usuario.historialVentas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, password, nombres, apellidos, correo, direccion, telefono, documento, calificacion, historialCompras, historialVentas);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", user='" + getUser() + "'" +
            ", password='" + getPassword() + "'" +
            ", nombres='" + getNombres() + "'" +
            ", apellidos='" + getApellidos() + "'" +
            ", correo='" + getCorreo() + "'" +
            ", direccion='" + getDireccion() + "'" +
            ", telefono='" + getTelefono() + "'" +
            ", documento='" + getDocumento() + "'" +
            ", calificacion='" + getCalificacion() + "'" +
            ", historialCompras='" + getHistorialCompras() + "'" +
            ", historialVentas='" + getHistorialVentas() + "'" +
            "}";
    }

}
