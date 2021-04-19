package pujaQpuja.controller.modelos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.ImageView;
import pujaQpuja.model.entities.EstadoPuja;
import pujaQpuja.model.entities.Puja;
import pujaQpuja.model.entities.otros.TablaCatalogoTemporal;
import pujaQpuja.model.repository.PujaRepository;

public class PujaController {

    PujaRepository pujaRepository;

    public PujaController() {
        pujaRepository = new PujaRepository();
    }

    public ObservableList<TablaCatalogoTemporal> getPujasActivasItems() {

        ObservableList<TablaCatalogoTemporal> datos = FXCollections.observableArrayList();

        for (Puja actual : pujaRepository.getPujasActivas()) {
            if (actual.getEstado() == EstadoPuja.ACTIVO) {
                TablaCatalogoTemporal temp = new TablaCatalogoTemporal();
                temp.setPuja(actual);
                if (actual.getProducto() != null) {
                    if (actual.getProducto().getFoto() != null) {
                        temp.setImagen(new ImageView(actual.getProducto().getFoto()));
                    }
                }
                StringBuilder dtemp = new StringBuilder("Nombre:  " + actual.getProducto().getNombre() + "\n" + "Descripción:  " + actual.getProducto().getDescripcion() + "\n" + "Precio:  " + "$ " + actual.getPrecioFinal() + " COP" + "\n" + "Categoria: " + actual.getProducto().getCategoria());
                temp.setDesc(dtemp.toString());
                datos.add(temp);
            }
        }
        return datos;
    }
}
