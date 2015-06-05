package com.hextremelabs.hellomaven;

import javax.inject.Inject;

/**
 *
 * @author oladeji
 */
public class Greeter {

  private final PhraseBuilder phraseBuilder;

  @Inject
  public Greeter(PhraseBuilder phraseBuilder) {
    this.phraseBuilder = phraseBuilder;
  }

  public String createGreeting(String name) {
    return phraseBuilder.buildPhrase("hello", name);
  }
}
