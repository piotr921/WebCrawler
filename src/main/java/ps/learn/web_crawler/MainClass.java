package ps.learn.web_crawler;

import ps.learn.web_crawler.adapter.ConsoleInput;
import ps.learn.web_crawler.domain.SearchTerm;
import ps.learn.web_crawler.domain.WebClient;
import ps.learn.web_crawler.infra.JsoupWebClient;

import java.util.Set;

class MainClass {
    public static void main(String[] args) {
        ConsoleInput consoleInput = new ConsoleInput();
        WebClient webClient = new JsoupWebClient();

        final SearchTerm searchTerm = consoleInput.readSearchTerm(args);
        final Set<String> urls = webClient.getUrlsFoundByGoogle(searchTerm);

        System.out.println("Google for search term: " + searchTerm.getValue() + " found following urls");
        urls.forEach(System.out::println);
    }
}
