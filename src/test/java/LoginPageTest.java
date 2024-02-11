//import junit.framework.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

import static org.testng.TestNGAntTask.Mode.junit;

public class LoginPageTest extends BaseTest{
    @BeforeMethod
    public void openWebsite () {
        loginPage.openWebsite();
    }

    @Test (priority = 1)
    public void loginWithInvalidData() throws InterruptedException {

        // loginPage.openWebsite();
        loginPage.sendInvalidTextToElementAndClick();
        loginPage.assertEqualsOfStrings("Помилка: Невірний логін/пароль");
        // Assert.assertTrue("не вірний логін/пароль", true);
    }

    @Test (priority = 2)
    public void registrationWithValidData() throws InterruptedException {
        //  loginPage.openWebsite();
        loginPage.registration();
        loginPage.sendValidTextToElementAndClickOnRegistration();
        loginPage.assertWhereIs("Зареєструватися");
    }

    @Test (priority = 3)
    public void registrationWithInValidData() throws InterruptedException {
        // loginPage.openWebsite();
        loginPage.registration();
        loginPage.sendInValidTextToElementAndClickOnRegistration();
        loginPage.assertEqualsOfStrings("Реєстрація не була виконана. Будь ласка спробуйте ще раз.");
    }

    @Test (priority = 4)
    public void clickOnResetButton() throws InterruptedException {

        loginPage.clickOnResetButton();
        loginPage.assertEqualsOfStringsResult("Будь ласка, перевірте свою пошту");

    }
    @Test (priority = 5)
    public void clickOnResetButtonWithInvalidData() throws InterruptedException {
        //  loginPage.openWebsite();
        loginPage.clickOnResetButtonWithInvalidData();
        loginPage.assertEqualsOfStrings("В системі не знайдено користувача з таким email-ом");

    }
    @Test (priority = 6)
    public void loginWithValidData() {

        loginPage.sendValidTextToElementAndClick();
        loginPage.assertWhereIs("Дашборд");
        loginPage.logOutFromDashboard();
    }

}