package com.github.stefanbirkner.contarini;

public class WebCrawlerInfo {
	public final String canonical;

	private WebCrawlerInfo(String canonical) {
		this.canonical = canonical;
	}

	public WebCrawlerInfo() {
		this.canonical = null;
	}

	public WebCrawlerInfo withCanonical(String canoncial) {
		return new WebCrawlerInfo(canoncial);
	}

	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = prime * result
				+ ((canonical == null) ? 0 : canonical.hashCode());
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
		if (canonical == null) {
			if (other.canonical != null)
				return false;
		} else if (!canonical.equals(other.canonical))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "WebCrawlerInfo [canonical=" + canonical + "]";
	}
}
