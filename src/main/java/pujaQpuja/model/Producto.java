package pujaQpuja.model;

import java.util.List;
import java.util.Objects;

import javafx.scene.image.Image;

public class Producto {
    private String nombre;
    private List<Categoría> categorias;
    private String descripcion;
    private List<Image> fotos;
    private Condicion condicion;



    public Producto() {
    }

    public Producto(String nombre, List<Categoría> categorias, String descripcion, List<Image> fotos, Condicion condicion) {
        this.nombre = nombre;
        this.categorias = categorias;
        this.descripcion = descripcion;
        this.fotos = fotos;
        this.condicion = condicion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Categoría> getCategorias() {
        return this.categorias;
    }

    public void setCategorias(List<Categoría> categorias) {
        this.categorias = categorias;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Image> getFotos() {
        return this.fotos;
    }

    public void setFotos(List<Image> fotos) {
        this.fotos = fotos;
    }

    public Condicion getCondicion() {
        return this.condicion;
    }

    public void setCondicion(Condicion condicion) {
        this.condicion = condicion;
    }

    public Producto nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    public Producto categorias(List<Categoría> categorias) {
        setCategorias(categorias);
        return this;
    }

    public Producto descripcion(String descripcion) {
        setDescripcion(descripcion);
        return this;
    }

    public Producto fotos(List<Image> fotos) {
        setFotos(fotos);
        return this;
    }

    public Producto condicion(Condicion condicion) {
        setCondicion(condicion);
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
        return Objects.equals(nombre, producto.nombre) && Objects.equals(categorias, producto.categorias) && Objects.equals(descripcion, producto.descripcion) && Objects.equals(fotos, producto.fotos) && Objects.equals(condicion, producto.condicion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, categorias, descripcion, fotos, condicion);
    }

    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            ", categorias='" + getCategorias() + "'" +
            ", descripcion='" + getDescripcion() + "'" +
            ", fotos='" + getFotos() + "'" +
            ", condicion='" + getCondicion() + "'" +
            "}";
    }
}