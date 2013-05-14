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
<<<<<<< HEAD
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
=======
		City c = City.findFirst("name = ?", city);		
		Owner o = new Owner();
        	o.set("first_name", first_name).set("last_name",last_name).set("city_id", city).set("neighborhood", neighborhood).set("street", street).set("n_street", n_street).set("email", email);
        	c.add(o);
>>>>>>> d71f1dec7fc4b6664e29b6b8e0b7c169c4acc343
	}//end create
        
    public void delete(String id){   
    	Owner o = Owner.findFirst("id = ?", id);
        o.deleteCascade();
    }//end delete
        
    public void update(String id, String column, String value){
    	//Busqueda
        //List<Owner> list = Owner.where("id = 'id'");
    
     /* //Muestra de resultados de busqueda
		Owner.find("id = 'id'", new ModelListener<Owner>() {
			public void onModel(Owner Dueño) {
				System.out.println("Found person: " + Dueño);
			}
		});*/
        
    	//Updating a single record
        List<Owner> list = Owner.find("id = id");
        Owner o = list.get(0);
        o.set(column, value).saveIt();
       
        //Actualización de registros seleccionados en la tabla
        //Owner.update("name = ?, last_name = ?", "name like ?", "Steve", "Johnson", "%J%");
        //Owner o = Employee.findFirst("first_name = ?", "Debora");
        //o.set("last_name", "Steinbeck").saveIt(); 
    }//end update

	//
	// Accessor methods
	//

	//
	// Other methods
	//

}
