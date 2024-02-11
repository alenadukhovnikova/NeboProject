import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasketPage;

public class BasketPageTest extends BaseTest {
    @BeforeMethod
    public void openWebsite () {
        basketPage.openWebsite();
    }
    @Test (priority = 1)
    public void searchAndAddNewBookToTheBasket () {
        //   basketPage.openWebsite();
        basketPage.addBookToTheBasket();
        basketPage.searchAndAddNewBooksToTheBasket();
        basketPage.assertCountBooksInTheBasket("2");

    }
    @Test (priority = 2)
    public void returnToTheMenu () {
        //  basketPage.openWebsite();
        basketPage.addBookToTheBasket();
        basketPage.openTheBasket();
        basketPage.returnToTheMain();
        basketPage.assertWhereIs("Pages");

    }

    @Test (priority = 3)
    public void clearTheBasket () {
        //  basketPage.openWebsite();
        basketPage.addBookToTheBasket();
        basketPage.openTheBasket();
        basketPage.clearTheBasket();
        basketPage.assertEmptyBasket("УПС, ВАШ КОШИК - ПОРОЖНІЙ");

    }
    @Test (priority = 4)
    public void deleteItemsInTheBasket () {
        //  basketPage.openWebsite();
        basketPage.addBookToTheBasket();
        basketPage.openTheBasket();
        basketPage.deleteItemsInTheBasket();
        basketPage.assertEmptyBasket("УПС, ВАШ КОШИК - ПОРОЖНІЙ");

    }

    @Test (priority = 5)
    public void checkOutButtonClick () {
        //  basketPage.openWebsite();
        basketPage.addBookToTheBasket();
        basketPage.openTheBasket();
        basketPage.checkOut();
        basketPage.assertWhereIs("Оформити");
    }

    //  @Test
    // public void plusMinusBookInTheBasket() throws InterruptedException {

    //    basketPage.openWebsite();
    //   basketPage.addBookToTheBasket();
    //   basketPage.openTheBasket();
    //   basketPage.plusMinusBookInTheBasket();
    //   basketPage.assertHowMach("2");


}
//  @Test
// public void checkPromocodeInTheBasket () {
//  basketPage.openWebsite();
//   basketPage.addBookToTheBasket();
// basketPage.openTheBasket();
//  basketPage.checkThePromocodeFieldWithInvalidData();
//  basketPage.checkPromocodeInTheBasket();
//   basketPage.assertUsePromocode("УПС, ВАШ КОШИК - ПОРОЖНІЙ");
//  basketPage.closePage();
// }


