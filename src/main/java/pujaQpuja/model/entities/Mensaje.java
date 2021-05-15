package pujaQpuja.model.entities;

import java.util.Objects;

public class Mensaje {
    private long id;
    private long emisor;
    private long receptor;
    private String cuerpo;

    public Mensaje() {
    }

    public Mensaje(long id, long emisor, long receptor, String cuerpo) {
        this.id = id;
        this.emisor = emisor;
        this.receptor = receptor;
        this.cuerpo = cuerpo;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getEmisor() {
        return this.emisor;
    }

    public void setEmisor(long emisor) {
        this.emisor = emisor;
    }

    public long getReceptor() {
        return this.receptor;
    }

    public void setReceptor(long receptor) {
        this.receptor = receptor;
    }

    public String getCuerpo() {
        return this.cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public Mensaje id(long id) {
        setId(id);
        return this;
    }

    public Mensaje emisor(long emisor) {
        setEmisor(emisor);
        return this;
    }

    public Mensaje receptor(long receptor) {
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
        return id == mensaje.id && Objects.equals(emisor, mensaje.emisor) && Objects.equals(receptor, mensaje.receptor) && Objects.equals(cuerpo, mensaje.cuerpo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, emisor, receptor, cuerpo);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", emisor='" + getEmisor() + "'" + ", receptor='" + getReceptor() + "'" + ", cuerpo='" + getCuerpo() + "'" + "}";
    }

}