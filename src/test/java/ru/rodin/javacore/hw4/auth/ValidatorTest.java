package ru.rodin.javacore.hw4.auth;

import org.junit.jupiter.api.Test;
import ru.rodin.javacore.hw4.auth.exep.WrongLoginException;
import ru.rodin.javacore.hw4.auth.exep.WrongPasswordException;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    void testLoginIsValid() {
        String login = "login";
        boolean loginIsValid = Validator.validateLogin(login);
        assertTrue(loginIsValid);
    }
    @Test
    void testEmpty() {
        String login = "";
        boolean loginIsValid = Validator.validateLogin(login);
        assertFalse(loginIsValid);
    }
    @Test
    void testLoginToLong() {
        String login = "loginloginloginloginlogin";
        assertThrows(WrongLoginException.class, () -> {
            Validator.validateLogin(login);
        });
    }



    @Test
    void testPasswordsMatches() {
        String password = "password";
        String confirmPassword = "password";
        boolean passwordIsValid = Validator.validatePassword(password, confirmPassword);
        assertTrue(passwordIsValid);
    }

    @Test
    void testPasswordEmpty() {
        String password = "";
        String confirmPassword = "password";
        boolean passwordIsValid = Validator.validatePassword(password, confirmPassword);
        assertFalse(passwordIsValid);
    }

    @Test
    void testPasswordToLong() {
        String password = "loginloginloginloginlogin";
        assertThrows(WrongPasswordException.class, () -> {
            Validator.validatePassword(password, "password");
        });
    }

    @Test
    void testPasswordNotEquals() {
        String password = "loginloginloginloginlogin";
        String passwordConfirm = "loginloginloginlogin";
        assertThrows(WrongPasswordException.class, () -> {
            Validator.validatePassword(password, passwordConfirm);
        });
    }

}