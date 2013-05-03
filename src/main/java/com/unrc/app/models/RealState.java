package com.unrc.app.models;

import org.javalite.activejdbc.Model;

public class RealState extends Model {
    static{
      validatePresenceOf("name", "phone");
  }
}