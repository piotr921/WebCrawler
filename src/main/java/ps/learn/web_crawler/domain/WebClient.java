package ps.learn.web_crawler.domain;

import java.util.Set;

public interface WebClient {

    Set<String> getUrlsFoundByGoogle(SearchTerm searchTerm);
}
