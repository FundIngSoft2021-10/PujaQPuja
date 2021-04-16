package pujaQpuja.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javafx.scene.image.ImageView;

public class Producto {
    private String nombre;
    private List<Categoría> categorias;
    private String descripcion;
    private List<ImageView> fotos;
    private Condicion condicion;
    private float precioInicial;



    public Producto() {
        this.fotos= new ArrayList<ImageView>();
        this.categorias= new ArrayList<>();
    }

    public Producto(String nombre, List<Categoría> categorias, String descripcion, List<ImageView> fotos, Condicion condicion, float precioInicial) {
        this.nombre = nombre;
        this.categorias = categorias;
        this.descripcion = descripcion;
        this.fotos = fotos;
        this.condicion = condicion;
        this.precioInicial=precioInicial;
        
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

    public List<ImageView> getFotos() {
        return this.fotos;
    }

    public void setFotos(List<ImageView> fotos) {
        this.fotos = fotos;
    }

    public Condicion getCondicion() {
        return this.condicion;
    }

    public float getPrecioInicial(){
        return this.precioInicial;
    }

    public void setPrecioInicial(float precioInicial){
        this.precioInicial=precioInicial;
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

    public Producto fotos(List<ImageView> fotos) {
        setFotos(fotos);
        return this;
    }

    public Producto condicion(Condicion condicion) {
        setCondicion(condicion);
        return this;
    }

    public Producto precioInicial(float precioInicial){
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
        return Objects.equals(nombre, producto.nombre) && Objects.equals(categorias, producto.categorias) && Objects.equals(descripcion, producto.descripcion) && Objects.equals(fotos, producto.fotos) && Objects.equals(condicion, producto.condicion)&& Objects.equals(precioInicial, producto.precioInicial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, categorias, descripcion, fotos, condicion, precioInicial);
    }

    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            ", categorias='" + getCategorias() + "'" +
            ", descripcion='" + getDescripcion() + "'" +
            ", fotos='" + getFotos() + "'" +
            ", condicion='" + getCondicion() + "'" +
            ", precio inicial='"+ getPrecioInicial()+"}";
    }

    public void insertarFoto(ImageView imagen) {
        this.fotos.add(imagen);
    }
    public void insertarCategoria(Categoría actual)
    {
    this.categorias.add(actual);
    }
}