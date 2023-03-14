package framework;

import org.testng.annotations.*;


@Listeners(TestListener.class)
public class BaseTest {
    public String correctPassword = new PropertyReader("config.properties").getProperty("correct.password");
    public String correctLogin = new PropertyReader("config.properties").getProperty("correct.login");
    public String incorrectPassword = new PropertyReader("config.properties").getProperty("incorrectPassword");
    public String incorrectLogin = new PropertyReader("config.properties").getProperty("incorrectLogin");
    public String addresseeName = new PropertyReader("config.properties").getProperty("addressee.name");
    public String addresseeSurname = new PropertyReader("config.properties").getProperty("addressee.surname");
    public String searchingValue = new PropertyReader("config.properties").getProperty("searchingValue");
    public static Browser driver = new Browser();

    @BeforeMethod
    public void setup() {
        driver.getInstance();
        driver.windowMaximize();
        driver.navigate(PropertyReader.getProperty("base.URL"));
    }

    @AfterTest(alwaysRun = true, description = "Closing browser")
    public void tearDown() {
        driver.exit();
    }
}
