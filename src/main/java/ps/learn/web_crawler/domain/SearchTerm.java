package ps.learn.web_crawler.domain;

// lombok @Value would be useful here
public class SearchTerm {
    private final String value;

    public SearchTerm(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "SearchTerm{" +
                "value='" + value + '\'' +
                '}';
    }
}
