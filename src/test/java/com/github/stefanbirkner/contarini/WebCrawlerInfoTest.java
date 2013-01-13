package com.github.stefanbirkner.contarini;

import static org.junit.rules.ExpectedException.none;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class WebCrawlerInfoTest {
  private static final Alternate DUMMY_ALTERNATE = new Alternate("language", "href");
  private static final Alternate ANOTHER_DUMMY_ALTERNATE = new Alternate("another language", "another href");

  @Rule
  public final ExpectedException thrown = none();

  @Test
  public void makesListOfAlternatesUnmodifiable() {
    thrown.expect(UnsupportedOperationException.class);
    WebCrawlerInfo info = new WebCrawlerInfo().withAlternates(DUMMY_ALTERNATE);
    info.alternates.add(ANOTHER_DUMMY_ALTERNATE);
  }

  @Test
  public void createsEmptyInfoWithUnmodfiableListOfNoAlternates() {
    thrown.expect(UnsupportedOperationException.class);
    WebCrawlerInfo info = new WebCrawlerInfo();
    info.alternates.add(DUMMY_ALTERNATE);
  }
}
