package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClickerPage extends BasePage{
    public ClickerPage(WebDriver driver) {
        super(driver);
    }



    private static class Locators {
        private final static By plusButton = By.id("plus-btn");
        private final static By counterField = By.xpath("//div[@id='counter']/span");
        private final static By cookies = By.xpath("//p[text()='Consent']");
        private final static By iframe = By.xpath("//iframe[contains(@src,'online-click-counter')]");
    }

    private static class Strings {
        private final static String siteUrl = "https://www.clickspeedtester.com/click-counter/";
    }

    public void acceptCookies(){
        elements.click(Locators.cookies);
    }

    public void openWebsite() {
        logger.info("Открываю сайт");
        driver.get(Strings.siteUrl);
    }

    public void clickOnPlusButton(int countOfClick) {
        logger.info("Кликаю на элемент " + Locators.plusButton + " " + countOfClick + " раз.");
        for (int i = 0; i < countOfClick; i++) {
            elements.click(Locators.plusButton);
        }
    }

    public void assertCountOfClicks(int expectedResult){
        assertions.equalsOfInts(getIntegerFromResultField(), expectedResult);
    }

    public int getIntegerFromResultField(){
        return Integer.parseInt(elements.getTextFromElement(Locators.counterField));
    }
    public void switchToClickButtonsFrame(){
        waiters.switchToFrameAfterWaiting(Locators.iframe);
    }

}
