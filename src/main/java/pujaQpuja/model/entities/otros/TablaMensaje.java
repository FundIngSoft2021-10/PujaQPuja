package pujaQpuja.model.entities.otros;

import java.util.Objects;

import javafx.scene.image.ImageView;
import pujaQpuja.model.entities.Mensaje;
import pujaQpuja.model.entities.Puja;

public class TablaMensaje {
    private ImageView imagen;
    private String pregunta;
    private String respuesta;
    private Puja puja;
    private Mensaje mensaje;

    public TablaMensaje() {
    }

    public TablaMensaje(ImageView imagen, String pregunta, Puja puja, String estado, String respuesta, Mensaje mensaje) {
        this.imagen = imagen;
        this.pregunta = pregunta;
        this.puja = puja;
        this.respuesta = respuesta;
        this.mensaje = mensaje;
    }

    public ImageView getImagen() {
        return this.imagen;
    }

    public void setImagen(ImageView imagen) {
        this.imagen = imagen;
    }

    public String getPregunta() {
        return this.pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public Puja getPuja() {
        return this.puja;
    }

    public void setPuja(Puja puja) {
        this.puja = puja;
    }

    public String getRespuesta() {
        return this.respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Mensaje getMensaje() {
        return this.mensaje;
    }

    public void setMensaje(Mensaje mensaje) {
        this.mensaje = mensaje;
    }

    public TablaMensaje imagen(ImageView imagen) {
        setImagen(imagen);
        return this;
    }

    public TablaMensaje pregunta(String pregunta) {
        pregunta(pregunta);
        return this;
    }

    public TablaMensaje respuesta(String respuesta) {
        respuesta(respuesta);
        return this;
    }

    public TablaMensaje puja(Puja puja) {
        setPuja(puja);
        return this;
    }

    public TablaMensaje mensaje(Mensaje mensaje) {
        setMensaje(mensaje);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TablaMensaje)) {
            return false;
        }
        TablaMensaje tablaCatalogoTemporal = (TablaMensaje) o;
        return Objects.equals(imagen, tablaCatalogoTemporal.imagen) && Objects.equals(pregunta, tablaCatalogoTemporal.pregunta) && Objects.equals(puja, tablaCatalogoTemporal.puja);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imagen, pregunta, puja);
    }

    @Override
    public String toString() {
        return "{" + " imagen='" + getImagen() + "'" + ", desc='" + getPregunta() + "'" + ", puja='" + getPuja() + "'" + "}";
    }
}
