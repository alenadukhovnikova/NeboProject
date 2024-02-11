package functions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ElementsClass {
    private final WebDriver driver;
    private final WaitersClass waiters;
    static final Logger logger = LoggerFactory.getLogger(ElementsClass.class);

    public ElementsClass(WebDriver driver) {
        this.driver = driver;
        waiters = new WaitersClass(driver);
    }


    public void click(By locator) {
        waiters.waitForVisabilityOfWebElement(locator);
        logger.info("Очікую натискання на елемент " + locator);
        driver.findElement(locator).click();
    }

    public void sendKeys(By locator, String text) {
        waiters.waitForVisabilityOfWebElement(locator);
        driver.findElement(locator).sendKeys(text);
    }

    public void sendKeys(By locator, Keys key) {
        waiters.waitForVisabilityOfWebElement(locator);
        driver.findElement(locator).sendKeys(key);
    }

    public void clearAndSendKeys(By locator, String text) {
        waiters.waitForVisabilityOfWebElement(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public String getTextFromElement(By locator) {
        logger.info("Отримую текст із елемента " + locator);
        waiters.waitForVisabilityOfWebElement(locator);
        return driver.findElement(locator).getText();
    }

}

