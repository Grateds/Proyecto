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
                "    <a href='owners/1'>Owners</a><br>"+
                "    <a href='realestates/1'>RealEstates</a><br>"+
                "    <a href='adduser/'>Add User</a></br>"+
                "    <a href='addowner/'>Add Owner</a></center>"+        
                "</body>" +
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
        }); //end User
    	
         Spark.get(new Route("/owners/:id") {
    		@Override
    		public Object handle(Request request, Response response) {
    			Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
    			Owner  owner = Owner.findFirst("id = ?", request.params(":id"));
    			Base.close();
        
    			if (owner != null ){
    				return "Name: "+owner.get("first_name");
    			}else{
    				response.status(404);
    				return "Owner not found";
    			}
    		}
    	}); //end Owner

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
    	}); //end Real Estate
    	
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
    		
                return "Usuario registrado exitosamente.!";

    		}
    	});
        
        Spark.get(new Route("/addowner/") {
    		@Override
    		public Object handle(Request request, Response response) {	
                    
                response.type("text/html");
    			
    			return ""+
    			"<form method='POST' action='/addowner/'>"+

    				"first_name: <input name='first_name'><P>"+
    				"last_name:  <input name='last_name'><P>"+
                                "city_id: <input name='city_id'><P>"+
                                "neighborhood: <input name='neighborhood'><P>"+ 
                                "street: <input name='street'><P>"+ 
                                "n_street: <input name='n_street'><P>"+ 
                                "email:   "+"<input name='email'><P>"+
                                
    			 "<input type='submit' value='Add'>"+
    			 "<input type='reset' value='Reset'></form>";	
    		}
    	});
        
        Spark.post(new Route("/addowner/") {
    		@Override
    		public Object handle(Request request, Response response) {
                
    			crudOwner o = new crudOwner();
    			Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
    			o.create(request.queryParams("first_name"), request.queryParams("last_name"), request.queryParams("city_id"),request.queryParams("neighborhood"),request.queryParams("street"),request.queryParams("n_street"),request.queryParams("email"));			
                        Base.close();
    		
                return "Propietario registrado exitosamente.!";

    		}
    	});
    }
}
