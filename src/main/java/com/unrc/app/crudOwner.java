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
            Owner o = Owner.findFirst("id = ?", id); 
            o.deleteCascade();
        };//end delete
        
    public static void update(String id){             
            //Busqueda 
            //List<Owner> list = Owner.where("id = 'id'");
        
          /*  //Muestra de resultados de busqueda
            Owner.find("id = 'id'", new ModelListener<Owner>() {         
                public void onModel(Owner Dueño) {
                 System.out.println("Found person: " + Dueño);
                 }
            });*/

            List<Owner> list = Owner.find("id = id");
            Owner o = list.get(0);
            o.set("first_name", "pepita");
            o.saveIt();
           
            //Actualización de registros seleccionados en la tabla 
            //Owner.update("name = ?, last_name = ?", "name like ?", "Steve", "Johnson", "%J%");   
            //Owner o = Employee.findFirst("first_name = ?", "Debora");
            //o.set("last_name", "Steinbeck").saveIt();           
        };//end update

	//
	// Accessor methods
	//

	//
	// Other methods
	//

}
