package com.unrc.app.models;

import org.javalite.activejdbc.Model;

public class Building extends Model {
  static{
      validatePresenceOf("typ", "id_owner", "id_city", "street", "neighborhood", "street", "n_street");
  }
}
