package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage extends BasePage {

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    static class Locators {

        private final static By booksMenu = By.xpath("//a[@href='/books'][1]");
        private final static By openFirstBook = By.xpath("//img[@alt='dim-neba-i-podikhu'][@src='/files/books/800/978_617_8383_26_8_4.png']");
        private final static By addBookToBasket = By.cssSelector(".btn-product.btn-cart.text-normal.ls-normal.font-weight-semi-bold");
        private final static By smallBooksBasket = By.xpath("//i[@class='d-icon-bag'][1]");
        private final static By bigBooksBasket = By.xpath("//a[@href='/pages/cart/lang:ukr']");
        private final static By plusBookInBasket = By.xpath("//button[@class='quantity-plus d-icon-plus'][1]");
        private final static By minusBookInBasket = By.xpath("//button[@class='quantity-minus d-icon-minus'][1]");
        //   private final static By counterBooksField = By.xpath("//input[@class='quantity form-control']");

        private final static By counterBooksField = By.cssSelector(".quantity.form-control");
        private final static By returnTotheMain = By.cssSelector(".btn.btn-dark.btn-md.btn-rounded");
        private final static By emptyTheBasket = By.cssSelector(".mt-10.mb-0.ls-m.text-uppercase");
        private final static By clearTheBasket = By.cssSelector(".btn.btn-rounded.btn-outline.btn-outline-light");

        private final static By deleteItems = By.xpath("//a[@href='/pages/delCartItem/0']");
        private final static By useThePromocode = By.cssSelector(".btn.btn-md.btn-dark.btn-rounded.btn-outline");

        private final static By promocodeField = By.id("CouponCouponCode");
        private final static By checkThePromocode = By.xpath("//p[@class='summary-subtotal-price'][2]");
        private final static By checkOutButton = By.cssSelector(".btn.btn-dark.btn-rounded.btn-checkout");
        private final static By searchBigButton = By.xpath("//i[@class='d-icon-search'][1]");
        private final static By searchSmallButton = By.id("SearchKeywd");
        private final static By searchClick = By.xpath("//button[@class='btn btn-search'][@type='submit'][1]");
        private final static By addNewFoundBook = By.cssSelector(".btn-product.btn-cart");
        private final static By checkCountOfBooks = By.cssSelector(".cart-count");
    }

    private static class Strings {
        private final static String siteUrl = "https://nebopublishing.com.ua/pages/cart/lang:ukr";
    }

    public void openWebsite() {
        logger.info("Открываю сайт");
        driver.get(BasketPage.Strings.siteUrl);
    }

    public void addBookToTheBasket() {
        driver.findElement(BasketPage.Locators.booksMenu).click();
        driver.findElement(BasketPage.Locators.openFirstBook).click();
        driver.findElement(BasketPage.Locators.addBookToBasket).click();
    }

    public void plusMinusBookInTheBasket() throws InterruptedException {
        driver.findElement(BasketPage.Locators.smallBooksBasket).click();
        driver.findElement(BasketPage.Locators.bigBooksBasket).click();
        driver.findElement(BasketPage.Locators.plusBookInBasket).click();
        driver.findElement(BasketPage.Locators.plusBookInBasket).click();
        driver.findElement(BasketPage.Locators.minusBookInBasket).click();
        Thread.sleep(5000);

    }

    public void assertHowMach(String expectedResult) {
        assertions.equalsOfStrings(elements.getTextFromElement(Locators.counterBooksField), expectedResult);
    }

    public void openTheBasket() {
        driver.findElement(BasketPage.Locators.smallBooksBasket).click();
        driver.findElement(BasketPage.Locators.bigBooksBasket).click();
    }

  ////  public void assertCountOfBooks(int expectedResult) {
   //     assertions.equalsOfInts(getIntegerFromResultField(), expectedResult);
  //  }

 //   public int getIntegerFromResultField() {
  //      return elements.getIntFromElement(BasketPage.Locators.counterBooksField);
  //  }

    public void returnToTheMain() {
        driver.findElement(Locators.returnTotheMain).click();
        System.out.println(driver.findElement(Locators.booksMenu).getText());
    }

    public void assertWhereIs(String expectedResult) {
        assertions.equalsOfStrings(driver.getTitle(), expectedResult);
    }

    public String clearTheBasket() {
        driver.findElement(Locators.clearTheBasket).click();
        String string = driver.findElement(Locators.emptyTheBasket).getText();
        return string;
    }

    public void assertEmptyBasket(String expectedResult) {
        assertions.equalsOfStrings(elements.getTextFromElement(Locators.emptyTheBasket), expectedResult);
    }

    public String deleteItemsInTheBasket() {
        driver.findElement(Locators.deleteItems).click();
        String string = driver.findElement(Locators.emptyTheBasket).getText();
        return string;
    }

    public void checkThePromocodeFieldWithInvalidData() {
        driver.findElement(Locators.promocodeField).sendKeys("##################################");
        driver.findElement(Locators.useThePromocode).click();
    }

    public String checkPromocodeInTheBasket() {
        driver.findElement(Locators.checkThePromocode).click();
        String string = driver.findElement(Locators.checkThePromocode).getText();
        return string;
    }

    public void assertUsePromocode(String expectedResult) {
        assertions.equalsOfStrind(elements.getTextFromElement(Locators.checkThePromocode), expectedResult);
    }

    public void closePage() {
        driver.quit();
    }

    public void checkOut() {
        driver.findElement(Locators.checkOutButton).click();
    }

    public void searchAndAddNewBooksToTheBasket() {
        driver.findElement(Locators.searchBigButton).click();
        driver.findElement(Locators.searchSmallButton).click();
        driver.findElement(Locators.searchSmallButton).sendKeys("Полліанна");
        driver.findElement(Locators.searchClick).click();
        driver.findElement(Locators.addNewFoundBook).click();
    }
    public void assertCountBooksInTheBasket (String expectedResult) {
        assertions.equalsOfStrind(elements.getTextFromElement(Locators.checkCountOfBooks), expectedResult);
    }


    //   public String addNewBookFromSearch() {
    ///     driver.findElement(Locators.clearTheBasket).click();
    //  String string = driver.findElement(Locators.emptyTheBasket).getText();
    //return string;

}