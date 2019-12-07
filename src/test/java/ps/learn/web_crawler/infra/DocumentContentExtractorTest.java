package ps.learn.web_crawler.infra;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class DocumentContentExtractorTest {
    private static final String FILE_PATH = "src/test/resources/";

    private DocumentContentExtractor extractor;


    @BeforeEach
    void setUp() {
        extractor = new DocumentContentExtractor();
    }

    @Test
    void givenValidGoogleResponse_whenExtractingUrls_shouldReturnValidResponse() throws Exception {
        // Given
        final String content = new String(Files.readAllBytes(Paths.get(FILE_PATH, "polsat.html")));
        final Document documentFixture = Jsoup.parse(content);

        // When
        final Set<String> urls = extractor.getUrls(documentFixture);

        // Then
        Set<String> expectedUrls = Stream.of(
                "https://www.cyfrowypolsat.pl/",
                "https://programtv.onet.pl/program-tv/polsat-38",
                "https://www.telemagazyn.pl/polsat/",
                "https://www.polsat.pl/",
                "https://www.polsatnews.pl/",
                "https://pilot.wp.pl/program/polsat",
                "https://icok.cyfrowypolsat.pl/",
                "https://pl.wikipedia.org/wiki/Polsat",
                "https://www.polsat.pl/program-tv/",
                "https://www.facebook.com/polsat/")
                .collect(Collectors.toSet());
        Assertions.assertEquals(expectedUrls, urls);
    }
}