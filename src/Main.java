import javax.swing.*;

public class Main {

    private static final String VALIDATE_PATTERN = "^[a-zA-Z0-9_]+s";

    public static void main(String[] args) {
        validate("login","pass", "pass" );
        validate("loinloinloinloinloin", "pass", "pass");
        validate("login", "pass", "pass2");
        validate("login", "passpasspasspasspasspass","pass");
        validate("login%%%%%%", "pass", "pass0");

    }

    public static Boolean validate(String login, String password, String confirmPassword) {
        boolean isValid = true;
        try {
            validateLogin(login);
            validatePassword(password, confirmPassword);
        } catch (WrongLoginException e) {
            System.out.println("ошибка с введенным логином: " + e.getMessage());
            isValid = false;
        } catch (WrongPasswordException e) {
            System.out.println("ошибка с введенным паролем : " + e.getMessage());

        isValid = false;

    }
        if(isValid) {
        System.out.println(" Логин и пароль корректные");
    }
        return isValid;
}


    public static void validateLogin(String login) throws WrongLoginException {
        if (!login.matches(VALIDATE_PATTERN)) {
            throw new WrongLoginException("Логин может содержать  себе только латинские буквы, цифры и знак подчеркивания.");
        }
        if (login.length() > 20) {
            throw new WrongLoginException("Логин не может быть длинее 20 символовю");
        }

    }

    public static void validatePassword(String password, String confirmPassword) throws WrongPasswordException {

        if (!password.matches(VALIDATE_PATTERN)) {


            throw new WrongPasswordException("Пароль может содержать  себе только латинские буквы, цифры и знак подчеркивания.");
        }
        if (password.length() > 20) {

            throw new WrongPasswordException("Пароль не может быть длинее 20 символов.");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароль не совпадает");
        }
    }
}