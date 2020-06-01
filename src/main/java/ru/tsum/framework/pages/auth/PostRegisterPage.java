package ru.tsum.framework.pages.auth;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import ru.tsum.framework.pages.base.BasePage;

/**
 * Страница выбора предпочтений и подписки на новости, после регистрации
 */
public class PostRegisterPage extends BasePage {
    //  String labels
    public static final String MEN_OPTION_TEXT = "Мужское";
    public static final String WOMEN_OPTION_TEXT = "Женское";
    public static final String SUBSCRIBE_LABEL_TEXT = "Подписаться на новости ЦУМ";
    public static final String POLICY_LINK_TEXT = "Политика конфиденциальности";

    //  Element locators
    @FindBy(css = "auth-layout div.ui-h2.ng-star-inserted")
    public WebElementFacade sectionTitle;

    @FindBy(css = "auth-register span.subscribe__men_label")
    public WebElementFacade menSubscribeOption;

    @FindBy(css = "auth-register span.subscribe__women_label")
    public WebElementFacade womenSubscribeOption;

    @FindBy(css = "auth-register div.ui-checkbox__label span")
    public WebElementFacade subscribeLabel;

    @FindBy(css = "auth-register div.ui-checkbox__label a")
    public WebElementFacade policyConfidentialLink;

}
