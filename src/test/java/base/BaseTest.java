package base;

import net.thucydides.core.annotations.Managed;
import org.apache.commons.lang3.SystemUtils;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

/**
 * Класс для базового теста.
 */
public abstract class BaseTest {

    @Managed(driver = "chrome")
    WebDriver driver;

    @Before
    public void initWebDriver() {
        System.setProperty("webdriver.chrome.driver", driverPathForOs());
        driver.manage().window().maximize();
    }

    /**
     * Определение используемого бинарного файла для веб-драйвера в зависимости от используемой ОС.
     *
     * @return путь к проектной папке с нужным веб-драйвером
     * @throws IllegalArgumentException если для ОС пользователя нет веб-драйверов в проекте
     */
    private static String driverPathForOs() {
        String pathToDriverBinary;

        if (SystemUtils.IS_OS_MAC) {
            pathToDriverBinary = "/driver/chromedriver_mac";
        } else if (SystemUtils.IS_OS_WINDOWS) {
            pathToDriverBinary = "/driver/chromedriver.exe";
        } else if (SystemUtils.IS_OS_LINUX) {
            pathToDriverBinary = "/driver/chromedriver_linux";
        } else {
            throw new IllegalArgumentException("No available WebDriver for current OS!");
        }

        return System.getProperty("user.dir") + pathToDriverBinary;
    }
}
