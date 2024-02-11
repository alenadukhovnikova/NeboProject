import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PersonalAccountPageTest extends BaseTest {

    @BeforeClass
    public void authorizationOnThePersonalAccount() {
        personalAccountPage.openWebsite();
        personalAccountPage.sendValidTextToElementAndClick();
    }
    @Test (priority =3)
    public  void clickOnTheWishListButton () {
        //  personalAccountPage.openWebsite();
        //  personalAccountPage.sendValidTextToElementAndClick();
        personalAccountPage.clickOnTheWishListButton();
        personalAccountPage.assertWhereIs("Список бажань");
    }
    @Test (priority =4)
    public  void clickOnBasketButton () {
        // personalAccountPage.openWebsite();
        //  personalAccountPage.sendValidTextToElementAndClick();
        personalAccountPage.clickOnTheBasketButton();
        personalAccountPage.assertWhereIs("Кошик");
    }
    @Test (priority =2)
    public  void clickOnMySettingsButton () {
        //  personalAccountPage.openWebsite();
        personalAccountPage.sendValidTextToElementAndClick();
        personalAccountPage.clickOnMySettingsButton();
        personalAccountPage.assertWhereIs("Налаштування");
    }
    @Test (priority =5)
    public  void returnToTheMainPage () {
        //   personalAccountPage.openWebsite();
        //   personalAccountPage.sendValidTextToElementAndClick();
        personalAccountPage.returnToTheMain();
        personalAccountPage.assertWhereIs("Pages");
    }
    @Test (priority =1)
    public  void logOutFromTheDashboard () {
        //  personalAccountPage.openWebsite();
        // personalAccountPage.sendValidTextToElementAndClick();
        personalAccountPage.logOutFromDashboard();
        personalAccountPage.assertWhereIs("Авторизуватися");
    }
    // @Test
    //    public void addBooksToTheWishListOnDashboard() throws InterruptedException {
    //        personalAccountPage.openWebsite();
    //        personalAccountPage.sendValidTextToElementAndClick();
    //        personalAccountPage.openBooksMenu();
    //     //   personalAccountPage.addBooksToTheWishListOnDashBoard();
    //     //   personalAccountPage.assertAvailabilityOfBooks("Товар було успішно додано до вішлістa");
    //    }
    //
    //    @Test
    //    public void addBooksToTheBasketOnDashboard() throws InterruptedException {
    //        personalAccountPage.openWebsite();
    //        personalAccountPage.sendValidTextToElementAndClick();
    //        personalAccountPage.openBooksMenu();
    //        personalAccountPage.addBooksToTheBasketOnDashBoard();
    //        personalAccountPage.assertAvailabilityOfBooks("Товар було успішно додано до кошика");
    //    }
    //
    //    @Test
    //    public void searchBooksOnDashboard() throws InterruptedException {
    //        personalAccountPage.openWebsite();
    //        personalAccountPage.sendValidTextToElementAndClick();
    //        personalAccountPage.openBooksMenu();
    //        personalAccountPage.searchBooksOnDashBoard();
    //        personalAccountPage.assertAvailabilityOfBooksInSearchResult("Товар було успішно додано до кошика");
    //
    //    }
}