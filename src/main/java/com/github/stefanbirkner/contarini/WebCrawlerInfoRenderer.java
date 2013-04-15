package com.github.stefanbirkner.contarini;

import static java.util.Arrays.asList;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class WebCrawlerInfoRenderer {
  private static final List<Replacement> REPLACEMENTS = asList(new Replacement("&", "&amp;"), new Replacement("<",
      "&lt;"), new Replacement(">", "&gt;"), new Replacement("\"", "&quot;"), new Replacement("'", "&apos;"));

  public void writeTagsForInfoToWriter(WebCrawlerInfo info, Writer w) throws IOException {
    if (info.canonical != null)
      writeCanonicalToWriter(info.canonical, w);
    if (!info.advices.isEmpty())
      writeAdvicesToWriter(info.advices, w);
    writeAlternatesToWriter(info.alternates, w);
    writeMetaTagToWriterIfContentExists("description", info.description, w);
    writeMetaTagToWriterIfContentExists("keywords", info.keywords, w);
  }

  private void writeCanonicalToWriter(String canonical, Writer w) throws IOException {
    w.write("<link rel=\"canonical\" href=\"");
    w.write(canonical);
    w.write("\"/>");
  }

  private void writeAdvicesToWriter(List<WebCrawlerAdvice> advices, Writer w) throws IOException {
    String content = join(advices);
    writeMetaTagToWriter("robots", content, w);
  }

  private String join(List<WebCrawlerAdvice> advices) {
    StringBuilder sb = new StringBuilder();
    boolean first = true;
    for (WebCrawlerAdvice advice : advices) {
      if (!first)
        sb.append(", ");
      sb.append(advice.getLabel());
      first = false;
    }
    return sb.toString();
  }

  private void writeAlternatesToWriter(List<Alternate> alternates, Writer w) throws IOException {
    for (Alternate alternate : alternates)
      writeAlternateToWriter(alternate, w);
  }

  private void writeAlternateToWriter(Alternate alternate, Writer w) throws IOException {
    w.write("<link rel=\"alternate\" hreflang=\"");
    w.write(alternate.language);
    w.write("\" href=\"");
    w.write(alternate.href);
    w.write("\"/>");
  }

  private void writeMetaTagToWriterIfContentExists(String name, String content, Writer w) throws IOException {
    if (content != null)
      writeMetaTagToWriter(name, content, w);
  }

  private void writeMetaTagToWriter(String name, String content, Writer w) throws IOException {
    w.write("<meta name=\"");
    w.write(name);
    w.write("\" content=\"");
    for (Replacement replacement : REPLACEMENTS)
      content = content.replace(replacement.character, replacement.escapeSequence);
    w.write(content);
    w.write("\"/>");
  }

  private static class Replacement {
    final String character;
    final String escapeSequence;

    public Replacement(String character, String escapeSequence) {
      this.character = character;
      this.escapeSequence = escapeSequence;
    }
  }
}
