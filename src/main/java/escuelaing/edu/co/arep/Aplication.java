package escuelaing.edu.co.arep;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Aplication {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.getInstance();
        server.nuevoServicio("/index.html", new Rest() {
            @Override
            public String getHeader() {
                return "HTTP/1.1 200 \r\n" +
                        "Content-Type: text/html \r\n" +
                        "\r\n";
            }

            @Override
            public String getResponse() {
                byte[] file;
                try{
                    file = Files.readAllBytes(Paths.get("src/main/resources/index.html"));
                }catch (IOException e){
                    throw new RuntimeException(e);
                }
                return new String(file);
            }
        });
        server.nuevoServicio("/index.css", new Rest() {
            @Override
            public String getHeader() {
                return "HTTP/1.1 200 \r\n" +
                        "Content-Type: text/css \r\n" +
                        "\r\n";
            }

            @Override
            public String getResponse() {
                byte[] file;

                try {
                    file = Files.readAllBytes(Paths.get("src/main/resources/index.css"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                return new String(file);
            }
        });
        server.nuevoServicio("/script.js", new Rest() {
            @Override
            public String getHeader() {
                return "HTTP/1.1 200 \r\n" +
                        "Content-Type: text/javascript \r\n" +
                        "\r\n";
            }

            @Override
            public String getResponse() {
                byte[] file;
                try{
                    file = Files.readAllBytes(Paths.get("src/main/resources/script.js"));
                }catch (IOException e){
                    throw new RuntimeException(e);
                }
                return new String(file);
            }
        });
        server.nuevoServicio("/noEncontrado", new Rest() {
            @Override
            public String getHeader() {
                return "HTTP/1.1 200 \r\n" +
                        "Content-Type: text/html \r\n" +
                        "\r\n";
            }


            @Override
            public String getResponse() {
                byte[] file;
                try{
                    file = Files.readAllBytes(Paths.get("src/main/resources/error404.html"));
                }catch (IOException e){
                    throw new RuntimeException(e);
                }
                return new String(file);
            }
        });
        server.run(args);
    }
}
