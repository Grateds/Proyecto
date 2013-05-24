package com.unrc.app;

import static spark.Spark.*;

import org.javalite.activejdbc.Base;

import spark.*;
import com.unrc.app.models.*;

public class Inmoweb {
    public static void main( String[] args ) {
        
    	//http://0.0.0.0:4567/
    	Spark.get(new Route("/users/:id") {
         @Override
         public Object handle(Request request, Response response) {
             Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
        	 User user = User.findFirst("id = ?", request.params(":id"));
        	 Base.close();
        	 
        	 if (user != null ){
        		 return "Name: "+user.get("first_name");
        	 }else{
        	     response.status(404);
        	     return "User not found";
        	 }
        }
      });

    }
}
