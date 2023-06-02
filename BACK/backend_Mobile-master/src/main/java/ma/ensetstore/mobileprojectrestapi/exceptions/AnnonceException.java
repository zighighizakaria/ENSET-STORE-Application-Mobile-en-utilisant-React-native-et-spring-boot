package ma.ensetstore.mobileprojectrestapi.exceptions;

public class AnnonceException extends RuntimeException {
    public AnnonceException(String message) {
        super(message);
    }

    public AnnonceException(String message, Throwable cause) {
        super(message, cause);
    }
}

