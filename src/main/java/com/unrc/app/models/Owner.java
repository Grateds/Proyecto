package com.unrc.app.models;

import org.javalite.activejdbc.Model;

public class Owner extends Model {
  static{
       validatePresenceOf("first_name").message ("Nombre");
       validatePresenceOf("last_name").message ("Apellido");
       validateRegexpOf("email", "\\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b").message("Email");       
  }
}
