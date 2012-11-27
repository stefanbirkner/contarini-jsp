package com.github.stefanbirkner.contarini;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.io.StringWriter;

import org.junit.Test;

public class WebCrawlerInfoRendererTest extends WebCrawlerInfoRenderer {
  private static final String DUMMY_CANONICAL = "http://dummy.canonical";
  private final WebCrawlerInfoRenderer renderer = new WebCrawlerInfoRenderer();

  @Test
  public void writesCanonical() throws Exception {
    WebCrawlerInfo info = new WebCrawlerInfo().withCanonical(DUMMY_CANONICAL);
    String tags = renderTagsForInfo(info);
    assertThat(tags, is(equalTo("<link rel=\"canonical\" href=\"" + DUMMY_CANONICAL + "\"/>")));
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
