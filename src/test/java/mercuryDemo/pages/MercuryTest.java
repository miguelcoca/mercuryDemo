package mercuryDemo.pages;

import org.junit.Before;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by mike on 1/31/16.
 */


public class MercuryTest extends TestBase {

	MercuryHomePage homepage;

	@Before
	public void testInit() {
		webDriver.get(websiteUrl);
		homepage = PageFactory.initElements(webDriver, MercuryHomePage.class);
	}

	@Test
	public void testH1Existing() throws Exception {
		//Assert.fail();
		Assert.assertTrue(homepage.getTitle().equals("Welcome: Mercury Tours"));
	}

	@Test
	public void testRegisterNewUser() throws Exception {
		MercuryHomePage mercuryHome;
		mercuryHome = PageFactory.initElements(webDriver, MercuryHomePage.class);
		Assert.assertTrue("Error: Unable to Register a New User", mercuryHome.RegisterNewUser());
	}

	@Test
	public void testSignOn() throws Exception {
		MercuryHomePage mercuryHome;
		mercuryHome = PageFactory.initElements(webDriver, MercuryHomePage.class);
		Assert.assertTrue("Error: Unable to Sign In", mercuryHome.SignOnFromPage());
	}

	@Test
	public void testHomePageSignOn() throws Exception {
		MercuryHomePage mercuryHome;
		mercuryHome = PageFactory.initElements(webDriver, MercuryHomePage.class);
		Assert.assertTrue("Error: Unable to Sign In from Mercury Home Page", mercuryHome.homePageSignOn());
	}

	@Test
	public void testDoReservation() throws Exception {
		MercuryHomePage mercuryHome;
		mercuryHome = PageFactory.initElements(webDriver, MercuryHomePage.class);
		mercuryHome.SignOnFromPage();
		Assert.assertTrue("Error: Unable to make reservation", mercuryHome.makeReservation());
	}

	@Test
	public void testRegisterPage() throws Exception {
		MercuryHomePage mercuryHome;
		mercuryHome = PageFactory.initElements(webDriver, MercuryHomePage.class);
		Assert.assertTrue("Error: Unable to browse to register page", mercuryHome.verifyRegisterPageLoad());
	}

	@Test
	public void testSupportPage() throws Exception {
		MercuryHomePage mercuryHome;
		mercuryHome = PageFactory.initElements(webDriver, MercuryHomePage.class);
		Assert.assertTrue("Error: Unable to browse to support page under construction message displayed", mercuryHome.verifySupportPageLoad());
	}
}
