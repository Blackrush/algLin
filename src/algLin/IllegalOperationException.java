package algLin;

public class IllegalOperationException extends Exception {
    private String message;

    public IllegalOperationException(String s) {
        message = s;
    }

    public String toString() {
        return message;
    }
}
