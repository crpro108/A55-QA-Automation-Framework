import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class HomeWork25 extends BaseTest2 {
    @Test
    public void launchParallel() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        loginPage.loginMainPage();

    }

}
