package com.unrc.app;

import static org.javalite.test.jspec.JSpec.the;

import org.javalite.activejdbc.Base;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.unrc.app.models.Building;
import com.unrc.app.models.City;
import com.unrc.app.models.Owner;
import com.unrc.app.models.RealEstate;
import com.unrc.app.models.BuildingRealEstate;

public class BuildingRealEstateSpec {
	
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
        city.set("name", "space").saveIt();
        
        Owner owner = new Owner();
        owner.set("first_name","Jose");
        owner.set("last_name","Perez");
        owner.set("email","jperez@hotmail.com").saveIt();
       
        RealEstate realestate = new RealEstate();
        realestate.set("name","Inmobiliaria Los Ladrones");
        realestate.set("phone","4678963");

        Building building = new Building();
        building.set("type","land");
        building.set("owner_id",owner.getId());
        building.set("city_id",city.getId());
        building.set("neighborhood","Santa Rosa");
        building.set("street","Sobremonte");
        building.set("n_street","1789");
        
        BuildingRealEstate buildingRealEstate = new BuildingRealEstate();

        //check errors
        the(buildingRealEstate).shouldNotBe("valid");
        the(buildingRealEstate.errors().get("building_id")).shouldBeEqual("value is missing");
        the(buildingRealEstate.errors().get("real_estate_id")).shouldBeEqual("value is missing");
                
        buildingRealEstate.set("building_id",building.getId());
        buildingRealEstate.set("real_estate_id",realestate.getId());

        //all is good:
        the(buildingRealEstate).shouldBe("valid");
    }
    
    @Test
    public void shouldSaveRecord(){
//    	City city = new City();
//        city.set("name", "space").saveIt();
//        
//        Owner owner = new Owner();
//        owner.set("first_name","Jose");
//        owner.set("last_name","Perez");
//        owner.set("email","jperez@hotmail.com").saveIt();
//       
//        RealEstate realestate = new RealEstate();
//        realestate.set("name","Inmobiliaria Los Ladrones");
//        realestate.set("phone","4678963");
//
//        Building building = new Building();
//        building.set("type","land");
//        building.set("owner_id",owner.getId());
//        building.set("city_id",city.getId());
//        building.set("neighborhood","Santa Rosa");
//        building.set("street","Sobremonte");
//        building.set("n_street","1789");
//        
//        BuildingRealEstate buildingRealEstate = new BuildingRealEstate();
//        buildingRealEstate.set("building_id",building.getId());
//        buildingRealEstate.set("real_estate_id",realestate.getId());
//        buildingRealEstate.saveIt();
//        
//        BuildingRealEstate bRE = BuildingRealEstate.findFirst("building_id = ?", building.getId());
//        the(buildingRealEstate.getId()).shouldBeEqual(bRE.getId());
    }
}
