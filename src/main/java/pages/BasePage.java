package pages;

import functions.ActionClass;
import functions.AssertionsClass;
import functions.ElementsClass;
import functions.WaitersClass;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage {
    protected static WebDriver driver;
    static ActionClass action;
    static AssertionsClass assertions;
    static ElementsClass elements;
    static WaitersClass waiters;
    static final Logger logger = LoggerFactory.getLogger(BasePage.class);

    public BasePage(WebDriver driver) {
        this.driver = driver;
        action = new ActionClass(driver);
        assertions = new AssertionsClass(driver);
        elements = new ElementsClass(driver);
        waiters = new WaitersClass(driver);
    }
}

