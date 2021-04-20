package pujaQpuja.model.entities;

import java.util.List;
import java.util.Objects;

public class Usuario {

    private long id;
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

    public Usuario(long id, String password, String nombres, String apellidos, String correo, String direccion, String telefono, String documento, double calificacion, List<Puja> historialCompras, List<Puja> historialVentas, List<Mensaje> mensajes) {
        this.id = id;
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
        this.mensajes = mensajes;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
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

    public List<Mensaje> getMensajes() {
        return this.mensajes;
    }

    public void setMensajes(List<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }

    public Usuario id(long id) {
        setId(id);
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

    public Usuario mensajes(List<Mensaje> mensajes) {
        setMensajes(mensajes);
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
        return Objects.equals(id, usuario.id) && Objects.equals(password, usuario.password) && Objects.equals(nombres, usuario.nombres) && Objects.equals(apellidos, usuario.apellidos) && Objects.equals(correo, usuario.correo) && Objects.equals(direccion, usuario.direccion) && Objects.equals(telefono, usuario.telefono) && Objects.equals(documento, usuario.documento) && calificacion == usuario.calificacion && Objects.equals(historialCompras, usuario.historialCompras) && Objects.equals(historialVentas, usuario.historialVentas) && Objects.equals(mensajes, usuario.mensajes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, password, nombres, apellidos, correo, direccion, telefono, documento, calificacion, historialCompras, historialVentas, mensajes);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", password='" + getPassword() + "'" + ", nombres='" + getNombres() + "'" + ", apellidos='" + getApellidos() + "'" + ", correo='" + getCorreo() + "'" + ", direccion='" + getDireccion() + "'" + ", telefono='" + getTelefono() + "'" + ", documento='" + getDocumento() + "'" + ", calificacion='" + getCalificacion() + "'" + ", historialCompras='" + getHistorialCompras() + "'" + ", historialVentas='" + getHistorialVentas() + "'" + ", mensajes='" + getMensajes() + "'" + "}";
    }

}
