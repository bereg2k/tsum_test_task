package tests.login;

import base.BaseTest;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.tsum.framework.pages.MainPage;
import ru.tsum.framework.pages.PersonalPage;
import ru.tsum.framework.steps.LoginSteps;
import ru.tsum.framework.steps.PersonalSteps;
import ru.tsum.framework.utils.UserInfo;
import ru.tsum.framework.utils.UserRoles;

/**
 * Тест-кейсы на сценарии Авторизации пользователя (позитивные).
 */
@RunWith(SerenityRunner.class)
public class LoginPositiveTest extends BaseTest {

    MainPage mainPage;
    PersonalPage personalPage;

    @Steps
    LoginSteps loginSteps;
    @Steps
    PersonalSteps personalSteps;

    @Before
    public void openMain() {
        loginSteps.openMainPage();
    }

    @Test
    @Title("Проверка наличия ссылки в личный кабинет из главной страницы")
    public void checkLoginPageLinkFromMainPageTest() {
        loginSteps.checkElementVisible(mainPage.loginLink);
        loginSteps.assertText(MainPage.PERSONAL_TITLE, mainPage.loginLink);
    }

    @Test
    @Title("Проверка содержимого страницы авторизации")
    public void checkLoginPageContentsTest() {
        loginSteps.openLoginPage();
        loginSteps.validateOpenedLoginPage();
    }

    @Test
    @Title("Авторизация зарегистрированным пользователем")
    public void loginValidUserTest() {
        UserInfo userInfo = new UserInfo(UserRoles.VALID);

        loginSteps.openLoginPage();
        loginSteps.login(userInfo.getEmail(), userInfo.getPassword());
        loginSteps.assertText(userInfo.getEmail(), mainPage.personalPageLink);

        personalSteps.openPersonalPageFromMainPage();
        personalSteps.assertText(PersonalPage.PERSONAL_TITLE, personalPage.sectionTitle);
        personalSteps.assertText(PersonalPage.ORDERS_TITLE, personalPage.ordersTitle);
    }

    @Test
    @Title("Выйти из Личного Кабинета зарегистированного пользователя")
    public void logoutValidUserTest() {
        loginValidUserTest();

        personalSteps.logout();

        personalSteps.assertText(MainPage.PERSONAL_TITLE, mainPage.loginLink);
    }
}
