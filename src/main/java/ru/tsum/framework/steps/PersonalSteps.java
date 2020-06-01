package ru.tsum.framework.steps;

import net.thucydides.core.annotations.Step;
import ru.tsum.framework.pages.MainPage;
import ru.tsum.framework.pages.PersonalPage;

/**
 * Класс пользовательских действий, связанных с работой с Личным Кабинетом.
 */
public class PersonalSteps extends BaseSteps {
    //  String labels
    private static final String LOGOUT_TEXT = "Выход";

    MainPage mainPage;
    PersonalPage personalPage;

    @Step("Нажать на ссылку в Личный Кабинет на Главной Странице")
    public void openPersonalPageFromMainPage() {
        mainPage.personalPageLink.click();
    }

    @Step("Выбрать пункт меню '{0}'")
    public void clickMenuItem(String menuItem) {
        personalPage.getMenuItem(menuItem).click();
    }

    @Step("Выйти из личного кабинета")
    public void logout() {
        clickMenuItem(LOGOUT_TEXT);
    }
}
