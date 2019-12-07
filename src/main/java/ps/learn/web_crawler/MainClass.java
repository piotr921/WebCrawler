package ps.learn.web_crawler;

import ps.learn.web_crawler.adapter.ConsoleInput;
import ps.learn.web_crawler.domain.SearchTerm;

class MainClass {
    public static void main(String[] args) {
        ConsoleInput consoleInput = new ConsoleInput();

        final SearchTerm searchTerm = consoleInput.readSearchTerm(args);
        System.out.println("Searching for: " + searchTerm);
    }
}
