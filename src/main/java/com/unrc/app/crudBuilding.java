package com.unrc.app;

import java.util.ArrayList;

import com.unrc.app.models.Building;
import com.unrc.app.models.BuildingsRealEstates;
import com.unrc.app.models.RealEstate;

/**
 * Class crudBuilding
 */
public class crudBuilding {
	
	ArrayList<String> RealEstates = new ArrayList<String>();
	
	/** Pre: city.exist() && owner.exist() = true **/
	/** Pos: Created building **/

	public void create(String real_estate_id, String type, String owner_id, String city_id, String neighborhood, String street, String n_street, String description, String price, String operation){
        Building b = new Building();
		b.set("type", type);
		b.set("neighborhood", neighborhood);
		b.set("street", street);
		b.set("n_street", n_street);
		b.set("description", description);
		b.set("price", price);
		b.set("operation", operation);
		b.set("owner_id", owner_id);
        b.set("city_id", city_id).saveIt();
        
       	RealEstate realEstate = RealEstate.findFirst("id = ?", real_estate_id);
       	b.add(realEstate);
       	b.saveIt();
	}
	
	/** Pre: building.exist() = true **/
	/** Pos: Deleted building **/
	public void delete(String id){   
   		Building b = Building.findFirst("id = ?", id);
   		BuildingsRealEstates bRE = BuildingsRealEstates.findFirst("building_id = ?", id);
   		RealEstate re = RealEstate.findFirst("id = ?", bRE.get("real_estate_id"));
   		b.remove(re);
   		b.delete();
    }

	/** Pre: building.exist() = true **/
	/** Pos: Updated building **/
	public void update(String id, String real_estate_id, String type, String owner_id, String city_id, String neighborhood, String street, String n_street, String description, String price, String operation){   
		
		Building b = Building.findFirst("id = ?", id);
		b.set("type",type);
		b.set("owner_id",owner_id);
		b.set("city_id",city_id);
		b.set("neighborhood",neighborhood);
		b.set("street",street);
		b.set("n_street",n_street);
		b.set("description",description);
		b.set("price",price);
		b.set("operation",operation);
		b.saveIt();
		
		BuildingsRealEstates bRE = BuildingsRealEstates.first("building_id = ?", id);
		bRE.set("real_estate_id", real_estate_id);
		bRE.saveIt();
	}
}
