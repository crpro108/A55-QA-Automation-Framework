
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class HomeWork23 extends BaseTest2{
    @Test
    public void renamePlaylist() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        String expectedPlayListMsg = "Updated playlist \"Car.\"";
        loginPage.loginMainPage();
        homePage.selectPlayList("Car");
        Assert.assertEquals(homePage.getUpdatedPlaylistMsg(), expectedPlayListMsg);
    }
}
