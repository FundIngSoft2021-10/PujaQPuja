package pujaQpuja.model;

import java.sql.Date;

import java.util.List;

public class Puja {

    private double precioFinal                         ;
    private Date fecha                                 ;
    private List<CompradorXpuja> listaCompradores ;
    private Producto producto                          ;
    private Usuario vendedor                           ;
    private EstadoPuja estado                          ;


    public Puja() {
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
