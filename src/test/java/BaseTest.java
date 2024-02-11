import driverFactory.DriverSetUp;
import functions.ActionClass;
import functions.AssertionsClass;
import functions.ElementsClass;
import functions.WaitersClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.*;

public class BaseTest {
    protected WebDriver driver = DriverSetUp.startChromeDriver();

    protected ActionClass action = new ActionClass(driver);
    protected AssertionsClass assertions = new AssertionsClass(driver);
    protected ElementsClass elements = new ElementsClass(driver);
    protected WaitersClass waiters = new WaitersClass(driver);


    protected BasePage basePage = new BasePage(driver);
    protected ClickerPage clickerPage = new ClickerPage(driver);
    protected BasketPage basketPage = new BasketPage(driver);
    protected LoginPage loginPage = new LoginPage(driver);
    protected PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);


    @BeforeSuite
    public void startDriver() {
        driver = DriverSetUp.startChromeDriver();
    }

    @AfterSuite
    public void closeDriver() {
        driver.quit();
    }
}
