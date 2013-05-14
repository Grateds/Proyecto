package com.unrc.app;

import com.unrc.app.models.City;

/**
 * Class crudCity
 */
public class crudCity {
	
	/** Pre: true **/
	/** Pos: Created city **/
	public void create(String name){
		City c = new City(); 		
        c.set("name", name).saveIt();
	}//end create
	
	/** Pre: city.exist() = true **/
	/** Pos: Deleted city **/
	public void delete(String name){   
    	City c = City.findFirst("name = ?", name);
        c.deleteCascade();
    }//end delete

	/** Pre: city.exist() = true **/
	/** Pos: Updated city **/
	public void update(String name, String new_name){   
    	City c = City.findFirst("name = ?", name);
    	c.set("name", new_name).saveIt();
    }//end update

	//
	// Accessor methods
	//

	//
	// Other methods
	//
}
