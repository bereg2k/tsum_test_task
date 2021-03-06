package ru.tsum.framework.utils;

/**
 * Вспомогательный класс для обеспечения работы класса по получения данных пользователя из файла ресурсов.
 * Работает в связке с {@link UserInfo}, предоставляя более удобный варианты работы с запросами данных пользователя
 * чем напрямую через строковые значения ролей из файла с пользовательскими данными.
 * <p></p>
 * При любом изменении в файле с данными пользователя, нужно своевременно актуализировать и данный список.
 */
public enum UserRoles {
    /**
     * Пользователь существует в системе, данные валидные по формату
     */
    VALID("valid"),

    /**
     * Пользователь существует в системе, некорректный пароль
     */
    INCORRECT_PASS("incorrectPass"),

    /**
     * Пользователь не существует в системе, данные валидные по формату
     */
    NON_EXISTENT("non-existent"),

    /**
     * Пользователь существует в системе, невалидный по формату email
     */
    INVALID_EMAIL("invalidEmail"),

    /**
     * Пользователь существует в системе, невалидный по формату пароль
     */
    INVALID_PASS("invalidPass"),

    /**
     * Генерация новых данных пользователя, данные валидные по формату
     */
    RANDOM("random");

    public final String label;

    UserRoles(String label) {
        this.label = label;
    }
}
