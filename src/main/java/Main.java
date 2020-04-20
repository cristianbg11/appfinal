import spark.ModelAndView;
import spark.Session;
import spark.template.freemarker.FreeMarkerEngine;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class Main {

    public static void main(final String[] args) throws Exception {
        Kmeans kmeans = new Kmeans();
        //kmeans.inicializar(10, 5);
        //System.out.println(System.getProperty("user.dir"));
        staticFiles.location("/publico");
        port(getHerokuAssignedPort());

        get("", (request, response)-> {
            //response.redirect("/login.html");
            return renderContent("publico/index.html");
        });

        get("/table", (request, response)-> {
            ArrayList<Instancia> instancias = new ArrayList<>();
            Map<String, Object> attributes = new HashMap<>();
            //int id = Integer.parseInt(request.queryParams("id"));
            //Estudiante est = (Estudiante) estudiantes.get(id);
            instancias = kmeans.inicializar(10, 5);
            attributes.put("instancias", instancias);
            return new ModelAndView(attributes, "table.ftl");

        } , new FreeMarkerEngine());
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
