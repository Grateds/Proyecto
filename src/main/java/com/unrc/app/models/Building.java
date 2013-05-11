package com.unrc.app.models;

import org.javalite.activejdbc.Model;

public class Building extends Model {
  static{
      validatePresenceOf("type", "owner_id", "city_id", "neighborhood", "street", "n_street");
  }
}
