package com.unrc.app;

import static org.javalite.test.jspec.JSpec.the;

import org.javalite.activejdbc.Base;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.unrc.app.models.City;

@SuppressWarnings("unused")
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
/*
        City city = new City();

        //check errors
        the(city).shouldNotBe("valid");
        the(city.errors().get("name")).shouldBeEqual("value is missing");

        //all is good:
        the(city).shouldBe("valid");*/
    }
}
