package com.unrc.app.models;

import org.javalite.activejdbc.Model;

public class BuildingRealEstate extends Model {
	static{
	      validatePresenceOf("building_id", "real_estate_id");
	  }
}
