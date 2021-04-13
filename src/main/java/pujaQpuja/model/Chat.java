package pujaQpuja.model;

import java.util.Objects;
import java.util.Queue;

public class Chat {
    private Queue<Mensaje> chatcola;



    public Chat() {
    }

    public Chat(Queue<Mensaje> chatcola) {
        this.chatcola = chatcola;
    }

    public Queue<Mensaje> getChatcola() {
        return this.chatcola;
    }

    public void setChatcola(Queue<Mensaje> chatcola) {
        this.chatcola = chatcola;
    }

    public Chat chatcola(Queue<Mensaje> chatcola) {
        setChatcola(chatcola);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Chat)) {
            return false;
        }
        Chat chat = (Chat) o;
        return Objects.equals(chatcola, chat.chatcola);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(chatcola);
    }

    @Override
    public String toString() {
        return "{" +
            " chatcola='" + getChatcola() + "'" +
            "}";
    }
}
