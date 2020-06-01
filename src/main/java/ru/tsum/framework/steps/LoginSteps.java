package ru.tsum.framework.steps;

import net.thucydides.core.annotations.Step;
import ru.tsum.framework.pages.auth.LoginPage;
import ru.tsum.framework.pages.MainPage;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static ru.tsum.framework.pages.auth.LoginPage.LOGIN_BUTTON_TEXT;

/**
 * Класс пользовательских действий, связанных с авторизацией.
 */
public class LoginSteps extends BaseSteps {

    MainPage mainPage;
    LoginPage loginPage;

    @Step("Открыть главную страницу")
    public void openMainPage() {
        mainPage.open();
    }

    @Step("Открыть страницу входа в Личный Кабинет по ссылке с Главной")
    public void openLoginPage() {
        mainPage.loginLink.click();
    }

    @Step("Авторизоваться в Личный Кабинет")
    public void login(String email, String password) {
        enterIntoTextField(loginPage.emailInput, email);
        enterIntoTextField(loginPage.passwordInput, password);

        loginPage.submitLoginButton.shouldBeEnabled();
        clickOnElement(loginPage.submitLoginButton);
    }

    @Step("Проверить только что открытую страницу Авторизации")
    public void validateOpenedLoginPage() {
        checkLoginPageElementsVisible();

        assertThat(loginPage.emailInput.getText(), is(""));
        assertThat(loginPage.passwordInput.getText(), is(""));

        loginPage.submitLoginButton.shouldNotBeEnabled();
        assertEquals(LOGIN_BUTTON_TEXT, loginPage.submitLoginButton.getText());
    }

    @Step("Проверить видимость основных элементов страницы Авторизации")
    public void checkLoginPageElementsVisible() {
        checkElementsVisible(Arrays.asList(
                loginPage.sectionTitle,
                loginPage.loginTab, loginPage.registerTab,
                loginPage.emailInput, loginPage.passwordInput,
                loginPage.showPassIcon, loginPage.forgetPassLink,
                loginPage.submitLoginButton,
                loginPage.facebookIcon, loginPage.twitterIcon, loginPage.vkIcon
        ));
    }
}
