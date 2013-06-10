package com.unrc.app;

import com.unrc.app.models.*;

import org.javalite.activejdbc.Base;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("unused")
public class Inmo {
    public static void main( String[] args ) {

        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
      
       // crudBuildingRealEstate cBR = new crudBuildingRealEstate();
       // cBR.create("1", "6");
       // cBR.create("2", "4");
       // cBR.create("1", "1");
       // System.out.println( "Hello World!" );
    }
}
