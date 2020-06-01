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
import ru.tsum.framework.pages.auth.RegisterPage;
import ru.tsum.framework.steps.LoginSteps;
import ru.tsum.framework.steps.RegisterSteps;
import ru.tsum.framework.utils.UserInfo;
import ru.tsum.framework.utils.UserRoles;

import static ru.tsum.framework.pages.auth.AuthPage.*;

/**
 * Тест-кейсы на сценарии Регистрации пользователя (негативные).
 */
@RunWith(SerenityRunner.class)
public class RegisterNegativeTest extends BaseTest {

    LoginPage loginPage;
    RegisterPage registerPage;

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
    @Title("Регистрация пользователя с ранее зарегистрированным email")
    public void registerExistentUserTest() {
        UserInfo userInfo = new UserInfo(UserRoles.VALID);

        registerSteps.register(userInfo.getEmail(), userInfo.getPassword());

        registerSteps.assertText(EMAIL_EXIST_REG_ERR, registerPage.errorDialog);
    }

    @Test
    @Title("Регистрация незарегистрированным пользователем с невалидным email")
    public void registerInvalidEmailTest() {
        UserInfo userInfo = new UserInfo(UserRoles.INVALID_EMAIL);

        registerSteps.register(userInfo.getEmail(), userInfo.getPassword());

        registerSteps.assertText(INCORRECT_EMAIL_ERR, registerPage.errorDialog);
        //  Проверка цвета текста поля и его границы
        registerSteps.checkElementCssColor(registerPage.emailInput, HIGHLIGHT_HEX_COLOR);
        registerSteps.checkTextInputBorderColor(registerPage.emailInput, HIGHLIGHT_HEX_COLOR);
    }

    @Test
    @Title("Регистрация незарегистрированным пользователем с невалидным паролем")
    public void registerInvalidPasswordTest() {
        UserInfo userInfo = new UserInfo(UserRoles.INVALID_PASS);

        registerSteps.register(userInfo.getEmail(), userInfo.getPassword());

        registerSteps.assertText(PASS_SHORT_REG_ERR, registerPage.errorDialog);
        //  Проверка цвета текста поля и его границы
        registerSteps.checkElementCssColor(registerPage.passwordInput, HIGHLIGHT_HEX_COLOR);
        registerSteps.checkTextInputBorderColor(registerPage.passwordInput, HIGHLIGHT_HEX_COLOR);
    }
}
