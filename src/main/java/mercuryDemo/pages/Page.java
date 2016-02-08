package mercuryDemo.pages;

import mercuryDemo.util.PropertyLoader;
import org.openqa.selenium.WebDriver;

/**
 * Created by mike on 1/31/16.
 */

public abstract class Page {

	protected WebDriver driver;
	protected boolean DEBUG;

	public Page(WebDriver webDriver) {
		this.driver = webDriver;

		if(PropertyLoader.loadProperty("site.DEBUG").equals("true")){
			DEBUG = true;
		}
	}

	public WebDriver getWebDriver() {
		return driver;
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public void println(String message){
		if(DEBUG){
			System.out.println(message);
		}
	}
}
