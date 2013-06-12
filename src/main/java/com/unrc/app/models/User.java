package com.unrc.app.models;

import org.javalite.activejdbc.Model;

public class User extends Model {
  static{
      validatePresenceOf("email", "first_name", "last_name");
      validateRegexpOf("email", "\\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b").message("Email");
  }
}