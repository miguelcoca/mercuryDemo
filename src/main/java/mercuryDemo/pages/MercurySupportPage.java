package mercuryDemo.pages;
import java.util.Map;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by mike on 1/31/16.
 */

public class MercurySupportPage extends Page{
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

    @FindBy(css = "a[href='mercuryreservation.php']")
    @CacheLookup
    private WebElement flights;

    @FindBy(css = "div table tbody tr td:nth-of-type(1) table tbody tr td table tbody tr td table tbody tr:nth-of-type(1) td:nth-of-type(2) font a")
    @CacheLookup
    private WebElement home;

    @FindBy(css = "div table tbody tr td:nth-of-type(1) table tbody tr td table tbody tr td table tbody tr:nth-of-type(3) td:nth-of-type(2) a")
    @CacheLookup
    private WebElement hotels;

    private final String pageLoadedText = "Please press your browser's back         button to return to the previous page or click the \"BACK TO HOME\"";

    private final String pageUrl = "/mercuryunderconst.php";

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

    public MercurySupportPage(WebDriver driver) {
        super(driver);
    }

    public MercurySupportPage clickCarRentalsLink() {
        carRentals.click();
        return this;
    }

    public MercurySupportPage clickContactLink() {
        contact.click();
        return this;
    }

    public MercurySupportPage clickCruisesLink() {
        cruises.click();
        return this;
    }

    public MercurySupportPage clickDestinationsLink() {
        destinations.click();
        return this;
    }

    public MercurySupportPage clickFlightsLink() {
        flights.click();
        return this;
    }

    public MercurySupportPage verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }
}
