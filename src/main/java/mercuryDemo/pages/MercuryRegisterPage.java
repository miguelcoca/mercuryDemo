package mercuryDemo.pages;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import mercuryDemo.util.PropertyLoader;

/**
 * Created by mike on 1/30/16.
 */

public class MercuryRegisterPage extends Page{
    private int timeout = 15;

    private final String SUCCESS_MESSAGE="Thank you for registering. You may now sign-in using the user name and password you've just entered.";

    @FindBy(css = "div table tbody tr td:nth-of-type(1) table tbody tr td table tbody tr td table tbody tr:nth-of-type(4) td:nth-of-type(2) font a")
    @CacheLookup
    private WebElement carRentals;

    @FindBy(css = "div table tbody tr td:nth-of-type(2) table tbody tr:nth-of-type(2) td table tbody tr td:nth-of-type(4) a")
    @CacheLookup
    private WebElement contact;

    @FindBy(css = "a[href='mercurycruise.php']")
    @CacheLookup
    private WebElement cruises;

    @FindBy(css = "div table tbody tr td:nth-of-type(1) table tbody tr td table tbody tr td table tbody tr:nth-of-type(6) td:nth-of-type(2) a")
    @CacheLookup
    private WebElement destinations;

    @FindBy(css = "a[href='mercuryreservation.php']")
    @CacheLookup
    private WebElement flights;

    @FindBy(css = "a[href='mercurywelcome.php']")
    @CacheLookup
    private WebElement home;

    @FindBy(css = "div table tbody tr td:nth-of-type(1) table tbody tr td table tbody tr td table tbody tr:nth-of-type(3) td:nth-of-type(2) a")
    @CacheLookup
    private WebElement hotels;

    private final String pageLoadedText = "and contact you if your travel arrangements change";

    private final String pageUrl = "/mercuryregister.php";

    @FindBy(css = "a[href='mercuryregister.php']")
    @CacheLookup
    private WebElement register;

    @FindBy(css = "a[href='mercurysignon.php']")
    @CacheLookup
    private WebElement signon;

    @FindBy(css = "div table tbody tr td:nth-of-type(2) table tbody tr:nth-of-type(2) td table tbody tr td:nth-of-type(3) a")
    @CacheLookup
    private WebElement support;

    @FindBy(css = "div table tbody tr td:nth-of-type(1) table tbody tr td table tbody tr td table tbody tr:nth-of-type(7) td:nth-of-type(2) a")
    @CacheLookup
    private WebElement vacations;

    @FindBy(name = "firstName")
    @CacheLookup
    private WebElement inputFirstName;

    @FindBy(name = "country")
    @CacheLookup
    private WebElement inputCountry;

    @FindBy(id = "email")
    @CacheLookup
    private WebElement inputEmail;

    @FindBy(name = "password")
    @CacheLookup
    private WebElement inputPassword;

    @FindBy(name = "confirmPassword")
    @CacheLookup
    private WebElement inputConfirmPassword;

    @FindBy(name = "register")
    @CacheLookup
    private WebElement submitRegister;

    @FindBy(name = "lastName")
    @CacheLookup
    private WebElement inputLastName;

    @FindBy(name = "phone")
    @CacheLookup
    private WebElement inputPhone;

    @FindBy(id = "userName")
    @CacheLookup
    private WebElement inputUserName;

    @FindBy(name = "address1")
    @CacheLookup
    private WebElement inputAddress1;

    @FindBy(name = "address2")
    @CacheLookup
    private WebElement inputAddress2;

    @FindBy(name = "city")
    @CacheLookup
    private WebElement inputCity;

    @FindBy(name = "state")
    @CacheLookup
    private WebElement inputState;

    @FindBy(name = "postalCode")
    @CacheLookup
    private WebElement inputPostalCode;

    public MercuryRegisterPage(WebDriver driver) {
        super(driver);
    }

    public MercuryRegisterPage clickCarRentalsLink() {
        carRentals.click();
        return this;
    }

    public MercuryRegisterPage clickContactLink() {
        contact.click();
        return this;
    }

    public MercuryRegisterPage clickCruisesLink() {
        cruises.click();
        return this;
    }

    public MercuryRegisterPage clickDestinationsLink() {
        destinations.click();
        return this;
    }

    public MercuryRegisterPage clickFlightsLink() {
        flights.click();
        return this;
    }

    public MercuryRegisterPage clickHomeLink() {
        home.click();
        return this;
    }

    public MercuryRegisterPage clickHotelsLink() {
        hotels.click();
        return this;
    }

    public MercuryRegisterPage clickRegisterLink() {
        register.click();
        return this;
    }

    public MercuryRegisterPage clickSignonLink() {
        signon.click();
        return this;
    }

    public MercuryRegisterPage clickSupportLink() {
        support.click();
        return this;
    }

    public MercuryRegisterPage clickVacationsLink() {
        vacations.click();
        return this;
    }

    public MercuryRegisterPage clickSubmitButton() {
        println("click submit button");
        submitRegister.click();
        return this;
    }

    public MercuryRegisterPage fill() {
        setFirstNameTextField();
        setLastNameTextField();
        setPhoneTextField();
        setUserNameTextField();//
        setAddress1TextField();
        setAddress2TextField();
        setCityTextField();
        setStateTextField();
        setPostalCodeTextField();
        setCountryDropDownListField();
        setemailTextField();//
        setPasswordField();
        setConfirmPasswordField();
        return this;
    }

    public MercuryRegisterPage setCountryDropDownListField() {
        return setCountryDropDownListField(PropertyLoader.loadProperty("mailinfo.country"));
    }

    public MercuryRegisterPage setCountryDropDownListField(String country) {
        println("select country: " + country);
        new Select(inputCountry).selectByVisibleText("TAIWAN");
        return this;
    }

    public MercuryRegisterPage setemailTextField() {
        return setemailTextField(PropertyLoader.loadProperty("user.username"));
    }

    public MercuryRegisterPage setemailTextField(String email) {
        println("write email text field: " + email);
        inputEmail.sendKeys(email);
        return this;
    }

    public MercuryRegisterPage setPasswordField() {
        return setPasswordField(PropertyLoader.loadProperty("user.password"));
    }

    public MercuryRegisterPage setPasswordField(String password) {
        println("write password field: XXXXXXX");
        inputPassword.sendKeys(password);
        return this;
    }

    public MercuryRegisterPage setConfirmPasswordField() {
        return setConfirmPasswordField(PropertyLoader.loadProperty("user.password"));
    }

    public MercuryRegisterPage setConfirmPasswordField(String confirmPassword) {
        println("write confirmation password field: XXXXXXX");
        inputConfirmPassword.sendKeys(confirmPassword);
        return this;
    }

    public MercuryRegisterPage setFirstNameTextField() {
        return setFirstNameTextField(PropertyLoader.loadProperty("contact.firstname"));
    }

    public MercuryRegisterPage setFirstNameTextField(String firstname) {
        println("set first name field: " + firstname);
        inputFirstName.sendKeys(firstname);
        return this;
    }

    public MercuryRegisterPage setLastNameTextField() {
        return setLastNameTextField(PropertyLoader.loadProperty("contact.lastname"));
    }

    public MercuryRegisterPage setLastNameTextField(String lastName) {
        println("set last name text field: " + lastName);
        inputLastName.sendKeys(lastName);
        return this;
    }

    public MercuryRegisterPage setPhoneTextField() {
        return setPhoneTextField(PropertyLoader.loadProperty("contact.phone"));
    }

    public MercuryRegisterPage setPhoneTextField(String phone) {
        println("set phone text field: " + phone);
        inputPhone.sendKeys(phone);
        return this;
    }

    public MercuryRegisterPage setUserNameTextField() {
        return setUserNameTextField(PropertyLoader.loadProperty("contact.email"));
    }

    public MercuryRegisterPage setUserNameTextField(String userName) {
        println("set user name text field: " + userName);
        inputUserName.sendKeys(userName);
        return this;
    }

    public MercuryRegisterPage setAddress1TextField() {
        return setAddress1TextField(PropertyLoader.loadProperty("mailinfo.address"));
    }

    public MercuryRegisterPage setAddress1TextField(String address1) {
        println("set address text field :" + address1);
        inputAddress1.sendKeys(address1);
        return this;
    }

    public MercuryRegisterPage setAddress2TextField() {
        return setAddress2TextField(PropertyLoader.loadProperty("mailinfo.address"));
    }

    public MercuryRegisterPage setAddress2TextField(String address2) {
        println("set address text field :" + address2);
        inputAddress2.sendKeys(address2);
        return this;
    }

    public MercuryRegisterPage setCityTextField() {
        return setCityTextField(PropertyLoader.loadProperty("mailinfo.city"));
    }

    public MercuryRegisterPage setCityTextField(String city) {
        println("set city text field :" + city);
        inputCity.sendKeys(city);
        return this;
    }

    public MercuryRegisterPage setStateTextField() {
        return setStateTextField(PropertyLoader.loadProperty("mailinfo.state"));
    }

    public MercuryRegisterPage setStateTextField(String state) {
        println("set state text field :" + state);
        inputState.sendKeys(state);
        return this;
    }

    public MercuryRegisterPage setPostalCodeTextField() {
        return setPostalCodeTextField(PropertyLoader.loadProperty("mailinfo.postalcode"));
    }

    public MercuryRegisterPage setPostalCodeTextField(String postalcode) {
        println("set postal code text field :" + postalcode);
        inputPostalCode.sendKeys(postalcode);
        return this;
    }

    public MercuryRegisterPage selectCountry(String country) {
        println("select country field :" + country);
        new Select(inputCountry).selectByVisibleText(country);
        return this;
    }

    public MercuryRegisterPage verifyPageLoaded() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getPageSource().contains(pageLoadedText);
            }
        });
        return this;
    }

    public MercuryRegisterPage verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }

    public boolean verifySuccessMessage(){
        WebElement successmsg = driver.findElement(By.cssSelector("body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(3) > td > p:nth-child(2)"));
        return successmsg.getText().equals(SUCCESS_MESSAGE);
    }

    public MercuryRegisterPage registerUser() {
        fill();
        clickSubmitButton();
        return this;
    }
}
