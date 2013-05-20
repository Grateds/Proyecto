package com.unrc.app;

import com.unrc.app.models.*;

import org.javalite.activejdbc.Base;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("unused")
public class Inmo {
    public static void main( String[] args ) {
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
        
//       crudUser e = new crudUser();
//       e.create("user@email.com", "John", "Doe");   
       
//       crudOwner o = new crudOwner();     
//       o.create("Debora","Meltrozo","2","Santa Rosa","Sobremonte","153","deborame@outlook.com");
//       o.update(...);                  
       
        crudBuilding b = new crudBuilding();
        b.create("land","2","4","Banda Norte","Marcelo T. Alvear","132","Fea","300.000","venta");
        b.update("1", "farm", "1", "10", "Brasca", "Lavalle", "5000", "", "200000", "alquiler");
        
        System.out.println( "Hello World!" );
    }
}
