package content;

import java.util.ArrayList;

/**
 * Created by bqnieves on 12/12/13.
 */
public class ChatMessagesPersistence {
    private ChatResponse chatState = new ChatResponse(new ArrayList<Message>(),0);

        public ChatMessagesPersistence(){
    }

    public void addMessage(Message newMessage){
        chatState.getMessages().add(newMessage);
        chatState.setNext_Seq(chatState.getNext_Seq()+1);
    }

    public ChatResponse fetchMessagesFromNumSeq(int seqAsked) {
        if ( seqAsked > chatState.getNext_Seq() || seqAsked < 0) seqAsked = chatState.getNext_Seq() ;

        if( seqAsked==0) return chatState;
        else{
            ChatResponse response = new ChatResponse(chatState.getMessages().subList(seqAsked, chatState.getNext_Seq()),
                                                       chatState.getNext_Seq());

            return response;
        }
    }
}
