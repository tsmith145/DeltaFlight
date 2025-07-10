package pagefactory;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public abstract class AbstractTest {
	//C:\Users\Mjrlo\eclipse-workspace\cucumberProject\target
	
	protected WebDriver driver;
	
	
	public void isGridEnabled() throws MalformedURLException {
		if(Boolean.getBoolean("selenium.grid.enabled")) {
			this.driver = getRemoteDriver();
		}
	}
	


	public WebDriver getRemoteDriver() throws MalformedURLException {
		Capabilities capabilities;
		
		if(System.getProperty("browser").equalsIgnoreCase("chrome")) {
			capabilities= new ChromeOptions();
		}else {
			capabilities= new FirefoxOptions();
		}
		
		return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
	}

}
