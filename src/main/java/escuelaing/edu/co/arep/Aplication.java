package escuelaing.edu.co.arep;

import escuelaing.edu.co.arep.sparkService.Service;

import java.io.IOException;

public class Aplication {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.getInstance();
        Service.get("/index.html",  (request, response) -> { response.setExtent("text/html");return response.getResponse();});
        Service.get("/index.css",  (request, response) -> { response.setExtent("text/css");return response.getResponse();});
        Service.get("/script.js",  (request, response) -> { response.setExtent("text/javascript");return response.getResponse();});
        server.run(args);
    }
}
