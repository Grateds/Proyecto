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
       
//          crudOwner o = new crudOwner();     
//          o.create("Debora","Meltrozo","2","Santa Rosa","Sobremonte","153","debosame@outlook.com");
                  
       
//        crudBuilding b = new crudBuilding();
//        b.create("house","2","4","Banda Norte","Marcelo T. Alvear","132","Fea","300.000","venta");
//        b.update("1", "house", "1", "10", "Brasca", "Lavalle", "5000", "", "200000", "alquiler");
       
//        crudRealEstate r = new crudRealEstate();
//        
//        r.create("msida", "436554", "mierd24@gmail.com", "3", "la villa", "lavalle", "456", "www.clsd4d4e.com");
       
        crudBuildingRealEstate cBR = new crudBuildingRealEstate();
        cBR.create("1", "6");
        cBR.create("2", "4");
        cBR.create("1", "1");
        System.out.println( "Hello World!" );
    }
}
