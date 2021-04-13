package pujaQpuja.model;

import java.util.Objects;

public class Mensaje {
 private Usuario emisor;
 private Usuario receptor;
 private String cuerpo;

    public Mensaje() {
    }

    public Mensaje(Usuario emisor, Usuario receptor, String cuerpo) {
        this.emisor = emisor;
        this.receptor = receptor;
        this.cuerpo = cuerpo;
    }

    public Usuario getEmisor() {
        return this.emisor;
    }

    public void setEmisor(Usuario emisor) {
        this.emisor = emisor;
    }

    public Usuario getReceptor() {
        return this.receptor;
    }

    public void setReceptor(Usuario receptor) {
        this.receptor = receptor;
    }

    public String getCuerpo() {
        return this.cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public Mensaje emisor(Usuario emisor) {
        setEmisor(emisor);
        return this;
    }

    public Mensaje receptor(Usuario receptor) {
        setReceptor(receptor);
        return this;
    }

    public Mensaje cuerpo(String cuerpo) {
        setCuerpo(cuerpo);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Mensaje)) {
            return false;
        }
        Mensaje mensaje = (Mensaje) o;
        return Objects.equals(emisor, mensaje.emisor) && Objects.equals(receptor, mensaje.receptor) && Objects.equals(cuerpo, mensaje.cuerpo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emisor, receptor, cuerpo);
    }

    @Override
    public String toString() {
        return "{" +
            " emisor='" + getEmisor() + "'" +
            ", receptor='" + getReceptor() + "'" +
            ", cuerpo='" + getCuerpo() + "'" +
            "}";
    }

}