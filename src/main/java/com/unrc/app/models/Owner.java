package com.unrc.app.models;

import org.javalite.activejdbc.Model;

public class Owner extends Model {
  static{
       validatePresenceOf("first_name", "last_name", "email");
  }
}
