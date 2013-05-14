package com.unrc.app;

<<<<<<< HEAD
import com.unrc.app.models.*;
=======
import com.unrc.app.models.City;
import com.unrc.app.models.User;
import com.unrc.app.models.Building;
import com.unrc.app.models.Owner;
import com.unrc.app.models.RealEstate;
>>>>>>> d71f1dec7fc4b6664e29b6b8e0b7c169c4acc343

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
        
<<<<<<< HEAD
        crudOwner o = new crudOwner(); 
        /* Crear un dueño */
        o.create("Debora","Meltrozo","San Salvador de Jujuy","Santa Rosa","Sobremonte","153","deborame@outlook.com");
=======
        crudOwner c = new crudOwner(); 
        /* Crear un dueño */
        c.create("Debora","Meltrozo","Jujuy","Santa Rosa","Sobremonte","153","deborame@outlook.com");
>>>>>>> d71f1dec7fc4b6664e29b6b8e0b7c169c4acc343
        
        /*Elimina Dueño*/
        //o.delete("1");
        
        /*Modifica un dueño */
<<<<<<< HEAD
        //o.update("1");
       
        /* Segundo crear un inmueble */
        crudBuilding b = new crudBuilding();
        b.create("land","Meltrozo","San Salvador de Jujuy","Banda Norte","Marcelo T. Alvear","132","Fea","300.000","venta");
       
=======
        //c.update("1");
       
        /* Segundo crear un inmueble */
       /* Building i = new Building();
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
        */
        /* Crear una inmobiliaria */
        /*RealEstate r = new RealEstate();
        
        r.set("name", "Vienes Raices Imperio"); 
        r.set("city_id", "1");
        r.set("neighborhood", "Centro");
        r.set("street", "Baigorria");
        r.set("n_street", "1250");
        r.set("phone", "4689765");
        r.set("email", "vrimperio@outlook.com");
        r.set("site_web", "www.vrimperio.com");
        r.saveIt(); 
*/
>>>>>>> d71f1dec7fc4b6664e29b6b8e0b7c169c4acc343
        System.out.println( "Hello World!" );
    }
}
