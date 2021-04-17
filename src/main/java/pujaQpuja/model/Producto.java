package pujaQpuja.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pujaQpuja.model.Categoria;

public class Producto {
    private String nombre;
    private Categoria categorias;
    private String descripcion;
    private List<Image> fotos;
    private Condicion condicion;
    private float precioInicial;

    public Producto() {
        this.fotos = new ArrayList<Image>();
    }

    public Producto(String nombre, Categoria categorias, String descripcion, List<Image> fotos,
            Condicion condicion, float precioInicial) {
        this.nombre = nombre;
        this.categorias = categorias;
        this.descripcion = descripcion;
        this.fotos = fotos;
        this.condicion = condicion;
        this.precioInicial = precioInicial;

    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Categoria getCategorias() {
        return this.categorias;
    }

    public void setCategorias(Categoria categorias) {
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
        ImageView ej = new ImageView();
    }

    public Condicion getCondicion() {
        return this.condicion;
    }

    public float getPrecioInicial() {
        return this.precioInicial;
    }

    public void setPrecioInicial(float precioInicial) {
        this.precioInicial = precioInicial;
    }

    public void setCondicion(Condicion condicion) {
        this.condicion = condicion;
    }

    public Producto nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    public Producto categorias(Categoria categorias) {
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

    public Producto precioInicial(float precioInicial) {
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
        return Objects.equals(nombre, producto.nombre) && Objects.equals(categorias, producto.categorias)
                && Objects.equals(descripcion, producto.descripcion) && Objects.equals(fotos, producto.fotos)
                && Objects.equals(condicion, producto.condicion)
                && Objects.equals(precioInicial, producto.precioInicial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, categorias, descripcion, fotos, condicion, precioInicial);
    }

    @Override
    public String toString() {
        return "{" + " nombre='" + getNombre() + "'" + ", categorias='" + getCategorias() + "'" + ", descripcion='"
                + getDescripcion() + "'" + ", fotos='" + getFotos() + "'" + ", condicion='" + getCondicion() + "'"
                + ", precio inicial='" + getPrecioInicial() + "}";
    }

    public void insertarFoto(Image imagen) {
        this.fotos.add(imagen);
    }

    public void insertarCategoria(Categoria actual) {
        this.categorias =actual;
    }
}