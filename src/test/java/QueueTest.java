import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.QueuePage;

public class QueueTest extends BaseTest {
    public String url = "https://qa.koel.app/";
    @Test
    public void allSongsQueueTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        QueuePage queuePage = new QueuePage(getThreadLocal());

        loginPage.loginMainPage();
        // 1. Open Current Queue page to be able to see all currently played songs (empty)
        homePage.selectQueue();
        // 1. Current Queue page should display currently played songs by a user in the app
        queuePage.clickShuffleAllSongs();
        // 2. & 3. The total count of songs should be displayed & the total duration of all songs should be displayed
        queuePage.checkTotalSongsAndDuration();
        // 4. ID, Title, Artist, Album, and Time should be correctly displayed as Header
        queuePage.listOfAllHeaders();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // 5. User should be navigated to Current Queue page after double clicking on the song on the following pages:
        // Home, All songs, Albums, Artists, Favorites, Recently played and Homelist (user's created playlist)
        queuePage.currentQueue();
        // 6. 'Shuffle All' button should shuffle songs
        queuePage.shuffleAll();
        // 7. The page should be empty after clicking on 'Clear' button. 'No songs queued. How about shuffling all songs?' message should appear.
        // Songs should appear on the Current Queue page when clicking on the 'shuffling all songs'
        queuePage.clearSongsQueue();
    }
}

