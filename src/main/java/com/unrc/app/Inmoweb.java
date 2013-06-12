package com.unrc.app;

import java.util.List;
import org.javalite.activejdbc.Base;
import static spark.Spark.externalStaticFileLocation;
import spark.*;
import com.unrc.app.models.*;

public class Inmoweb {


    public static String optionCity(String option, String required){

        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
        List<City> cities = City.findAll();
        String ret = "<select class='span3' NAME='city_id' "+required+">"+"<option value=''>"+option+"</option><br>";
        for(int i=0; i < cities.size(); i++){
            City c = cities.get(i);
            ret = ret+"<option value="+c.get("id")+">"+c.get("name")+"</option><br>";
        }
        ret= ret + "</select>";
         Base.close();  			
     	return ret;
    }
    
    public static String optionCityUpdate(String id){
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
        City city = City.findFirst("id = ?", id);
        List<City> cities = City.findAll();
        String ret = "<select class='span3' NAME='city_id' required='required'>"+"<option value='"+id+"' style='display:none;'>"+city.get("name")+"</option><br>";
        for(int i=0; i < cities.size(); i++){
            City c = cities.get(i);
            ret = ret+"<option value="+c.get("id")+">"+c.get("name")+"</option><br>";
        }
        ret= ret + "</select>";
        Base.close();  			
     	return ret;
    }
    
    public static String optionOperation(String option, String required){
    	String ret = "<select class='span3' NAME='operation' "+required+">"+"<option value=''>"+option+"</option><br>";
		ret = ret+"<option value='venta'>Venta</option><br>" +
				  "<option value='alquiler'>Alquiler</option><br>";
    	return ret+"</select>";
    }
    
    public static String optionOperationUpdate(String operation){
    	String ret = "<select class='span3' NAME='operation' required='required'>"+"<option value='"+operation+"' style='display:none;'>"+operation+"</option><br>";
    	ret = ret+"<option value='venta'>Venta</option><br>" +
				  "<option value='alquiler'>Alquiler</option><br>";
    	return ret+"</select>";
    }
    
    public static String optionType(String option, String required){
    	String ret = "<select class='span3' NAME='type' "+required+">"+"<option value=''>"+option+"</option><br>";
		ret = ret+"<option value='land'>Campo</option><br>" +
				  "<option value='farm'>Quinta</option><br>" +
	        	  "<option value='house'>Casa</option><br>" +
				  "<option value='garage'>Garage</option><br>";
    	return ret+"</select>";
    }
    
    public static String optionTypeUpdate(String type){
    	String ret = "<select class='span3' NAME='type' required='required'>"+"<option value='"+type+"' style='display:none;'>"+type+"</option><br>";
		ret = ret+"<option value='land'>Campo</option><br>" +
				  "<option value='farm'>Quinta</option><br>" +
	        	  "<option value='house'>Casa</option><br>" +
				  "<option value='garage'>Garage</option><br>";
    	return ret+"</select>";
    }
    
    public static String optionOwner(){
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
        List<Owner> owners = Owner.findAll();
        String ret = "<select class='span3' NAME='owner_id' required='required'>"+"<option value=''>Seleccionar dueño</option><br>";
        for(int i=0; i < owners.size(); i++){
            Owner o = owners.get(i);
            ret = ret+"<option value="+o.get("id")+">"+o.get("first_name")+" - "+o.get("last_name")+" - "+o.get("email")+"</option><br>";
        }
        ret= ret + "</select>";
         Base.close();  			
     	return ret;
    }
    
    public static String optionOwnerUpdate(String id){
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
        Owner owner = Owner.findFirst("id = ?", id);
        List<Owner> owners = Owner.findAll();
        String ret = "<select class='span3' NAME='owner_id' required='required'>"+"<option value='"+id+"' style='display:none;'>"+owner.get("first_name")+" - "+owner.get("last_name")+" - "+owner.get("email")+"</option><br>";
        for(int i=0; i < owners.size(); i++){
            Owner o = owners.get(i);
            ret = ret+"<option value="+o.get("id")+">"+o.get("first_name")+" - "+o.get("last_name")+" - "+o.get("email")+"</option><br>";
        }
        ret= ret + "</select>";
         Base.close();  			
     	return ret;
    }
    
    public static String optionRealEstate(String option, String required){
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
        List<RealEstate> realestates = RealEstate.findAll();
        String ret = "<select class='span3' NAME='real_estate_id' "+required+">"+"<option value='' '>"+option+"</option><br>";
        for(int i=0; i < realestates.size(); i++){
            RealEstate re = realestates.get(i);
            ret = ret+"<option value="+re.get("id")+">"+re.get("name")+"</option><br>";
        }
        ret= ret + "</select>";
        Base.close();  			
     	return ret;
    }
    
    public static void main( String[] args ) {

        externalStaticFileLocation("src/main/java/com/unrc/app/public");

        final String EncabezadoHTML1 =
        		"<!DOCTYPE html>"+
                "<html lang='en'>"+
                	"<head>"+
                		"<meta charset='utf-8'>"+
                		"<title>Inmobiliario Web</title>"+
                		"<!-- Le styles -->"+
                		"<link href='../bootstrap/css/bootstrap.css' rel='stylesheet'>"+
                		"<link rel='stylesheet' href='../bootstrap/css/docs.css'></link>"+
                		"<style type='text/css'>"+
                			"body {"+
                				"padding-top: 60px;"+
                				"padding-bottom: 40px;"+
                			"}"+			
                		"</style>"+
                		"<link href='../bootstrap/css/bootstrap-responsive.css' rel='stylesheet'>"+
                		"<link rel='shortcut icon' href='../bootstrap/img/inmoapp.png'>"+
                	"</head>"+
  				"<body background ='../bootstrap/img/background.jpg'>"+
   					"<div class='navbar navbar-inverse navbar-fixed-top'>"+
   						"<div class='navbar-inner'>"+
   				   			"<div class='container'>"+
   				   				"<button type='button' class='btn btn-navbar' data-toggle='collapse' data-target='.nav-collapse'>"+
   				   				"</button>"+
   								"<a class='brand' href='/'>Inmobiliaria</a>"+           
   								"<div class='nav-collapse collapse'>"+
   									"<ul class='nav'>";
   				final String EncabezadoHTML2 = 
   		   								"<li><a href='/'>Inicio</a></li>"+
   		   								"<li><a href='/about/'>Acerca</a></li>"+
   		   								"<li><a href='/contact/'>Contacto</a></li>";
   				final String EncabezadoHTML3 = 
   										"<li class='dropdown'>"+
   			    							"<a href='#' class='dropdown-toggle' data-toggle='dropdown'>Registro <b class='caret'></b></a>"+
   			    							"<ul class='dropdown-menu'>"+
   			    								"<li><a href='/addowner/'><img src='../bootstrap/img/owner-add.png'> Registrar Dueño</a></li>"+
   			    								"<li><a href='/addbuilding/'><img src='../bootstrap/img/building-add.png'> Registrar Inmueble</a></li>"+
   			    								"<li><a href='/addrealestate/'><img src='../bootstrap/img/inmo-add.png'> Registrar Inmobiliaria</a></li>"+
   			    							"</ul>"+
   			    						"</li>"+
                						"<li class='dropdown'>"+
                							"<a href='#' class='dropdown-toggle' data-toggle='dropdown'>Administración <b class='caret'></b></a>"+
                							"<ul class='dropdown-menu'>"+
                								"<li><a href='/users/'><img src='../bootstrap/img/list.png'> Ver Usuarios</a></li>"+
                								"<li><a href='/owners/'><img src='../bootstrap/img/list.png'> Ver Dueños</a></li>"+
                								"<li><a href='/buildings/'><img src='../bootstrap/img/list.png'> Ver Inmuebles</a></li>" +
                								"<li><a href='/realestates/'><img src='../bootstrap/img/list.png'> Ver Inmobiliarias</a></li>"+
                								"<li class='divider'></li>"+
                								"<li><a href='/search/'><img src='../bootstrap/img/search-icon.png'> Buscar</a></li>"+
                							"</ul>"+
                						"</li>"+
                					"</ul>"+
                				"</div>"+
                			"</div>"+
                		"</div>"+
                	"</div>";
        		
        Spark.get(new Route("/"){
            @Override
            public Object handle(Request request, Response response) {
                response.type("text/html");
                
                return 
                		EncabezadoHTML1+
                								"<li class='active'><a href='/'>Inicio</a></li>"+
                								"<li><a href='/about/'>Acerca</a></li>"+
                								"<li><a href='/contact/'>Contacto</a></li>"+
   						EncabezadoHTML3+	
                        	"<div class='container'>"+
                        	"<!-- Main hero unit for a primary marketing message or call to action -->"+
                        		"<div class='hero-unit'>"+
                        			"<div class='row'>"+
                        				"<div class='span6'>"+
                        					"<center><h1>¡Bienvenido!</h1>"+
                        					"<p>This is a template for a simple marketing or informational website.</p>"+
                        					"<img src='../bootstrap/img/index.png'></center>"+
                        				"</div>"+
                        				"<div class='span4'>"+
                        					"<form class='form' method='POST' action='/adduser/'>"+
                        						"<h3>Regístrarse</h3>"+
                        						"<label>* Datos obligatorios</label>"+
                        						"<hr></hr>"+      
                        						"<label>Nombre:*</label><input type='text' id='inputSuccess' class='input-block-level' name='fname' pattern='[a-zA-Z ]+' title='Solo letras - Maxima Longitud 56' maxlength='56'required='required' placeholder='Nombre'>"+  
                        						"<label>Apellido:*</label><input type='text' class='input-block-level' name='lname' pattern='[a-zA-Z ]+' title='Solo letras - Maxima Longitud 56' placeholder='Apellido' maxlength='56' required='required'>"+
                        						"<label>E-mail:*</label><input type='text' class='input-block-level' name='email' pattern='[a-zA-Z0-9]+[.[a-zA-Z0-9_-]+]*@[a-z0-9][\\w\\.-]*[a-z0-9]\\.[a-z][a-z\\.]*[a-z]$'+ title='Maxima Longitud 60' placeholder='someone@example.com' maxlength='60' required='required'>"+                   
                        						"<dl class= 'form'>"+
                        							"<button class='btn btn-large btn-primary' type='submit'>Registrarme</button>"+
                        						"</dl>"+           
                        					"</form>"+
                        				"</div>"+
                        			"</div>"+
                        		"</div>"+
                        		"<footer>"+
                        			"<p>&copy; 2013 Grateds, Inc. All rights reserved.</p>"+
                        		"</footer>"+
                        	"</div> <!-- /container -->"+
            				"<script src='../bootstrap/js/jquery.js'></script>"+
            				"<script src='../bootstrap/js/bootstrap-dropdown.js'></script>"+
            			"</body>"+
          				"</html>";
                
            }
        });
        
        Spark.get(new Route("/users/") { 
        	@Override
     		public Object handle(Request request, Response response) {
        		response.type("text/html");
                Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
                List<User> users = User.findAll();
     			
                String ret = 
                		"<table class='table table-hover'>" +
                			"<thead>" +
                				"<tr>" +
                					"<th>#</th>" +
                					"<th>Nombre</th>" +
                					"<th>Apellido</th>" +
                					"<th>E-mail</th>" +
                				"</tr>" +
                			"</thead>" +
                			"<tbody>";
                int j;
     			for(int i=0; i < users.size(); i++){
     				User u = users.get(i);
                    j = i+1;
     				ret = ret+"<tr><td>"+j+"</td>"+
     							  "<td>"+u.get("first_name")+"</td>" +
     							  "<td>"+u.get("last_name")+"</td>" +
     							  "<td>"+u.get("email")+"</td>"+
                                  "<td><a href='/updateuser/"+u.get("id")+"'><img src='../bootstrap/img/edit-update.png'></a></td>"+
                                  "<td><a href='/deleteuser/"+u.get("id")+"'><img src='../bootstrap/img/edit-delete.png'></a></td>";
     			}
     			ret = ret +"</tbody></table>";
     			Base.close(); 
                return
                		EncabezadoHTML1+
                		EncabezadoHTML2+
                		EncabezadoHTML3+
    	                	"<div class='container'>"+
    	                		"<!-- Main hero unit for a primary marketing message or call to action -->"+
    	                		"<div class='form-actions'>" +
    	                			"<div class='page-header'>" +
    	                				"<center><h1> Usuarios Registrados</h1></center>" +
    	                			"</div>"+
    	                			"<div>"+
    	                				ret+
    	                			"</div>"+
    	                		"</div>"+
    	                		"<footer>"+
    	                			"<p>&copy; 2013 Grateds, Inc. All rights reserved.</p>"+
    	                		"</footer>"+
    	                	"</div> <!-- /container -->"+
    	    				"<script src='../bootstrap/js/jquery.js'></script>"+
    	    				"<script src='../bootstrap/js/bootstrap-dropdown.js'></script>"+
    	    			"</body>"+
    	  				"</html>";    
                }
     	}); // end users (ListUsers)
        
        Spark.get(new Route("/owners/") { 
        	@Override
     		public Object handle(Request request, Response response) {
        		response.type("text/html");
                Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
                List<Owner> owners = Owner.findAll();
     			
                String ret = 
                		"<table class='table table-hover'>" +
                			"<thead>" +
                				"<tr>" +
                					"<th>#</th>" +
                					"<th>Nombre</th>" +
                					"<th>Apellido</th>" +
                					"<th>Ciudad</th>" +
                					"<th>Barrio</th>" +
                					"<th>Calle</th>" +
                					"<th>Numero</th>" +
                					"<th>E-mail</th>" +
                				"</tr>" +
                			"</thead>" +
                			"<tbody>";
                int j;

                City c = new City();
                for(int i=0; i < owners.size(); i++){
     				Owner o = owners.get(i);
     				j = i+1;
     				c = City.findFirst("id = ?", o.get("city_id"));
     				ret = ret+"<tr><td>"+j+"</td>"+
							  "<td>"+o.get("first_name")+"</td>" +
							  "<td>"+o.get("last_name")+"</td>" +
							  "<td>"+c.get("name")+"</td>"+
							  "<td>"+o.get("neighborhood")+"</td>"+
							  "<td>"+o.get("street")+"</td>"+
							  "<td>"+o.get("n_street")+"</td>"+
							  "<td>"+o.get("email")+"</td>"+
							  "<td><a href='/updateowner/"+o.get("id")+"'><img src='../bootstrap/img/edit-update.png'></a></td>"+
							  "<td><a href='/deleteowner/"+o.get("id")+"'><img src='../bootstrap/img/edit-delete.png'></a></td>";					
     			}   
     			ret = ret +"</tbody></table>";
     			Base.close();  			
                return 
                		EncabezadoHTML1+
                		EncabezadoHTML2+
                		EncabezadoHTML3+
    	                	"<div class='container'>"+
    	                		"<!-- Main hero unit for a primary marketing message or call to action -->"+
    	                		"<div class='form-actions'>" +
    	                			"<div class='page-header'>" +
    	                				"<center><h1> Dueños Registrados</h1></center>" +
    	                			"</div>"+
    	                			"<div>"+
    	                				ret+
    	                			"</div>"+
    	                		"</div>"+
    	                		"<footer>"+
    	                			"<p>&copy; 2013 Grateds, Inc. All rights reserved.</p>"+
    	                		"</footer>"+
    	                	"</div> <!-- /container -->"+
    	    				"<script src='../bootstrap/js/jquery.js'></script>"+
    	    				"<script src='../bootstrap/js/bootstrap-dropdown.js'></script>"+
    	    			"</body>"+
    	  				"</html>";  
        	}
     	}); // end owners (ListOwners)
         
        Spark.get(new Route("/buildings/") { 
        	@Override
     		public Object handle(Request request, Response response) {
        		response.type("text/html");
                Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
                List<Building> buildings = Building.findAll();
     			
                String ret = 
                		"<table class='table table-hover'>" +
                			"<thead>" +
                				"<tr>" +
                					"<th>#</th>"+
                					"<th>Tipo</th>"+
                					"<th>Dueño</th>"+
                					"<th>Inmobiliaria</th>"+
                					"<th>Ciudad</th>"+
                					"<th>Barrio</th>"+
                					"<th>Calle</th>"+
                					"<th>Numero</th>"+
                					"<th>Descripción</th>"+
                					"<th>Precio $</th>"+
                					"<th>Operación</th>"+
                				"</tr>" +
                			"</thead>" +
                			"<tbody>";
                int j;

                City c = new City();
                Owner o = new Owner();
                RealEstate r = new RealEstate();
                BuildingsRealEstates bRE = new BuildingsRealEstates();
                for(int i=0; i < buildings.size(); i++){
     				Building b = buildings.get(i);
     				j = i+1;
     				c = City.findFirst("id = ?", b.get("city_id"));
     				o = Owner.findFirst("id = ?", b.get("owner_id"));
     				bRE = BuildingsRealEstates.findFirst("building_id = ?", b.getId());
     				r = RealEstate.findFirst("id = ?", bRE.get("real_estate_id"));
     				ret = ret+"<tr><td>"+j+"</td>"+
							  "<td>"+b.get("type")+"</td>" +
							  "<td>"+o.get("last_name")+"</td>" +
							  "<td>"+r.get("name")+"</td>"+
							  "<td>"+c.get("name")+"</td>"+
							  "<td>"+b.get("neighborhood")+"</td>"+
							  "<td>"+b.get("street")+"</td>"+
							  "<td>"+b.get("n_street")+"</td>"+
							  "<td>"+b.get("description")+"</td>"+
							  "<td>"+b.get("price")+"</td>" +
							  "<td>"+b.get("operation")+"</td>"+
							  "<td><a href='/updatebuilding/"+b.get("id")+"'><img src='../bootstrap/img/edit-update.png'></a></td>"+
							  "<td><a href='/deletebuilding/"+b.get("id")+"'><img src='../bootstrap/img/edit-delete.png'></a></td>";
     			}   
     			ret = ret +"</tbody></table>";
     			Base.close();  			
                return 
                		EncabezadoHTML1+
                		EncabezadoHTML2+
                		EncabezadoHTML3+
    	                	"<div class='container'>"+
    	                		"<!-- Main hero unit for a primary marketing message or call to action -->"+
    	                		"<div class='form-actions'>" +
    	                			"<div class='page-header'>" +
    	                				"<center><h1> Inmuebles Registrados</h1></center>" +
    	                			"</div>"+
    	                			"<div>"+
    	                				ret+
    	                			"</div>"+
    	                		"</div>"+
    	                		"<footer>"+
    	                			"<p>&copy; 2013 Grateds, Inc. All rights reserved.</p>"+
    	                		"</footer>"+
    	                	"</div> <!-- /container -->"+
    	    				"<script src='../bootstrap/js/jquery.js'></script>"+
    	    				"<script src='../bootstrap/js/bootstrap-dropdown.js'></script>"+
    	    			"</body>"+
    	  				"</html>";  
        	}
     	}); // end buildings (ListBuilding)
        
        Spark.get(new Route("/realestates/") { 
        	@Override
     		public Object handle(Request request, Response response) {
        		response.type("text/html");
                Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
                List<RealEstate> realestates = RealEstate.findAll();
     			
                String ret = 
                		"<table class='table table-hover'>" +
                			"<thead>" +
                				"<tr>" +
                					"<th>#</th>" +
                					"<th>Nombre</th>" +
                					"<th>Ciudad</th>" +
                					"<th>Barrio</th>" +
                					"<th>Calle</th>" +
                					"<th>Numero</th>" +
                					"<th>Telefono</th>" +
                					"<th>E-mail</th>" +
                					"<th>Sitio Web</th>"+
                				"</tr>" +
                			"</thead>" +
                			"<tbody>";
                int j;

                City c = new City();
                for(int i=0; i < realestates.size(); i++){
     				RealEstate r = realestates.get(i);
     				j = i+1;
     				c = City.findFirst("id = ?", r.get("city_id"));
     				ret = ret+"<tr><td>"+j+"</td>"+
							  "<td>"+r.get("name")+"</td>" +
							  "<td>"+c.get("name")+"</td>"+
							  "<td>"+r.get("neighborhood")+"</td>"+
							  "<td>"+r.get("street")+"</td>"+
							  "<td>"+r.get("n_street")+"</td>"+
							  "<td>"+r.get("phone")+"</td>"+
							  "<td>"+r.get("email")+"</td>" +
							  "<td>"+r.get("site_web")+"</td>"+
                              "<td><a href='/updaterealestate/"+r.get("id")+"'><img src='../bootstrap/img/edit-update.png'></a></td>"+
                              "<td><a href='/deleterealestate/"+r.get("id")+"'><img src='../bootstrap/img/edit-delete.png'></a></td>";
     			}   
     			ret = ret +"</tbody></table>";
     			Base.close();  			
                return 
                		EncabezadoHTML1+
                		EncabezadoHTML2+
                		EncabezadoHTML3+
    	                	"<div class='container'>"+
    	                		"<!-- Main hero unit for a primary marketing message or call to action -->"+
    	                		"<div class='form-actions'>" +
    	                			"<div class='page-header'>" +
    	                				"<center><h1> Inmobiliarias Registradas</h1></center>" +
    	                			"</div>"+
    	                			"<div>"+
    	                				ret+
    	                			"</div>"+
    	                		"</div>"+
    	                		"<footer>"+
    	                			"<p>&copy; 2013 Grateds, Inc. All rights reserved.</p>"+
    	                		"</footer>"+
    	                	"</div> <!-- /container -->"+
    	    				"<script src='../bootstrap/js/jquery.js'></script>"+
    	    				"<script src='../bootstrap/js/bootstrap-dropdown.js'></script>"+
    	    			"</body>"+
    	  				"</html>";  
        	}
     	}); // end realEstates (ListRealEstates)
    	
        Spark.post(new Route("/adduser/") {
    		@Override
    		public Object handle(Request request, Response response) {
    			response.type("text/html");
    			crudUser u = new crudUser();
    			Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
    			u.create(request.queryParams("email"), request.queryParams("fname"), request.queryParams("lname"));
    			Base.close();
    		
    			return 
    				EncabezadoHTML1+
                		EncabezadoHTML2+
                		EncabezadoHTML3+
		                "<div class='container'>"+
		                	"<!-- Main hero unit for a primary marketing message or call to action -->"+
		                	"<div class='hero-unit'>"+
		                		"<center>"+
    	                			"<h3>Usuario registrado exitosamente.</h3>" +
    	                			"<a href='/'>" +
    	                				"<button class='btn btn-success btn-primary'>Volver</button>" +
    	                			"</a>"+
    	                		"</center>"+ 
		                	"</div>"+
		                	"<footer>"+
		                		"<p>&copy; 2013 Grateds, Inc. All rights reserved.</p>"+
		                	"</footer>"+
		                "</div> <!-- /container -->"+
		    			"<script src='../bootstrap/js/jquery.js'></script>"+
		    			"<script src='../bootstrap/js/bootstrap-dropdown.js'></script>"+
		    				"</body>"+
		  				"</html>"; 
    		}
    	}); //end post adduser
        
        Spark.get(new Route("/addowner/") {
    		@Override
    		public Object handle(Request request, Response response) {	
                response.type("text/html");
                
    			return 
                        EncabezadoHTML1+
                		EncabezadoHTML2+
                		EncabezadoHTML3+
    	                "	<div class='container'>"+
    	                "		<!-- Main hero unit for a primary marketing message or call to action -->"+
    	                "		<div class='hero-unit'>"+
    	                "			<div class='container'>"+
    	                "				<h2>Registrar Dueño</h2>"+
    	                "				<label>* Datos obligatorios </label>"+
    	                "			</div>"+
    	                "			<hr></hr>"+
    	                "			<div>"+
    	                "				<form class='form-horizontal' method='POST' action='/addowner/'>"+       
                        "					<div class='control-group'>"+
    	                "						<label class='control-label'>Nombre:*</label>"+
    	                "						<div class='controls'>"+
    	                "							<input type='text' name='first_name' pattern='[a-zA-Z ]+' title='Solo letras - Maxima Longitud 56' maxlength='56'required='required'>"+
    	                "						</div>"+  
                        "                   </div>"+
    	                "					<div class='control-group'>"+
    	                "						<label class='control-label'>Apellido:*</label>"+
    	                "						<div class='controls'>"+
    	                "							<input type='text' name='last_name' pattern='[a-zA-Z ]+' title='Solo letras - Maxima Longitud 56' maxlength='56' required='required'>"+
    	                "						</div>"+  
                        "					</div>"+
    	                "					<div class='control-group'>"+
    	                "						<label class='control-label'>Ciudad:</label>"+
    	                "						<div class='controls'>"+
    	                							optionCity("Seleccionar ciudad","required='required'")+
    	                "						</div>"+                 
    	                "					</div>"+
    	                "					<div class='control-group'>"+
    	                "						<label class='control-label'>Barrio:</label>"+
    	                "						<div class='controls'>"+
    	                "							<input type='text' name='neighborhood' pattern='[a-zA-Z ]+' title='Solo letras - Maxima Longitud 30' maxlength='30'>"+
    	                "						</div>"+   
    	                "					</div>"+
    	                "					<div class='control-group'>"+
    	                "						<label class='control-label'>Calle:</label>"+
    	                "						<div class='controls'>"+
    	                "							<input type='text' name='street' pattern='[a-zA-Z ]+' title='Solo letras - Maxima Longitud 30' maxlength='30'>"+
    	                "						</div>"+  
    	                "					</div>"+ 
    	                "					<div class='control-group'>"+
    	                "						<label class='control-label'>Numero:</label>"+
    	                "						<div class='controls'>"+
    	                "							<input type='text' name='n_street' pattern='[0-9]+' title='Solo numeros - Sin espacios - Maxima Longitud 10' maxlength='10'>"+
    	                "						</div>"+   	                	  	               	     
    	                "					</div>"+
                        "					<div class='control-group'>"+
    	                "						<label class='control-label'>Email:*</label>"+
    	                "						<div class='controls'>"+
    	                "							<input type='text' name='email' placeholder='someone@example.com' pattern='[a-zA-Z0-9]+[.[a-zA-Z0-9_-]+]*@[a-z0-9][\\w\\.-]*[a-z0-9]\\.[a-z][a-z\\.]*[a-z]$'+ title='Maxima Longitud 60' maxlength='60' required='required'>"+
    	                "						</div>"+   	                	  	               	     
    	                "					</div>"+
    	                "					<div class='form-actions'>"+
    	                "						<button class='btn btn-large btn-primary' type='submit'>Registrar</button>"+
    	                "					</div>"+
    	                "				</form>"+
    	                "			</div>"+
    	                "		</div>"+		
    	                "		<footer>"+
    	                "			<p>&copy; 2013 Grateds, Inc. All rights reserved.</p>"+
    	                "		</footer>"+
    	                "	</div> <!-- /container -->"+
    	    			"	<script src='../bootstrap/js/jquery.js'></script>"+
    	    			"	<script src='../bootstrap/js/bootstrap-dropdown.js'></script>"+
    	    			"</body>"+
    	  				"</html>";
    		}
    	}); // end addowner
        
        Spark.post(new Route("/addowner/") {
    		@Override
    		public Object handle(Request request, Response response) {
    			response.type("text/html");
    			crudOwner o = new crudOwner();
    			Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
    			o.create(request.queryParams("first_name"),request.queryParams("last_name"),request.queryParams("city_id"), request.queryParams("neighborhood"), request.queryParams("street"), request.queryParams("n_street"), request.queryParams("email"));
    			Base.close();
    		
    			return 
    				EncabezadoHTML1+
                		EncabezadoHTML2+
                		EncabezadoHTML3+
		                "<div class='container'>"+
		                	"<!-- Main hero unit for a primary marketing message or call to action -->"+
		                	"<div class='hero-unit'>"+
		                		"<center>"+
    	                			"<h3>Dueño registrado exitosamente.</h3>" +
    	                			"<a href='/'>" +
    	                				"<button class='btn btn-success btn-primary'>Volver</button>" +
    	                			"</a>"+
    	                		"</center>"+ 
		                	"</div>"+
		                	"<footer>"+
		                		"<p>&copy; 2013 Grateds, Inc. All rights reserved.</p>"+
		                	"</footer>"+
		                "</div> <!-- /container -->"+
		    			"<script src='../bootstrap/js/jquery.js'></script>"+
		    			"<script src='../bootstrap/js/bootstrap-dropdown.js'></script>"+
		    				"</body>"+
		  				"</html>"; 
    		}
    	});
        
        Spark.get(new Route("/addbuilding/") {
    		@Override
    		public Object handle(Request request, Response response) {	
                response.type("text/html");
                
    			return 
    				EncabezadoHTML1+
                		EncabezadoHTML2+
                		EncabezadoHTML3+
    	                "	<div class='container'>"+
    	                "		<!-- Main hero unit for a primary marketing message or call to action -->"+
    	                "		<div class='hero-unit'>"+
    	                "			<div class='container'>"+
    	                "				<h2>Registrar Inmueble</h2>"+
    	                "				<label>* Datos obligatorios </label>"+
    	                "			</div>"+
    	                "			<hr></hr>"+
    	                "			<div>"+
    	                "				<form class='form-horizontal' method='POST' action='/addbuilding/'>"+
                        "					<div class='control-group'>"+
    	                "						<label class='control-label'>Inmobiliaria:*</label>"+
    	                "						<div class='controls'>"+
    	                							optionRealEstate("Seleccionar inmobiliaria","required='required'")+
    	                "						</div>"+
    	                "					</div>"+
    	                "					<div class='control-group'>"+
    	                "						<label class='control-label'>Tipo:*</label>"+
    	                "						<div class='controls'>"+
    	                							optionType("Seleccionar tipo","required='required'")+
    	                "						</div>"+
    	                "					</div>"+
    	                "					<div class='control-group'>"+
    	                "						<label class='control-label'>Barrio:*</label>"+
    	                "						<div class='controls'>"+
    	                "							<input type='text' name='neighborhood' pattern='[a-zA-Z ]+' title='Solo letras - Maxima Longitud 30' maxlength='30' required='required'>"+
    	                "						</div>"+
    	                "					</div>"+
    	                "					<div class='control-group'>"+
    	                "						<label class='control-label'>Calle:*</label>"+
    	                "						<div class='controls'>"+
    	                "							<input type='text' name='street' pattern='[a-zA-Z ]+' title='Solo letras - Maxima Longitud 30' maxlength='30' required='required'>"+
    	                "						</div>"+
    	                "					</div>"+ 
    	                "					<div class='control-group'>"+
    	                "						<label class='control-label'>Numero:*</label>"+
    	                "						<div class='controls'>"+
    	                "							<input type='text' name='n_street' pattern='[0-9]+' title='Solo numeros - Sin espacios - Maxima Longitud 10' maxlength='10' required='required'>"+
    	                "						</div>"+
    	                "					</div>"+
    	                "					<div class='control-group'>"+
    	                "						<label class='control-label'>Descripción:</label>"+
    	                "						<div class='controls'>"+
    	                "							<textarea style='width: 394px; height: 115px;;' name= 'description'></textarea>"+
    	                "						</div>"+
    	                "					</div>"+
    	                "					<div class='control-group'>"+
    	                "						<label class='control-label'>Precio:*</label>"+
    	                "						<div class='controls'>"+
    	                "							<input type='text' name='price' pattern='[0-9-.]+' title='Solo numeros - Sin espacios - Maxima Longitud 10' maxlength='10' required='required'>"+
    	                "						</div>"+
    	                "					</div>"+
    	                "					<div class='control-group'>"+
    	                "						<label class='control-label'>Operación:*</label>"+
    	                "						<div class='controls'>"+
    	                							optionOperation("Seleccionar operación","required='required'")+
    	                "						</div>"+
    	                "					</div>"+
    	                "					<div class='control-group'>"+
    	                "						<label class='control-label'>Dueño:*</label>"+
    	                "						<div class='controls'>"+
    	                							optionOwner()+ 
    	                "						</div>"+
    	                "					</div>"+
    	                "					<div class='control-group'>"+
    	                "						<label class='control-label'>Ciudad:*</label>"+
    	                "						<div class='controls'>"+
    	                							optionCity("Seleccionar ciudad","required='required'")+
    	                "						</div>"+
    	                "					</div>"+
    	                "					<div class='form-actions'>"+
    	                "						<button class='btn btn-large btn-primary' type='submit'>Registrar</button>"+
    	                "					</div>"+
    	                "				</form>"+
    	                "			</div>"+
    	                "		</div>"+		
    	                "		<footer>"+
    	                "			<p>&copy; 2013 Grateds, Inc. All rights reserved.</p>"+
    	                "		</footer>"+
    	                "	</div> <!-- /container -->"+
    	    			"	<script src='../bootstrap/js/jquery.js'></script>"+
    	    			"	<script src='../bootstrap/js/bootstrap-dropdown.js'></script>"+
    	    			"</body>"+
    	  				"</html>";
    		}
    	}); 
        
        Spark.post(new Route("/addbuilding/") {
    		@Override
    		public Object handle(Request request, Response response) {
    			response.type("text/html");
    			crudBuilding b = new crudBuilding();
    			Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
    			b.create(request.queryParams("real_estate_id"), request.queryParams("type"), request.queryParams("owner_id"), request.queryParams("city_id"), request.queryParams("neighborhood"), request.queryParams("street"), request.queryParams("n_street"), request.queryParams("description"), request.queryParams("price"), request.queryParams("operation"));
    			Base.close();
    		
    			return 
    					EncabezadoHTML1+
                		EncabezadoHTML2+
                		EncabezadoHTML3+
		                "<div class='container'>"+
		                	"<!-- Main hero unit for a primary marketing message or call to action -->"+
		                	"<div class='hero-unit'>"+
		                		"<center>"+
    	                			"<h3>Inmueble registrado exitosamente.</h3>" +
    	                			"<a href='/'>" +
    	                				"<button class='btn btn-success btn-primary'>Volver</button>" +
    	                			"</a>"+
    	                		"</center>"+ 
		                	"</div>"+
		                	"<footer>"+
		                		"<p>&copy; 2013 Grateds, Inc. All rights reserved.</p>"+
		                	"</footer>"+
		                "</div> <!-- /container -->"+
		    			"<script src='../bootstrap/js/jquery.js'></script>"+
		    			"<script src='../bootstrap/js/bootstrap-dropdown.js'></script>"+
		    				"</body>"+
		  				"</html>"; 
    		}
    	}); //end post adduser
        
        Spark.get(new Route("/about/") {
    		@Override
    		public Object handle(Request request, Response response) {	
                response.type("text/html");
    			
    			return 
    					EncabezadoHTML1+
    					"						<li><a href='/'>Inicio</a></li>"+
    					"						<li class='active'><a href='/about/'>Acerca</a></li>"+
    					"						<li><a href='/contact/'>Contacto</a></li>"+
   		   				EncabezadoHTML3+
    	                	"<div class='container'>"+
    	                		"<!-- Main hero unit for a primary marketing message or call to action -->"+
    	                		"<div class='hero-unit'>"+
    	                			"<div>"+
    	                				"<center>"+
    	    	        					"<h1>Misión y Valores..</h1>" +
    	    	        					"<img src='../bootstrap/img/about.png'>" +		
    	    	        					"<p>Misión: Ofrecer, con nuestro equipo multidisciplinario de profesionales comprometidos, soluciones informáticas a medida para optimizar los procesos de negocio de  nuestros clientes.</p>" +
                                            "<p>Valores: Nuestros valores son,</p>" +
                                            "<p>Responsabilidad: En nuestros proyectos.</p>" +
                                            "<p>Trabajo en Equipo: Es la base de nuestra organización</p>" +
    	    	        				"</center>"+
    	                			"</div>"+
    	                		"</div>"+
    	                		"<footer>"+
    	                			"<p>&copy; 2013 Grateds, Inc. All rights reserved.</p>"+
    	                		"</footer>"+
    	                	"</div> <!-- /container -->"+
    	    				"<script src='../bootstrap/js/jquery.js'></script>"+
    	    				"<script src='../bootstrap/js/bootstrap-dropdown.js'></script>"+
    	    			"</body>"+
    	  				"</html>";
    		}
    	}); 
        
        Spark.get(new Route("/contact/") {
    		@Override
    		public Object handle(Request request, Response response) {	
                response.type("text/html");
    			
    			return EncabezadoHTML1+
    											"<li><a href='/'>Inicio</a></li>"+
    	   										"<li><a href='/about/'>Acerca</a></li>"+
    	   										"<li class='active'><a href='/contact/'>Contacto</a></li>"+
    					EncabezadoHTML3+
    	                	"<div class='container'>"+
    	                		"<!-- Main hero unit for a primary marketing message or call to action -->"+
    	                		"<div class='hero-unit'>"+
    	                			"<div class='container'>"+
    	                				"<h2>Contactanos</h2>"+
    	                				"<label>Estamos aquí para ayudar con cualquier pregunta o comentario. </label>"+
    	                			"</div>"+
    	                			"<hr></hr>"+
    	                			"<div class='container'>"+
    	                				"<form class='navbar-form pull-left'>"+
    	                					"<dl class= 'form'>"+
    	                						"<label><b>Nombre</b></label>"+
    	                						"<input type='text' class='input-block-level' name='name' pattern='[a-zA-Z ]+' title='Solo letras - Maxima Longitud 56' maxlength='56'required='required'>"+     
    	                					"</dl>"+
    	                					"<dl class= 'form'>"+
                        						"<label><b>E-mail</b></label>"+   
                        						"<input type='text' class='input-block-level' name='email' pattern='[a-zA-Z0-9]+[.[a-zA-Z0-9_-]+]*@[a-z0-9][\\w\\.-]*[a-z0-9]\\.[a-z][a-z\\.]*[a-z]$'+ title='Maxima Longitud 60' maxlength='60' required='required'>"+     
                        					"</dl>"+
                        					"<dl class= 'form'>"+
                        						"<label><b>Asunto</b></label>"+
                        						"<input type='text' class='input-block-level' name='subject' pattern='[a-zA-Z ]+' title='Solo letras - Maxima Longitud 56' maxlength='56' required='required'>"+     
                        					"</dl>"+
                        					"<dl class= 'form'>"+
                        						"<label><b>Mensaje</b></label>"+
                        						"<textarea style='width: 403px; height: 180px;' name='body' required='required'></textarea><br>"+    					
                        					"</dl>" +
                        					"<dl class= 'form'>" +
                        						"<button class='btn btn-large btn-primary' type='submit'>Enviar</button>"+ 
                        					"</dl>"+
                       					"</form>"+
                        			"</div>"+
    	                		"</div>"+
    	                		"<footer>"+
    	                			"<p>&copy; 2013 Grateds, Inc. All rights reserved.</p>"+
    	                		"</footer>"+
    	                	"</div> <!-- /container -->"+
    	    				"<script src='../bootstrap/js/jquery.js'></script>"+
    	    				"<script src='../bootstrap/js/bootstrap-dropdown.js'></script>"+
    	    			"</body>"+
    	  				"</html>";
    		}
    	});
     
        Spark.get(new Route("/addrealestate/"){
            @Override
    		public Object handle(Request request, Response response) {	
                response.type("text/html");
                
    			return 
    				EncabezadoHTML1+
                		EncabezadoHTML2+
                		EncabezadoHTML3+
    	                "	<div class='container'>"+
    	                "		<!-- Main hero unit for a primary marketing message or call to action -->"+
    	                "		<div class='hero-unit'>"+
    	                "			<div class='container'>"+
    	                "				<h2>Registrar Inmobiliaria</h2>"+
    	                "				<label>* Datos obligatorios </label>"+
    	                "			</div>"+
    	                "			<hr></hr>"+
    	                "			<div>"+
    	                "				<form class='form-horizontal' method='POST' action='/addrealestate/'>"+  
                        "					<div class='control-group'>"+
    	                "						<label class='control-label'>Nombre:*</label>"+
    	                "						<div class='controls'>"+ 
    	                "							<input type='text' name='name' pattern='[a-zA-Z ]+' title='Solo letras - Maxima Longitud 30' maxlength='30' required='required'>"+
    	                "						</div>"+
    	                "					</div>"+
                        "					<div class='control-group'>"+
    	                "						<label class='control-label'>Ciudad:*</label>"+
    	                "						<div class='controls'>"+
    	                							optionCity("Seleccionar ciudad","required='required'")+      
    	                "						</div>"+
    	                "					</div>"+                     
    	                "					<div class='control-group'>"+
    	                "						<label class='control-label'>Calle:</label>"+
    	                "						<div class='controls'>"+   
    	                "							<input type='text' name='street' pattern='[a-zA-Z ]+' title='Solo letras - Maxima Longitud 30' maxlength='30'>"+
    	                "						</div>"+
    	                "					</div>"+ 
    	                "					<div class='control-group'>"+
    	                "						<label class='control-label'>Numero:</label>"+
    	                "						<div class='controls'>"+   
    	                "							<input type='text' name='n_street' pattern='[0-9]+' title='Solo numeros - Sin espacios - Maxima Longitud 10' maxlength='10'>"+
    	                "						</div>"+
    	                "					</div>"+                                                        
                        "					<div class='control-group'>"+
    	                "						<label class='control-label'>Barrio:</label>"+
    	                "						<div class='controls'>"+ 
    	                "							<input type='text' name='neighborhood' pattern='[a-zA-Z ]+' title='Solo letras - Maxima Longitud 30' maxlength='30'>"+
    	                "						</div>"+
    	                "					</div>"+                             
                        "					<div class='control-group'>"+
    	                "						<label class='control-label'>Telefono:*</label>"+
    	                "						<div class='controls'>"+ 
    	                "							<input type='text' name='phone' pattern='[0-9]+' title='Solo numeros - Sin espacios - Maxima Longitud 15' maxlength='15' required='required'>"+
    	                "						</div>"+
    	                "					</div>"+
                        "					<div class='control-group'>"+
    	                "						<label class='control-label'>Email:*</label>"+
    	                "						<div class='controls'>"+ 
    	                "							<input type='text' name='email' placeholder='someone@example.com' pattern='[a-zA-Z0-9]+[.[a-zA-Z0-9_-]+]*@[a-z0-9][\\w\\.-]*[a-z0-9]\\.[a-z][a-z\\.]*[a-z]$'+ title='Maxima Longitud 60' maxlength='60' required='required'>"+
    	                "						</div>"+
    	                "					</div>"+
                        "					<div class='control-group'>"+
    	                "						<label class='control-label'>Sitio Web:*</label>"+
    	                "						<div class='controls'>"+ 
    	                "							<input type='text' name='site_web' paceholder='www.example.com' required='required'>"+
    	                "						</div>"+
    	                "					</div>"+
    	                "					<div class='form-actions'>"+
    	                "						<button class='btn btn-large btn-primary' type='submit'>Registrar</button>"+
    	                "					</div>"+
    	                "				</form>"+
    	                "			</div>"+
    	                "		</div>"+		
    	                "		<footer>"+
    	                "			<p>&copy; 2013 Grateds, Inc. All rights reserved.</p>"+
    	                "		</footer>"+
    	                "	</div> <!-- /container -->"+
    	    			"	<script src='../bootstrap/js/jquery.js'></script>"+
    	    			"	<script src='../bootstrap/js/bootstrap-dropdown.js'></script>"+
    	    			"</body>"+
    	  				"</html>";
    		}
        });
        
        Spark.post(new Route("/addrealestate/"){
            @Override
            public Object handle(Request request, Response response){
                response.type("text/html");
                crudRealEstate re = new crudRealEstate();
                Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
                re.create(request.queryParams("name"), request.queryParams("phone"), request.queryParams("email"), request.queryParams("city_id"), request.queryParams("neighborhood"), request.queryParams("street"), request.queryParams("n_street"), request.queryParams("site_web"));
                Base.close();
                return 
    					EncabezadoHTML1+
                		EncabezadoHTML2+
                		EncabezadoHTML3+
		                "<div class='container'>"+
		                	"<!-- Main hero unit for a primary marketing message or call to action -->"+
		                	"<div class='hero-unit'>"+
		                		"<center>"+
    	                			"<h3>Inmobiliaria registrada exitosamente.</h3>" +
    	                			"<a href='/'>" +
    	                				"<button class='btn btn-success btn-primary'>Volver</button>" +
    	                			"</a>"+
    	                		"</center>"+ 
		                	"</div>"+
		                	"<footer>"+
		                		"<p>&copy; 2013 Grateds, Inc. All rights reserved.</p>"+
		                	"</footer>"+
		                "</div> <!-- /container -->"+
		    			"<script src='../bootstrap/js/jquery.js'></script>"+
		    			"<script src='../bootstrap/js/bootstrap-dropdown.js'></script>"+
		    				"</body>"+
		  				"</html>"; 
    		}
    	});
        
        Spark.get(new Route("/deleterealestate/:id"){
            @Override
            public Object handle(Request request, Response response){
                response.redirect("/realestates/");
                Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
                crudRealEstate rs = new crudRealEstate();
                rs.delete(request.params(":id"));
                Base.close();
                return "";
            }
        });
        
        Spark.get(new Route("/updaterealestate/:id"){
           @Override
            public Object handle(Request request, Response response){
            	response.type("text/html");
                Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
                        RealEstate rs = RealEstate.findFirst("id = ?", request.params(":id"));
                Base.close();
                return 
                		EncabezadoHTML1+
                		EncabezadoHTML2+
                		EncabezadoHTML3+
                	"               <div class='container'>"+
    	                "		<!-- Main hero unit for a primary marketing message or call to action -->"+
    	                "		<div class='hero-unit'>"+
    	                "			<div class='container'>"+
    	                "				<h2>Modificar Datos</h2>"+
    	                "				<label>* Datos obligatorios </label>"+
    	                "			</div>"+
    	                "			<hr></hr>"+
    	                "			<div>"+
    	                "				<form class='form-horizontal' method='POST' action='/updaterealestate/"+request.params(":id")+"'>"+                 
                        "					<div class='control-group'>"+
    	                "						<label class='control-label'>Nombre:*</label>"+
    	                "						<div class='controls'>"+
    	                "							<input type='text' name='name' value='"+rs.get("name")+"' pattern='[a-zA-Z ]+' title='Solo letras - Maxima Longitud 30' maxlength='30' required='required'>"+
    	                "						</div>"+             
    	                "					</div>"+ 
                        "					<div class='control-group'>"+
    	                "						<label class='control-label'>Ciudad:*</label>"+
    	                "						<div class='controls'>"+
    	                							optionCityUpdate(""+rs.get("city_id")+"")+
    	                "						</div>"+            
    	                "					</div>"+
    	                "					<div class='control-group'>"+
    	                "						<label class='control-label'>Calle:</label>"+
    	                "						<div class='controls'>"+
    	                "							<input type='text' name='street' value='"+rs.get("street")+" 'pattern='[a-zA-Z ]+' title='Solo letras - Maxima Longitud 30' maxlength='30'>"+
    	                "						</div>"+             
    	                "					</div>"+ 
    	                "					<div class='control-group'>"+
    	                "						<label class='control-label'>Numero:*</label>"+
    	                "						<div class='controls'>"+
    	                "							<input type='text' name='n_street' value='"+rs.get("n_street")+"' pattern='[0-9]+' title='Solo numeros - Sin espacios - Maxima Longitud 10' maxlength='10' required='required'>"+
    	                "						</div>"+            
    	                "					</div>"+
                        "					<div class='control-group'>"+
    	                "						<label class='control-label'>Barrio:</label>"+
    	                "						<div class='controls'>"+
    	                "							<input type='text' name='neighborhood' value='"+rs.get("neighborhood")+" 'pattern='[a-zA-Z ]+' title='Solo letras - Sin espacios - Maxima Longitud 30' maxlength='30'>"+
    	                "						</div>"+             
    	                "					</div>"+                     
    	                "					<div class='control-group'>"+
    	                "						<label class='control-label'>Telefono:*</label>"+
    	                "						<div class='controls'>"+
    	                "							<input type='text' name='phone' value='"+rs.get("phone")+"' pattern='[0-9]+' title='Solo numeros - Sin espacios - Maxima Longitud 15' maxlength='15' required='required'>"+
    	                "						</div>"+            
    	                "					</div>"+
                        "					<div class='control-group'>"+
    	                "						<label class='control-label'>Email:*</label>"+
    	                "						<div class='controls'>"+
    	                "							<input type='text' name='email' value='"+rs.get("email")+"' placeholder='someone@example.com' pattern='[a-zA-Z0-9]+[.[a-zA-Z0-9_-]+]*@[a-z0-9][\\w\\.-]*[a-z0-9]\\.[a-z][a-z\\.]*[a-z]$'+ title='Maxima Longitud 60' maxlength='60' required='required'>"+
    	                "						</div>"+            
    	                "					</div>"+
                        "					<div class='control-group'>"+
    	                "						<label class='control-label'>Sitio Web:*</label>"+
    	                "						<div class='controls'>"+
    	                "							<input type='text' name='site_web' value='"+rs.get("site_web")+"' required='required'>"+
    	                "						</div>"+            
    	                "					</div>"+
    	                "					<div class='form-actions'>"+
    	                "						<button class='btn btn-large btn-primary' type='submit'>Guardar</button>"+
    	                "					</div>"+
    	                "				</form>"+
    	                "			</div>"+
    	                "		</div>"+		
    	                "		<footer>"+
    	                "			<p>&copy; 2013 Grateds, Inc. All rights reserved.</p>"+
    	                "		</footer>"+
    	                "	</div> <!-- /container -->"+
    	    			"	<script src='../bootstrap/js/jquery.js'></script>"+
    	    			"	<script src='../bootstrap/js/bootstrap-dropdown.js'></script>"+
    	    			"</body>"+
                                        "</html>";
            }   
        });
        
        Spark.post(new Route("/updaterealestate/:id"){
             @Override
            public Object handle(Request request, Response response){
            	response.redirect("/realestates/");
            	crudRealEstate realestate = new crudRealEstate();
    			Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
    			realestate.update(request.params(":id"), request.queryParams("name"), request.queryParams("phone"), request.queryParams("email"), request.queryParams("city_id"), request.queryParams("neighborhood"), request.queryParams("street"), request.queryParams("n_street"), request.queryParams("site_web"));			
                Base.close();
                
                return "";    
            }
        });
        
        Spark.get(new Route("/search/"){
            @Override
            public Object handle(Request request, Response response){
                response.type("text/html");
                return
                		EncabezadoHTML1+
                    	EncabezadoHTML2+
                    	EncabezadoHTML3+
                    	"<div class='container'>"+
                        	"<!-- Main hero unit for a primary marketing message or call to action -->"+
                        	"<div class='hero-unit'>" +
                             	"<div>" +
                                 	"<center><h2>Busqueda</h2></center>" +
                                 "</div>"+
                             	"<div>"+
                             		"<form method='POST' action='/search/'>"+
                             			optionType("Todos","")+""+
                             			optionOperation("Todos","")+" "+
                             			optionCity("Todos","")+""+
                             			optionRealEstate("Todos","")+" "+
                             			"<button class='btn btn-small btn-primary type='sumit'>Buscar</buton>"+
                             		"</form>"+
                             	"</div>"+
                            "</div>"+
                            "<footer>"+
                                "<p>&copy; 2013 Grateds, Inc. All rights reserved.</p>"+
                            "</footer>"+
                        "</div> <!-- /container -->"+
                        "<script src='../bootstrap/js/jquery.js'></script>"+
                        "<script src='../bootstrap/js/bootstrap-dropdown.js'></script>"+
                 "</body>"+
                 "</html>";
            }
        }); //end get search
        
        Spark.post(new Route("/search/"){
            @Override
            public Object handle(Request request, Response response){
                response.type("text/html");
                String SubqueryType;
                String SubqueryCity;
                String SubqueryREst;
                String SubqueryOper;
                String query;
                
                Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
                if(request.queryParams("type") == "")
                	SubqueryType = "true";
                else
                	SubqueryType = "type='"+request.queryParams("type")+"'";
                if(request.queryParams("city_id") == "")
                	SubqueryCity = "true";
                else
                	SubqueryCity = "city_id='"+request.queryParams("city_id")+"'";
                if(request.queryParams("real_estate_id") == "")
                	SubqueryREst = "true";
                else
                	SubqueryREst = "real_estate_id="+request.queryParams("real_estate_id");
                if(request.queryParams("operation") == "")
                	SubqueryOper = "true";
                else
                	SubqueryOper = "operation='"+request.queryParams("operation")+"'";
              
                if(SubqueryType+SubqueryCity+SubqueryREst+SubqueryOper=="truetruetruetrue")
                	query = "select * from buildings";
                else{
                	query = "select * from buildings INNER JOIN buildings_real_estates on buildings.id=buildings_real_estates.building_id where "+SubqueryType+" AND "+SubqueryCity+" AND "+SubqueryREst+" AND "+SubqueryOper;
                }
                
                List<Building> buildings = Building.findBySQL(query);
                String ret = 
                		"<table class='table table-hover'>" +
                			"<thead>" +
                				"<tr>" +
                					"<th>#</th>"+
                					"<th>Tipo</th>"+
                					"<th>Dueño</th>"+
                					"<th>Inmobiliaria</th>"+
                					"<th>Ciudad</th>"+
                					"<th>Barrio</th>"+
                					"<th>Calle</th>"+
                					"<th>Numero</th>"+
                					"<th>Descripción</th>"+
                					"<th>Precio $</th>"+
                					"<th>Operación</th>"+
                				"</tr>" +
                			"</thead>" +
                			"<tbody>";
                int j;

                City c = new City();
                Owner o = new Owner();
                RealEstate r = new RealEstate();
                BuildingsRealEstates bRE = new BuildingsRealEstates();
                for(int i=0; i < buildings.size(); i++){
     				Building b = buildings.get(i);
     				j = i+1;
     				c = City.findFirst("id = ?", b.get("city_id"));
     				o = Owner.findFirst("id = ?", b.get("owner_id"));
     				bRE = BuildingsRealEstates.findFirst("building_id = ?", b.getId());
     				r = RealEstate.findFirst("id = ?", bRE.get("real_estate_id"));
     				ret = ret+"<tr><td>"+j+"</td>"+
							  "<td>"+b.get("type")+"</td>" +
							  "<td>"+o.get("last_name")+"</td>" +
							  "<td>"+r.get("name")+"</td>"+
							  "<td>"+c.get("name")+"</td>"+
							  "<td>"+b.get("neighborhood")+"</td>"+
							  "<td>"+b.get("street")+"</td>"+
							  "<td>"+b.get("n_street")+"</td>"+
							  "<td>"+b.get("description")+"</td>"+
							  "<td>"+b.get("price")+"</td>" +
							  "<td>"+b.get("operation")+"</td>"+
							  "<td><a href='/updatebuilding/"+b.get("id")+"'><img src='../bootstrap/img/edit-update.png'></a></td>"+
							  "<td><a href='/deletebuilding/"+b.get("id")+"'><img src='../bootstrap/img/edit-delete.png'></a></td>";
     			}   
     			ret = ret +"</tbody></table>";
                Base.close();
                
                return 
                		EncabezadoHTML1+
                		EncabezadoHTML2+
                		EncabezadoHTML3+
		        "               <div class='container'>"+
		        "               <!-- Main hero unit for a primary marketing message or call to action -->"+
		        "               <div class='form-actions'>"+
		        "                   <center>"+                    
    	                "			<h2>Resultado de Busqueda</h2>" +
                                                    ret+
    	                "			<a href='/'>" +
    	                "				<button class='btn btn-success btn-primary'>Volver</button>" +
    	                "			</a>"+
    	                "                   </center>"+ 
		        "               </div>"+
		        "               <footer>"+
		        "               	<p>&copy; 2013 Grateds, Inc. All rights reserved.</p>"+
		        "                       </footer>"+
		        "               </div> <!-- /container -->"+
		        "               <script src='../bootstrap/js/jquery.js'></script>"+
		        "               <script src='../bootstrap/js/bootstrap-dropdown.js'></script>"+
		    	"	</body>"+
		  	"</html>"; 
    		}
        });
        
        Spark.get(new Route("/deleteuser/:id"){
            @Override
            public Object handle(Request request, Response response){
            	response.redirect("/users/");
                Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
                crudUser user = new crudUser();
                user.delete(request.params(":id"));
                Base.close();
                return "";
            }
        });
        
        Spark.get(new Route("/updateuser/:id"){
            @Override
            public Object handle(Request request, Response response){
            	response.type("text/html");
                Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
    			User user = User.findFirst("id = ?", request.params(":id"));
                Base.close();

                return 
                		EncabezadoHTML1+
                		EncabezadoHTML2+
                		EncabezadoHTML3+
    	                	"<div class='container'>"+
    	                		"<!-- Main hero unit for a primary marketing message or call to action -->"+
    	                		"<div class='hero-unit'>"+
    	                			"<div class='container'>"+
    	                				"<h2>Modificar Datos</h2>"+
    	                				"<label>* Datos obligatorios </label>"+
    	                			"</div>"+
    	                			"<hr></hr>"+
    	                			"<div>"+
    	                				"<form class='form-horizontal' method='POST' action='/updateuser/"+request.params(":id")+"'>"+               
    	                					"<div class='control-group'>"+
    	                						"<label class='control-label'>Nombre:*</label>"+
    	                						"<div class='controls'>"+
    	                							"<input type='text' name='first_name' value='"+user.get("first_name")+"' pattern='[a-zA-Z ]+' title='Solo letras - Maxima Longitud 56' maxlength='56' required='required'>"+
    	                						"</div>"+
    	                					"</div>"+
    	                					"<div class='control-group'>"+
    	                						"<label class='control-label'>Apellido:*</label>"+
    	                						"<div class='controls'>"+
    	                							"<input type='text' name='last_name' value='"+user.get("last_name")+"' pattern='[a-zA-Z ]+' title='Solo letras - Maxima Longitud 56' maxlength='56' required='required'>"+
    	                						"</div>"+
    	                					"</div>"+
    	                					"<div class='control-group'>"+
    	                						"<label class='control-label'>Email:*</label>"+
    	                						"<div class='controls'>"+
    	                							"<input type='text' name='email' value='"+user.get("email")+"' placeholder='someone@example.com' pattern='[a-zA-Z0-9]+[.[a-zA-Z0-9_-]+]*@[a-z0-9][\\w\\.-]*[a-z0-9]\\.[a-z][a-z\\.]*[a-z]$'+ title='Maxima Longitud 60' maxlength='60' required='required'>"+
    	                						"</div>"+
    	                					"</div>"+     	               
    	                					"<div class='form-actions'>"+
    	                						"<button class='btn btn-large btn-primary' type='submit'>Guardar</button>"+
    	                					"</div>"+
    	                				"</form>"+
    	                			"</div>"+
    	                		"</div>"+		
    	                		"<footer>"+
    	                			"<p>&copy; 2013 Grateds, Inc. All rights reserved.</p>"+
    	                		"</footer>"+
    	                	"</div> <!-- /container -->"+
    	    				"<script src='../bootstrap/js/jquery.js'></script>"+
    	    				"<script src='../bootstrap/js/bootstrap-dropdown.js'></script>"+
    	    			"</body>"+
    	  				"</html>";               
            }
        });
        
        Spark.post(new Route("/updateuser/:id"){
            @Override
            public Object handle(Request request, Response response){
            	response.redirect("/users/");
            	crudUser user = new crudUser();
    			Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
    			user.update(request.params(":id"),request.queryParams("first_name"), request.queryParams("last_name"), request.queryParams("email"));			
                Base.close();
    		
                return "";    
            }
        });
        
        Spark.get(new Route("/deletebuilding/:id"){
            @Override
            public Object handle(Request request, Response response){
            	response.redirect("/buildings/");
                Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
                crudBuilding building = new crudBuilding();
                building.delete(request.params(":id"));
                Base.close();
                return "";
            }
        });
        
        Spark.get(new Route("/updatebuilding/:id"){
            @Override
            public Object handle(Request request, Response response){
            	response.type("text/html");
                Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
    			Building building = Building.findFirst("id = ?", request.params(":id"));
                Base.close();

                return 
                		EncabezadoHTML1+
                		EncabezadoHTML2+
                		EncabezadoHTML3+
                			"<div class='container'>"+
    	                		"<!-- Main hero unit for a primary marketing message or call to action -->"+
    	                		"<div class='hero-unit'>"+
    	                			"<div class='container'>"+
    	                				"<h2>Modificar Datos</h2>"+
    	                				"<label>* Datos obligatorios </label>"+
    	                			"</div>"+
    	                			"<hr></hr>"+
    	                			"<div>"+
    	                				"<form class='form-horizontal' method='POST' action='/updatebuilding/"+request.params(":id")+"'>"+               
    	                					"<div class='control-group'>"+
    	                						"<label class='control-label'>Tipo:*</label>"+
    	                						"<div class='controls'>"+
    	                							optionTypeUpdate(""+building.get("type")+"")+
    	                						"</div>"+
    	                					"</div>"+
    	                					"<div class='control-group'>"+
    	                						"<label class='control-label'>Barrio:*</label>"+
    	                						"<div class='controls'>"+
    	                							"<input type='text' name='neighborhood' value='"+building.get("neighborhood")+"' pattern='[a-zA-Z ]+' title='Solo letras - Maxima Longitud 30' maxlength='30' required='required'>"+
    	                						"</div>"+
    	                					"</div>"+
    	                					"<div class='control-group'>"+
    	                						"<label class='control-label'>Calle:*</label>"+
    	                						"<div class='controls'>"+
    	                							"<input type='text' name='street' value='"+building.get("street")+"' pattern='[a-zA-Z ]+' title='Solo letras - Maxima Longitud 30' maxlength='30' required='required'>"+
    	                						"</div>"+
    	                					"</div>"+ 
    	                					"<div class='control-group'>"+
    	                						"<label class='control-label'>Numero:*</label>"+
    	                						"<div class='controls'>"+
    	                							"<input type='text' name='n_street' value='"+building.get("n_street")+"' pattern='[0-9]+' title='Solo numeros - Sin espacios - Maxima Longitud 10' maxlength='10' required='required'>"+
    	                						"</div>"+
    	                					"</div>"+
    	                					"<div class='control-group'>"+
    	                						"<label class='control-label'>Descripción:</label>"+
    	                						"<div class='controls'>"+
    	                							"<textarea style='width: 394px; height: 115px;;' name= 'description'>"+building.get("description")+"</textarea>"+
    	                						"</div>"+
    	                					"</div>"+
    	                					"<div class='control-group'>"+
    	                						"<label class='control-label'>Precio:*</label>"+
    	                						"<div class='controls'>"+
    	                							"<input type='text' name='price' value='"+building.get("price")+"' pattern='[0-9-.]+' title='Solo numeros - Sin espacios - Maxima Longitud 10' maxlength='10' required='required'>"+
    	                						"</div>"+
    	                					"</div>"+
    	                					"<div class='control-group'>"+
    	                						"<label class='control-label'>Operación:*</label>"+
    	                						"<div class='controls'>"+
    	                							optionOperationUpdate(""+building.get("operation")+"")+
    	                						"</div>"+
    	                					"</div>"+
    	                					"<div class='control-group'>"+
    	                						"<label class='control-label'>Dueño:*</label>"+
    	                						"<div class='controls'>"+
    	                							optionOwnerUpdate(""+building.get("owner_id")+"")+
    	                						"</div>"+
    	                					"</div>"+
    	                					"<div class='control-group'>"+
    	                						"<label class='control-label'>Ciudad:*</label>"+
    	                						"<div class='controls'>"+
    	                							optionCityUpdate(""+building.get("city_id")+"")+
    	                						"</div>"+
    	                					"</div>"+
    	                					"<div class='form-actions'>"+
    	                						"<button class='btn btn-large btn-primary' type='submit'>Guardar</button>"+
    	                					"</div>"+
    	                				"</form>"+
    	                			"</div>"+
    	                		"</div>"+		
    	                		"<footer>"+
    	                			"<p>&copy; 2013 Grateds, Inc. All rights reserved.</p>"+
    	                		"</footer>"+
    	                	"</div> <!-- /container -->"+
    	    				"<script src='../bootstrap/js/jquery.js'></script>"+
    	    				"<script src='../bootstrap/js/bootstrap-dropdown.js'></script>"+
    	    			"</body>"+
    	  				"</html>";
            }
        });
        
        Spark.post(new Route("/updatebuilding/:id"){
            @Override
            public Object handle(Request request, Response response){
            	response.redirect("/buildings/");
            	crudBuilding building = new crudBuilding();
    			Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
    			building.update(request.params(":id"), request.queryParams("type"), request.queryParams("owner_id"), request.queryParams("city_id"), request.queryParams("neighborhood"), request.queryParams("street"), request.queryParams("n_street"), request.queryParams("description"), request.queryParams("price"), request.queryParams("operation"));			
                Base.close();
                
                return "";    
            }
        });
        
        Spark.get(new Route("/deleteowner/:id"){
            @Override
            public Object handle(Request request, Response response){
            	response.redirect("/owners/");
                Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
                crudOwner owner = new crudOwner();
                owner.delete(request.params(":id"));
                Base.close();
                return "";
            }
        });
        
        Spark.get(new Route("/updateowner/:id"){
            @Override
            public Object handle(Request request, Response response){
            	response.type("text/html");
                Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
    			Owner owner = Owner.findFirst("id = ?", request.params(":id"));
                Base.close();

                return 
                		EncabezadoHTML1+
                		EncabezadoHTML2+
                		EncabezadoHTML3+
                		"	<div class='container'>"+
    	                "		<!-- Main hero unit for a primary marketing message or call to action -->"+
    	                "		<div class='hero-unit'>"+
    	                "			<div class='container'>"+
    	                "				<h2>Modificar Datos</h2>"+
    	                "				<label>* Datos obligatorios </label>"+
    	                "			</div>"+
    	                "			<hr></hr>"+
    	                "			<div>"+
    	                "				<form class='form-horizontal' method='POST' action='/updateowner/"+request.params(":id")+"'>"+ 
                        "                                       <div class='control-group'>"+
    	                "                                           <label class='control-label'>Nombre:*</label>"+
    	                "                                           <div class='controls'>"+
    	                "							<input type='text' name='first_name' value='"+owner.get("first_name")+"' pattern='[a-zA-Z ]+' title='Solo letras - Maxima Longitud 56' maxlength='56' required='required'>"+
    	                "						</div>"+
    	                "					</div>"+
                        "                                       <div class='control-group'>"+
    	                "                                           <label class='control-label'>Apellido:*</label>"+
    	                "                                           <div class='controls'>"+
    	                "							<input type='text' name='last_name' value='"+owner.get("last_name")+"' pattern='[a-zA-Z ]+' title='Solo letras - Maxima Longitud 56' maxlength='56' required='required'>"+
    	                "						</div>"+
    	                "					</div>"+
                        "                                       <div class='control-group'>"+
    	                "                                           <label class='control-label'>Ciudad:*</label>"+
    	                "                                           <div class='controls'>"+
    	                						optionCityUpdate(""+owner.get("city_id")+"")+
    	                "                                           </div>"+
    	                "					</div>"+
    	                "					<div class='control-group'>"+
    	                "						<label class='control-label'>Barrio:</label>"+
    	                "						<div class='controls'>"+
    	                "							<input type='text' name='neighborhood' value='"+owner.get("neighborhood")+"' pattern='[a-zA-Z ]+' title='Solo letras - Maxima Longitud 30' maxlength='30'>"+
    	                "						</div>"+
    	                "					</div>"+
    	                "					<div class='control-group'>"+
    	                "						<label class='control-label'>Calle:</label>"+
    	                "						<div class='controls'>"+
    	                "							<input type='text' name='street' value='"+owner.get("street")+"' pattern='[a-zA-Z ]+' title='Solo letras - Maxima Longitud 30' maxlength='30'>"+
    	                "						</div>"+
    	                "					</div>"+ 
    	                "					<div class='control-group'>"+
    	                "						<label class='control-label'>Numero:</label>"+
    	                "						<div class='controls'>"+
    	                "							<input type='text' name='n_street' value='"+owner.get("n_street")+"' pattern='[0-9]+' title='Solo numeros - Sin espacios - Maxima Longitud 10' maxlength='10'>"+
    	                "						</div>"+
    	                "					</div>"+
    	                "					<div class='control-group'>"+
    	                "						<label class='control-label'>Email:*</label>"+
    	                "						<div class='controls'>"+
    	                "							<input type='text' name='email' value='"+owner.get("email")+"' placeholder='someone@example.com' pattern='[a-zA-Z0-9]+[.[a-zA-Z0-9_-]+]*@[a-z0-9][\\w\\.-]*[a-z0-9]\\.[a-z][a-z\\.]*[a-z]$'+ title='Maxima Longitud 60' maxlength='60' required='required'>"+
    	                "						</div>"+
    	                "					</div>"+
    	                "					<div class='form-actions'>"+
    	                "						<button class='btn btn-large btn-primary' type='submit'>Guardar</button>"+
    	                "					</div>"+
    	                "				</form>"+
    	                "			</div>"+
    	                "		</div>"+		
    	                "		<footer>"+
    	                "			<p>&copy; 2013 Grateds, Inc. All rights reserved.</p>"+
    	                "		</footer>"+
    	                "	</div> <!-- /container -->"+
    	    			"	<script src='../bootstrap/js/jquery.js'></script>"+
    	    			"	<script src='../bootstrap/js/bootstrap-dropdown.js'></script>"+
    	    			"</body>"+
    	  				"</html>";
            }
        });
        
        Spark.post(new Route("/updateowner/:id"){
            @Override
            public Object handle(Request request, Response response){
            	response.redirect("/owners/");
            	crudOwner o = new crudOwner();
    			Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
    			o.update(request.params(":id"),request.queryParams("first_name"), request.queryParams("last_name"), request.queryParams("city_id"),request.queryParams("neighborhood"),request.queryParams("street"),request.queryParams("n_street"),request.queryParams("email"));			
                Base.close();
    		
                return "";    
            }
        });
    }
}
