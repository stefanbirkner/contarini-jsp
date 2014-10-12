package com.github.stefanbirkner.contarini.jsp;

import com.github.stefanbirkner.serverrule.HttpServer;
import org.apache.commons.io.IOUtils;
import org.junit.ClassRule;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class WebCrawlerInfoTagTest {
    @ClassRule
    public static final HttpServer SERVER = new HttpServer();

    @Test
    public void rendersTags() throws Exception {
        String pageSource = pageSourceForUrl("http://127.0.0.1:8080/index.jsp");
        assertThat(pageSource, is(equalTo(snippetWithName("tags.snippet"))));
    }

    private String pageSourceForUrl(String urlAsString) throws IOException {
        URL url = new URL(urlAsString);
        return IOUtils.toString(url.openStream());
    }

    private String snippetWithName(String name) throws IOException {
        InputStream is = getClass().getResourceAsStream(name);
        return IOUtils.toString(is);
    }
}
