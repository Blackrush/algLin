package algLin;

public class IrregularSysLinException extends Exception {
    private String message;

    public IrregularSysLinException(String s) {
        message = s;
    }

    public String toString() {
        return message;
    }
}
