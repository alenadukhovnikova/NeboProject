package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }


    private static class Locators {
        private final static By login = By.id("UserUsername");
        private final static By password = By.id("UserPassword");

        private final static By surname = By.id("UserSname");
        private final static By firstname = By.id("UserFname");
        private final static By loginRegistration = By.id("UserEmail");
        private final static By passwordRegistration = By.id("UserPassword");
        private final static By doublePasswordRegistration = By.id("UserPasswordConfirmation");

        private final static By enterButton = By.cssSelector(".btn.btn-primary.me-2.flex-shrink-0");
        private final static By loginButton = By.xpath("//i[@class='d-icon-user'][1]");

        private final static By registrationButton = By.cssSelector(".link-primary.fw-bold.fs-5");
        private final static By acceptRegistrationButton = By.cssSelector(".btn.btn-primary.me-2.flex-shrink-0");
        private final static By resetButton = By.xpath("//a[@href='/forgot_password']");
        private final static By sendMissedPassword = By.cssSelector(".btn.btn-primary.me-2.flex-shrink-0");

        private final static By alertInvalidAuthorization = By.cssSelector(".alert.alert-danger.alert-simple.alert-inline");
        private final static By alertSuccess = By.cssSelector(".alert.alert-success.alert-simple.alert-inline");
        private final static By resetResult = By.cssSelector(".text-gray-400.fw-semibold.fs-6");
        private final static By logOut = By.xpath("//a[@href='/logout'][@class='menu-link px-5']");
        private final static By speedActionsButton = By.xpath("//a[@class='btn btn-icon btn-custom btn-active-color-primary'][@data-kt-menu-trigger='click']");
        private final static By loginForReset = By.id("UserEmail");
        private final static By sendDataForReset = By.cssSelector(".btn.btn-primary.me-2.flex-shrink-0");

    }

    static class Strings {
        final static String siteUrl = "https://nebopublishing.com.ua/login";
    }

    public void openWebsite() {
        logger.info("Открываю сайт");
        driver.get(Strings.siteUrl);
    }

    public void clickOnLoginButton() {
        driver.findElement(LoginPage.Locators.loginButton).click();
    }

    public void sendValidTextToElementAndClick() {
        driver.findElement(LoginPage.Locators.login).sendKeys("alena19apr@gmail.com");
        driver.findElement(LoginPage.Locators.password).sendKeys("alena1904");
        driver.findElement(LoginPage.Locators.enterButton).click();
    }

    public void sendInvalidTextToElementAndClick() {
        driver.findElement(LoginPage.Locators.login).sendKeys("example@gmail.com");
        driver.findElement(LoginPage.Locators.password).sendKeys("fghjkkl");
        driver.findElement(LoginPage.Locators.enterButton).click();
    }

    public void registration() {
        //   driver.findElement(LoginPage.Locators.loginButton).click();
        driver.findElement(LoginPage.Locators.registrationButton).click();
    }

    public void sendValidTextToElementAndClickOnRegistration() {
        driver.findElement(LoginPage.Locators.surname).sendKeys("Петрова");
        driver.findElement(LoginPage.Locators.firstname).sendKeys("Валерія");
        driver.findElement(LoginPage.Locators.loginRegistration).sendKeys("alala@gmail.com");
        driver.findElement(LoginPage.Locators.passwordRegistration).sendKeys("Alala1234567");
        driver.findElement(Locators.doublePasswordRegistration).sendKeys("Alala1234567");
        driver.findElement(LoginPage.Locators.acceptRegistrationButton).click();
    }

    public void sendInValidTextToElementAndClickOnRegistration() {
        driver.findElement(LoginPage.Locators.surname).sendKeys("Петрова");
        driver.findElement(LoginPage.Locators.firstname).sendKeys("Валерія");
        driver.findElement(LoginPage.Locators.loginRegistration).sendKeys("alala@gmail");
        driver.findElement(LoginPage.Locators.passwordRegistration).sendKeys("Alala1234567");
        driver.findElement(Locators.doublePasswordRegistration).sendKeys("Alala1234567");
        driver.findElement(LoginPage.Locators.acceptRegistrationButton).click();
    }

    public void clickOnResetButton() {
        //   driver.findElement(LoginPage.Locators.loginButton).click();
        driver.findElement(LoginPage.Locators.resetButton).click();
        driver.findElement(Locators.loginForReset).sendKeys("alena19apr@gmail.com");
        driver.findElement(Locators.sendDataForReset).click();
    }

    public void clickOnResetButtonWithInvalidData() {
        //  driver.findElement(LoginPage.Locators.loginButton).click();
        driver.findElement(LoginPage.Locators.resetButton).click();
        driver.findElement(LoginPage.Locators.loginRegistration).sendKeys("alala@lala");
        driver.findElement(LoginPage.Locators.sendMissedPassword).click();

        System.out.println(driver.findElement(By.xpath("//span[text()='В системі не знайдено користувача з таким email-ом']")).getText());
    }

    public void clickOnLoginButton(By locator) {
        clickOnLoginButton(LoginPage.Locators.loginButton);
    }

    public void assertWhereIs(String expectedResult) {
        assertions.equalsOfStrings(driver.getTitle(), expectedResult);
    }

    public void resultAlert() {
        Alert alert1 = new Alert() {
            @Override
            public void dismiss() {

            }

            @Override
            public void accept() {

            }

            @Override
            public String getText() {
                return null;
            }

            @Override
            public void sendKeys(String s) {

            }
        };
        System.out.println(alert1.getText());
    }

    public void assertEqualsOfStrings(String expectedResult) throws InterruptedException {
        Thread.sleep(5000);
        assertions.equalsOfStrings(elements.getTextFromElement(Locators.alertInvalidAuthorization), expectedResult);
    }
    public void assertEqualsOfStringsResult(String expectedResult) throws InterruptedException {
        Thread.sleep(5000);
        assertions.equalsOfStrings(elements.getTextFromElement(Locators.alertSuccess), expectedResult);
    }

    public void logOutFromDashboard() {
        driver.findElement(LoginPage.Locators.speedActionsButton).click();
        driver.findElement(LoginPage.Locators.logOut).click();
    }
}
