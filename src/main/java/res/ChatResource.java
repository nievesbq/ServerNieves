package res;

import com.google.common.base.Optional;
import com.yammer.metrics.annotation.Timed;
import content.ChatMessagesPersistence;
import content.ChatResponse;
import content.Message;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

/**
 * Created by bqnieves on 12/12/13.
 */

@Path("/chat-kata/api/chat")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ChatResource {

    ChatMessagesPersistence chatChatMessagesPersistencePersistence;

    public ChatResource(ChatMessagesPersistence chatChatMessagesPersistencePersistence){
        //chatChatMessagesPersistencePersistence = new ChatMessagesPersistence(new ArrayList<Message>(), 0);
        this.chatChatMessagesPersistencePersistence = chatChatMessagesPersistencePersistence;
    };

    @GET
    @Timed
    public ChatResponse getMessages(@QueryParam("next_seq") Optional<String> next_Seq) {
       int seqAsked;
        try{
            seqAsked = Integer.parseInt(next_Seq.get()) ;
        }
        catch (Exception e){
            seqAsked = 0;
        }
        ChatResponse response = chatChatMessagesPersistencePersistence.fetchMessagesFromNumSeq(seqAsked);

        return response;
    }

    @POST
    @Timed
    public Response addMessage(Message msg) {
        //bad constructions test
        if(msg==null || msg.getMessage()==null || msg.getNick()==null ){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        else
            chatChatMessagesPersistencePersistence.addMessage(msg);
        return Response.status(Response.Status.OK).build();
    }
}