package pujaQpuja.model.entities;

import java.util.Objects;
import java.util.Queue;

public class Chat {

    private long id;
    private Usuario usuarioUno;
    private Usuario usuarioDos;
    private Queue<Mensaje> mensajes;

    public Chat() {
    }

    public Chat(long id, Usuario usuarioUno, Usuario usuarioDos, Queue<Mensaje> mensajes) {
        this.id = id;
        this.usuarioUno = usuarioUno;
        this.usuarioDos = usuarioDos;
        this.mensajes = mensajes;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Usuario getUsuarioUno() {
        return this.usuarioUno;
    }

    public void setUsuarioUno(Usuario usuarioUno) {
        this.usuarioUno = usuarioUno;
    }

    public Usuario getUsuarioDos() {
        return this.usuarioDos;
    }

    public void setUsuarioDos(Usuario usuarioDos) {
        this.usuarioDos = usuarioDos;
    }

    public Queue<Mensaje> getMensajes() {
        return this.mensajes;
    }

    public void setMensajes(Queue<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }

    public Chat id(long id) {
        setId(id);
        return this;
    }

    public Chat usuarioUno(Usuario usuarioUno) {
        setUsuarioUno(usuarioUno);
        return this;
    }

    public Chat usuarioDos(Usuario usuarioDos) {
        setUsuarioDos(usuarioDos);
        return this;
    }

    public Chat mensajes(Queue<Mensaje> mensajes) {
        setMensajes(mensajes);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Chat)) {
            return false;
        }
        Chat chat = (Chat) o;
        return id == chat.id && Objects.equals(usuarioUno, chat.usuarioUno) && Objects.equals(usuarioDos, chat.usuarioDos) && Objects.equals(mensajes, chat.mensajes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usuarioUno, usuarioDos, mensajes);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", usuarioUno='" + getUsuarioUno() + "'" + ", usuarioDos='" + getUsuarioDos() + "'" + ", mensajes='" + getMensajes() + "'" + "}";
    }

}
