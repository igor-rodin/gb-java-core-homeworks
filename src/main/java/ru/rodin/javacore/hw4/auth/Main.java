package ru.rodin.javacore.hw4.auth;

import ru.rodin.javacore.hw4.auth.exep.WrongLoginException;
import ru.rodin.javacore.hw4.auth.exep.WrongPasswordException;

public class Main {


    public static void main(String[] args) {
        String login = "login";
        String longLogin = "loginloginloginloginloginloginlogin";
        String password = "password";
        String longPassword = "passwordpasswordpasswordpasswordpassword";
        String confirmPassword = "password";
        String notConfirmPassword = "passwor";

        try {
            System.out.println(Auth.validateCredentials(longLogin, password, confirmPassword));
            System.out.println(Auth.validateCredentials(login, password, notConfirmPassword));
            System.out.println(Auth.validateCredentials(login, longPassword, confirmPassword));
            System.out.println(Auth.validateCredentials(longLogin, password, confirmPassword));
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        }
    }
}
