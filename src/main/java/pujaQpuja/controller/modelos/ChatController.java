package pujaQpuja.controller.modelos;

import pujaQpuja.model.entities.Mensaje;
import pujaQpuja.model.repository.ChatRepository;

public class ChatController {
    private ChatRepository chatRepository;
    private long idPuja;
    private long idVendedor;
    private long idComprador;

    public ChatController() {
        chatRepository = new ChatRepository();
    }

}
