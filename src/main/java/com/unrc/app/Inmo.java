package com.unrc.app;

import com.unrc.app.models.User;
import com.unrc.app.models.Building;
import com.unrc.app.models.Owner;

import org.javalite.activejdbc.Base;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Inmo {
    public static void main( String[] args )
    {
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");

        User e = new User();
   
        e.set("email", "user@email.com");
        e.set("first_name", "John");
        e.set("last_name", "Doe");
        e.saveIt();
        
        /* Primero crear un dueño */
        Owner o = new Owner(); 
        
        o.set("nam", "Raquel");
        o.set("id_city", "1");
        o.set("neighborhood", "Santa Rosa");
        o.set("street", "Sobremonte");
        o.set("n_street", "153");
        o.set("email", "Raquel@Gmail.com");
        o.saveIt();
    
        /* Segundo crear un inmueble */
        Building i = new Building();
   
        i.set("typ", "land");
        i.set("id_owner", "1");
        i.set("id_city", "1");
        i.set("neighborhood", "Santa Rosa");
        i.set("street", "Sobremonte");
        i.set("n_street", "153");
        i.set("description", "Gran propiedad");
        i.set("price", "150000");
        i.set("operation", "venta");
        i.saveIt();
        
        System.out.println( "Hello World!" );
    }
}
