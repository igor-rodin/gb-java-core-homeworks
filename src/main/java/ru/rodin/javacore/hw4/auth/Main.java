package ru.rodin.javacore.hw4.auth;

import ru.rodin.javacore.hw4.auth.exep.WrongLoginException;
import ru.rodin.javacore.hw4.auth.exep.WrongPasswordException;

public class Main {


    public static void main(String[] args) {
        String login = "login";
        String longLogin  = "loginloginloginloginloginloginlogin";
        String password = "password";
        String longPassword = "passwordpasswordpasswordpasswordpassword";
        String confirmPassword = "password";
        String notConfirmPassword = "passwor";

        try {
            System.out.println(Auth.register(login, password, notConfirmPassword));
            System.out.println(Auth.register(login, longPassword, confirmPassword));
            System.out.println(Auth.register(longLogin, password, confirmPassword));
            System.out.println(Auth.register(longLogin, password, confirmPassword));
        } catch (WrongLoginException e) {
            System.out.println(e.getMessage());
        } catch (WrongPasswordException e) {
            System.out.println(e.getMessage());
        }
        }
}
