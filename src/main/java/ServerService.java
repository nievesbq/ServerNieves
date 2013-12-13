/**
 * Created by bqnieves on 12/12/13.
 */
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import config.ServerConfiguration;
import content.ChatMessagesPersistence;
import res.ChatResource;

public class ServerService extends Service<ServerConfiguration> {

    public static void main(String[] args) throws Exception {
        args = new String[]{"server"};
        new ServerService().run(args);
    }

    @Override
    public void initialize(Bootstrap<ServerConfiguration> bootstrap) {
        bootstrap.setName("chat-kata");
    }

    @Override
    public void run(ServerConfiguration configuration, Environment environment) {
        ChatMessagesPersistence chatChatMessagesPersistencePersistence = new ChatMessagesPersistence();
        environment.addResource(new ChatResource(chatChatMessagesPersistencePersistence));
    }

}