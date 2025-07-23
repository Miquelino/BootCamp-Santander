package deBugAula.exception;

import javax.management.RuntimeMBeanException;

public class UserNotFoundExeption extends RuntimeException {

    public UserNotFoundExeption(final String message) {
        super(message);
    }
}
