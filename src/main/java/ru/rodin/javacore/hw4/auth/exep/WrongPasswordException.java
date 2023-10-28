package ru.rodin.javacore.hw4.auth.exep;

public class WrongPasswordException extends RuntimeException {

    public static final String SHORT_ERROR_MSG = "Пароль слишком длинный или пароли не совпадают";
    public static final String FULL_ERROR_MSG = " Пароль %s превышает %d символов";
    public static final String PASSWORDS_NOT_EQUALS_ERROR_MSG  = " Пароли не совпадают";
    private int maxLength;
    private String password;
    private boolean isPasswordsEqual;

    public WrongPasswordException() {
        super(SHORT_ERROR_MSG);
    }

    public WrongPasswordException(String password, int maxLength, boolean isPasswordsEqual) {
        super();
        this.maxLength = maxLength;
        this.password = password;
        this.isPasswordsEqual = isPasswordsEqual;
    }

    @Override
    public String getMessage() {
        String message;
        if (isPasswordsEqual) {
            message = String.format(FULL_ERROR_MSG, this.password, this.maxLength);
        } else {
            message = PASSWORDS_NOT_EQUALS_ERROR_MSG;
        }
        return super.getMessage() + message;
    }
}
