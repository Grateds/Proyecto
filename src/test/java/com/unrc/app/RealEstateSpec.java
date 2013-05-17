package com.unrc.app;

import static org.javalite.test.jspec.JSpec.*;

import org.javalite.activejdbc.Base;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.unrc.app.models.City;
import com.unrc.app.models.RealEstate;


@SuppressWarnings("unused")
public class RealEstateSpec {
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

        RealEstate realestate = new RealEstate();

        //check errors
        the(realestate).shouldNotBe("valid");
        the(realestate.errors().get("name")).shouldBeEqual("value is missing");
        the(realestate.errors().get("phone")).shouldBeEqual("value is missing");
       
        realestate.set("name","Inmobiliaria Los Ladrones");
        realestate.set("phone","4678963");
              
        //all is good:
        the(realestate).shouldBe("valid");
    }

    @Test
    public void shouldSaveRecord(){
        RealEstate realestate = new RealEstate();
        City city = new City();
        
        city.set("name", "space").saveIt();
        
        realestate.set("city_id",city.getId());
        realestate.set("name","Inmobiliaria Los Ladrones");
        realestate.set("phone","4678963");
        realestate.set("neighborhood", "Barrio Balaco");
        realestate.set("street", "Sobremonte");
        realestate.set("n_street", "789");
        realestate.set("email","inmoll@hotmail.com");
        realestate.set("site_web","www.inmoll.com.ar");   
        realestate.saveIt();
        
        RealEstate rs = RealEstate.findFirst("name = ?", "Inmobiliaria Los Ladrones");
        the(realestate.get("id")).shouldBeEqual(rs.get("id"));
    }
}
