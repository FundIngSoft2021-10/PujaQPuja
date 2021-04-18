package pujaQpuja.model.entities.otros;

import pujaQpuja.model.entities.Categoría;
import pujaQpuja.model.entities.Puja;

import java.util.List;
import java.util.Objects;

public class Catalogo {

    private List<Puja> listaPujas;
    private List<Categoría> categorias;

    public Catalogo() {
    }

    public Catalogo(List<Puja> listaPujas, List<Categoría> categorias) {
        this.listaPujas = listaPujas;
        this.categorias = categorias;
    }

    public List<Puja> getListaPujas() {
        return this.listaPujas;
    }

    public void setListaPujas(List<Puja> listaPujas) {
        this.listaPujas = listaPujas;
    }

    public List<Categoría> getCategorias() {
        return this.categorias;
    }

    public void setCategorias(List<Categoría> categorias) {
        this.categorias = categorias;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Catalogo)) {
            return false;
        }
        Catalogo catalogo = (Catalogo) o;
        return Objects.equals(listaPujas, catalogo.listaPujas) && Objects.equals(categorias, catalogo.categorias);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listaPujas, categorias);
    }

    @Override
    public String toString() {
        return "{" +
            " listaPujas='" + getListaPujas() + "'" +
            ", categorias='" + getCategorias() + "'" +
            "}";
    }
    
}