package com.unrc.app.models;

import org.javalite.activejdbc.Model;

public class Owners extends Model {
  static{
      validatePresenceOf("adress", "email", "id_inmob", );
  }
}

