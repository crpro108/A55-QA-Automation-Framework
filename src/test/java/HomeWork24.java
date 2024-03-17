import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.net.MalformedURLException;

public class HomeWork24 extends BaseTest2{
    public String url = "https://qa.koel.app/";
    @Test
    public void launchGrid() throws MalformedURLException {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.loginMainPage();

        Assert.assertEquals(driver.getCurrentUrl(),url);

    }
}