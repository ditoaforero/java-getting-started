import java.sql.*;
import java.text.DecimalFormat;
import java.util.*;

import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.get;

import com.heroku.sdk.jdbc.DatabaseUrl;
public class Main {

  public static void main(String[] args) {

    port(Integer.valueOf(System.getenv("PORT")));
    staticFileLocation("/public");

    get("/tarea", (request, response) -> {

      ArrayList<Double> listActualAddedModifiedSize = new ArrayList();
      ArrayList<Double> listEstimatedProxySize = new ArrayList();
      ArrayList<Double> listPlanAddedModifiedSize = new ArrayList();
      ArrayList<Double> listActualDevelopmentHour = new ArrayList();

      listActualAddedModifiedSize = (ArrayList) Archivo.retornarContenidoArchivoDouble("src/main/resources/public/ActualAddedModifiedSize.txt");
      listEstimatedProxySize = (ArrayList) Archivo.retornarContenidoArchivoDouble("src/main/resources/public/EstimatedProxySize.txt");
      listPlanAddedModifiedSize = (ArrayList) Archivo.retornarContenidoArchivoDouble("src/main/resources/public/PlanAddedModifiedSize.txt");
      listActualDevelopmentHour = (ArrayList) Archivo.retornarContenidoArchivoDouble("src/main/resources/public/ActualDevelopmentHour.txt");

      Map<String, Object> attributes = new HashMap<>();
      attributes.put("listActualAddedModifiedSize", listActualAddedModifiedSize);
      attributes.put("listEstimatedProxySize", listEstimatedProxySize);
      attributes.put("listPlanAddedModifiedSize", listPlanAddedModifiedSize);
      attributes.put("listActualDevelopmentHour", listActualDevelopmentHour);
      attributes.put("test1", Tarea.ejecutarTest("listEstimatedProxySize - listActualAddedModifiedSize: ",listEstimatedProxySize, listActualAddedModifiedSize ));
      attributes.put("test2", Tarea.ejecutarTest("listEstimatedProxySize - listActualDevelopmentHour: ",listEstimatedProxySize, listActualDevelopmentHour ));
      attributes.put("test3", Tarea.ejecutarTest("listPlanAddedModifiedSize - listActualAddedModifiedSize: ",listPlanAddedModifiedSize, listActualAddedModifiedSize ));
      attributes.put("test4", Tarea.ejecutarTest("listPlanAddedModifiedSize - listActualDevelopmentHour: ",listPlanAddedModifiedSize, listActualDevelopmentHour ));

      return new ModelAndView(attributes, "resultadosTarea.ftl");
    }, new FreeMarkerEngine());


    get("/hello", (req, res) -> "Hello world");

    get("/", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Hello World!");

            return new ModelAndView(attributes, "index.ftl");
        }, new FreeMarkerEngine());

    get("/db", (req, res) -> {
      Connection connection = null;
      Map<String, Object> attributes = new HashMap<>();
      try {
        connection = DatabaseUrl.extract().getConnection();

        Statement stmt = connection.createStatement();
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
        stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
        ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");

        ArrayList<String> output = new ArrayList<String>();
        while (rs.next()) {
          output.add( "Read from DB: " + rs.getTimestamp("tick"));
        }

        attributes.put("results", output);
        return new ModelAndView(attributes, "db.ftl");
      } catch (Exception e) {
        attributes.put("message", "There was an error: " + e);
        return new ModelAndView(attributes, "error.ftl");
      } finally {
        if (connection != null) try{connection.close();} catch(SQLException e){}
      }
    }, new FreeMarkerEngine());

  }

}
