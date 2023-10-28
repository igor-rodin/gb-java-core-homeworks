package ru.rodin.javacore.hw4.auth;

public class Auth {


    public static boolean register(String login, String password, String confirmPassword) {
        boolean loginIsValid = Validator.validateLogin(login);
        boolean passwordIsValid = Validator.validatePassword(password, confirmPassword);
        return loginIsValid && passwordIsValid;
    }
}
