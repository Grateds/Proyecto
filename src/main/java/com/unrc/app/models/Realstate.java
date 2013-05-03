package com.unrc.app.models;

import org.javalite.activejdbc.Model;

public class Realstate extends Model {
    static{
      validatePresenceOf("name", "phone");
  }
}