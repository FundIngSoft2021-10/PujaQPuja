package pujaQpuja.controller.modelos;

import javafx.scene.image.ImageView;
import pujaQpuja.model.entities.*;
import pujaQpuja.model.entities.otros.TablaCatalogoTemporal;
import pujaQpuja.model.repository.MensajeRepository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MensajeController {

    private MensajeRepository mensajeRepository;
    private ControladorGeneral controladorGeneral;

    public MensajeController() {
        mensajeRepository = new MensajeRepository();
    }

    public void crear(long idVendedor,long idComprador, String pregunta) {
        Mensaje mensaje = new Mensaje();
        mensaje.setEmisor(idComprador);
        mensaje.setReceptor(idVendedor);
        mensaje.setCuerpo(pregunta);
        mensajeRepository.crear(mensaje);
    }

    public List<Mensaje> getPreguntasRespuestas() {
        return getPreguntasRespuestasByID();
    }
    public List<Mensaje> getPreguntasRespuestasByID() {
        List<Mensaje> datos = new ArrayList<>();

        for (Mensaje actual : mensajeRepository.getPreguntasYRespuestas(controladorGeneral.autenticacionController.getAutenticado().getId())) {
            datos.add(actual);
        }
        return datos;
    }
}
