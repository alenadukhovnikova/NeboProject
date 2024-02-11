package functions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClass {
    private final WebDriver driver;
    private final Actions actions;
    private final ElementsClass elementsClass;
    private final WaitersClass waiters;

    public ActionClass(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        elementsClass = new ElementsClass(driver);
        waiters = new WaitersClass(driver);
    }

    public void clickAndOpenInNewWindow(By locator){
        waiters.waitForVisabilityOfWebElement(locator);
        actions.keyDown(Keys.CONTROL).click(driver.findElement(locator)).keyUp(Keys.CONTROL).build().perform();
    }
    public void hoverTheCursorToElement(By locator){
        waiters.waitForVisabilityOfWebElement(locator);
        actions.moveToElement(driver.findElement(locator)).perform();
    }
}
