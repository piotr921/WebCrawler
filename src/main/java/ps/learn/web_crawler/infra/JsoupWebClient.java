package ps.learn.web_crawler.infra;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import ps.learn.web_crawler.domain.SearchTerm;
import ps.learn.web_crawler.domain.WebClient;

import java.io.IOException;
import java.util.Set;

public class JsoupWebClient implements WebClient {
    private static final String uri = "https://www.google.com/search?q=";

    private final DocumentContentExtractor extractor;

    public JsoupWebClient() {
        extractor = new DocumentContentExtractor();
    }

    @Override
    public Set<String> getUrlsFoundByGoogle(SearchTerm searchTerm) {
        final String searchUrl = uri + searchTerm.getValue() + "&num=10";
        try {
            final Document document = Jsoup.connect(searchUrl).userAgent("Mozilla/5.0").get();
            return extractor.getUrls(document);

        } catch (IOException e) {
            throw new WebClientException("Getting data for uri: " + uri + " failed.");
        }
    }
}
