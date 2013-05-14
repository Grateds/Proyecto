package com.unrc.app;

import com.unrc.app.models.Owner;
import com.unrc.app.models.City;

import java.util.List;

/**
 * Class crudOwner
 */
public class crudOwner {
	
	//
	// Methods
	//
	
	/** Pre: city.exist() = true **/
	/** Pos: Created owner **/
	public void create(String first_name, String last_name,String city, String neighborhood, String street, String n_street, String email){
		City c = City.findFirst("name = ?", city);
		Owner o = new Owner();
        	o.set("first_name", first_name);
        	o.set("last_name",last_name);
        	o.set("city_id", c.getId());
        	o.set("neighborhood", neighborhood);
        	o.set("street", street);
        	o.set("n_street", n_street);
        	o.set("email", email);
        	o.saveIt();
	}//end create
        
    	public void delete(String id){   
    	Owner o = Owner.findFirst("id = ?", id);
        o.deleteCascade();
    	}//end delete
        
    public void update(String id, String column, String value){
    	//Updating a single record
        List<Owner> list = Owner.find("id = id");
        Owner o = list.get(0);
        o.set(column, value).saveIt();
       
    }//end update

}
