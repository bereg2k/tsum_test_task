package ru.tsum.framework.pages.auth;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

/**
 * Страница Регистрации в Личный Кабинет
 */
@DefaultUrl("http://tsum.ru/registration")
public class RegisterPage extends AuthPage {
    //  String labels
    public static final String TERMS_LINK_TEXT = "Правила продажи товаров";
    public static final String REGISTER_BUTTON_TEXT = "Зарегистрироваться";

    //  Element locators
    /**
     * Поле ввода email
     */
    @FindBy(xpath = "//auth-register//input[@formcontrolname='email']")
    public WebElementFacade emailInput;

    /**
     * Поле ввода пароля
     */
    @FindBy(xpath = "//auth-register//input[@formcontrolname='password']")
    public WebElementFacade passwordInput;

    /**
     * Кнопка показа/скрытия вводимых символов для пароля
     */
    @FindBy(xpath = "//auth-register//div[@class='eye-pwd']")
    public WebElementFacade showPassIcon;

    /**
     * Ссылка на текст Правил продажи товаров
     */
    @FindBy(css = "auth-register a")
    public WebElementFacade termsLink;

    /**
     * Кнопка "Зарегистрироваться"
     */
    @FindBy(xpath = "//auth-register//button")
    public WebElementFacade submitRegisterButton;

}
