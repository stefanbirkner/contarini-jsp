package com.github.stefanbirkner.contarini;

public enum CommonWebCrawlerAdvice implements WebCrawlerAdvice {
  NO_INDEX("noindex"), NO_FOLLOW("nofollow"), NONE("none"), NO_ARCHIVE("noarchive"), NO_SNIPPET("nosnippet"), NO_ODP(
      "noodp"), NO_TRANSLATE("notranslate"), NO_IMAGE_INDEX("noimageindex");

  private final String label;

  private CommonWebCrawlerAdvice(String label) {
    this.label = label;
  }

  @Override
  public String getLabel() {
    return label;
  }
}
