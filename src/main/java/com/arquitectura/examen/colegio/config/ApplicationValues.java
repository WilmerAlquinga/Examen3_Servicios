package com.arquitectura.examen.colegio.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ApplicationValues {
  private final String mongoHost;
  private final String mongoDB;
  private final String mongoUsr;
  private final String mongoPwd;
  private final String mongoAut;

  public ApplicationValues(
      @Value("${banquito.core.customers.mongo.host}") String mongoHost,
      @Value("${banquito.core.customers.mongo.db}") String mongoDB,
      @Value("${banquito.core.customers.mongo.usr}") String mongoUsr,
      @Value("${banquito.core.customers.mongo.pwd}") String mongoPwd,
      @Value("${banquito.core.customers.mongo.aut}") String mongoAut) {

    this.mongoHost = mongoHost;
    this.mongoDB = mongoDB;
    this.mongoUsr = mongoUsr;
    this.mongoPwd = mongoPwd;
    this.mongoAut = mongoAut;
  }
}
