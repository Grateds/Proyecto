package com.unrc.app.models;

import org.javalite.activejdbc.Model;

public class Owner extends Model {
  static{
       validatePresenceOf("first_name").message ( "Por favor, Nombre" );
       validatePresenceOf("last_name").message ( "Por favor, Apellido" );
       validateRegexpOf("email", "\\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b");       
  }
}
