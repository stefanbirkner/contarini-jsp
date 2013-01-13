package com.github.stefanbirkner.contarini;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;

import java.util.List;

public class WebCrawlerInfo {
  private static final List<Alternate> NO_ALTERNATES = emptyList();
  public final String canonical;
  public final List<Alternate> alternates;
  public final String description;

  private WebCrawlerInfo(String canonical, List<Alternate> alternates, String description) {
    this.canonical = canonical;
    this.alternates = alternates;
    this.description = description;
  }

  public WebCrawlerInfo() {
    this.canonical = null;
    this.alternates = NO_ALTERNATES;
    this.description = null;
  }

  public WebCrawlerInfo withCanonical(String canoncial) {
    return new WebCrawlerInfo(canoncial, alternates, description);
  }

  public WebCrawlerInfo withAlternates(Alternate... alternates) {
    return new WebCrawlerInfo(canonical, asList(alternates), description);
  }

  public WebCrawlerInfo withDescription(String description) {
    return new WebCrawlerInfo(canonical, alternates, description);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((alternates == null) ? 0 : alternates.hashCode());
    result = prime * result + ((canonical == null) ? 0 : canonical.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    WebCrawlerInfo other = (WebCrawlerInfo) obj;
    if (alternates == null) {
      if (other.alternates != null)
        return false;
    } else if (!alternates.equals(other.alternates))
      return false;
    if (canonical == null) {
      if (other.canonical != null)
        return false;
    } else if (!canonical.equals(other.canonical))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "WebCrawlerInfo [canonical=" + canonical + ", alternates=" + alternates + "]";
  }
}
