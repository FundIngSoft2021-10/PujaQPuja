package pujaQpuja.model;
import java.util.Objects;
public class CompradorXpuja {

    private Usuario comprador    ;
    private double precioOfertado;




    public CompradorXpuja() {
    }

    public CompradorXpuja(Usuario comprador, double precioOfertado) {
        this.comprador = comprador;
        this.precioOfertado = precioOfertado;
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

    public CompradorXpuja comprador(Usuario comprador) {
        setComprador(comprador);
        return this;
    }

    public CompradorXpuja precioOfertado(double precioOfertado) {
        setPrecioOfertado(precioOfertado);
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
        return Objects.equals(comprador, compradorXpuja.comprador) && precioOfertado == compradorXpuja.precioOfertado;
    }

    @Override
    public int hashCode() {
        return Objects.hash(comprador, precioOfertado);
    }

    @Override
    public String toString() {
        return "{" +
            " comprador='" + getComprador() + "'" +
            ", precioOfertado='" + getPrecioOfertado() + "'" +
            "}";
    }

    
}
