package com.unrc.app;

import static org.javalite.test.jspec.JSpec.the;

import org.javalite.activejdbc.Base;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.unrc.app.models.City;

public class CitySpec {
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

        City city = new City();

        //check errors
        the(city).shouldNotBe("valid");
        the(city.errors().get("name")).shouldBeEqual("value is missing");

        city.set("name","space");
        
        //all is good:
        the(city).shouldBe("valid");
    }
    
    @Test
    public void shouldSaveRecord(){
    	City city = new City();
    	
    	city.set("name", "space").saveIt();
    	
        City c = City.findFirst("name = ?", "space");
        the(city.get("id")).shouldBeEqual(c.get("id"));
    }
}
