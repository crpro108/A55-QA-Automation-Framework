import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {
    public String url = "https://qa.koel.app/";

    public void loginSucceedTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.loginIncorrectPassword();
        loginPage.loginIncorrectEmailAndPassword();
        loginPage.loginMainPage();
        Assert.assertTrue(homePage.getUserAvatar());
    }
}
