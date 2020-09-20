package sda.finalProject.Budget.exception;

public class UserLoginExistException extends RuntimeException{
    private final static String MESSAGE = "There is a user with login: ";
    public UserLoginExistException(String login) {
        super(MESSAGE + login);
    }
}
