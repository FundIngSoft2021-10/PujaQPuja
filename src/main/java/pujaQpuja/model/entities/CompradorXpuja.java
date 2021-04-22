package pujaQpuja.model.entities;

import java.sql.Date;
import java.util.Objects;

public class CompradorXpuja {

    private long id;
    private Usuario comprador;
    private double precioOfertado;
    private Date fechaComprador;

    public CompradorXpuja() {
    }

    public CompradorXpuja(long id, Usuario comprador, double precioOfertado, Date fechaComprador) {
        this.id = id;
        this.comprador = comprador;
        this.precioOfertado = precioOfertado;
        this.fechaComprador = fechaComprador;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Usuario getComprador() {
        return this.comprador;
    }

    public void setComprador(Usuario comprador) {
        this.comprador = comprador;
    }

    public double getPrecioOfertado() {
        return this.precioOfertado;
    }

    public void setPrecioOfertado(double precioOfertado) {
        this.precioOfertado = precioOfertado;
    }

    public Date getFechaComprador() {
        return this.fechaComprador;
    }

    public void setFechaComprador(Date fechaComprador) {
        this.fechaComprador = fechaComprador;
    }

    public CompradorXpuja id(long id) {
        setId(id);
        return this;
    }

    public CompradorXpuja comprador(Usuario comprador) {
        setComprador(comprador);
        return this;
    }

    public CompradorXpuja precioOfertado(double precioOfertado) {
        setPrecioOfertado(precioOfertado);
        return this;
    }

    public CompradorXpuja fechaComprador(Date fechaComprador) {
        setFechaComprador(fechaComprador);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CompradorXpuja)) {
            return false;
        }
        CompradorXpuja compradorXpuja = (CompradorXpuja) o;
        return id == compradorXpuja.id && Objects.equals(comprador, compradorXpuja.comprador) && precioOfertado == compradorXpuja.precioOfertado && Objects.equals(fechaComprador, compradorXpuja.fechaComprador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, comprador, precioOfertado, fechaComprador);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", comprador='" + getComprador() + "'" + ", precioOfertado='" + getPrecioOfertado() + "'" + ", fechaComprador='" + getFechaComprador() + "'" + "}";
    }


}
