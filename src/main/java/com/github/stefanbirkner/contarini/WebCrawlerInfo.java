package com.github.stefanbirkner.contarini;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;

import java.util.List;

public class WebCrawlerInfo {
  private static final List<WebCrawlerAdvice> NO_ADVICES = emptyList();
  private static final List<Alternate> NO_ALTERNATES = emptyList();
  public final String canonical;
  public final List<WebCrawlerAdvice> advices;
  public final List<Alternate> alternates;
  public final String description;
  public final String keywords;

  private WebCrawlerInfo(String canonical, List<WebCrawlerAdvice> advices, List<Alternate> alternates,
      String description, String keywords) {
    this.canonical = canonical;
    this.advices = advices;
    this.alternates = alternates;
    this.description = description;
    this.keywords = keywords;
  }

  public WebCrawlerInfo() {
    this.canonical = null;
    this.advices = NO_ADVICES;
    this.alternates = NO_ALTERNATES;
    this.description = null;
    this.keywords = null;
  }

  public WebCrawlerInfo withCanonical(String canoncial) {
    return new WebCrawlerInfo(canoncial, advices, alternates, description, keywords);
  }

  public WebCrawlerInfo withAdvices(WebCrawlerAdvice... advices) {
    return new WebCrawlerInfo(canonical, asList(advices), alternates, description, keywords);
  }

  public WebCrawlerInfo withAlternates(Alternate... alternates) {
    return new WebCrawlerInfo(canonical, advices, asList(alternates), description, keywords);
  }

  public WebCrawlerInfo withDescription(String description) {
    return new WebCrawlerInfo(canonical, advices, alternates, description, keywords);
  }

  public WebCrawlerInfo withKeywords(String keywords) {
    return new WebCrawlerInfo(canonical, advices, alternates, description, keywords);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((advices == null) ? 0 : advices.hashCode());
    result = prime * result + ((alternates == null) ? 0 : alternates.hashCode());
    result = prime * result + ((canonical == null) ? 0 : canonical.hashCode());
    result = prime * result + ((description == null) ? 0 : description.hashCode());
    result = prime * result + ((keywords == null) ? 0 : keywords.hashCode());
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
    if (advices == null) {
      if (other.advices != null)
        return false;
    } else if (!advices.equals(other.advices))
      return false;
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
    if (description == null) {
      if (other.description != null)
        return false;
    } else if (!description.equals(other.description))
      return false;
    if (keywords == null) {
      if (other.keywords != null)
        return false;
    } else if (!keywords.equals(other.keywords))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "WebCrawlerInfo [canonical=" + canonical + ", advices=" + advices + ", alternates=" + alternates
        + ", description=" + description + ", keywords=" + keywords + "]";
  }
}
