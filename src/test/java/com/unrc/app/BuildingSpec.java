package com.unrc.app;

import static org.javalite.test.jspec.JSpec.the;

import org.javalite.activejdbc.Base;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.unrc.app.models.Building;
import com.unrc.app.models.City;
import com.unrc.app.models.Owner;

public class BuildingSpec {
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

        Building building = new Building();
        Owner owner = new Owner();
        owner.set("first_name","Jose");
        owner.set("last_name","Perez");
        owner.set("email","jperez@hotmail.com").saveIt();
       
        City city = new City();
        city.set("name", "space").saveIt();
        
        //check errors
        the(building).shouldNotBe("valid");
        the(building.errors().get("type")).shouldBeEqual("value is missing");
        the(building.errors().get("owner_id")).shouldBeEqual("value is missing");
        the(building.errors().get("city_id")).shouldBeEqual("value is missing");
        the(building.errors().get("neighborhood")).shouldBeEqual("value is missing");
        the(building.errors().get("street")).shouldBeEqual("value is missing");
        the(building.errors().get("n_street")).shouldBeEqual("value is missing");
        
        building.set("type","land");
        building.set("owner_id",owner.getId());
        building.set("city_id",city.getId());
        building.set("neighborhood","Santa Rosa");
        building.set("street","Sobremonte");
        building.set("n_street","1789");
        
        //all is good:
        the(building).shouldBe("valid");
        
    }
}
