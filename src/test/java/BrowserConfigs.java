import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;

public class BrowserConfigs {

    WebDriver driver = null;
    String seleniumHubUrl = "http://sghpng-selenium-grid.sghprod.cloud/wd/hub";

    public WebDriver setUpBrowser() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setBrowserName(BrowserType.CHROME);
        System.out.println(seleniumHubUrl);
        try {
            driver = new RemoteWebDriver(new java.net.URL(seleniumHubUrl), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        ((RemoteWebDriver)driver).setFileDetector(new LocalFileDetector());
        return driver;
    }

}
