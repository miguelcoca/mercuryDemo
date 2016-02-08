package mercuryDemo.pages;

import mercuryDemo.util.PropertyLoader;
import org.apache.commons.collections.set.PredicatedSortedSet;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * Created by mike on 1/31/16.
 */
public class MercuryReservationPage3 extends Page{


    public static final String SELECTOR_SUCCESS_CONFIRMATION = "body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr:nth-child(1) > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > table > tbody > tr:nth-child(1) > td > table > tbody > tr > td:nth-child(1) > b > font > font > b > font:nth-child(1)";
    @FindBy(name = "passFirst0")
    @CacheLookup
    private WebElement passFirstName;

    @FindBy(name = "passLast0")
    @CacheLookup
    private WebElement passLastName;

    @FindBy(name = "pass.0.meal")
    @CacheLookup
    private WebElement passMeal;

    @FindBy(name = "creditCard")
    @CacheLookup
    private WebElement creditCard;

    @FindBy(name = "creditnumber")
    @CacheLookup
    private WebElement creditCardNumber;

    @FindBy(name = "cc_exp_dt_mn")
    @CacheLookup
    private WebElement cc_exp_dt_mn;

    @FindBy(name = "cc_exp_dt_yr")
    @CacheLookup
    private WebElement cc_exp_dt_yr;

    @FindBy(name = "cc_frst_name")
    @CacheLookup
    private WebElement ccFirstName;

    @FindBy(name = "cc_mid_name")
    @CacheLookup
    private WebElement ccMidName;

    @FindBy(name = "cc_last_name")
    @CacheLookup
    private WebElement ccLastName;

    @FindBy(name = "buyFlights")
    @CacheLookup
    private WebElement buyFlights;

    @FindBy(name = "billCountry")
    @CacheLookup
    private WebElement billCountry;

    @FindBy(name = "delCountry")
    @CacheLookup
    private WebElement delCountry;

    public MercuryReservationPage3(WebDriver driver){
        super(driver);
    }

    public MercuryReservationPage3 fill(){
        println("write first Name:" + PropertyLoader.loadProperty("contact.firstname"));
        passFirstName.sendKeys(PropertyLoader.loadProperty("contact.firstname"));
        println("write last name: " + PropertyLoader.loadProperty("contact.lastname"));
        passLastName.sendKeys(PropertyLoader.loadProperty("contact.lastname"));
        println("select meal type");
        new Select(passMeal).selectByVisibleText("Low Cholesterol");
        println("select credit card");
        new Select(creditCard).selectByVisibleText("MasterCard");
        println("write credit card number");
        creditCardNumber.sendKeys("001234567890");
        println("select credit card expiration date");
        new Select(cc_exp_dt_mn).selectByVisibleText("10");
        println("select credit card expiration year");
        new Select(cc_exp_dt_yr).selectByVisibleText("2010");
        println("write contact first name");
        ccFirstName.sendKeys(PropertyLoader.loadProperty("contact.firstname"));
        println("write contact middle name");
        ccMidName.sendKeys(PropertyLoader.loadProperty("contact.firstname"));
        println("write contact last name");
        ccLastName.sendKeys(PropertyLoader.loadProperty("contact.lastname"));
        println("click button dialog");
        driver.findElement(By.cssSelector("body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table > tbody > tr:nth-child(1) > td > font > font > b > font > font")).click();
        println("dealing with save dialog, switch to AWT robot");
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_PAGE_DOWN);
            robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        } catch (Exception e){
            e.printStackTrace();
        }

        println("select bill country United states");
        new Select(driver.findElement(By.name("billCountry"))).selectByVisibleText("UNITED STATES");
        println("select delivery country United states");
        new Select(driver.findElement(By.name("delCountry"))).selectByVisibleText("UNITED STATES");

        return this;
    }

    public boolean verifyFlightConfirmation(){
        println("verify success flight confirmation");
        return driver.findElement(By.cssSelector(SELECTOR_SUCCESS_CONFIRMATION)).getText().contains("Flight Confirmation");
    }

    public void clickbuyFlights() {
        println("click buy flights");
        buyFlights.sendKeys(Keys.ENTER);
        //driver.findElement(By.name("buyFlights")).click();
    }
}
