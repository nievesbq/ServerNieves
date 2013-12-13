package content;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by bqnieves on 13/12/13.
 */
public class ChatResponse {
    @JsonProperty
    private List<Message> messages;

    @JsonProperty
    private int next_Seq;

    private ChatResponse(){}

    public ChatResponse(List<Message> messages, int next_seq) {
        this.messages = messages;
        this.next_Seq = next_seq;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public int getNext_Seq() {
        return next_Seq;
    }

    public void setNext_Seq(int next_Seq) {
        this.next_Seq = next_Seq;
    }
}
