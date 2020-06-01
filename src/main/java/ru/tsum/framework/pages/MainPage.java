package ru.tsum.framework.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import ru.tsum.framework.pages.base.BasePage;

/**
 * Главная страница
 */
@DefaultUrl("http://tsum.ru")
public class MainPage extends BasePage {
    //  String labels
    public static final String PERSONAL_TITLE = "Личный кабинет";

    //  Element locators
    /**
     * Ссылка в Личный Кабинет (неавторизованный пользователь)
     */
    @FindBy(xpath = "//a[@href='/login/']")
    public WebElementFacade loginLink;

    /**
     * Ссылка в Личный Кабинет (авторизованный пользователь)
     */
    @FindBy(xpath = "//a[@href='/personal/orders/']")
    public WebElementFacade personalPageLink;

}
