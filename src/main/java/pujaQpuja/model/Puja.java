package pujaQpuja.model;

import java.sql.Date;

import java.util.List;
import java.util.Objects;

public class Puja {

    private long identificador;
    private double precioFinal                         ;
    private Date fecha                                 ;
    private List<CompradorXpuja> listaCompradores ;
    private Producto producto                          ;
    private Usuario vendedor                           ;
    private EstadoPuja estado                          ;


    public Puja(long identificador, double precioFinal, Date fecha, List<CompradorXpuja> listaCompradores, Producto producto, Usuario vendedor, EstadoPuja estado) {
        this.identificador = identificador;
        this.precioFinal = precioFinal;
        this.fecha = fecha;
        this.listaCompradores = listaCompradores;
        this.producto = producto;
        this.vendedor = vendedor;
        this.estado = estado;
    }

    public long getIdentificador() {
        return this.identificador;
    }

    public void setIdentificador(long identificador) {
        this.identificador = identificador;
    }

    public Puja identificador(long identificador) {
        setIdentificador(identificador);
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
        return identificador == puja.identificador && precioFinal == puja.precioFinal && Objects.equals(fecha, puja.fecha) && Objects.equals(listaCompradores, puja.listaCompradores) && Objects.equals(producto, puja.producto) && Objects.equals(vendedor, puja.vendedor) && Objects.equals(estado, puja.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador, precioFinal, fecha, listaCompradores, producto, vendedor, estado);
    }

    @Override
    public String toString() {
        return "{" +
            " identificador='" + getIdentificador() + "'" +
            ", precioFinal='" + getPrecioFinal() + "'" +
            ", fecha='" + getFecha() + "'" +
            ", listaCompradores='" + getListaCompradores() + "'" +
            ", producto='" + getProducto() + "'" +
            ", vendedor='" + getVendedor() + "'" +
            ", estado='" + getEstado() + "'" +
            "}";
    }

    public Puja() {

        this.identificador=+1;
    }


    public Puja(double precioFinal, Date fecha, List<CompradorXpuja> listaCompradores, Producto producto, Usuario vendedor, EstadoPuja estado) {
        this.precioFinal = precioFinal;
        this.fecha = fecha;
        this.listaCompradores = listaCompradores;
        this.producto = producto;
        this.vendedor = vendedor;
        this.estado = estado;
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

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Usuario getVendedor() {
        return this.vendedor;
    }

    public void setVendedor(Usuario vendedor) {
        this.vendedor = vendedor;
    }

    public EstadoPuja getEstado() {
        return this.estado;
    }

    public void setEstado(EstadoPuja estado) {
        this.estado = estado;
    }
   
}
