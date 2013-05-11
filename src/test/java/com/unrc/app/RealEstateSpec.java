package com.unrc.app;

import static org.javalite.test.jspec.JSpec.the;

import org.javalite.activejdbc.Base;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.unrc.app.models.RealEstate;

public class RealEstateSpec {
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

        RealEstate realEstate = new RealEstate();

        //check errors
        the(realEstate).shouldNotBe("valid");
        the(realEstate.errors().get("name")).shouldBeEqual("value is missing");
        the(realEstate.errors().get("phone")).shouldBeEqual("value is missing");
        
        //all is good:
        the(realEstate).shouldBe("valid");
    }
}
