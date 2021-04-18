package pujaQpuja.model.entities;

import java.util.Objects;

import javafx.scene.image.Image;
import pujaQpuja.model.entities.otros.Condicion;

public class Producto {

    private long id;
    private String nombre;
    private Categoría categoria;
    private String descripcion;
    private Image foto;
    private Condicion condicion;
    private double precioInicial;


    public Producto() {
    }

    public Producto(long id, String nombre, Categoría categoria, String descripcion, Image foto, Condicion condicion, double precioInicial) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.foto = foto;
        this.condicion = condicion;
        this.precioInicial = precioInicial;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Categoría getCategoria() {
        return this.categoria;
    }

    public void setCategoria(Categoría categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Image getFoto() {
        return this.foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    public Condicion getCondicion() {
        return this.condicion;
    }

    public void setCondicion(Condicion condicion) {
        this.condicion = condicion;
    }

    public double getPrecioInicial() {
        return this.precioInicial;
    }

    public void setPrecioInicial(double precioInicial) {
        this.precioInicial = precioInicial;
    }

    public Producto id(long id) {
        setId(id);
        return this;
    }

    public Producto nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    public Producto categoria(Categoría categoria) {
        setCategoria(categoria);
        return this;
    }

    public Producto descripcion(String descripcion) {
        setDescripcion(descripcion);
        return this;
    }

    public Producto foto(Image foto) {
        setFoto(foto);
        return this;
    }

    public Producto condicion(Condicion condicion) {
        setCondicion(condicion);
        return this;
    }

    public Producto precioInicial(double precioInicial) {
        setPrecioInicial(precioInicial);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Producto)) {
            return false;
        }
        Producto producto = (Producto) o;
        return id == producto.id && Objects.equals(nombre, producto.nombre) && Objects.equals(categoria, producto.categoria) && Objects.equals(descripcion, producto.descripcion) && Objects.equals(foto, producto.foto) && Objects.equals(condicion, producto.condicion) && precioInicial == producto.precioInicial;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, categoria, descripcion, foto, condicion, precioInicial);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", categoria='" + getCategoria() + "'" +
            ", descripcion='" + getDescripcion() + "'" +
            ", foto='" + getFoto() + "'" +
            ", condicion='" + getCondicion() + "'" +
            ", precioInicial='" + getPrecioInicial() + "'" +
            "}";
    }

}