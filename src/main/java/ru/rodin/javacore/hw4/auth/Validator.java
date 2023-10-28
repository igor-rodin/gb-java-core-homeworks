package ru.rodin.javacore.hw4.auth;

import ru.rodin.javacore.hw4.auth.exep.WrongLoginException;
import ru.rodin.javacore.hw4.auth.exep.WrongPasswordException;

public class Validator {
    private static final int MAX_LOGIN_SIZE = 20;
    public static boolean validateLogin(String login) {
        if (login.isEmpty()) {
            return false;
        }
        if (login.length() > MAX_LOGIN_SIZE) {
            throw new WrongLoginException(login, MAX_LOGIN_SIZE);
        }

        return true;
    }

    public static boolean validatePassword(String password, String confirmPassword) {
        if (password.isEmpty() || confirmPassword.isEmpty()) {
            return false;
        }

        boolean isPasswordsEqual = password.equals(confirmPassword);
        if (password.length() > MAX_LOGIN_SIZE) {
            throw new WrongPasswordException(password, MAX_LOGIN_SIZE, isPasswordsEqual);
        }
        if (!isPasswordsEqual) {
            throw new WrongPasswordException(password, MAX_LOGIN_SIZE, false);
        }
        return true;
    }

}
