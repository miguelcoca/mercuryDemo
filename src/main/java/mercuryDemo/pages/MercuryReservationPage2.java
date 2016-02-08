package mercuryDemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by mike on 1/31/16.
 */
public class MercuryReservationPage2 extends Page {

    public static final String SELECTOR_DEPART = "body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table:nth-child(9) > tbody > tr:nth-child(9) > td.frame_action_xrows > input[type=\"radio\"]";
    public static final String SELECTOR_RETURN = "body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table:nth-child(10) > tbody > tr:nth-child(9) > td.frame_action_xrows > input[type=\"radio\"]";

    @FindBy(css = MercuryReservationPage2.SELECTOR_DEPART)
    @CacheLookup
    private WebElement departFlight;

    @FindBy(css = MercuryReservationPage2.SELECTOR_RETURN)
    @CacheLookup
    private WebElement returnflight;

    @FindBy(name = "reserveFlights")
    @CacheLookup
    private  WebElement reserveFlights;

    public MercuryReservationPage2(WebDriver driver){
        super(driver);
    }

    public MercuryReservationPage2 fill(){
        println("click from flight");
        departFlight.click();
        println("click return flight");
        returnflight.click();

        return this;
    }

    public void clickreserveFlights() {
        println("click reserve Flights");
        reserveFlights.click();
    }
}
