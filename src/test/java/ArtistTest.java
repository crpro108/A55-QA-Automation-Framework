import org.testng.Assert;
import pages.ArtistPage;

public class ArtistTest extends BaseTest{
    //public static WebDriver driver;
    ArtistPage artistPage = new ArtistPage(getThreadLocal());
    artistPage.clickArtistHeader();
    Assert.assertTrue(artistPage.checkArtist());
}
