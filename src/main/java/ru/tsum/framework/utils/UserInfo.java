package ru.tsum.framework.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/**
 * Утилитарный класс получения данных пользователя (email и пароль) из файла ресурсов.
 * Данные для авторизации берутся из файла по тегу из вспомогательного класса {@link UserRoles}.
 */
public class UserInfo {
    /**
     * Относительный путь в проекте до файла ресурсов с пользовательскими данными
     */
    private static final String USERS_FILE_PATH = "/src/test/resources/users.csv";

    private String email;
    private String password;

    /**
     * Создать сущность с пользовательскими данными по значению "роли".
     *
     * @param role роль пользовательской записи. Указывает на назначение данных в контексте теста.
     *             (валидные данные, невалидные данные...)
     */
    public UserInfo(UserRoles role) {
        if (role == UserRoles.RANDOM) {
            generateNewUserInfo();
        } else {
            getUserInfoByRole(role.label);
        }
    }

    /**
     * Получить данные пользователя из файла ресурсов по предоставленной "роли".
     *
     * @param role роль пользовательской записи.
     */
    private void getUserInfoByRole(String role) {
        String filePath = new File("").getAbsolutePath() + USERS_FILE_PATH;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(role)) {
                    String[] lineSplit = line.split(";");
                    email = lineSplit[0];
                    password = lineSplit[1];
                    return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        throw new IllegalArgumentException("В списке не существует учетной записи с ролью \"" + role + "\"!");
    }

    /**
     * Генерация данных для нового пользователя с помощью (псевдо)случайных чисел.
     * В будущем можно заменить на более изощренный механизм для усиления разброса возможных вариантов.
     */
    private void generateNewUserInfo() {
        email = "xineg" + new Random().nextInt(9999) + "@dffwer.com";
        password = "password123";
    }

    /**
     * Получить email из учетной записи пользователя.
     *
     * @return email учетной записи пользователя.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Получить пароль из учетной записи пользователя.
     *
     * @return пароль учетной записи пользователя.
     */
    public String getPassword() {
        return password;
    }
}
