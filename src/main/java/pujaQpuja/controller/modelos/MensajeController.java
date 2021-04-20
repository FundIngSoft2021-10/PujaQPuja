package pujaQpuja.controller.modelos;

import pujaQpuja.model.repository.MensajeRepository;

public class MensajeController {

    MensajeRepository mensajeRepository;

    public MensajeController() {
        mensajeRepository = new MensajeRepository();
    }
}
