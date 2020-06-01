package tests.register;

import base.BaseTest;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.TestData;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.tsum.framework.pages.auth.LoginPage;
import ru.tsum.framework.pages.auth.RegisterPage;
import ru.tsum.framework.steps.LoginSteps;
import ru.tsum.framework.steps.RegisterSteps;

import java.util.Arrays;
import java.util.Collection;

import static ru.tsum.framework.pages.auth.LoginPage.HIGHLIGHT_HEX_COLOR;

/**
 * Тест-кейсы на проверку валидации поля email при Регистрации.
 */
@RunWith(SerenityParameterizedRunner.class)
public class RegisterNegativeEmailInputTest extends BaseTest {

    private String incorrectEmail;

    public RegisterNegativeEmailInputTest(String incorrectEmail) {
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
    RegisterPage registerPage;

    @Steps
    LoginSteps loginSteps;
    @Steps
    RegisterSteps registerSteps;

    @Test
    @Title("Проверка валидации некорректно введенного email при Регистрации")
    public void registerEmailValidationTest() {
        loginSteps.openMainPage();
        loginSteps.openLoginPage();
        loginSteps.clickOnElement(loginPage.registerTab);

        registerSteps.enterIntoTextField(registerPage.emailInput, incorrectEmail);
        registerSteps.clickOnElement(registerPage.passwordInput);

        //  Проверка цвета текста поля и его границы
        registerSteps.checkElementCssColor(registerPage.emailInput, HIGHLIGHT_HEX_COLOR);
        registerSteps.checkTextInputBorderColor(registerPage.emailInput, HIGHLIGHT_HEX_COLOR);
    }
}
