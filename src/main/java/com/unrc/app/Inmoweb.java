package com.unrc.app;

import java.util.List;
import org.javalite.activejdbc.Base;
import spark.*;
import com.unrc.app.models.*;

public class Inmoweb {
	
    public static String optionCity(){
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
        List<City> cities = City.findAll();
        String ret = "<SELECT NAME='city_id' SIZE=1 onChange='javascript:alert('prueba');'>"+"<option value='' disabled selected style='display:none;'>Seleccionar ciudad</option><br>";
        for(int i=0; i < cities.size(); i++){
            City c = cities.get(i);
            ret = ret+"<option value="+c.get("id")+">"+c.get("name")+"</option><br>";
        }
        ret= ret + "</SELECT>";
         Base.close();  			
     	return ret;
    }
    
    public static void main( String[] args ) {
        
        Spark.get(new Route("/"){
            @Override
            public Object handle(Request request, Response response) {
                response.type("text/html");
                
                return 
                "<!DOCTYPE html>"+
                "<html lang='en'>"+
                "	<head>"+
                "		<meta charset='utf-8'>"+
                "		<title>Inmobiliario Web</title>"+
                "		<!-- Le styles -->"+
                "		<link href='http://twitter.github.io/bootstrap/assets/css/bootstrap.css' rel='stylesheet'>"+
                "		<style type='text/css'>"+
                "			body {"+
                "				padding-top: 60px;"+
                "				padding-bottom: 40px;"+
                "			}"+
                "		</style>"+
                "		<link href='http://twitter.github.io/bootstrap/assets/css/bootstrap-responsive.css' rel='stylesheet'>"+
                "		<link rel='shortcut icon' href='http://icons.iconarchive.com/icons/deleket/3d-cartoon-vol3/24/Axialis-Icon-Workshop-Classic-icon.png'>"+
                "	</head>"+
  				"<body background = 'http://loadpaper.com/large/Sky_wallpapers_171.jpg'>"+
   				"	<div class='navbar navbar-inverse navbar-fixed-top'>"+
   				"		<div class='navbar-inner'>"+
   				"   		<div class='container'>"+
   				"   		<button type='button' class='btn btn-navbar' data-toggle='collapse' data-target='.nav-collapse'>"+
   				"   		</button>"+
   				"			<a class='brand' href='/'>Inmobiliaria</a>"+
   				"			<div class='nav-collapse collapse'>"+
   				"				<ul class='nav'>"+
   				"					<li class='active'><a href='/'>Inicio</a></li>"+
   				"					<li><a href='/about/'>Acerca</a></li>"+
   				"					<li><a href='/contact/'>Contacto</a></li>"+
                "					<li class='dropdown'>"+
                "						<a href='#' class='dropdown-toggle' data-toggle='dropdown'>Acciones <b class='caret'></b></a>"+
                "						<ul class='dropdown-menu'>"+
                "							<li><a href='/users/'>Listar Usuarios</a></li>"+
                "							<li><a href='/owners/'>Listar Dueños</a></li>"+
                "							<li><a href='/buildings/'>Listar Inmuebles</a></li>" +
                "							<li><a href='/realstates/'>Listar Inmobiliarias</a></li>"+  
                "							<li class='divider'></li>"+
                "							<li class='nav-header'>Other thing</li>"+
                "    		                                        <li><a href='adduser/'>Agregar Usuario</a></li>"+
                "    		                                        <li><a href='addowner/'>Agregar Dueño</a></li>"+
                "							<li class='divider'></li>"+
                "							<li class='nav-header'>Other thing</li>"+
                "						</ul>"+
                "					</li>"+
                "				</ul>"+
                "			</div>"+
                "		</div>"+
                "	</div>"+
                "</div>"+
                "<div class='container'>"+
                "	<!-- Main hero unit for a primary marketing message or call to action -->"+
                "	<div class='hero-unit'>"+
                "		<h1>Bienvenido!</h1>"+
                "		<p>El sitio donde puede encontrar:</p>" +
                "		<p>Merca</p>" +
                "		<p>Paco</p>" +
                "		<p>Extasis</p>" +
                "		<p>Marihuana</p>"+
                "		<p><a href='./sign-up.html' class='btn btn-primary btn-large'>Registrarse &raquo;</a></p>"+
                "	</div>"+
                "<footer>"+
                "<p>&copy; Grateds, Inc. All rights reserved</p>"+
                "</footer>"+
                "</div> <!-- /container -->"+
    			"<script src='http://twitter.github.io/bootstrap/assets/js/jquery.js'></script>"+
    			"<script src='http://twitter.github.io/bootstrap/assets/js/bootstrap-dropdown.js'></script>"+
    			"	</body>"+
  				"</html>";
            }
        });
        
    	Spark.get(new Route("/user/:id") {
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
        
        Spark.get(new Route("/users/") { 
        	@Override
     		public Object handle(Request request, Response response) {
        		response.type("text/html");
                Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
                List<User> users = User.findAll();
     			
                String ret = "";
     			for(int i=0; i < users.size(); i++){
     				User o = users.get(i);
                    ret = ret+"<b>First name:</b> "+o.get("first_name")+", <b>Last name:</b> "+o.get("last_name")+"<br><br>";
                }   
     			Base.close(); 
                        return
     			"<DOCTYPE html>" +
                        "<html>" +	        
                        "   </head>" +
                        "	<body background = 'http://loadpaper.com/large/Sky_wallpapers_171.jpg'>"+
                                ret+
                        "	</body>" +
                        "</html>";  
            }
     	}); // end users (ListUsers)
        
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
                        return 
                        "<DOCTYPE html>" +
                        "<html>" +	        
                        "   </head>" +
                        "	<body background = 'http://loadpaper.com/large/Sky_wallpapers_171.jpg'>"+
                                ret+
                        "	</body>" +
                        "</html>";                 
            }
     	}); // end owners (ListOwners)
         
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
    	        "	<body background = 'http://loadpaper.com/large/Sky_wallpapers_171.jpg'>"+
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
                "	<body background = 'http://loadpaper.com/large/Sky_wallpapers_171.jpg'>"+
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
                    "           <meta charset=\"utf-8\">"+
    		    "		<title>Agregar Usuario</title>"+
    		    "		<link rel='shortcut icon' href='http://icons.iconarchive.com/icons/deleket/3d-cartoon-vol3/24/Axialis-Icon-Workshop-Classic-icon.png'>"+
    		    "   </head>" +
    		    "	<body background = 'http://loadpaper.com/large/Sky_wallpapers_171.jpg'>"+
    		    "   	<center><h1>Formulario</h1>" +     			
    			"		<form method='POST' action='/addowner/'>"+
    			"			<p><input name='first_name' placeholder='Nombre'></p>"+
    			"			<p><input name='last_name' placeholder='Apellido'></p>"+
                			optionCity()+
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
                        response.type("text/html");
    			crudOwner o = new crudOwner();
    			Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
    			o.create(request.queryParams("first_name"), request.queryParams("last_name"), request.queryParams("city_id"),request.queryParams("neighborhood"),request.queryParams("street"),request.queryParams("n_street"),request.queryParams("email"));			
                        Base.close();
    		
                return 
                "<DOCTYPE html>" +
            	"<html>" +
            	"	<head>" +
            	"		<title>Agregar Dueño</title>"+
                "		<link rel='shortcut icon' href='http://icons.iconarchive.com/icons/deleket/3d-cartoon-vol3/24/Axialis-Icon-Workshop-Classic-icon.png'>"+
                "       </head>" +
                "	<body background = 'http://loadpaper.com/large/Sky_wallpapers_171.jpg'>"+
                "		<h1>Due&ntilde;o registrado exitosamente</h1>" +
                "		<a href='/'>Inicio</a>" +
                "       </body>" +
                "</html>";
            }
    	});
        
        Spark.get(new Route("/about/") {
    		@Override
    		public Object handle(Request request, Response response) {	
                response.type("text/html");
    			
    			return 
    					"<!DOCTYPE html>"+
    	                "<html lang='en'>"+
    	                "	<head>"+
    	                "		<meta charset='utf-8'>"+
    	                "		<title>Inmobiliario Web</title>"+
    	                "		<!-- Le styles -->"+
    	                "		<link href='http://twitter.github.io/bootstrap/assets/css/bootstrap.css' rel='stylesheet'>"+
    	                "		<style type='text/css'>"+
    	                "			body {"+
    	                "				padding-top: 60px;"+
    	                "				padding-bottom: 40px;"+
    	                "			}"+
    	                "		</style>"+
    	                "		<link href='http://twitter.github.io/bootstrap/assets/css/bootstrap-responsive.css' rel='stylesheet'>"+
    	                "		<link rel='shortcut icon' href='http://icons.iconarchive.com/icons/deleket/3d-cartoon-vol3/24/Axialis-Icon-Workshop-Classic-icon.png'>"+
    	                "	</head>"+
    	  				"<body background = 'http://loadpaper.com/large/Sky_wallpapers_171.jpg'>"+
    	   				"	<div class='navbar navbar-inverse navbar-fixed-top'>"+
    	   				"		<div class='navbar-inner'>"+
    	   				"   		<div class='container'>"+
    	   				"   		<button type='button' class='btn btn-navbar' data-toggle='collapse' data-target='.nav-collapse'>"+
    	   				"   		</button>"+
    	   				"			<a class='brand' href='/'>Inmobiliaria</a>"+
    	   				"			<div class='nav-collapse collapse'>"+
    	   				"				<ul class='nav'>"+
    	   				"					<li><a href='/'>Inicio</a></li>"+
    	   				"					<li class='active'><a href='./about.html'>Acerca</a></li>"+
    	   				"					<li><a href='/contact/'>Contacto</a></li>"+
    	                "					<li class='dropdown'>"+
    	                "						<a href='#' class='dropdown-toggle' data-toggle='dropdown'>Acciones <b class='caret'></b></a>"+
    	                "						<ul class='dropdown-menu'>"+
    	                "							<li><a href='/users/'>Listar Usuarios</a></li>"+
    	                "							<li><a href='/owners/'>Listar Dueños</a></li>"+
    	                "							<li><a href='/buildings/'>Listar Inmuebles</a></li>" +
    	                "							<li><a href='/realstates/'>Listar Inmobiliarias</a></li>"+
    	                "							<li class='divider'></li>"+
    	                "							<li class='nav-header'>Other thing</li>"+
    	                "							<li><a href='./separeated-link.html'>Thing 1</a></li>"+
    	                "							<li><a href='./1-more-separated.html'>Thing 2</a></li>"+
    	                "						</ul>"+
    	                "					</li>"+
    	                "				</ul>"+
    	                "			</div>"+
    	                "		</div>"+
    	                "	</div>"+
    	                "</div>"+
    	                "<div class='container'>"+
    	                "	<!-- Main hero unit for a primary marketing message or call to action -->"+
    	                "	<div class='hero-unit'>" +
    	                "		<center>"+
    	                "			<h1>En construcción..</h1>" +
    	                "			<img src='http://tiendasuzuki.com/hombre.png'>" +
    	                "			<p>Lamentamos las molestas ocasionadas.</p>" +
    	                "		</center>"+
    	                "	</div>"+
    	                "<footer>"+
    	                "<p>&copy; Grateds, Inc. All rights reserved</p>"+
    	                "</footer>"+
    	                "</div> <!-- /container -->"+
    	    			"<script src='http://twitter.github.io/bootstrap/assets/js/jquery.js'></script>"+
    	    			"<script src='http://twitter.github.io/bootstrap/assets/js/bootstrap-dropdown.js'></script>"+
    	    			"	</body>"+
    	  				"</html>";
    		}
    	}); 
        Spark.get(new Route("/contact/") {
    		@Override
    		public Object handle(Request request, Response response) {	
                response.type("text/html");
    			
    			return 
    					"<!DOCTYPE html>"+
    	                "<html lang='en'>"+
    	                "	<head>"+
    	                "		<meta charset='utf-8'>"+
    	                "		<title>Inmobiliario Web</title>"+
    	                "		<!-- Le styles -->"+
    	                "		<link href='http://twitter.github.io/bootstrap/assets/css/bootstrap.css' rel='stylesheet'>"+
    	                "		<style type='text/css'>"+
    	                "			body {"+
    	                "				padding-top: 60px;"+
    	                "				padding-bottom: 40px;"+
    	                "			}"+
    	                "		</style>"+
    	                "		<link href='http://twitter.github.io/bootstrap/assets/css/bootstrap-responsive.css' rel='stylesheet'>"+
    	                "		<link rel='shortcut icon' href='http://icons.iconarchive.com/icons/deleket/3d-cartoon-vol3/24/Axialis-Icon-Workshop-Classic-icon.png'>"+
    	                "	</head>"+
    	  				"<body background = 'http://loadpaper.com/large/Sky_wallpapers_171.jpg'>"+
    	   				"	<div class='navbar navbar-inverse navbar-fixed-top'>"+
    	   				"		<div class='navbar-inner'>"+
    	   				"   		<div class='container'>"+
    	   				"   		<button type='button' class='btn btn-navbar' data-toggle='collapse' data-target='.nav-collapse'>"+
    	   				"   		</button>"+
    	   				"			<a class='brand' href='/'>Inmobiliaria</a>"+
    	   				"			<div class='nav-collapse collapse'>"+
    	   				"				<ul class='nav'>"+
    	   				"					<li><a href='/'>Inicio</a></li>"+
    	   				"					<li><a href='/about/'>Acerca</a></li>"+
    	   				"					<li class='active'><a href='/contact/'>Contacto</a></li>"+
    	                "					<li class='dropdown'>"+
    	                "						<a href='#' class='dropdown-toggle' data-toggle='dropdown'>Acciones <b class='caret'></b></a>"+
    	                "						<ul class='dropdown-menu'>"+
    	                "							<li><a href='/users/'>Listar Usuarios</a></li>"+
    	                "							<li><a href='/owners/'>Listar Dueños</a></li>"+
    	                "							<li><a href='/buildings/'>Listar Inmuebles</a></li>" +
    	                "							<li><a href='/realstates/'>Listar Inmobiliarias</a></li>"+
    	                "							<li class='divider'></li>"+
    	                "							<li class='nav-header'>Other thing</li>"+
    	                "							<li><a href='./separeated-link.html'>Thing 1</a></li>"+
    	                "							<li><a href='./1-more-separated.html'>Thing 2</a></li>"+
    	                "						</ul>"+
    	                "					</li>"+
    	                "				</ul>"+
    	                "			</div>"+
    	                "		</div>"+
    	                "	</div>"+
    	                "</div>"+
    	                "<div class='container'>"+
    	                "	<!-- Main hero unit for a primary marketing message or call to action -->"+
    	                "	<div class='hero-unit'>"+
    	                "		<div class='container'>"+
    	                "			<h2>Contactanos</h2>"+
    	                "			<label>Estamos aquí para ayudar con cualquier pregunta o comentario. </label>"+
    	                "		</div>"+
    	                "		<hr></hr>"+
    	                "		<div class='container'>"+
    	                "			<form class='navbar-form pull-left'>"+
    	                "				<dl class= 'form'>"+
    	                "					<dt>"+
    	                "						<label for='form_name'>"+
    	                "							<b>Nombre</b>"+
    	                "						</label>"+
    	                "						<input type='text' class='input-block-level'>"+     
    	                "					</dt>"+
    	                "				</dl>"+
    	                "				<dl class= 'form'>"+
    	                "					<dt>"+
    	                "						<label for='form_email'>"+
                        "							<b>Email</b>"+
                        "						</label>"+   
                        "						<input type='text' class='input-block-level'>"+     
                        "					</dt>"+
                        "				</dl>"+
                        "				<dl class= 'form'>"+
                        "					<dt>"+
                        "						<label for='form_subject'>"+
                        "							<b>Asunto</b>"+
                        "						</label>"+
                        "						<input type='text' class='input-block-level'>"+     
                        "					</dt>"+
                        "				</dl>"+
                        "				<dl class= 'form'>"+
                        "					<dt>"+
                        "						<label for='form_body'>"+
                        "							<b>Mensaje</b>"+
                        "						</label>"+
                        "						<textarea style='width: 394px; height: 52px;'></textarea><br>"+
                        "						<button class='btn btn-large btn-primary' type='submit'>Enviar</button>"+     
                        "					</dt>"+
                        "				</dl>"+
                       	"			</form>"+
                        "		</div>"+
    	                "	</div>"+
    	                "<footer>"+
    	                "<p>&copy; Grateds, Inc. All rights reserved</p>"+
    	                "</footer>"+
    	                "</div> <!-- /container -->"+
    	    			"<script src='http://twitter.github.io/bootstrap/assets/js/jquery.js'></script>"+
    	    			"<script src='http://twitter.github.io/bootstrap/assets/js/bootstrap-dropdown.js'></script>"+
    	    			"	</body>"+
    	  				"</html>";
    		}
    	}); 
    }
}
