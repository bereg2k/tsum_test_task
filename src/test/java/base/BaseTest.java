package base;

import net.thucydides.core.annotations.Managed;
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
        String pathToDriverBinary = System.getProperty("user.dir") + "/driver/chromedriver";
        System.setProperty("webdriver.chrome.driver", pathToDriverBinary);
        driver.manage().window().maximize();
    }
}
