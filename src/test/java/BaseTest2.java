import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

public class BaseTest2 {
    public WebDriver driver;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.safaridriver().setup();
    }
    @BeforeMethod
    @Parameters("baseUrl")
    public void setUpBrowser(String baseUrl) throws MalformedURLException {
        driver = pickBrowser(System.getProperty("browser"));
        System.out.println("browser");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.1.158:4444";
        switch (browser) {
            case "safari":
                SafariOptions safariOptions = new SafariOptions();
                System.out.println("safari");
                return driver = new SafariDriver(safariOptions);
            case "grid-safari":
                caps.setCapability("browserName", "Safari");
                System.out.println("grid-safari");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                System.out.println("grid-chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            default:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                //System.setProperty("webdriver.chrome.driver", "chromedriver-mac-arm64/chromedriver");
                System.out.println("chrome");
                return driver = new ChromeDriver(chromeOptions);
        }
    }
    @AfterMethod
        public void closeBrowser(){
        driver.quit();
    }

}
