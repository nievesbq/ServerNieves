package res;

import com.google.common.base.Optional;
import com.yammer.metrics.annotation.Timed;
import content.Message;
import content.Messages;

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
public class MessagesResource {

    Messages allcontent;

    public MessagesResource(){
        allcontent = new Messages();
    };

    @GET
    @Timed
    public Response getMessages(@QueryParam("seq") Optional<String> seq) {

        int seqAsked = Integer.parseInt(seq.toString()) ;
        if( seqAsked < allcontent.getSeq() ){

            return Response.status(Response.Status.CREATED).entity(allcontent.response(seqAsked)).build();
        }
        else return Response.status(Response.Status.BAD_REQUEST).build();

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
            allcontent.addMessage(msg);
            return Response.status(Response.Status.CREATED).entity(msg).build();
    }
}