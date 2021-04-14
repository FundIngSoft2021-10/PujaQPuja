package pujaQpuja.controller;

import java.util.Objects;

import pujaQpuja.model.Usuario;


public class ControllerGeneral {


    private Usuario autenticado;

    public ControllerGeneral() {
    }

    public ControllerGeneral(Usuario autenticado) {
        this.autenticado = autenticado;
    }

    public Usuario getAutenticado() {
        return this.autenticado;
    }

    public void setAutenticado(Usuario autenticado) {
        this.autenticado = autenticado;
    }

    public ControllerGeneral autenticado(Usuario autenticado) {
        setAutenticado(autenticado);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ControllerGeneral)) {
            return false;
        }
        ControllerGeneral controllerGeneral = (ControllerGeneral) o;
        return Objects.equals(autenticado, controllerGeneral.autenticado);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(autenticado);
    }

    @Override
    public String toString() {
        return "{" +
            " autenticado='" + getAutenticado() + "'" +
            "}";
    }
    
}
