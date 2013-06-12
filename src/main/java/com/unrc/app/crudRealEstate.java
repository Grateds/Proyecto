package com.unrc.app;

import com.unrc.app.models.RealEstate;
import com.unrc.app.models.Building;
import com.unrc.app.models.BuildingsRealEstates;
import java.util.List;

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
        List<BuildingsRealEstates> bREs = BuildingsRealEstates.find("real_estate_id = ?", id);
        for(int i=0; i<bREs.size();i++){
            Building b = Building.findFirst("id = ?", (bREs.get(i)).get("building_id"));
            rs.remove(b);//borra en buildings_real_estates
            b.delete();//borra en buildings
        }
        rs.delete();
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
