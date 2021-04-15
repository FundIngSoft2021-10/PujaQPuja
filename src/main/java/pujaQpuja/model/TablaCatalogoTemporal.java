package pujaQpuja.model;

import java.util.Objects;

import javafx.scene.image.ImageView;

public class TablaCatalogoTemporal {
    private ImageView imagen;
    private String desc;

    public TablaCatalogoTemporal() {
    }

    public TablaCatalogoTemporal(ImageView imagen, String desc) {
        this.imagen = imagen;
        this.desc = desc;
    }

    public ImageView getImagen() {
        return this.imagen;
    }

    public void setImagen(ImageView imagen) {
        this.imagen = imagen;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public TablaCatalogoTemporal imagen(ImageView imagen) {
        setImagen(imagen);
        return this;
    }

    public TablaCatalogoTemporal desc(String desc) {
        setDesc(desc);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TablaCatalogoTemporal)) {
            return false;
        }
        TablaCatalogoTemporal tablaCatalogoTemporal = (TablaCatalogoTemporal) o;
        return Objects.equals(imagen, tablaCatalogoTemporal.imagen) && Objects.equals(desc, tablaCatalogoTemporal.desc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imagen, desc);
    }

    @Override
    public String toString() {
        return "{" +
            " imagen='" + getImagen() + "'" +
            ", desc='" + getDesc() + "'" +
            "}";
    }
    
}
