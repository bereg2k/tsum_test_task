package ru.tsum.framework.steps;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebElement;
import ru.tsum.framework.pages.base.BasePage;

import java.util.List;

import static java.lang.String.format;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static ru.tsum.framework.utils.CssProperty.*;
import static ru.tsum.framework.utils.RgbHexColorConvert.hexToRgba;

/**
 * Базовый класс пользовательских действий, обладающий некоторыми общими полезными методами.
 * Присутствие обёрток для стандартных методов PageObject необходимо для более детальной отчетности.
 */
public abstract class BaseSteps {
    // Error messages
    protected static final String ELEMENT_NOT_VISIBLE_FORMAT = "Элемент %s не отображается на экране!";
    protected static final String INCORRECT_COLOR = " имеет некорректный цвет!";
    protected static final String BORDER_TOP = "Верхняя граница поля";
    protected static final String BORDER_BOTTOM = "Нижняя граница поля";
    protected static final String BORDER_LEFT = "Левая граница поля";
    protected static final String BORDER_RIGHT = "Правая граница поля";
    protected static final String ELEMENT = "Элемент";

    BasePage page;

    @Step("Ввести текст '{1}' в поле '{0}'")
    public void enterIntoTextField(WebElement element, String text) {
        page.typeInto(element, text);
    }

    @Step("Нажать по элементу '{0}'")
    public void clickOnElement(WebElement element) {
        page.clickOn(element);
    }

    @Step("Проверить, что ожидаемое значение текста в элементе '{1}' равно фактическому '{0}'")
    public void assertText(String expected, WebElement actualElement) {
        assertEquals(expected, actualElement.getText());
    }

    @Step("Проверить видимость элемента '{0}'")
    public void checkElementVisible(WebElementFacade element) {
        assertTrue(format(ELEMENT_NOT_VISIBLE_FORMAT, element), element.isVisible());
    }

    @Step("Проверить видимость списка элементов '{0}'")
    public void checkElementsVisible(List<WebElementFacade> elements) {
        for (WebElementFacade element : elements) {
            checkElementVisible(element);
        }
    }

    @Step("Проверить цвет '{1}' элемента '{0}'")
    public void checkElementCssColor(WebElement element, String expectedHexColor) {
        String expectedRgbaColor = hexToRgba(expectedHexColor);

        assertEquals(ELEMENT + INCORRECT_COLOR,
                expectedRgbaColor, element.getCssValue(COLOR.property));
    }

    @Step("Проверить цвет границы '{1}' текстового поля элемента '{0}'")
    public void checkTextInputBorderColor(WebElement textInput, String expectedHexColor) {
        String expectedRgbaColor = hexToRgba(expectedHexColor);

        assertEquals(BORDER_TOP + INCORRECT_COLOR,
                expectedRgbaColor, textInput.getCssValue(BORDER_TOP_COLOR.property));
        assertEquals(BORDER_BOTTOM + INCORRECT_COLOR,
                expectedRgbaColor, textInput.getCssValue(BORDER_BOTTOM_COLOR.property));
        assertEquals(BORDER_LEFT + INCORRECT_COLOR,
                expectedRgbaColor, textInput.getCssValue(BORDER_LEFT_COLOR.property));
        assertEquals(BORDER_RIGHT + INCORRECT_COLOR,
                expectedRgbaColor, textInput.getCssValue(BORDER_RIGHT_COLOR.property));
    }
}
