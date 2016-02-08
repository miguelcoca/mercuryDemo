package mercuryDemo.pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import mercuryDemo.util.PropertyLoader;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by mike on 1/30/16.
 */

public class MercurySignOnPage extends Page {
    private int timeout = 15;

    @FindBy(css = "div table tbody tr td:nth-of-type(1) table tbody tr td table tbody tr td table tbody tr:nth-of-type(4) td:nth-of-type(2) font a")
    @CacheLookup
    private WebElement carRentals;

    @FindBy(css = "div table tbody tr td:nth-of-type(2) table tbody tr:nth-of-type(2) td table tbody tr td:nth-of-type(4) a")
    @CacheLookup
    private WebElement contact;

    @FindBy(css = "div table tbody tr td:nth-of-type(1) table tbody tr td table tbody tr td table tbody tr:nth-of-type(5) td:nth-of-type(2) a")
    @CacheLookup
    private WebElement cruises;

    @FindBy(css = "div table tbody tr td:nth-of-type(1) table tbody tr td table tbody tr td table tbody tr:nth-of-type(6) td:nth-of-type(2) a")
    @CacheLookup
    private WebElement destinations;

    @FindBy(name = "userName")
    @CacheLookup
    private WebElement userNameText;

    @FindBy(name = "password")
    @CacheLookup
    private WebElement passwordText;

    @FindBy(css = "a[href='mercuryreservation.php']")
    @CacheLookup
    private WebElement flights;

    @FindBy(css = "a[href='mercurywelcome.php']")
    @CacheLookup
    private WebElement home;

    @FindBy(css = "div table tbody tr td:nth-of-type(1) table tbody tr td table tbody tr td table tbody tr:nth-of-type(3) td:nth-of-type(2) a")
    @CacheLookup
    private WebElement hotels;

    @FindBy(name = "login")
    @CacheLookup
    private WebElement login;

    private final String pageLoadedText = "Enter your user information to access the member-only";

    private final String pageUrl = "/mercurysignon.php";

    @FindBy(css = "div table tbody tr td:nth-of-type(2) table tbody tr:nth-of-type(2) td table tbody tr td:nth-of-type(2) a")
    @CacheLookup
    private WebElement register;

    @FindBy(css = "div table tbody tr td:nth-of-type(2) table tbody tr:nth-of-type(4) td table tbody tr td:nth-of-type(2) table tbody tr:nth-of-type(3) td p font a")
    @CacheLookup
    private WebElement registrationForm;

    @FindBy(css = "a[href='mercurysignon.php']")
    @CacheLookup
    private WebElement signon;

    @FindBy(css = "div table tbody tr td:nth-of-type(2) table tbody tr:nth-of-type(2) td table tbody tr td:nth-of-type(3) a")
    @CacheLookup
    private WebElement support;

    @FindBy(css = "div table tbody tr td:nth-of-type(1) table tbody tr td table tbody tr td table tbody tr:nth-of-type(7) td:nth-of-type(2) a")
    @CacheLookup
    private WebElement vacations;

    public MercurySignOnPage(WebDriver driver) {
        super(driver);
    }

    public MercurySignOnPage clickHomeLink() {
        home.click();
        return this;
    }

    public MercurySignOnPage clickLoginButton() {
        println("click login button");
        login.click();
        return this;
    }

    public MercurySignOnPage clickRegistrationFormLink() {
        registrationForm.click();
        return this;
    }

    public MercurySignOnPage clickSignonLink() {
        signon.click();
        return this;
    }

    public MercurySignOnPage clickSupportLink() {
        support.click();
        return this;
    }

    public MercurySignOnPage clickVacationsLink() {
        vacations.click();
        return this;
    }

    public MercurySignOnPage fill() {
        println("fill in method called");
        writeUserName();
        writePassword();
        return this;
    }

    public MercurySignOnPage writeUserName() {
        return writeUserName(PropertyLoader.loadProperty("user.username"));
    }

    public MercurySignOnPage writeUserName(String userName) {
        println("write username: " + userName);
        userNameText.sendKeys(userName);
        return this;
    }

    public MercurySignOnPage writePassword() {
        return writePassword(PropertyLoader.loadProperty("user.password"));
    }

    public MercurySignOnPage writePassword(String password) {
        println("write user password: XXXXXXX");
        passwordText.sendKeys(password);
        return this;
    }

    public MercurySignOnPage verifyPageLoaded() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getPageSource().contains(pageLoadedText);
            }
        });
        return this;
    }

    public MercurySignOnPage verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }

    public MercurySignOnPage doSignOn() {
        fill();
        clickLoginButton();
        return this;
    }

    public boolean verifySuccessfulSignOn() {
        println("verify SING-OFF exists");
        return (driver.findElement(By.linkText("SIGN-OFF")).isDisplayed());
    }
}
