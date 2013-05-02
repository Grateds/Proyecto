package com.unrc.app;

import com.unrc.app.models.User;
import com.unrc.app.models.Building;

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
    
        Building i = new Building();
   
        i.set("typ", "land");
        i.set("id_owners", "1");
        i.set("adress", "ciudad");
        i.set("txt", "Gran propiedad");
        i.set("price", "150000");
        i.set("v_a", "venta");
        i.saveIt();
        
        System.out.println( "Hello World!" );
    }
}
