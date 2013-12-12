package content;

/**
 * Created by bqnieves on 12/12/13.
 */
public class Message {

    private String nick;
    private String message;

    private Message(){ }

    public Message(String nick, String message){
        this.nick = nick;
        this.message = message;
    }

    public String getNick() {
        return nick;
    }

    public String getMessage() {
        return message;
    }
}
