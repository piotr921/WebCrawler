package ps.learn.web_crawler.infra;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

class DocumentContentExtractor {

    Set<String> getUrls(Document document) {
        final Elements elements = document.getElementsByClass("kCrYT");
        Set<String> urls = new HashSet<>();
        elements.forEach(e -> extractUrlFromElement(e, urls));
        return urls.stream()
                .filter(url -> url.contains("https"))
                .collect(Collectors.toSet());
    }

    private void extractUrlFromElement(Element element, Set<String> urls) {
        final String[] splitted = element
                .getElementsByAttribute("href")
                .attr("href")
                .split("\\=");
        if (splitted.length > 1) {
            final String extractedUrl = splitted[1].split("\\&")[0];
            urls.add(extractedUrl);
        }
    }
}
