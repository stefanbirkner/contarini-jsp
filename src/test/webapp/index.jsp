<%@ taglib prefix="contarini" uri="http://stefanbirkner.github.com/contarini/tags" %>
<%
	pageContext.setAttribute(
		"info",
		new com.github.stefanbirkner.contarini.WebCrawlerInfo()
			.withCanonical("/index.html")
			.withAdvices(
					com.github.stefanbirkner.contarini.CommonWebCrawlerAdvice.NO_INDEX,
					com.github.stefanbirkner.contarini.CommonWebCrawlerAdvice.NO_FOLLOW)
			.withAlternates(
					new com.github.stefanbirkner.contarini.Alternate("de", "/de/index.html"),
					new com.github.stefanbirkner.contarini.Alternate("en", "/en/index.html"))
			.withDescription("dummy description")
			.withKeywords("dummy keywords"));
%>
<contarini:webCrawlerInfo info="${info}"/>