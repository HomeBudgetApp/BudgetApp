package sda.finalProject.Budget.exception;

public class InputsCannotBeEmptyException extends RuntimeException {

    private static final String MESSAGE = "Text areas cannot be empty.";
    public InputsCannotBeEmptyException(){
        super(MESSAGE);
    }
}
