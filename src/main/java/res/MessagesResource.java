package res;

import com.google.common.base.Optional;
import com.yammer.metrics.annotation.Timed;
import content.Message;
import content.Messages;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by bqnieves on 12/12/13.
 */

@Path("/chat-kata/api/chat")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessagesResource {

    Messages allContent;

    public MessagesResource(){

    };

    @GET
    @Timed
    public Response getMessages(@QueryParam("seq") Optional<String> seq) {
        int seqAsked;
        try{
            seqAsked = Integer.parseInt(seq.toString()) ;
        }
        catch (Exception e){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        if ( seqAsked > allContent.getSeq() || seqAsked < 0) seqAsked = allContent.getSeq() ;

        Messages response = new Messages( allContent.getList().subList(seqAsked, allContent.getSeq()), allContent.getSeq());

        return Response.status(Response.Status.CREATED).entity(response).build();

    }

    @POST
    @Timed
    public Response addMessage(Message msg) {
        //three possible bad constructions
        if(msg==null || msg.getMessage()==null || msg.getNick()==null ){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        else
            //add it
            allContent.addMessage(msg);
        return Response.status(Response.Status.CREATED).entity(msg).build();
    }
}