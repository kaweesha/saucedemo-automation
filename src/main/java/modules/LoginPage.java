package modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static modules.LoginPageLocators.*;

public class LoginPage {
    WebDriver driver;

    @FindBy(id = USERNAME_INPUT_FIELD_ID)
    WebElement usernameInputField;

    @FindBy(id = PASSWORD_INPUT_FIELD_ID)
    WebElement passwordInputField;

    @FindBy(id = LOGIN_BUTTON_ID)
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getUsernameInputField() {
        return usernameInputField;
    }

    public WebElement getPasswordInputField() {
        return passwordInputField;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public void loginToSystem(String username, String password) {
        this.getUsernameInputField().sendKeys(username);
        this.getPasswordInputField().sendKeys(password);
        this.getLoginButton().click();
    }
}
