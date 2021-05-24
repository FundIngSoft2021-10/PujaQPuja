package pujaQpuja.model.entities;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

public class Puja {

    private long id;
    private double precioFinal;
    private Date fecha;
    private List<CompradorXpuja> listaCompradores;
    private Producto producto;
    private Usuario vendedor;
    private Usuario comprador;
    private EstadoPuja estado;
    private Mensaje mensaje;

    public Puja() {
    }

    public Puja(long id, double precioFinal, Date fecha, List<CompradorXpuja> listaCompradores, Producto producto, Usuario vendedor, Usuario comprador, EstadoPuja estado, Mensaje mensaje) {
        this.id = id;
        this.precioFinal = precioFinal;
        this.fecha = fecha;
        this.listaCompradores = listaCompradores;
        this.producto = producto;
        this.vendedor = vendedor;
        this.comprador = comprador;
        this.estado = estado;
        this.mensaje = mensaje;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrecioFinal() {
        return this.precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<CompradorXpuja> getListaCompradores() {
        return this.listaCompradores;
    }

    public void setListaCompradores(List<CompradorXpuja> listaCompradores) {
        this.listaCompradores = listaCompradores;
    }

    public Producto getProducto() {
        return this.producto;
    }

    public void setProducto(Producto productoASubastar) {
        this.producto = productoASubastar;
    }

    public Usuario getVendedor() {
        return this.vendedor;
    }

    public void setVendedor(Usuario vendedor) {
        this.vendedor = vendedor;
    }

    public Usuario getComprador() {
        return this.comprador;
    }

    public void setComprador(Usuario comprador) {
        this.comprador = comprador;
    }

    public EstadoPuja getEstado() {
        return this.estado;
    }

    public void setEstado(EstadoPuja estado) {
        this.estado = estado;
    }

    public Puja id(long id) {
        setId(id);
        return this;
    }

    public Puja precioFinal(double precioFinal) {
        setPrecioFinal(precioFinal);
        return this;
    }

    public Puja fecha(Date fecha) {
        setFecha(fecha);
        return this;
    }

    public Puja listaCompradores(List<CompradorXpuja> listaCompradores) {
        setListaCompradores(listaCompradores);
        return this;
    }

    public Puja producto(Producto producto) {
        setProducto(producto);
        return this;
    }

    public Puja vendedor(Usuario vendedor) {
        setVendedor(vendedor);
        return this;
    }

    public Puja comprador(Usuario comprador) {
        setComprador(comprador);
        return this;
    }

    public Puja estado(EstadoPuja estado) {
        setEstado(estado);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Puja)) {
            return false;
        }
        Puja puja = (Puja) o;
        return id == puja.id && precioFinal == puja.precioFinal && Objects.equals(fecha, puja.fecha) && Objects.equals(listaCompradores, puja.listaCompradores) && Objects.equals(producto, puja.producto) && Objects.equals(vendedor, puja.vendedor) && Objects.equals(comprador, puja.comprador) && Objects.equals(estado, puja.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, precioFinal, fecha, listaCompradores, producto, vendedor, comprador, estado);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", precioFinal='" + getPrecioFinal() + "'" + ", fecha='" + getFecha() + "'" + ", listaCompradores='" + getListaCompradores() + "'" + ", producto='" + getProducto() + "'" + ", vendedor='" + getVendedor() + "'" + ", comprador='" + getComprador() + "'" + ", estado='" + getEstado() + "'" + "}";
    }

    public Mensaje getMensaje() {
        return this.mensaje;
    }

    public void setMensaje(Mensaje mensaje) {
        this.mensaje = mensaje;
    }
}
