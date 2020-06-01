package tests.login;

import base.BaseTest;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.TestData;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.tsum.framework.pages.auth.LoginPage;
import ru.tsum.framework.steps.LoginSteps;

import java.util.Arrays;
import java.util.Collection;

import static ru.tsum.framework.pages.auth.LoginPage.HIGHLIGHT_HEX_COLOR;

/**
 * Тест-кейсы на проверку валидации поля email при Авторизации
 */
@RunWith(SerenityParameterizedRunner.class)
public class LoginNegativeEmailInputTest extends BaseTest {

    private String incorrectEmail;

    public LoginNegativeEmailInputTest(String incorrectEmail) {
        this.incorrectEmail = incorrectEmail;
    }

    @TestData(columnNames = "Значение для поля email")
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {"user@domain"}, {"@domain.com"},
                {"user@doma@in.com"}, {"userdomain.com"},
                {"user@domain.c"}, {"user@.com"},
                {"user@domain..com"}, {"user@domain,com"}
        });
    }

    LoginPage loginPage;

    @Steps
    LoginSteps loginSteps;

    @Test
    @Title("Проверка валидации некорректно введенного email при Авторизации")
    public void loginEmailValidationTest() {
        loginSteps.openMainPage();
        loginSteps.openLoginPage();
        loginSteps.enterIntoTextField(loginPage.emailInput, incorrectEmail);
        loginSteps.clickOnElement(loginPage.passwordInput);

        //  Проверка цвета текста поля и его границы
        loginSteps.checkElementCssColor(loginPage.emailInput, HIGHLIGHT_HEX_COLOR);
        loginSteps.checkTextInputBorderColor(loginPage.emailInput, HIGHLIGHT_HEX_COLOR);
    }
}
