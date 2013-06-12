package com.unrc.app;

import com.unrc.app.models.Building;
import com.unrc.app.models.BuildingsRealEstates;
import com.unrc.app.models.RealEstate;

public class crudBuildingsRealEstates {
	
	/** Pre: building.exist() && realEstate.exist() = true **/
	/** Pos: Created BuildingRealEstate **/
	public void create(String building_id, String real_estate_id){
       	Building building = Building.findFirst("building_id", building_id);
       	RealEstate realEstate = RealEstate.findFirst("real_estate_id", real_estate_id);
       	building.add(realEstate);
	}
	
	/** Pre: BuildingRealEstate.exist() = true **/
	/** Pos: Deleted BuildingRealEstate **/
	public void delete(String id){   
   		BuildingsRealEstates bRE = BuildingsRealEstates.findFirst("id = ?", id);
    	bRE.delete();
    }

	/** Pre: BuildingRealEstate.exist() = true **/
	/** Pos: Updated BuildingRealEstate **/
	public void update(String id, String building_id, String real_estate_id){   
		BuildingsRealEstates bRE = BuildingsRealEstates.findFirst("id = ?", id);
		bRE.set("type", building_id);
		bRE.set("owner_id", real_estate_id);
		bRE.saveIt();
	}
}
