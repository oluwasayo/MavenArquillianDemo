/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hextremelabs.hellomaven;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.interceptor.Interceptors;

/**
 *
 * @author oladeji
 */
public class PhraseBuilder {

  private Map<String, String> templates;

  @Interceptors(DummyInterceptor.class)
  public String buildPhrase(String id, Object... args) {
    return MessageFormat.format(templates.get(id), args);
  }

  @PostConstruct
  public void initialize() {
    System.out.println("Executing PhraseBuilder.initialize()");
    templates = new HashMap<>();
    templates.put("hello", "Hello, {0}!");
  }
}
