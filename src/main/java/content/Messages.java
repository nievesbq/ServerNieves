package content;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bqnieves on 12/12/13.
 */
public class Messages { //persistence class

    @JsonProperty
    private List<Message> messages;

    @JsonProperty
    private int last_seq;

    private Messages(){
        messages = new ArrayList<Message>();
        last_seq = 0;
    }

    public Messages(List<Message> messages, int last_seq){
        this.messages = messages;
        this.last_seq = last_seq;
    }

    public void addMessage(Message newMessage){
        messages.add(newMessage);
        last_seq++;
    }

    public List<Message> getList(){
        return messages;
    }

    public int getSeq(){
        return last_seq;
    }

    public void setMessages(ArrayList<Message> messages){
        this.messages=messages;
    }

    public void setLast_seq(int last_seq){
        this.last_seq=last_seq;
    }


}
