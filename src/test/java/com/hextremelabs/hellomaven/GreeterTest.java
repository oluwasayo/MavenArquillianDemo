/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hextremelabs.hellomaven;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author oladeji
 */
@RunWith(Arquillian.class)
@Dependent
public class GreeterTest {

  @Inject
  private Greeter instance;

  @PersistenceContext
  private EntityManager em;

  public GreeterTest() {
  }

  @BeforeClass
  public static void setUpClass() {
  }

  @AfterClass
  public static void tearDownClass() {
  }

  @Deployment
  public static WebArchive createDeployment() {
    return ShrinkWrap.create(WebArchive.class)
        .addClasses(Greeter.class, PhraseBuilder.class, DummyInterceptor.class)
        .addAsResource("logging.properties", "META-INF/logging.properties")
        .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
        .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
  }

  @After
  public void tearDown() {
  }

  @Test
  public void testCreateGreeting() {
    System.out.println("createGreeting");
    assertEquals("Hello, Sayo!", instance.createGreeting("Sayo"));
  }

  @Test
  public void testPersistence() {
    DummyEntity de = new DummyEntity();
    de.setId(1l);
    de.setName("Petr Cech");
    de.setAge(10);
    em.persist(de);

    Query q = em.createQuery("SELECT d.age FROM DummyEntity d");
    assertEquals(10, q.getResultList().get(0));
  }
}
