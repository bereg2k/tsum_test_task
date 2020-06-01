package ru.tsum.framework.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.tsum.framework.pages.base.BasePage;

/**
 * Страница с Личным Кабинетом авторизованного пользователя.
 */
@DefaultUrl("http://www.tsum.ru/personal/orders/")
public class PersonalPage extends BasePage {
    //  String labels
    public static final String PERSONAL_TITLE = "Личный кабинет";
    public static final String ORDERS_TITLE = "Заказы";

    //  Element locators
    /**
     * Заголовок секции "Личный кабинет"
     */
    @FindBy(css = "div.ui-h1")
    public WebElementFacade sectionTitle;

    /**
     * Заголовок секции "Заказы"
     */
    @FindBy(css = "personal-orders h1")
    public WebElementFacade ordersTitle;

    /**
     * Вернуть веб-элемент главного меню по названию пункта
     *
     * @param itemText текст пункта меню
     * @return веб-элемент меню
     */
    public WebElementFacade getMenuItem(String itemText) {
        String itemXpath = "//a[@class='personal__nav-link'][contains(text(), '" + itemText + "')]";
        WebElementFacade menuItemElement = element((WebElement) getDriver().findElement(By.xpath(itemXpath)));
        menuItemElement.shouldBeVisible();
        return menuItemElement;
    }
}
