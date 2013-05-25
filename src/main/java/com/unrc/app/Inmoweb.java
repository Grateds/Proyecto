package com.unrc.app;

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
                "<body background = 'http://img190.imageshack.us/img190/7979/wwwplanillasesimitacion.jpg'>"+
                "<center>    <h1>Inmobiliaria Web</h1>" +
                "    <a href='users/2'>Users</a><br>"+
                "    <a href='realestates/1'>RealEstates</a><br>"+
                "	<a href='adduser/'>Add User</a></center>"+
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
    			RealEstate realstate = RealEstate.findFirst("id = ?", request.params(":id"));
    			Base.close();
        	 
    			if (realstate != null ){
    				return "Name: "+realstate.get("name");
    			}else{
    				response.status(404);
    				return "Real Estate not found";
    			}
    		}
    	});
    	
    	Spark.get(new Route("/adduser/") {
    		@Override
    		public Object handle(Request request, Response response) {
    			
                response.type("text/html");
    			
    			return ""+
    			"<form method='POST' action='/adduser/'>"+
    				"Email:   "+"<input name='email'><P>"+
    				"First name: <input name='fname'><P>"+
    				"Last name:  <input name='lname' VALUE='last name'><P>"+
    			 "<input type='submit' value='Add'>"+
    			 "<input type='reset' value='Reset'></form>";
    			
    		}
    	});
    	
    	Spark.post(new Route("/adduser/") {
    		@Override
    		public Object handle(Request request, Response response) {
                
    			crudUser u = new crudUser();
    			Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
    			u.create(request.queryParams("email"), request.queryParams("fname"), request.queryParams("lname"));
    			Base.close();
    		
                return "Usuario registrado exitosamente";

    		}
    	});

    }
}
