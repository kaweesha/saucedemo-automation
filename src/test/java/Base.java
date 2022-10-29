import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.ConfigFileReader;

public class Base {

    public WebDriver driver = null;
    public String appUrl;

    @BeforeClass
    @Parameters({"browser", "env", "grid"})
    public void beforeClass(@Optional("chrome") String browser, @Optional("qa") String env, @Optional("0") String grid) {

        ConfigFileReader cf = new ConfigFileReader();
        appUrl = cf.get("qa_url");
        System.out.println("appUrl: " + appUrl);

        System.out.println(browser);
        System.out.println(env);
        System.out.println(grid);

        if (grid.equals("0")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("window-size=1400,2100");
            driver = new ChromeDriver(chromeOptions);
        } else {
            BrowserConfigs bc = new BrowserConfigs();
            driver = bc.setUpBrowser();
        }

    }


    @AfterClass
    public void closeWindow() {
        driver.quit();
    }


}
