package com.unrc.app;

import com.unrc.app.models.User;

/**
 * Class crudUser
 */
public class crudUser {

	/** Pre: true **/
	/** Pos: Created user **/
	public void create(String email, String first_name, String last_name){
		User u = new User(); 		
        u.set("email", email).set("first_name", first_name).set("last_name", last_name).saveIt();
	}//end create
	
	/** Pre: user.exist() = true **/
	/** Pos: Deleted user **/
	public void delete(String id){   
    		User u = User.findFirst("id = ?", id);
        	u.delete();
    	}//end delete

	/** Pre: user.exist() = true **/
	/** Pos: Updated user **/
	public void update(String id, String first_name, String last_name, String email){   
		User u = User.findFirst("id = ?", id);
		u.set("first_name",first_name);
		u.set("last_name",last_name);
		u.set("email",email);
		u.saveIt();
	}
}
