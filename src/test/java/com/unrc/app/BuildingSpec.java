package com.unrc.app;

import static org.javalite.test.jspec.JSpec.the;

import org.javalite.activejdbc.Base;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.unrc.app.models.Building;

@SuppressWarnings("unused")
public class BuildingSpec {
	@Before
    public void before(){
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
        Base.openTransaction();
    }

    @After
    public void after(){
        Base.rollbackTransaction();
        Base.close();
    }

    @Test
    public void shouldValidateMandatoryFields(){
/*
        Building building = new Building();

        //check errors
        the(building).shouldNotBe("valid");
        the(building.errors().get("type")).shouldBeEqual("value is missing");
        the(building.errors().get("owner_id")).shouldBeEqual("value is missing");
        the(building.errors().get("city_id")).shouldBeEqual("value is missing");
        the(building.errors().get("street")).shouldBeEqual("value is missing");
        the(building.errors().get("neighborhood")).shouldBeEqual("value is missing");
        the(building.errors().get("n_street")).shouldBeEqual("value is missing");
        
        //all is good:
        the(building).shouldBe("valid");
        */
    }
}
