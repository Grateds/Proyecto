package com.unrc.app;

import com.unrc.app.models.User;
import com.unrc.app.models.Building;
import com.unrc.app.models.Owner;
import com.unrc.app.models.RealEstate;

import org.javalite.activejdbc.Base;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("unused")
public class Inmo {
    public static void main( String[] args ) {
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
        
        /* Usuario */
        User e = new User();
        e.set("email", "user@email.com");
        e.set("first_name", "John");
        e.set("last_name", "Doe");
        e.saveIt();
        
        crudOwner c = new crudOwner(); 
        /*Crear un dueño */
        c.create("Debora","Elva","1","Santa Rosa","Sobremonte","153","deborame@outlook.com");
        
        /*Elimina Dueño*/
        //c.delete("1");
       
        /*Modifica un dueño*/   
        //c.update("1");
    
    
        /* Segundo crear un inmueble */
        Building i = new Building();
        i.set("type", "land");
        i.set("owner_id", "1");
        i.set("city_id", "1");
        i.set("neighborhood", "Santa Rosa");
        i.set("street", "Sobremonte");
        i.set("n_street", "153");
        i.set("description", "Gran propiedad");
        i.set("price", "150000");
        i.set("operation", "venta");   
        i.saveIt();
        
        /* Crear una inmobiliaria */
        RealEstate r = new RealEstate();
        
        r.set("name", "Vienes Raices Imperio"); 
        r.set("city_id", "1");
        r.set("neighborhood", "Centro");
        r.set("street", "Baigorria");
        r.set("n_street", "1250");
        r.set("phone", "4689765");
        r.set("email", "vrimperio@outlook.com");
        r.set("site_web", "www.vrimperio.com");
        r.saveIt(); 

        System.out.println( "Hello World!" );
    }
}
