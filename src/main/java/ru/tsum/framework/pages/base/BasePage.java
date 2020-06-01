package ru.tsum.framework.pages.base;

import net.thucydides.core.pages.PageObject;

/**
 * Класс базовой страницы, потенциально определяющий некоторые методы для наследников.
 * <p></p>
 * На данный момент выделен в качестве общего родителя для всех страниц и сделан не-абстрактным
 * для обеспечения работы по ссылке в методах класса {@link ru.tsum.framework.steps.BaseSteps}.
 */
public class BasePage extends PageObject {
}
