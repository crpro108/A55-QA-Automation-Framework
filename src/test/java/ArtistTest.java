import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ArtistPage;


public class ArtistTest extends BaseTest{
    @Test
    public void checkForArtistPage() {
        ArtistPage artistPage = new ArtistPage(getThreadLocal());

        artistPage.clickArtistNavBar();
        Assert.assertTrue(artistPage.checkArtist());
    }
}
