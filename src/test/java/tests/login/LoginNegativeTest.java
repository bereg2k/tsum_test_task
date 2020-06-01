package tests.login;

import base.BaseTest;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.tsum.framework.pages.auth.LoginPage;
import ru.tsum.framework.steps.LoginSteps;
import ru.tsum.framework.utils.UserInfo;
import ru.tsum.framework.utils.UserRoles;

import static org.junit.Assert.assertEquals;
import static ru.tsum.framework.pages.auth.LoginPage.*;

/**
 * Тест-кейсы на сценарии Авторизации пользователя (негативные).
 */
@RunWith(SerenityRunner.class)
public class LoginNegativeTest extends BaseTest {

    LoginPage loginPage;

    @Steps
    LoginSteps loginSteps;

    @Before
    public void openMain() {
        loginSteps.openMainPage();
    }

    @Test
    @Title("Авторизация незарегистрированным пользователем")
    public void loginNonExistUserTest() {
        UserInfo userInfo = new UserInfo(UserRoles.NON_EXISTENT);

        loginSteps.openLoginPage();
        loginSteps.login(userInfo.getEmail(), userInfo.getPassword());
        loginSteps.assertText(INCORRECT_LOGIN_PASS_ERR, loginPage.errorDialog);
    }

    @Test
    @Title("Авторизация зарегистрированным пользователем с некорректным паролем")
    public void loginIncorrectPasswordTest() {
        UserInfo userInfo = new UserInfo(UserRoles.INCORRECT_PASS);

        loginSteps.openLoginPage();
        loginSteps.login(userInfo.getEmail(), userInfo.getPassword());
        loginSteps.assertText(INCORRECT_LOGIN_PASS_ERR, loginPage.errorDialog);
    }

    @Test
    @Title("Авторизация зарегистрированным пользователем с невалидным email")
    public void loginInvalidEmailTest() {
        UserInfo userInfo = new UserInfo(UserRoles.INVALID_EMAIL);

        loginSteps.openLoginPage();
        loginSteps.login(userInfo.getEmail(), userInfo.getPassword());

        loginSteps.assertText(INCORRECT_EMAIL_ERR, loginPage.errorDialog);
        //  Проверка цвета текста поля и его границы
        loginSteps.checkElementCssColor(loginPage.emailInput, HIGHLIGHT_HEX_COLOR);
        loginSteps.checkTextInputBorderColor(loginPage.emailInput, HIGHLIGHT_HEX_COLOR);
    }
}
