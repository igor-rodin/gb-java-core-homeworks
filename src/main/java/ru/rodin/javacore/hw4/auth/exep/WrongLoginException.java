package ru.rodin.javacore.hw4.auth.exep;

public class WrongLoginException extends RuntimeException{
    public static final String SHORT_ERROR_MSG = "Логин слишком длинный";
    public static final String FULL_ERROR_MSG = "Логин %s превышает %d символов";
    private int maxLength;
    private String login;
    public WrongLoginException(){
        super(SHORT_ERROR_MSG);
    }
    public WrongLoginException(String login, int maxLength){
        super();
        this.maxLength = maxLength;
        this.login = login;
    }

    @Override
    public String getMessage(){
        return String.format(FULL_ERROR_MSG, this.login, this.maxLength);
    }
}
