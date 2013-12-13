package content;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bqnieves on 12/12/13.
 */
public class Messages {

    @JsonProperty
    private List<Message> messages;

    @JsonProperty
    private int next_Seq;

    private Messages(){

    }

    public Messages(List<Message> messages, int next_Seq){
        this.messages = messages;
        this.next_Seq = next_Seq;
    }

    public void addMessage(Message newMessage){
        messages.add(newMessage);
        next_Seq++;
    }

    public List<Message> getList(){
        return messages;
    }

    public int getSeq(){
        return next_Seq;
    }

    public void setMessages(ArrayList<Message> messages){
        this.messages=messages;
    }

    public void setNext_Seq(int next_Seq){
        this.next_Seq = next_Seq;
    }


}
