package com.unrc.app;

import com.unrc.app.models.RealEstate;

public class crudRealEstate {
    
    public static void create(String name, Integer phone, String email, String city, String neighborhood, String street, Integer n_street, String site_web){
        RealEstate rs = new RealEstate();
        Scanner in = new Scanner(System.in);
        rs.set("name", name);
        rs.set("phone",phone);
        rs.set("email",email);
        rs.set("city",city);
        rs.set("neighborhood",neighborhood);
        rs.set("street",street);
        rs.set("n_street",n_street);
        rs.set("site_web",site_web);
        rs.saveIt();
    }
    public static void delete(String id){
        RealEstate rs = RealEstate.findFirst("id = ?", id)
        rs.deleteCascade();
    }
    public static void update(String id, String name, String newname){
        List<RealEstate> list = RealEstate.find("id = id");
        Owner o = list.get(0);
        o.set(name, new_name).saveIt();
    }
    
}
