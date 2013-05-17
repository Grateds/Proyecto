package com.unrc.app;

import com.unrc.app.models.Building;

/**
 * Class crudBuilding
 */
public class crudBuilding {

	/** Pre: city.exist() && owner.exist() = true **/
	/** Pos: Created building **/
	public void create(String type, String owner_id, String city_id, String neighborhood, String street, String n_street, String description, String price, String operation){
        Building b = new Building();
		b.set("type", type);
		b.set("neighborhood", neighborhood);
		b.set("street", street);
		b.set("n_street", n_street);
		b.set("description", description);
		b.set("price", price);
		b.set("operation", operation);
		b.set("owner_id", owner_id);
        b.set("city_id", city_id);
        b.saveIt();
	}//end create
	
	/** Pre: building.exist() = true **/
	/** Pos: Deleted building **/
	public void delete(String id){   
    	Building b = Building.findFirst("id = ?", id);
	    b.deleteCascade();
    }//end delete

	/** Pre: building.exist() = true **/
	/** Pos: Updated building **/
	public void update(String id, String type, String owner_id, String city_id, String neighborhood, String street, String n_street, String description, String price, String operation){   
		if (type != "")
			Building.update("type = ?", "id like ?", type, "%"+id+"%");
		if (owner_id != "")
			Building.update("owner_id = ?", "id like ?", owner_id, "%"+id+"%");
		if (city_id != "")
			Building.update("city_id = ?", "id like ?", city_id, "%"+id+"%");
		if (neighborhood != "")
			Building.update("neighborhood = ?", "id like ?", neighborhood, "%"+id+"%");
		if (street != "")
			Building.update("street = ?", "id like ?", street, "%"+id+"%");
		if (n_street != "")
			Building.update("n_street = ?", "id like ?", n_street, "%"+id+"%");
		if (description != "")
			Building.update("description = ?", "id like ?", description, "%"+id+"%");
		if (price != "")
			Building.update("price = ?", "id like ?", price, "%"+id+"%");
		if (operation != "")
			Building.update("operation = ?", "id like ?", operation, "%"+id+"%");
	}
}
