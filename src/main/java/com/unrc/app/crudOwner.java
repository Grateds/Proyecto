package com.unrc.app;
import com.unrc.app.models.Owner;

/**
 * Class crudOwner
 */
public class crudOwner {

	//
	// Fields
	//

  
	//
	// Constructors
	//
	public crudOwner() { };
  
	//
	// Methods
	//
	public static void create(String first_name, String last_name,String city_id, String neighborhood, String email){
            Owner o = new Owner(); 
            o.set("first_name", first_name).set("last_name",last_name).set("city_id", city_id).set("neighborhood", neighborhood).set("email", email).saveIt();
        };//end create
        
        public static void delete(){     
        };//end delete
        
        public static void update(){};

	//
	// Accessor methods
	//

	//
	// Other methods
	//

}
