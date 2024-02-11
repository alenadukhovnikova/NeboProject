package functions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.function.Function;

public class WaitersClass {
    private final WebDriver driver;
    private static final long EXPLICIT_WAIT = 10L;

    public WaitersClass(WebDriver driver) {
        this.driver = driver;
    }

    private FluentWait<WebDriver> fluentWait(Long  duration){
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(duration))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(InvalidElementStateException.class);
    }

    private void waitForFunction(Function function, Long timeOutInSeconds) {
        FluentWait<WebDriver> wait = fluentWait(timeOutInSeconds);
        wait.until(function);
    }

    public WebElement waitForVisabilityOfWebElementAndReturnElement(By locator){
        return fluentWait(EXPLICIT_WAIT).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForVisabilityOfWebElement(By locator){
        waitForFunction(ExpectedConditions.visibilityOfElementLocated(locator), EXPLICIT_WAIT);
    }
    public void waitForIframeAndClickElementInside(By locator, By elementInside){
        fluentWait(EXPLICIT_WAIT).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator))
                .findElement(elementInside).click();
    }
    public Alert switchToAlert(){
        return fluentWait(EXPLICIT_WAIT).until(ExpectedConditions.alertIsPresent());
    }
    public void switchToFrameAfterWaiting(By locator){
        fluentWait(EXPLICIT_WAIT).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
    }
}

