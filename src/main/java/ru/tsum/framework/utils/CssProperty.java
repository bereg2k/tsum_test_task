package ru.tsum.framework.utils;

import ru.tsum.framework.steps.BaseSteps;

/**
 * Вспомогательный класс-коллекция значений для проверки различных css свойств веб-элементов.
 * Используется для проверок из класса {@link BaseSteps}
 */
public enum CssProperty {
    COLOR("color"),
    BORDER_TOP_COLOR("border-top-color"),
    BORDER_BOTTOM_COLOR("border-bottom-color"),
    BORDER_LEFT_COLOR("border-left-color"),
    BORDER_RIGHT_COLOR("border-right-color");

    public final String property;

    CssProperty(String property) {
        this.property = property;
    }
}
