package com.unrc.app;

import java.util.List;
import org.javalite.activejdbc.Base;
import spark.*;
import com.unrc.app.models.*;

public class Inmoweb {
    public static void main( String[] args ) {
        
        Spark.get(new Route("/"){
            @Override
            public Object handle(Request request, Response response) {
                response.type("text/html");
                
                return 
                "<DOCTYPE html>" +
                "<html>" +
                "	<head>" +
                "		<meta http-equiv='Content-Type' content='text/html; charset=ISO-8859-1'>" +
                "		<title>Inmobiliaro Web</title>"+
                "		<link rel='shortcut icon' href='http://icons.iconarchive.com/icons/deleket/3d-cartoon-vol3/24/Axialis-Icon-Workshop-Classic-icon.png'>"+
                "   </head>" +
                "	<body background = 'http://static.giantbomb.com/uploads/original/3/35099/2183980-fez8.jpg'>"+
                "		<center>    <h1>Inmobiliario Web</h1>" +
                "   		<a href='users/2'>Users(Building..)</a><br>"+
                "    		<a href='owner/1'>Owner(Building..)</a><br>"+
                "    		<a href='owners/'>ListOwners(Building..)</a><br>"+
                "    		<a href='realestates/1'>RealEstates(Building..)</a><br>"+
                "    		<a href='adduser/'>Agregar Usuario</a><br>"+
                "    		<a href='addowner/'>Agregar Due&ntilde;o</a><br>" +
                "		</center>"+        
                "	</body>" +
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
    	
        Spark.get(new Route("/owner/:id") {
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
    	}); 
         
        Spark.get(new Route("/owners/") {
        	@Override
     		public Object handle(Request request, Response response) {
        		response.type("text/html");
                Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
                List<Owner> owners = Owner.findAll();
     			
                String ret = "";
     			for(int i=0; i < owners.size(); i++){
     				Owner o = owners.get(i);
                    ret = ret+"<b>First name:</b> "+o.get("first_name")+", <b>Last name:</b> "+o.get("last_name")+", <b>Email:</b> "+o.get("email")+"<br><br>";
                }   
     			Base.close();  			
     			return ret;
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
    			
    			return 
    		    "<DOCTYPE html>" +
    	        "<html>" +
    	        "	<head>" +
    	        "		<title>Agregar Usuario</title>"+
    	        "		<link rel='shortcut icon' href='http://icons.iconarchive.com/icons/deleket/3d-cartoon-vol3/24/Axialis-Icon-Workshop-Classic-icon.png'>"+
    	        "   </head>" +
    	        "	<body background = 'http://static.giantbomb.com/uploads/original/3/35099/2183980-fez8.jpg'>"+
    	        "   	<center><h1>Formulario</h1>" +    			
    			"		<form method='POST' action='/adduser/'>"+
    		    "			<p><input name='fname' placeholder='Nombre'></p>"+
    			"			<p><input name='lname' placeholder='Apellido'</p>"+
    			"			<p><input name='email' placeholder='someone@example.com'></p>"+ 
    			"			<input type='submit' value='Add'>"+
    			"			<input type='reset' value='Reset'>" +    			
    			"		</form></center>"+       
                "	</body>" +
                "</html>";
    			
    		}
    	}); 
    	
        Spark.post(new Route("/adduser/") {
    		@Override
    		public Object handle(Request request, Response response) {
    			response.type("text/html");
    			crudUser u = new crudUser();
    			Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
    			u.create(request.queryParams("email"), request.queryParams("fname"), request.queryParams("lname"));
    			Base.close();
    		
                return 
                "<DOCTYPE html>" +
            	"<html>" +
            	"	<head>" +
            	"		<title>Agregar Usuario</title>"+
                "		<link rel='shortcut icon' href='http://icons.iconarchive.com/icons/deleket/3d-cartoon-vol3/24/Axialis-Icon-Workshop-Classic-icon.png'>"+
                "   </head>" +
                "	<body background = 'http://static.giantbomb.com/uploads/original/3/35099/2183980-fez8.jpg'>"+
                "		<h1>Usuario registrado exitosamente</h1>" +
                "		<a href='/'>Inicio</a>" +
                "   </body>" +
                "</html>";
    		}
    	}); //end post adduser
        
        Spark.get(new Route("/addowner/") {
    		@Override
    		public Object handle(Request request, Response response) {	
                response.type("text/html");
    			
    			return 
    			"<DOCTYPE html>" +
    		    "<html>" +
    		    "	<head>" +
    		    "		<title>Agregar Usuario</title>"+
    		    "		<link rel='shortcut icon' href='http://icons.iconarchive.com/icons/deleket/3d-cartoon-vol3/24/Axialis-Icon-Workshop-Classic-icon.png'>"+
    		    "   </head>" +
    		    "	<body background = 'http://static.giantbomb.com/uploads/original/3/35099/2183980-fez8.jpg'>"+
    		    "   	<center><h1>Formulario</h1>" +     			
    			"		<form method='POST' action='/addowner/'>"+
    			"			<p><input name='first_name' placeholder='Nombre'></p>"+
    			"			<p><input name='last_name' placeholder='Apellido'></p>"+
                "			<input name='city_id' placeholder='Ciudad'>" +
                "			<SELECT NAME='selCombo' SIZE=1 onChange='javascript:alert('prueba');'>"+ 
                "				<OPTION VALUE='link pagina 1'>Seleccionar</OPTION>"+
                "				<OPTION VALUE='link pagina 2'>Ciudad 1</OPTION>"+
                "				<OPTION VALUE='link pagina 3'>Ciudad 2</OPTION>"+
                "				<OPTION VALUE='link pagina 4'>Ciudad 3</OPTION> "+
                "				<OPTION VALUE='link pagina 4'>..</OPTION> "+
                "			</SELECT>"+
                "			<p><input name='neighborhood' placeholder='Barrio'></p>"+ 
                "			<p><input name='street' placeholder='Calle'>"+ 
                "			<p><input name='n_street' placeholder='Numero'></p>"+ 
                "			<p><input name='email' placeholder='someone@example.com'></p>"+ 
                "			<input type='submit' value='Add'>"+
    			"			<input type='reset' value='Reset'>" +
    			"		</form></center>"+
    			"	</body>" +
                "</html>";
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