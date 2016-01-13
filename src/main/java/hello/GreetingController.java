package hello;

/**
 * Created by manish.rastogi on 11/1/16.
 */
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    Greeting user1 = new Greeting(0, "default");
 /*   @RequestMapping("/")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World!") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
*/
    @RequestMapping(value = "/user1?name=hello", method = RequestMethod.POST)
    public  @ResponseBody String createNewUser( @RequestParam(value="name") String name )   {
        user1 = new Greeting(counter.incrementAndGet(), name);
        String response = "{\"message\":\"Created New User - name: " + user1.getName() + "\"}";
        return response;
    }

    @RequestMapping(value = "/user1", method = RequestMethod.GET)
    public  @ResponseBody String getUser()   {
        String response = "{\""+user1.getContent()+"\",\"Your user id\":\""+ user1.getId() + "\",\"and Name is\":\""+ user1.getName() + "\"}";
        return response;
    }
}
