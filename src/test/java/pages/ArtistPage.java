package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ArtistPage extends BasePage{
    protected WebDriverWait wait;
    Actions action = new Actions(driver);
    public ArtistPage(WebDriver givenDriver){
        super(givenDriver);
    }
    @FindBy(xpath = "//h1[normalize-space(text())='Artists']")
    private WebElement artistHeader;

    @FindBy(xpath="//ul/li//a[@class='artists']")
    private WebElement artistNavBar;

    public void clickArtistNavBar(){
        artistNavBar.click();
    }
    public boolean checkArtist(){
//        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(3));
//        WebElement selectArtistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space(text())='Artists']")));
//        Actions action = new Actions(driver);
//        action.sendKeys(selectArtistElement).sendKeys(Keys.ENTER).perform();
            return artistHeader.isEnabled();
    }
    public void clickArtistHeader(){
        clickArtistNavBar();
    }


}
