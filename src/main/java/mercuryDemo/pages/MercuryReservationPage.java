package mercuryDemo.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by mike on 1/30/16.
 */
public class MercuryReservationPage extends Page {

    public static final String SUCCESS_SELECTOR = "body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table:nth-child(9) > tbody > tr:nth-child(1) > td > table > tbody > tr:nth-child(1) > td:nth-child(1) > font > b > font";
    public static final String CHECK_ROUND_TRIP = "body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table > tbody > tr:nth-child(2) > td:nth-child(2) > b > font > input[type=\"radio\"]:nth-child(1)";
    public static final String SELECTOR_CHECK_CLASS = "body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table > tbody > tr:nth-child(9) > td:nth-child(2) > font > font > input[type=\"radio\"]:nth-child(4)";

    @FindBy(name = "tripType")
    @CacheLookup
    private WebElement radioButtonTripType; //value=roundtrip|oneway

    @FindBy(css = CHECK_ROUND_TRIP)
    @CacheLookup
    private WebElement checkRoundTrip;

    @FindBy(name = "passCount")
    @CacheLookup
    private WebElement passengerCount;

    @FindBy(name = "fromPort")
    @CacheLookup
    private WebElement fromPort;

    @FindBy(name = "fromMonth")
    @CacheLookup
    private WebElement fromMonth;

    @FindBy(name = "fromDay")
    @CacheLookup
    private WebElement fromDay;

    @FindBy(name = "toPort")
    @CacheLookup
    private WebElement toPort;

    @FindBy(name = "toMonth")
    @CacheLookup
    private WebElement toMonth;

    @FindBy(name = "toDay")
    @CacheLookup
    private WebElement toDay;

    @FindBy(name = "servClass")
    @CacheLookup
    private WebElement servClass;

    @FindBy(css = SELECTOR_CHECK_CLASS)
    @CacheLookup
    private WebElement checkServClass;

    @FindBy(name = "airline")
    @CacheLookup
    private WebElement airline;


    @FindBy(name = "findFlights")
    @CacheLookup
    private WebElement findflights;

    public MercuryReservationPage(WebDriver driver){
        super(driver);
    }

    public MercuryReservationPage fill(String count){
        println("click round trip option");
        checkRoundTrip.click();
        println("select passenger count value: " + count.toString());
        new Select(passengerCount).selectByValue(count);
        println("select London as from port");
        new Select(fromPort).selectByVisibleText("London");
        println("select from Month: February");
        new Select(fromMonth).selectByVisibleText("February");
        println("select from Day: 15");
        new Select(fromDay).selectByVisibleText("15");
        println("select destination port: New York");
        new Select(toPort).selectByVisibleText("New York");
        println("select arrival month: March");
        new Select(toMonth).selectByVisibleText("March");
        println("select arrival day: 20");
        new Select(toDay).selectByVisibleText("20");
        println("select trip class ");
        checkServClass.click();
        println("select airline: Unified Airlines");
        new Select(airline).selectByVisibleText("Unified Airlines");

        return this;
    }

    public MercuryReservationPage clickFindSlights(){
        findflights.click();
        return this;
    }

    public boolean verifyFindFlyghtsSuccess(){
        return (driver.findElement(By.cssSelector(SUCCESS_SELECTOR)).isDisplayed() &&
                driver.getCurrentUrl().contains("mercuryreservation2"));
    }

    public void clickfindflights() {
        println("click find flights ");
        findflights.click();
    }
}
