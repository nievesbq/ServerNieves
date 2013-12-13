/**
 * Created by bqnieves on 12/12/13.
 */
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import config.ServerConfiguration;
import res.MessagesResource;

public class ServerService extends Service<ServerConfiguration> {

    public static void main(String[] args) throws Exception {
        new ServerService().run(args);
    }

    @Override
    public void initialize(Bootstrap<ServerConfiguration> bootstrap) {
        bootstrap.setName("chat-kata");
    }

    @Override
    public void run(ServerConfiguration configuration, Environment environment) {

        environment.addResource(new MessagesResource());

    }

}