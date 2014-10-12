package com.github.stefanbirkner.contarini.jsp;

import com.github.stefanbirkner.contarini.WebCrawlerInfo;
import com.github.stefanbirkner.contarini.WebCrawlerInfoRenderer;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class WebCrawlerInfoTag extends SimpleTagSupport {
    private static final WebCrawlerInfoRenderer RENDERER = new WebCrawlerInfoRenderer();
    private WebCrawlerInfo info;

    public void setInfo(WebCrawlerInfo info) {
        this.info = info;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        RENDERER.writeTagsForInfoToWriter(info, out);
    }
}
