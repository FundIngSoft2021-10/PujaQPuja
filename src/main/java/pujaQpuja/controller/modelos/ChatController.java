package pujaQpuja.controller.modelos;

import pujaQpuja.model.repository.ChatRepository;

public class ChatController {
    private ChatRepository chatRepository;

    public ChatController() {
        chatRepository = new ChatRepository();
    }
}
