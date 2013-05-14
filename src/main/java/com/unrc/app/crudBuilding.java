package com.unrc.app;

import com.unrc.app.models.Building;
import com.unrc.app.models.Owner;
import com.unrc.app.models.City;

/**
 * Class crudBuilding
 */
public class crudBuilding {

	/** Pre: city.exist() && owner.exist() = true **/
	/** Pos: Created building **/
	public void create(String type, String owner, String city, String neighborhood, String street, String n_street, String description, String price, String operation){
		City c = City.findFirst("name = ?", city);
		Owner o = Owner.findFirst("last_name = ?", owner);
        	Building b = new Building();
		b.set("type", type);
		b.set("neighborhood", neighborhood);
		b.set("street", street);
		b.set("n_street", n_street);
		b.set("description", description);
		b.set("price", price);
		b.set("operation", operation);
		b.set("owner_id", o.getId());
        	b.set("city_id", c.getId());
        	b.saveIt();
	}//end create
	
	/** Pre: building.exist() = true **/
	/** Pos: Deleted building **/
	public void delete(String id){   
    		Building c = Building.findFirst("id = ?", id);
	        c.deleteCascade();
    	}//end delete

	/** Pre: building.exist() = true **/
	/** Pos: Updated building **/
	public void update(String name, String new_name){   
    	
    	}//end update

	//
	// Accessor methods
	//

	//
	// Other methods
	//
}
