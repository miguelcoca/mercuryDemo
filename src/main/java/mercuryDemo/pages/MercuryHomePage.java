package mercuryDemo.pages;

import java.util.Map;

import mercuryDemo.util.PropertyLoader;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by mike on 1/30/16.
 */

public class MercuryHomePage extends Page {
    public static final String SELECTOR_BUSINESS_TRAVEL_ABOUT_COM = "a[href='http://businesstravel.about.com/mbody.htm?PM=78_101_T&cob=home']";
    public static final String SELECTOR_CAR_RENTALS = "div table tbody tr td:nth-of-type(1) table tbody tr td table tbody tr td table tbody tr:nth-of-type(4) td:nth-of-type(2) font a";
    public static final String SELECTOR_CONTACT = "div table tbody tr td:nth-of-type(2) table tbody tr:nth-of-type(2) td table tbody tr td:nth-of-type(4) a";
    public static final String SELECTOR_CRUISES = "a[href='mercurycruise.php?osCsid=96c8a6a6e501834918c5788d34eb8efa']";
    public static final String SELECTOR_DESTINATIONS = "div table tbody tr td:nth-of-type(1) table tbody tr td table tbody tr td table tbody tr:nth-of-type(6) td:nth-of-type(2) a";
    public static final String SELECTOR_FEATURED_VACATION_DESTINATIONS = "div table tbody tr td:nth-of-type(2) table tbody tr:nth-of-type(4) td table tbody tr td:nth-of-type(2) table tbody tr:nth-of-type(2) td:nth-of-type(3) form table tbody tr:nth-of-type(8) td table tbody tr td:nth-of-type(2) font a";
    public static final String SELECTOR_FLIGHTS = "a[href='mercuryreservation.php?osCsid=96c8a6a6e501834918c5788d34eb8efa']";
    public static final String SELECTOR_HOME = "a[href='mercurywelcome.php?osCsid=96c8a6a6e501834918c5788d34eb8efa']";
    public static final String SELECTOR_HOTELS = "div table tbody tr td:nth-of-type(1) table tbody tr td table tbody tr td table tbody tr:nth-of-type(3) td:nth-of-type(2) a";
    public static final String SELECTOR_REGISTER = "div table tbody tr td:nth-of-type(2) table tbody tr:nth-of-type(2) td table tbody tr td:nth-of-type(2) a";
    public static final String SELECTOR_REGISTER_HERE = "div table tbody tr td:nth-of-type(2) table tbody tr:nth-of-type(4) td table tbody tr td:nth-of-type(2) table tbody tr:nth-of-type(2) td:nth-of-type(3) form table tbody tr:nth-of-type(10) td table tbody tr td:nth-of-type(2) font a";
    public static final String SELECTOR_SALON_TRAVEL = "a[href='http://www.salon.com/travel/index.html']";
    public static final String SELECTOR_SIG_ON = "SIGN-ON";
    public static final String SELECTOR_SUPPORT = "div table tbody tr td:nth-of-type(2) table tbody tr:nth-of-type(2) td table tbody tr td:nth-of-type(3) a";
    public static final String SELECTOR_VACATIONS = "div table tbody tr td:nth-of-type(1) table tbody tr td table tbody tr td table tbody tr:nth-of-type(7) td:nth-of-type(2) a";
    public static final String SELECTOR_YOUR_DESTINATION = "div table tbody tr td:nth-of-type(2) table tbody tr:nth-of-type(4) td table tbody tr td:nth-of-type(2) table tbody tr:nth-of-type(2) td:nth-of-type(3) form table tbody tr:nth-of-type(6) td table tbody tr td:nth-of-type(2) font a";
    public static final String SELECTOR_REGISTER_FORM = "body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table";
    public static final String SELECTOR_UNDER_CONSTRUCTION_MSG = "body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr:nth-child(1) > td:nth-child(2) > table > tbody > tr:nth-child(3) > td > p > font:nth-child(1)";
    private int timeout = 15;

    @FindBy(css = SELECTOR_BUSINESS_TRAVEL_ABOUT_COM)
    @CacheLookup
    private WebElement businessTravelAboutCom;

    @FindBy(css = SELECTOR_CAR_RENTALS)
    @CacheLookup
    private WebElement carRentals;

    @FindBy(css = SELECTOR_CONTACT)
    @CacheLookup
    private WebElement contact;

    @FindBy(css = SELECTOR_CRUISES)
    @CacheLookup
    private WebElement cruises;

    @FindBy(css = SELECTOR_DESTINATIONS)
    @CacheLookup
    private WebElement destinations;

    @FindBy(css = SELECTOR_FEATURED_VACATION_DESTINATIONS)
    @CacheLookup
    private WebElement featuredVacationDestinations;

    @FindBy(css = SELECTOR_FLIGHTS)
    @CacheLookup
    private WebElement flights;

    @FindBy(css = SELECTOR_HOME)
    @CacheLookup
    private WebElement home;

    @FindBy(css = SELECTOR_HOTELS)
    @CacheLookup
    private WebElement hotels;

    @FindBy(name = "login")
    @CacheLookup
    private WebElement login;

    private final String pageLoadedText = "to find the lowest fare on participating";

    private final String pageUrl = "/";

    @FindBy(css = SELECTOR_REGISTER)
    @CacheLookup
    private WebElement register;

    @FindBy(css = SELECTOR_REGISTER_HERE)
    @CacheLookup
    private WebElement registerHere;

    @FindBy(css = SELECTOR_SALON_TRAVEL)
    @CacheLookup
    private WebElement salonTravel;

    @FindBy(linkText = SELECTOR_SIG_ON)
    @CacheLookup
    private WebElement signon;

    @FindBy(css = SELECTOR_SUPPORT)
    @CacheLookup
    private WebElement support;

    @FindBy(name = "userName")
    @CacheLookup
    private WebElement userNameText;

    @FindBy(name = "password")
    @CacheLookup
    private WebElement passwordText;

    @FindBy(css = SELECTOR_VACATIONS)
    @CacheLookup
    private WebElement vacations;

    @FindBy(css = SELECTOR_YOUR_DESTINATION)
    @CacheLookup
    private WebElement yourDestination;

    public MercuryHomePage(WebDriver driver) {
        super(driver);
    }

    public MercuryHomePage clickBusinessTravelAboutComLink() {
        businessTravelAboutCom.click();
        return this;
    }

    public MercuryHomePage clickCarRentalsLink() {
        carRentals.click();
        return this;
    }

    public MercuryHomePage clickContactLink() {
        contact.click();
        return this;
    }

    public MercuryHomePage clickCruisesLink() {
        cruises.click();
        return this;
    }

    public MercuryHomePage clickDestinationsLink() {
        destinations.click();
        return this;
    }

    public MercuryHomePage clickFeaturedVacationDestinationsLink() {
        featuredVacationDestinations.click();
        return this;
    }

    public MercuryHomePage clickFlightsLink() {
        flights.click();
        return this;
    }

    public MercuryHomePage clickHomeLink() {
        home.click();
        return this;
    }

    public MercuryHomePage clickHotelsLink() {
        hotels.click();
        return this;
    }

    public MercuryHomePage clickLoginButton() {
        println("click login button");
        login.click();
        return this;
    }

    public MercuryHomePage clickRegisterHereLink() {
        registerHere.click();
        return this;
    }

    public MercuryHomePage clickRegisterLink() {
        println("click register link");
        register.click();
        return this;
    }

    public MercuryHomePage clickSalonTravelLink() {
        salonTravel.click();
        return this;
    }

    public MercuryHomePage clickSignonLink() {
        println("click SignOn link");
        signon.click();
        return this;
    }

    public MercuryHomePage clickSupportLink() {
        println("click support link");
        support.click();
        return this;
    }

    public MercuryHomePage clickVacationsLink() {
        vacations.click();
        return this;
    }

    public MercuryHomePage clickYourDestinationLink() {
        yourDestination.click();
        return this;
    }

    public MercuryHomePage fill() {
        setUserNameField();
        sePasswordField();
        return this;
    }

    public MercuryHomePage setUserNameField() {
        return setUserNameField(PropertyLoader.loadProperty("user.username"));
    }

    public MercuryHomePage setUserNameField(String usersCanSigninHereToFind1Value) {
        println("write user name field :" + usersCanSigninHereToFind1Value);
        userNameText.sendKeys(usersCanSigninHereToFind1Value);
        return this;
    }

    public MercuryHomePage sePasswordField() {
        return sePasswordField(PropertyLoader.loadProperty("user.password"));
    }

    public MercuryHomePage sePasswordField(String usersCanSigninHereToFind2Value) {
        println("write password field: XXXXXXX");
        passwordText.sendKeys(usersCanSigninHereToFind2Value);
        return this;
    }

    public MercuryHomePage verifyPageLoaded() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getPageSource().contains(pageLoadedText);
            }
        });
        return this;
    }

    public MercuryHomePage verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }

    public boolean RegisterNewUser() {
        clickRegisterLink();
        MercuryRegisterPage mercuryRP;
        mercuryRP = PageFactory.initElements(getWebDriver(), MercuryRegisterPage.class);
        mercuryRP.registerUser();
        return mercuryRP.verifySuccessMessage();
    }

    public boolean SignOnFromPage() {
        clickSignonLink();
        MercurySignOnPage mercurySOP;
        mercurySOP = PageFactory.initElements(getWebDriver(), MercurySignOnPage.class);
        println("start signOn process");
        mercurySOP.doSignOn();

        return mercurySOP.verifySuccessfulSignOn();
    }

    public boolean homePageSignOn() {
        fill();
        clickLoginButton();
        return verifySuccessfulSignOn();
    }

    public boolean verifySuccessfulSignOn() {
        return (driver.findElement(By.linkText("SIGN-OFF")).isDisplayed());
    }

    public boolean makeReservation() {
        MercuryReservationPage mercuryReservation1;
        mercuryReservation1 = PageFactory.initElements(getWebDriver(), MercuryReservationPage.class);
        mercuryReservation1.fill("1");
        mercuryReservation1.clickfindflights();
        //Assert.assertTrue("Flight confirmation failed at stage 1", mercuryReservation1.verifyFindFlyghtsSuccess());

        MercuryReservationPage2 reservationPage2;
        reservationPage2 = PageFactory.initElements(getWebDriver(), MercuryReservationPage2.class);
        reservationPage2.fill();
        reservationPage2.clickreserveFlights();

        MercuryReservationPage3 reservationPage3;
        reservationPage3 = PageFactory.initElements(getWebDriver(), MercuryReservationPage3.class);
        reservationPage3.fill();
        reservationPage3.clickbuyFlights();
        Assert.assertTrue("Flight confirmation failed at stage 3", reservationPage3.verifyFlightConfirmation());

        return true;
    }

    public boolean verifyRegisterPageLoad() {
        clickRegisterLink();
        return (driver.findElement(By.cssSelector(SELECTOR_REGISTER_FORM)).isDisplayed());
    }

    public boolean verifySupportPageLoad() {
        clickSupportLink();
        return (!driver.findElement(By.cssSelector(SELECTOR_UNDER_CONSTRUCTION_MSG)).isDisplayed());
    }
}
