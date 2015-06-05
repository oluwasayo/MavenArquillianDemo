package com.hextremelabs.hellomaven;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oladeji
 */
public class DummyInterceptor {

  @AroundInvoke
  public Object intercept(InvocationContext ic) throws Exception {
    System.out.println("Interceptor kicking in...");
    return ic.proceed();
  }
}
