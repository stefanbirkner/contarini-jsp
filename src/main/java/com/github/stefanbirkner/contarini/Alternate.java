package com.github.stefanbirkner.contarini;

public class Alternate {
  public final String language;
  public final String href;

  public Alternate(String language, String href) {
    this.language = language;
    this.href = href;
  }

  @Override
  public int hashCode() {
    final int prime = 2543;
    int result = prime + ((href == null) ? 0 : href.hashCode());
    return prime * result + ((language == null) ? 0 : language.hashCode());
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Alternate other = (Alternate) obj;
    if (href == null) {
      if (other.href != null)
        return false;
    } else if (!href.equals(other.href))
      return false;
    if (language == null) {
      if (other.language != null)
        return false;
    } else if (!language.equals(other.language))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Alternate [language=" + language + ", href=" + href + "]";
  }
}
