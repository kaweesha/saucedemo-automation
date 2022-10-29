package modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static modules.HomePageLocators.PAGE_CATEGORY_XPATH;

public class HomePage {

    WebDriver driver = null;

    @FindBy(xpath = PAGE_CATEGORY_XPATH)
    WebElement pageCategory;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public WebElement getPageCategory() {
        return this.pageCategory;
    }

}
