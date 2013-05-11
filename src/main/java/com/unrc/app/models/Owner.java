package com.unrc.app.models;

import org.javalite.activejdbc.Model;

public class Owner extends Model {
  static{
       validatePresenceOf("first_name").message ( "Por favor, primer nombre" );
       validatePresenceOf("last_name").message ( "Por favor, segundo nombre" );
       validateRegexpOf("email", "\\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b");       
  }
}
