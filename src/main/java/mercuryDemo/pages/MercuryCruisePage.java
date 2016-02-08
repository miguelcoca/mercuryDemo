package mercuryDemo.pages;
import java.util.Map;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by mike on 1/30/16.
 */

public class MercuryCruisePage extends Page{
    private int timeout = 15;

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

    @FindBy(css = "div table tbody tr td:nth-of-type(1) table tbody tr td table tbody tr td table tbody tr:nth-of-type(2) td:nth-of-type(2) a")
    @CacheLookup
    private WebElement flights;

    @FindBy(css = "a[href='mercurywelcome.php']")
    @CacheLookup
    private WebElement home;

    @FindBy(css = "div table tbody tr td:nth-of-type(1) table tbody tr td table tbody tr td table tbody tr:nth-of-type(3) td:nth-of-type(2) a")
    @CacheLookup
    private WebElement hotels;

    private final String pageLoadedText = "Saturday departures from Seattle via the Inside Passage to Juneau, Hubbard Glacier, Yakutat Bay";

    private final String pageUrl = "/mercurycruise.php";

    @FindBy(css = "a[href='mercuryregister.php']")
    @CacheLookup
    private WebElement register;

    @FindBy(css = "div table tbody tr td:nth-of-type(2) table tbody tr:nth-of-type(4) td table tbody tr td:nth-of-type(2) table tbody tr:nth-of-type(2) td table tbody tr:nth-of-type(1) td p:nth-of-type(3) a")
    @CacheLookup
    private WebElement reservationsOpen;

    @FindBy(css = "a[href='mercurysignon.php']")
    @CacheLookup
    private WebElement signon;

    @FindBy(css = "div table tbody tr td:nth-of-type(2) table tbody tr:nth-of-type(2) td table tbody tr td:nth-of-type(3) a")
    @CacheLookup
    private WebElement support;

    @FindBy(css = "div table tbody tr td:nth-of-type(1) table tbody tr td table tbody tr td table tbody tr:nth-of-type(7) td:nth-of-type(2) a")
    @CacheLookup
    private WebElement vacations;

    public MercuryCruisePage(WebDriver driver) {
       super(driver);
    }

    public MercuryCruisePage clickCarRentalsLink() {
        carRentals.click();
        return this;
    }

    public MercuryCruisePage clickContactLink() {
        contact.click();
        return this;
    }

    public MercuryCruisePage clickCruisesLink() {
        cruises.click();
        return this;
    }

    public MercuryCruisePage clickDestinationsLink() {
        destinations.click();
        return this;
    }

    public MercuryCruisePage clickFlightsLink() {
        flights.click();
        return this;
    }

    public MercuryCruisePage clickHomeLink() {
        home.click();
        return this;
    }

    public MercuryCruisePage clickHotelsLink() {
        hotels.click();
        return this;
    }

    public MercuryCruisePage clickRegisterLink() {
        register.click();
        return this;
    }

    public MercuryCruisePage clickReservationsOpenLink() {
        reservationsOpen.click();
        return this;
    }

    public MercuryCruisePage clickSignonLink() {
        signon.click();
        return this;
    }

    public MercuryCruisePage clickSupportLink() {
        support.click();
        return this;
    }

    public MercuryCruisePage clickVacationsLink() {
        vacations.click();
        return this;
    }

    public MercuryCruisePage verifyPageLoaded() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getPageSource().contains(pageLoadedText);
            }
        });
        return this;
    }

    public MercuryCruisePage verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }
}
