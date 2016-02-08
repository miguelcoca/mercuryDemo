package mercuryDemo.pages;

import mercuryDemo.util.Browser;
import mercuryDemo.util.PropertyLoader;
import mercuryDemo.webdriver.WebDriverFactory;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by mike on 1/31/16.
 */

public class TestBase {
	private static final String SCREENSHOT_FOLDER = "target/screenshots/";
	private static final String SCREENSHOT_FORMAT = ".png";

	protected static WebDriver webDriver;

	protected String gridHubUrl;

	protected String websiteUrl;

	protected Browser browser;

	@Before
	public void init() {
		websiteUrl = PropertyLoader.loadProperty("site.url");
		gridHubUrl = PropertyLoader.loadProperty("grid2.hub");

		browser = new Browser();
		browser.setName(PropertyLoader.loadProperty("browser.name"));
		browser.setVersion(PropertyLoader.loadProperty("browser.version"));
		browser.setPlatform(PropertyLoader.loadProperty("browser.platform"));

		String username = PropertyLoader.loadProperty("user.username");
		String password = PropertyLoader.loadProperty("user.password");
		
		webDriver = WebDriverFactory.getInstance(gridHubUrl, browser, username, password);
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() {
		if (webDriver != null) {
			webDriver.close();
		}
	}


	@Rule
	public TestRule testWatcher = new TestWatcher() {
		@Override
		protected void starting(Description desc) {
			System.out.println("Start running test: " +desc.getMethodName() + " Launching browser...");
		}

		@Override
		protected void finished(Description desc) {
			System.out.println("Finished running test: " +desc.getMethodName());
		}

		@Override
		protected void failed(Throwable e, Description d) {
			System.out.println("Test Failed: " +d.getMethodName());
			System.out.println("Creating screenshot...");

			String filename = d.getMethodName() + SCREENSHOT_FORMAT;
			File screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(screenshot, new File(SCREENSHOT_FOLDER + File.separator + "result" + File.separator + filename));
			} catch (IOException ioe) {
			System.out.println("Error copying screenshot after exception. " + ioe);
			}
		}
	};
}
