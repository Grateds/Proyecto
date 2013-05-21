package com.unrc.app;
import static spark.Spark.*;

import spark.*;

/**
 * Hello world!
 *
 */
public class Inmoweb 
{
    public static void main( String[] args )
    {
        //http://0.0.0.0:4567/hello
        get(new Route("/hello") {
         @Override
         public Object handle(Request request, Response response) {
            return "Hello World!, this is a test";
         }
      });

    }
}
