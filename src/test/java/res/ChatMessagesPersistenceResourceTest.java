package res;

import com.yammer.dropwizard.testing.ResourceTest;
import content.ChatMessagesPersistence;
import content.ChatResponse;
import content.Message;
import org.junit.Test;

import java.util.ArrayList;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by bqnieves on 13/12/13.
 */
public class ChatMessagesPersistenceResourceTest extends ResourceTest {

    private final ChatMessagesPersistence chatMessagesPersistenceMock = mock(ChatMessagesPersistence.class);

    @Override
    protected void setUpResources() {

        addResource(new ChatResource(chatMessagesPersistenceMock));
    }

    @Test
    public void GETTest() throws Exception {
        ChatResponse chatResponse = new ChatResponse(new ArrayList<Message>(),5);
        when(chatMessagesPersistenceMock.fetchMessagesFromNumSeq(0)).thenReturn(chatResponse);

        ChatResponse getResponse = client().resource("/chat-kata/api/chat").get(ChatResponse.class);
        assertThat(getResponse).isEqualsToByComparingFields(chatResponse);

        verify(chatMessagesPersistenceMock).fetchMessagesFromNumSeq(0);
    }

    @Test
    public void numbSeqGET() throws Exception {

        ChatResponse chatResponse = new ChatResponse(new ArrayList<Message>(), 0);
        when(chatMessagesPersistenceMock.fetchMessagesFromNumSeq(5)).thenReturn(chatResponse);

        ChatResponse getResponse = client().resource("/chat-kata/api/chat?next_seq=5").get(ChatResponse.class);
        assertThat(getResponse.getNext_Seq()).isEqualTo(chatResponse.getNext_Seq());

        verify(chatMessagesPersistenceMock).fetchMessagesFromNumSeq(5);

    }

    @Test
    public void responsePOST() throws Exception {


    }


}
