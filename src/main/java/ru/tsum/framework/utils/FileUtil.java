package ru.tsum.framework.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import static org.apache.commons.io.FileUtils.writeStringToFile;

/**
 * Утилитарный класс для работы с файлами.
 */
public class FileUtil {
    private static final String REGISTERED_USERS_FILE_PATH = "/src/test/resources/registeredUsers.csv";

    public static final Logger LOG = LoggerFactory.getLogger(FileUtil.class);

    /**
     * Добавить успешно зарегистрированного пользователя в файл со списком зарегистрированных пользователей.
     *
     * @param email    электронная почта пользователя
     * @param password пароль пользователя
     */
    public static void addRegisteredUserInfoToFile(String email, String password) {
        File file = new File(System.getProperty("user.dir") + REGISTERED_USERS_FILE_PATH);
        String userData = email + ";" + password + "\n";

        //  если вдруг файл не найден/недоступен для записи,
        //  то пишем данные по зарегистрированному пользователю в лог консоли
        if (!file.canWrite()) {
            LOG.error("Файл для записи зарегистрированных пользователей не найден! " +
                    "Произведена регистрация нового пользователя c данными: " + userData);
            return;
        }

        try {
            writeStringToFile(file, userData, Charset.defaultCharset(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
