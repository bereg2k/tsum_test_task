package tests.register;

import base.BaseTest;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.tsum.framework.pages.auth.LoginPage;
import ru.tsum.framework.pages.MainPage;
import ru.tsum.framework.steps.LoginSteps;
import ru.tsum.framework.steps.RegisterSteps;
import ru.tsum.framework.utils.UserInfo;
import ru.tsum.framework.utils.UserRoles;

import static org.junit.Assert.assertEquals;
import static ru.tsum.framework.utils.FileUtil.addRegisteredUserInfoToFile;

/**
 * Тест-кейсы на сценарии Регистрации пользователя (позитивные).
 */
@RunWith(SerenityRunner.class)
public class RegisterPositiveTest extends BaseTest {

    MainPage mainPage;
    LoginPage loginPage;

    @Steps
    LoginSteps loginSteps;
    @Steps
    RegisterSteps registerSteps;

    @Before
    @Title("Открытие формы регистрации")
    public void openRegisterForm() {
        loginSteps.openMainPage();
        loginSteps.openLoginPage();
        loginSteps.clickOnElement(loginPage.registerTab);
    }

    @Test
    @Title("Проверка содержимого страницы регистрации")
    public void checkRegisterPageContentsTest() {
        registerSteps.validateOpenedRegisterPage();
    }

    @Test
    @Title("Регистрация нового пользователя с ранее незарегистрированным email")
    public void registerNewValidUserTest() {
        UserInfo userInfo = new UserInfo(UserRoles.RANDOM);

        registerSteps.register(userInfo.getEmail(), userInfo.getPassword());

        //  сохранить данные по зарегистированному пользователю для дальнейшей чистки
        addRegisteredUserInfoToFile(userInfo.getEmail(), userInfo.getPassword());

        registerSteps.validatePostRegisterPage();
        registerSteps.chooseSubscriptionForMen();

        registerSteps.assertText(userInfo.getEmail(), mainPage.personalPageLink);
    }
}
