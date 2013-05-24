package com.unrc.app;

import static spark.Spark.*;

import org.javalite.activejdbc.Base;

import spark.*;
import com.unrc.app.models.*;

public class Inmoweb {
    public static void main( String[] args ) {
        
    	//http://0.0.0.0:4567/
        Spark.get(new Route("/"){
            @Override
            public Object handle(Request request, Response response) {
                response.type("text/html");

                // return html
                return "" +
                "<DOCTYPE html>" +
                "<html>" +
                "  <head>" +
                        "<title>Inmo Web</title>"+
                "  </head>" +
                "  <body>" +
                "    <h1>InmoWeb</h1>" +
                "    <a href='users/'>Users</a><br>"+
                "    <a href='realestates/1'>RealEstates</a>"+
                "  </body>" +
                "</html>";
            }
        });
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
        Spark.get(new Route("/realestates/:id") {
         @Override
         public Object handle(Request request, Response response) {
             Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
        	 RealEstate rs = RealEstate.findFirst("id = ?", request.params(":id"));
        	 Base.close();
        	 
        	 if (rs != null ){
        		 return "Name: "+rs.get("name");
        	 }else{
        	     response.status(404);
        	     return "Real Estate not found";
        	 }
        }
      });

    }
}
