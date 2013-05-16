package com.unrc.app;

import com.unrc.app.models.*;

import org.javalite.activejdbc.Base;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("unused")
public class Inmo {
    public static void main( String[] args ) {
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
        
        /* Usuario */
        crudUser e = new crudUser();
        e.create("user@email.com", "John", "Doe");   
        
        
         /* Create Dueño */
        crudOwner o = new crudOwner();     
        o.create("Debora","Meltrozo","San Salvador de Jujuy","Santa Rosa","Sobremonte","153","deborame@outlook.com");
        
        /* Delete Dueño*/
        //o.delete("1");
        
        /* Update un dueño */
        //o.update("1");
       
       
        /* Segundo crear un inmueble */
        crudBuilding b = new crudBuilding();
        b.create("land","Meltrozo","San Salvador de Jujuy","Banda Norte","Marcelo T. Alvear","132","Fea","300.000","venta");
       
        System.out.println( "Hello World!" );
    }
}
