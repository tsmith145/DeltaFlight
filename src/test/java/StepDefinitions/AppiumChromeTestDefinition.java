package StepDefinitions;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AppiumChromeTestDefinition {
	
	/*
	 * desired_caps = { 'platformName': 'Android', 'deviceName': 'Android Emulator',
	 * 'appPackage': 'com.android.calculator2', 'appActivity': '.Calculator' }
	 */
	
	AndroidDriver driverAndroid;
	
	@Before
	public void setupTask() {
		DesiredCapabilities desired_caps= new DesiredCapabilities();
		desired_caps.setCapability("platformName", "Android");
		desired_caps.setCapability("deviceName", "Pixel 2");
		//desired_caps.setCapability("appPackage", "com.android.chrome");
		desired_caps.setCapability("automationName", "UiAutomator2");
		desired_caps.setBrowserName("Chrome");
		//desired_caps.setCapability("platformName", "Android");
        try {
        	driverAndroid = new AndroidDriver(new URL("http://127.0.0.1:4723"), desired_caps);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        
	}
	
	@Given("Chrome is open on android phone")
	public void chrome_is_open_on_android_phone() {
		
		driverAndroid.navigate().to("https://www.delta.com/");
	}
	

	@Then("Im on delta.com")
	public void im_on_delta_com() {
		
	    
	}


}
