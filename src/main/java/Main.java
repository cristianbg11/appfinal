import spark.Session;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static spark.Spark.*;

public class Main {

    public static void main(final String[] args) throws Exception {
        staticFiles.location("/publico");
        port(getHerokuAssignedPort());

        get("", (request, response)-> {
            //response.redirect("/login.html");
            return renderContent("publico/index.html");
        });
    }

    public static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 8080; //Retorna el puerto por defecto en caso de no estar en Heroku.
    }

    private static String renderContent(String htmlFile) throws IOException, URISyntaxException {
        URL url = Main.class.getResource(htmlFile);
        Path path = Paths.get(url.toURI());
        return new String(Files.readAllBytes(path), Charset.defaultCharset());
    }
}
