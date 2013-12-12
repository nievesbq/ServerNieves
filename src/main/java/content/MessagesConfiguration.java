package content;

/**
 * Created by bqnieves on 12/12/13.
 */
import com.yammer.dropwizard.config.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.ArrayList;

public class MessagesConfiguration extends Configuration {

    /*@NotEmpty
    @JsonProperty
    private String template;

    @NotEmpty
    @JsonProperty
    private String defaultName = "Stranger";

    public String getTemplate() {
        return template;
    }

    public String getDefaultName() {
        return defaultName;
    }*/

    @JsonProperty
    private long last_seq;

    @JsonProperty
    private ArrayList<Message> messages;

    public long getLast_seq(){
        return last_seq;
    }

    public ArrayList<Message> getMessages(){
        return messages;
    }

}
