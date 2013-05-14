package ru.weather;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;

/**
 * Created with IntelliJ IDEA.
 * User: a1
 * Date: 14.05.13
 * Time: 15:14
 * To change this template use File | Settings | File Templates.
 */
// The Java class will be hosted at the URI path "/helloworld"
@Path("/helloworld")
public class RestWeather {
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    public String getClichedMessage() {
        // Return some cliched textual content
        return "Hello World";
    }


    }
