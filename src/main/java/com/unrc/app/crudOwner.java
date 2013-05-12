package com.unrc.app;
import com.unrc.app.models.User;
import com.unrc.app.models.Owner;
import org.javalite.activejdbc.ModelListener;
import java.util.List;

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
	public void create(String first_name, String last_name,String city_id, String neighborhood, String street, String n_street, String email){
		Owner o = new Owner(); 
        o.set("first_name", first_name).set("last_name",last_name).set("city_id", city_id).set("neighborhood", neighborhood).set("street", street).set("n_street", n_street).set("email", email).saveIt();
    }//end create
        
      public static void delete(String id){   
            Owner e = Owner.findFirst("id = ?", id); 
            e.deleteCascade();
        };//end delete
        
    public void update(){
    	  //Busqueda 
            List<Owner> list = Owner.where("id = '10'");
          
            //Muestra de resultados
            Owner.find("id = '10'", new ModelListener<Owner>() {         
                public void onModel(Owner Dueño) {
                 System.out.println("Found person: " + Dueño);
                 }
            });
            
            //Actualización de registros seleccionados en la tabla          
    }//end update

	//
	// Accessor methods
	//

	//
	// Other methods
	//

}
