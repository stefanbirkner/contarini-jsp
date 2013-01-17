package com.github.stefanbirkner.contarini;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.rules.ExpectedException.none;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class WebCrawlerInfoTest {
  private static final Alternate DUMMY_ALTERNATE = new Alternate("language", "href");
  private static final Alternate OTHER_DUMMY_ALTERNATE = new Alternate("another language", "another href");

  @Rule
  public final ExpectedException thrown = none();

  @Test
  public void makesListOfAlternatesUnmodifiable() {
    thrown.expect(UnsupportedOperationException.class);
    WebCrawlerInfo info = new WebCrawlerInfo().withAlternates(DUMMY_ALTERNATE);
    info.alternates.add(OTHER_DUMMY_ALTERNATE);
  }

  @Test
  public void createsEmptyInfoWithUnmodfiableListOfNoAlternates() {
    thrown.expect(UnsupportedOperationException.class);
    WebCrawlerInfo info = new WebCrawlerInfo();
    info.alternates.add(DUMMY_ALTERNATE);
  }

  @Test
  public void isDifferentFromInfoWithOtherAlternates() {
    WebCrawlerInfo firstInfo = new WebCrawlerInfo().withAlternates(DUMMY_ALTERNATE);
    WebCrawlerInfo secondInfo = new WebCrawlerInfo().withAlternates(OTHER_DUMMY_ALTERNATE);
    assertThat(firstInfo, is(not(equalTo(secondInfo))));
  }

  @Test
  public void isDifferentFromInfoWithOtherCanonical() {
    WebCrawlerInfo firstInfo = new WebCrawlerInfo().withCanonical("first canonical");
    WebCrawlerInfo secondInfo = new WebCrawlerInfo().withCanonical("second canonical");
    assertThat(firstInfo, is(not(equalTo(secondInfo))));
  }

  @Test
  public void isDifferentFromInfoWithOtherDescription() {
    WebCrawlerInfo firstInfo = new WebCrawlerInfo().withDescription("first description");
    WebCrawlerInfo secondInfo = new WebCrawlerInfo().withDescription("second description");
    assertThat(firstInfo, is(not(equalTo(secondInfo))));
  }

  @Test
  public void isDifferentFromInfoWithOtherKeywords() {
    WebCrawlerInfo firstInfo = new WebCrawlerInfo().withKeywords("first keywords");
    WebCrawlerInfo secondInfo = new WebCrawlerInfo().withKeywords("second keywords");
    assertThat(firstInfo, is(not(equalTo(secondInfo))));
  }
}
