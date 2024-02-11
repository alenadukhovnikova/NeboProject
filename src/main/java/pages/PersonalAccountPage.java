package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAccountPage extends BasePage {
    public PersonalAccountPage(WebDriver driver) {
        super(driver);
    }

    private static class Locators {
        private final static By login = By.id("UserUsername");
        private final static By password = By.id("UserPassword");
        private final static By enterButton = By.cssSelector(".btn.btn-primary.me-2.flex-shrink-0");

        private final static By menuButton = By.cssSelector(".ki-duotone.ki-book-square.fs-2x");
        // private final static By menuBooksButton = By.xpath("//span[@class='menu-title'][text()='Книги']");
        private final static By menuBooksButton = By.xpath("//a[@href='/users/books'][1]");

        private final static By firstItemButton = By.xpath("//a[@href='/users/book_view/462'][@class='text-gray-800 text-hover-primary fs-5 fw-bold']");
        // private final static By actionsButton = By.cssSelector(".btn.btn-sm.btn-light.btn-flex.btn-center.btn-active-light-primary.show.menu-dropdown");
        private final static By actionsButton = By.xpath("//i[@class='ki-duotone ki-down fs-5 ms-1'][1]");

        private final static By actionsAddToTheBasket = By.xpath("//a[@href='/users/add_to_cart_item/462/books']");
        private final static By actionsAddToTheWishList = By.xpath("//a[@href='/users/add_to_wishlist/462/books']");
        private final static By actionsPreview = By.xpath("//a[@href='/users/book_view/462']");
        private final static By alertAfterAddToWishList = By.cssSelector(".alert.alert-success.alert-simple.alert-inline");
        private final static By searchButton = By.cssSelector(".form-control.form-control-solid.w-250px.ps-12");
        private final static By resultSearchButton = By.cssSelector(".sorting_1");

        private final static By returtToTheMain = By.cssSelector(".btn.btn-primary.fw-bold.fs-8.fs-lg-base");
        private final static By wishListButton = By.xpath("//a[@class='btn btn-icon btn-custom btn-active-color-primary position-relative'][1]");
        // private final static By basketButton = By.xpath("//a[@class='btn btn-icon btn-custom btn-active-color-primary position-relative'][2]");
        private final static By basketButton = By.xpath("//a[@href='#'][@data-kt-menu-trigger='click'][@data-kt-menu-placement='bottom-end'][@class='btn btn-icon btn-custom btn-active-color-primary position-relative']");
        private final static By viewMyBasketButton = By.cssSelector(".btn.btn-color-gray-600.btn-active-color-primary");

        private final static By logOut = By.xpath("//a[@href='/logout'][@class='menu-link px-5']");
        private final static By speedActionsButton = By.xpath("//a[@class='btn btn-icon btn-custom btn-active-color-primary'][@data-kt-menu-trigger='click']");
        private final static By mySettings = By.xpath("//a[@href='/my_settings'][@class='btn btn-flex btn-text-gray-800 btn-icon-gray-400 btn-active-color-primary bg-body flex-column justfiy-content-start align-items-start text-start w-100 p-10']");
    }

    static class Strings {
        final static String siteUrl = "https://nebopublishing.com.ua/login";
    }

    public void openWebsite() {
        logger.info("Открываю сайт");
        driver.get(PersonalAccountPage.Strings.siteUrl);
    }
    public void sendValidTextToElementAndClick() {
        driver.findElement(PersonalAccountPage.Locators.login).sendKeys("alena19apr@gmail.com");
        driver.findElement(PersonalAccountPage.Locators.password).sendKeys("alena1904");
        driver.findElement(PersonalAccountPage.Locators.enterButton).click();
    }

    public void addBooksToTheWishListOnDashBoard () throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(Locators.actionsButton).click();
        Thread.sleep(3000);
        driver.findElement(Locators.actionsAddToTheWishList).click();
        driver.findElement(Locators.alertAfterAddToWishList).getText();
    }
    public void assertAvailabilityOfBooks(String expectedResult) {
        assertions.equalsOfStrings(getResultFromResultField(), expectedResult);
    }

    public String getResultFromResultField() {
        return elements.getTextFromElement(Locators.alertAfterAddToWishList);
    }
    public void openBooksMenu () throws InterruptedException {

        driver.findElement(Locators.menuButton).click();
        Thread.sleep(5000);
        driver.findElement(Locators.menuBooksButton).click();
        Thread.sleep(5000);
        driver.findElement(Locators.firstItemButton).click();
        Thread.sleep(5000);
    }


    public void addBooksToTheBasketOnDashBoard () throws InterruptedException {
        Thread.sleep(7000);
        driver.findElement(Locators.actionsButton).click();
        Thread.sleep(3000);
        driver.findElement(Locators.actionsAddToTheBasket).click();
        driver.findElement(Locators.alertAfterAddToWishList).getText();
    }
    public void searchBooksOnDashBoard () {
        driver.findElement(Locators.searchButton).sendKeys("Полліанна");
        driver.findElement(Locators.resultSearchButton).getText();
    }
    public void assertAvailabilityOfBooksInSearchResult(String expectedResult) {
        //  assertions.equalsOfStrind(getResultFromBooksResultField(), expectedResult);
        assertions.equalsOfStrings(getResultFromBooksResultField(), expectedResult);
    }

    public String getResultFromBooksResultField() {
        return elements.getTextFromElement(Locators.resultSearchButton);
    }

    public void returnToTheMain () {
        driver.findElement(Locators.returtToTheMain).click();
    }
    public void logOutFromDashboard () {
        driver.findElement(Locators.speedActionsButton).click();
        driver.findElement(Locators.logOut).click();
    }

    public void clickOnTheWishListButton () {
        driver.findElement(Locators.wishListButton).click();
    }
    public void clickOnMySettingsButton() {
        driver.findElement(Locators.mySettings).click();
    }

    public void clickOnTheBasketButton () {
        driver.findElement(Locators.basketButton).click();
        driver.findElement(Locators.viewMyBasketButton).click();
    }

    public void assertWhereIs(String expectedResult) {
        assertions.equalsOfStrings(driver.getTitle(), expectedResult);
    }

}