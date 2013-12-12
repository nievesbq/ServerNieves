package content;

import java.util.ArrayList;

/**
 * Created by bqnieves on 12/12/13.
 */
public class Messages { //persistence class

    private static ArrayList<Message> messages;
    private static long last_seq;

    public Messages(){
        messages = new ArrayList<Message>();
        last_seq = 0;
    }

    public void addMessage(Message newMessage){
        messages.add(newMessage);
        last_seq++;
    }

    public ArrayList<Message> getList(){
        return messages;
    }

    public long getSeq(){
        return last_seq;
    }

}
