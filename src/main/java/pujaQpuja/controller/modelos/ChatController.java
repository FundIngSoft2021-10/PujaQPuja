package pujaQpuja.controller.modelos;

import pujaQpuja.model.repository.ChatRepository;

public class ChatController {
    ChatRepository chatRepository;

    public ChatController() {
        chatRepository = new ChatRepository();
    }
}
