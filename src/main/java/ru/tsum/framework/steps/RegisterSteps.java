package ru.tsum.framework.steps;

import net.thucydides.core.annotations.Step;
import ru.tsum.framework.pages.auth.PostRegisterPage;
import ru.tsum.framework.pages.auth.RegisterPage;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static ru.tsum.framework.pages.auth.PostRegisterPage.*;
import static ru.tsum.framework.pages.auth.RegisterPage.REGISTER_BUTTON_TEXT;
import static ru.tsum.framework.pages.auth.RegisterPage.TERMS_LINK_TEXT;

/**
 * Класс пользовательских действий, связанных с регистрацией.
 */
public class RegisterSteps extends BaseSteps {

    RegisterPage registerPage;
    PostRegisterPage postRegisterPage;

    @Step("Зарегистрировать новую учетную запись с email '{0}'")
    public void register(String email, String password) {
        enterIntoTextField(registerPage.emailInput, email);
        enterIntoTextField(registerPage.passwordInput, password);

        registerPage.submitRegisterButton.shouldBeEnabled();
        clickOnElement(registerPage.submitRegisterButton);
    }

    @Step("Проверить только что открытую страницу Регистрации")
    public void validateOpenedRegisterPage() {
        checkRegisterPageElementsVisible();

        assertThat(registerPage.emailInput.getText(), is(""));
        assertThat(registerPage.passwordInput.getText(), is(""));

        registerPage.submitRegisterButton.shouldNotBeEnabled();
        assertEquals(REGISTER_BUTTON_TEXT, registerPage.submitRegisterButton.getText());

        assertEquals(TERMS_LINK_TEXT, registerPage.termsLink.getText());
    }

    @Step("Проверить видимость основных элементов страницы Регистрации")
    public void checkRegisterPageElementsVisible() {
        checkElementsVisible(Arrays.asList(
                registerPage.sectionTitle,
                registerPage.loginTab, registerPage.registerTab,
                registerPage.emailInput, registerPage.passwordInput,
                registerPage.showPassIcon,
                registerPage.termsLink,
                registerPage.submitRegisterButton,
                registerPage.facebookIcon, registerPage.twitterIcon, registerPage.vkIcon
        ));
    }

    @Step("Проверить только что открытую страницу после Регистрации")
    public void validatePostRegisterPage() {
        checkPostRegisterPageElementsVisible();

        assertEquals(MEN_OPTION_TEXT, postRegisterPage.menSubscribeOption.getText());
        assertEquals(WOMEN_OPTION_TEXT, postRegisterPage.womenSubscribeOption.getText());
        assertEquals(SUBSCRIBE_LABEL_TEXT, postRegisterPage.subscribeLabel.getText());
        assertEquals(POLICY_LINK_TEXT, postRegisterPage.policyConfidentialLink.getText());
    }


    @Step("Проверить видимость основных элементов страницы после Регистрации")
    public void checkPostRegisterPageElementsVisible() {
        checkElementsVisible(Arrays.asList(
                postRegisterPage.sectionTitle,
                postRegisterPage.menSubscribeOption,
                postRegisterPage.womenSubscribeOption,
                postRegisterPage.subscribeLabel, postRegisterPage.policyConfidentialLink
        ));
    }

    @Step("Выбрать подписку на мужскую коллекцию")
    public void chooseSubscriptionForMen() {
        postRegisterPage.menSubscribeOption.click();
    }

    @Step("Выбрать подписку на женскую коллекцию")
    public void chooseSubscriptionForWomen() {
        postRegisterPage.womenSubscribeOption.click();
    }
}
