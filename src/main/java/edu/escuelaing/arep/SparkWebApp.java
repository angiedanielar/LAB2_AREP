package edu.escuelaing.arep;

import com.google.gson.Gson;
import edu.escuelaing.arep.calculator.App;
import spark.Spark;

import static spark.Spark.*;

/**
 * Web Spark app class
 * @author Angie Daniela Ruiz Alfonso
 */
public class SparkWebApp {
	
	//taken form taller-spark

    public static void main(String[] args) {
    	port(getPort());
    	CorsFilter.apply(); // Call this before mapping thy routes
        Gson gson = new Gson();
    
        post("/calculator/calculate/", (req, res) -> {
        	System.out.println("holi");
            String result = App.calculate(req.body());
            return gson.toJson(result);
        });
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; // returns default port if heroku-port isn't set(i.e. on localhost)
    }
}