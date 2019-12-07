package ps.learn.web_crawler.adapter;

import ps.learn.web_crawler.domain.SearchTerm;

public class ConsoleInput {

    public SearchTerm readSearchTerm(String[] inputArgs) {
        if (inputArgs.length < 1) {
            throw new InvalidInputException();
        }
        final String inputArg = inputArgs[0];

        if (inputArg.isEmpty()) {
            throw new InvalidInputException();
        }
        return new SearchTerm(inputArg);
    }
}
