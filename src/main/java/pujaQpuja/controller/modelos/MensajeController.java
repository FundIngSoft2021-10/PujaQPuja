package pujaQpuja.controller.modelos;

import javafx.scene.image.ImageView;
import pujaQpuja.model.entities.*;
import pujaQpuja.model.entities.otros.TablaMensaje;
import pujaQpuja.model.repository.MensajeRepository;

import java.util.ArrayList;
import java.util.List;

public class MensajeController {

    private MensajeRepository mensajeRepository;
    private ControladorGeneral controladorGeneral;
    private Mensaje seleccionada;

    public MensajeController() {
        mensajeRepository = new MensajeRepository();
    }

    public void crear(long idPuja,long idVendedor,long idComprador, String pregunta) {
        Mensaje mensaje = new Mensaje();
        mensaje.setIdPuja(idPuja);
        mensaje.setEmisor(idComprador);
        mensaje.setReceptor(idVendedor);
        mensaje.setCuerpo(pregunta);
        mensajeRepository.crear(mensaje);
    }

    public List<TablaMensaje> getPreguntasRespuestas(long id) {
        return getPreguntasRespuestasByID(id);
    }

    public List<TablaMensaje> getPreguntasRespuestasByID(long id) {
        List<TablaMensaje> datos = new ArrayList<>();
        for (Mensaje actual : mensajeRepository.getPreguntasYRespuestas(id)) {
            TablaMensaje temp = new TablaMensaje();
            temp.setMensaje(actual);
            Puja puja = mensajeRepository.getPujaXMensaje(actual.getIdPuja());
            temp.setPuja(puja);
            if (puja.getProducto() != null) {
                if (puja.getProducto().getFoto() != null) {
                    temp.setImagen(new ImageView(puja.getProducto().getFoto()));
                }
            }
            temp.setPregunta(actual.getCuerpo());
            temp.setRespuesta(actual.getRespuesta());
            datos.add(temp);
        }

        return datos;
    }

    public void respuesta(long idPuja, String respuesta) {
        mensajeRepository.respuesta(respuesta,idPuja);
    }

    public Mensaje mensajeVisualizado(Mensaje temp) {
        System.out.println(temp.getId());
        seleccionada = this.mensajeRepository.buscarPorId(temp.getId());
        return seleccionada;
    }

    public List<TablaMensaje> getPreguntas(long id) {
        List<TablaMensaje> datos = new ArrayList<>();
        for (Mensaje actual : mensajeRepository.getPreguntasIdPuja(id)) {
            TablaMensaje temp = new TablaMensaje();
            temp.setMensaje(actual);
            temp.setPregunta(actual.getCuerpo());
            temp.setRespuesta(actual.getRespuesta());
            datos.add(temp);
        }

        return datos;
    }
}
