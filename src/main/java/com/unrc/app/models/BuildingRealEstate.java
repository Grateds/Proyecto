package com.unrc.app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

@Table("building_real_estates")
public class BuildingRealEstate extends Model {
	static{
	      validatePresenceOf("building_id", "real_estate_id");
	  }
}
