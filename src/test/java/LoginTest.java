import modules.HomePage;
import modules.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest extends Base {

    LoginPage loginPage = null;
    HomePage homePage = null;

    @BeforeMethod
    public void setUp() {
        System.out.println("BeforeMethod");
        driver.get(appUrl);
        this.loginPage = new LoginPage(driver);
        this.homePage = new HomePage(driver);
    }

    @Test
    public void testSuccessLogin() {
        this.loginPage.loginToSystem("standard_user", "secret_sauce");
        String pageCategory = this.homePage.getPageCategory().getText();
        System.out.println("testing over");
        Assert.assertEquals(pageCategory, "PRODUCTS");
    }

}
