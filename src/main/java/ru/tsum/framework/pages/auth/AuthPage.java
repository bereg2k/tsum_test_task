package ru.tsum.framework.pages.auth;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import ru.tsum.framework.pages.base.BasePage;

/**
 * Объединенная страница Авторизации и Регистрации.
 * Содержит несколько общих элементов по дизайну + свойства и тексты ошибок.
 */
public abstract class AuthPage extends BasePage {
    //  Error messages
    public static final String INCORRECT_EMAIL_ERR = "Указан некорректный email";
    public static final String INCORRECT_LOGIN_PASS_ERR = "Неверный логин или пароль";
    public static final String EMAIL_EXIST_REG_ERR = "Пользователь с таким email уже существует.";
    public static final String PASS_SHORT_REG_ERR = "Пароль должен быть не менее 8 символов длиной";

    //  Properties
    /**
     * Красно-оранжевый цвет для выделения активных полей и подсвечивания ошибок.
     */
    public static final String HIGHLIGHT_HEX_COLOR = "#f94f0d";

    //  Element locators
    /**
     * Заголовок секции "Личный кабинет"
     */
    @FindBy(css = "div.ui-h2.ng-star-inserted")
    public WebElementFacade sectionTitle;

    /**
     * Вкладка "Авторизация"
     */
    @FindBy(css = "p.auth-layout__control-button.first")
    public WebElementFacade loginTab;

    /**
     * Вкладка "Регистрация"
     */
    @FindBy(css = "p.auth-layout__control-button.last")
    public WebElementFacade registerTab;

    /**
     * Иконка авторизации через Facebook
     */
    @FindBy(css = "div.social-icon.facebook-icon")
    public WebElementFacade facebookIcon;

    /**
     * Иконка авторизации через Twitter
     */
    @FindBy(css = "div.social-icon.twitter-icon")
    public WebElementFacade twitterIcon;

    /**
     * Иконка авторизации через VK
     */
    @FindBy(css = "div.social-icon.vk-icon")
    public WebElementFacade vkIcon;

    /**
     * Текст диалога с ошибкой
     */
    @FindBy(css = "div.notice.error span")
    public WebElementFacade errorDialog;

}
