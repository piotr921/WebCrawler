package ps.learn.web_crawler.adapter;

class InvalidInputException extends RuntimeException {

    InvalidInputException() {
        super("One search term must be provided");
    }
}
