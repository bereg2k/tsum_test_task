package ru.tsum.framework.pages.auth;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

/**
 * Страница Авторизации в Личный Кабинет
 */
@DefaultUrl("http://tsum.ru/login")
public class LoginPage extends AuthPage {
    //  String labels
    public static final String LOGIN_BUTTON_TEXT = "Войти";

    //  Element locators
    /**
     * Поле ввода email
     */
    @FindBy(xpath = "//auth-login//input[@formcontrolname='email']")
    public WebElementFacade emailInput;

    /**
     * Поле ввода пароля
     */
    @FindBy(xpath = "//auth-login//input[@formcontrolname='password']")
    public WebElementFacade passwordInput;

    /**
     * Кнопка показа/скрытия вводимых символов для пароля
     */
    @FindBy(xpath = "//auth-login//div[@class='eye-pwd']")
    public WebElementFacade showPassIcon;

    /**
     * Ссылка "Забыли пароль?"
     */
    @FindBy(css = "a.forget-pwd")
    public WebElementFacade forgetPassLink;

    /**
     * Кнопка "Войти"
     */
    @FindBy(xpath = "//auth-login//button")
    public WebElementFacade submitLoginButton;

}
