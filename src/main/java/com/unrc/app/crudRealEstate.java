package com.unrc.app;

import com.unrc.app.models.RealEstate;

public class crudRealEstate {
    
    public void create(String name, String phone, String email, String city, String neighborhood, String street, String n_street, String site_web){
        RealEstate rs = new RealEstate();
        rs.set("name", name);
        rs.set("phone",phone);
        rs.set("email",email);
        rs.set("city_id",city);
        rs.set("neighborhood",neighborhood);
        rs.set("street",street);
        rs.set("n_street",n_street);
        rs.set("site_web",site_web);
        rs.saveIt();
    }
    public void delete(String id){
        RealEstate rs = RealEstate.findFirst("id = ?", id);
        rs.deleteCascade();
    }
    public void update(String id, String name, String phone, String email, String city, String neighborhood, String street, String n_street, String site_web){
        RealEstate rs = RealEstate.findFirst("id = ?", id);
        rs.set("name", name);
        rs.set("phone",phone);
        rs.set("email",email);
        rs.set("city_id",city);
        rs.set("neighborhood",neighborhood);
        rs.set("street",street);
        rs.set("n_street",n_street);
        rs.set("site_web",site_web);
        rs.saveIt();    
    }
    
}
