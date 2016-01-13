package hello;

/**
 * Created by manish.rastogi on 11/1/16.
 */
public class Greeting {

    private final long id;
    private  String content;
    private static final String template = "Hello, %s!";

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return String.format(template, content);
    }

    public String getName() {
        return content;
    }


}
