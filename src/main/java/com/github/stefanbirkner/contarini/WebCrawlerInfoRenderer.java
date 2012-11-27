package com.github.stefanbirkner.contarini;

import java.io.IOException;
import java.io.Writer;

public class WebCrawlerInfoRenderer {
  public void writeTagsForInfoToWriter(WebCrawlerInfo info, Writer w) throws IOException {
    if (info.canonical != null)
      writeCanonicalToWriter(info.canonical, w);
  }

  private void writeCanonicalToWriter(String canonical, Writer w) throws IOException {
    w.write("<link rel=\"canonical\" href=\"");
    w.write(canonical);
    w.write("\"/>");
  }
}
