import org.testng.Assert;
import pages.ArtistPage;

public class ArtistTest extends BaseTest{
    public void checkForArtistPage() {
        ArtistPage artistPage = new ArtistPage(getThreadLocal());

        artistPage.clickArtistNavBar();
        Assert.assertTrue(artistPage.checkArtist());
    }
}
