package com.unrc.app;

import static org.javalite.test.jspec.JSpec.*;

import org.javalite.activejdbc.Base;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.unrc.app.models.City;
import com.unrc.app.models.Owner;

public class OwnerSpec {
    @Before
    public void before(){
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development_test", "root", "root");
        Base.openTransaction();
    }

    @After
    public void after(){
        Base.rollbackTransaction();
        Base.close();
    }

    @Test
    public void shouldValidateMandatoryFields(){

        Owner owner = new Owner();

        //check errors
        the(owner).shouldNotBe("valid");

        the(owner.errors().get("first_name")).shouldBeEqual("Nombre");
        the(owner.errors().get("last_name")).shouldBeEqual("Apellido");
        the(owner.errors().get("email")).shouldBeEqual("Email");

        //all is good:
        owner.set("first_name","Jose");
        owner.set("last_name","Perez");
        owner.set("email","jperez@hotmail.com");
        owner.saveIt();
        
        the(owner).shouldBe("valid");
    }
    
    @Test
    public void shouldSaveRecord(){
    	Owner owner = new Owner();
    	City city = new City();
    	city.set("name", "space").saveIt();
    	owner.set("first_name","Jose");
        owner.set("last_name","Perez");
        owner.set("city_id",city.getId());
        owner.set("neighborhood", "riverside");
        owner.set("street", "Sobremonte");
        owner.set("n_street", "789");
        owner.set("email","jperez@hotmail.com");
        owner.saveIt();
        
       //Owner o = Owner.findFirst("first_name = ?", "prpr");       
      //the(owner).shouldBeEqual(o);
    }
}
