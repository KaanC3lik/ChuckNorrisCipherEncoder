import java.io.UncheckedIOException;

// update the class
class BadRequestException extends java.lang.Exception {
    BadRequestException(String message) {
        super(message);
    }
}