package com.github.stefanbirkner.contarini;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.io.StringWriter;

import org.junit.Test;

public class WebCrawlerInfoRendererTest extends WebCrawlerInfoRenderer {
  private static final String DUMMY_CANONICAL = "http://dummy.canonical";
  private static final String DUMMY_TEXT = "dummy text";
  private static final String FIRST_DUMMY_LANGUAGE = "de";
  private static final String FIRST_DUMMY_HREF = DUMMY_CANONICAL;
  private static final String SECOND_DUMMY_LANGUAGE = "en";
  private static final String SECOND_DUMMY_HREF = DUMMY_CANONICAL + ".en";
  private final WebCrawlerInfoRenderer renderer = new WebCrawlerInfoRenderer();

  @Test
  public void writesCanonical() throws Exception {
    WebCrawlerInfo info = new WebCrawlerInfo().withCanonical(DUMMY_CANONICAL);
    String tags = renderTagsForInfo(info);
    assertThat(tags, is(equalTo("<link rel=\"canonical\" href=\"" + DUMMY_CANONICAL + "\"/>")));
  }

  @Test
  public void writesDescription() throws Exception {
    WebCrawlerInfo info = new WebCrawlerInfo().withDescription(DUMMY_TEXT);
    String tags = renderTagsForInfo(info);
    assertThat(tags, is(equalTo("<meta name=\"description\" content=\"" + DUMMY_TEXT + "\"/>")));
  }

  @Test
  public void writesKeywords() throws Exception {
    WebCrawlerInfo info = new WebCrawlerInfo().withKeywords(DUMMY_TEXT);
    String tags = renderTagsForInfo(info);
    assertThat(tags, is(equalTo("<meta name=\"keywords\" content=\"" + DUMMY_TEXT + "\"/>")));
  }

  @Test
  public void writesTwoAlternates() throws Exception {
    Alternate firstAlternate = new Alternate(FIRST_DUMMY_LANGUAGE, FIRST_DUMMY_HREF);
    Alternate secondAlternate = new Alternate(SECOND_DUMMY_LANGUAGE, SECOND_DUMMY_HREF);
    WebCrawlerInfo info = new WebCrawlerInfo().withAlternates(firstAlternate, secondAlternate);
    String tags = renderTagsForInfo(info);
    assertThat(tags, is(equalTo("<link rel=\"alternate\" hreflang=\"" + FIRST_DUMMY_LANGUAGE + "\" href=\""
        + FIRST_DUMMY_HREF + "\"/><link rel=\"alternate\" hreflang=\"" + SECOND_DUMMY_LANGUAGE + "\" href=\""
        + SECOND_DUMMY_HREF + "\"/>")));
  }

  @Test
  public void writesNothingForEmptyInfo() throws Exception {
    WebCrawlerInfo info = new WebCrawlerInfo();
    String tags = renderTagsForInfo(info);
    assertThat(tags, is(equalTo("")));
  }

  private String renderTagsForInfo(WebCrawlerInfo info) throws IOException {
    StringWriter w = new StringWriter();
    renderer.writeTagsForInfoToWriter(info, w);
    return w.toString();
  }
}
