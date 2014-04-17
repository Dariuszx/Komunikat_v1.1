package gui.KExceptions;

public class MenuException extends Exception {

    private String message;

    public MenuException( String msg ) {
        this.message = msg;
    }

    @Override
    public String toString() {
        return message;
    }
}
