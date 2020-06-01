package ru.tsum.framework.utils;

import org.openqa.selenium.WebElement;

/**
 * Вспомогательный класс для конвертации строковых значений с обозначением цветов в RGB и HEX форматах.
 */
public class RgbHexColorConvert {

    /**
     * Метод для конвертации строки с кодом цвета в hex-формате в RGBA формат.
     * Главным образом, полезен для работы с получением css-свойств у веб-элементов.
     * <p></p>
     * Используется для работы с методом из Selenium API {@link WebElement#getCssValue(String)}, который
     * возвращает значение цветов элементов в текстовом формате вида "<b>rgba(r, g, b, a)</b>".
     * <p></p>
     * На данный момент все результаты генерируются для вариантов цветов с alpha = 1.
     * <p>Примеры:</p>
     * <p> • #337AB7 -> rgba(51, 122, 183, 1) </p>
     * <p> • 337AB7 -> rgba(51, 122, 183, 1) </p>
     *
     * @param hexColor текстовое представление цвета в hex-формате (в формате #rrggbb или rrggbb)
     * @return текстовое представление цвета в rgba-формате (т.е. rgba(r, g, b, a))
     */
    public static String hexToRgba(String hexColor) {
        String result = hexColor.startsWith("#") ? hexColor.substring(1) : hexColor;
        String r = result.substring(0, 2);
        String g = result.substring(2, 4);
        String b = result.substring(4, 6);
        Integer rInt = Integer.parseInt(r, 16);
        Integer gInt = Integer.parseInt(g, 16);
        Integer bInt = Integer.parseInt(b, 16);
        return String.format("rgba(%d, %d, %d, 1)", rInt, gInt, bInt);
    }
}
