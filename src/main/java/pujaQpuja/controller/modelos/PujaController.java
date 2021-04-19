package pujaQpuja.controller.modelos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.ImageView;
import pujaQpuja.controller.GeneralController;
import pujaQpuja.controller.pantallas.PantallaSeleccionarCategoriaController;
import pujaQpuja.model.entities.Categoria;
import pujaQpuja.model.entities.EstadoPuja;
import pujaQpuja.model.entities.Puja;
import pujaQpuja.model.entities.otros.TablaCatalogoTemporal;
import pujaQpuja.model.repository.PujaRepository;

public class PujaController {

    PujaRepository pujaRepository;
    PantallaSeleccionarCategoriaController seleccionarCategoriaController;
    Puja seleccionada ;

    public PujaController() {
        pujaRepository = new PujaRepository();
        seleccionarCategoriaController = new PantallaSeleccionarCategoriaController();
    }

    public ObservableList<TablaCatalogoTemporal> getPujasActivasItems() {
        return getPujasActivasByEstadoPujaYCategoriaProducto(EstadoPuja.ACTIVO, null);
    }

    public ObservableList<TablaCatalogoTemporal> getPujasActivaByCategoria(Categoria categoria) {
        return getPujasActivasByEstadoPujaYCategoriaProducto(EstadoPuja.ACTIVO, categoria);
    }

    public ObservableList<TablaCatalogoTemporal> getPujasActivasByEstadoPujaYCategoriaProducto(EstadoPuja estado, Categoria filtro) {

        ObservableList<TablaCatalogoTemporal> datos = FXCollections.observableArrayList();

        for (Puja actual : pujaRepository.getPujasActivasByEstadoPujaYCategoriaProducto(estado, filtro)) {
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
        return datos;
    }


    public Puja pujaVisualizada(Puja temp) {
        System.out.println(temp.getId());
        seleccionada = this.pujaRepository.buscarPuja(temp.getId());
      // System.out.println(seleccionada.toString());
        return seleccionada ;
    }
    
    public  int obtenerPujantes( Long id){
        
      return this.pujaRepository.ContadorPujantes(id);
        
    }
    
    

/*
    public Puja getTemporalVisualizada() {
        System.out.println("LLeagamos A get");
        System.out.println(seleccionada.toString());
        return this.seleccionada;
    }

    public void setTemporalVisualizada(Puja seleccionada) {
        //System.out.println(seleccionada.toString());

        this.seleccionada = seleccionada;
    }

    public PujaController temporalVisualizada (Puja seleccionada) {
        setTemporalVisualizada(seleccionada);
        return this;
    }
*/

}
