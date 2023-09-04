package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookRoomLoginPage_PF {
	private WebDriver driver2;
	
	@FindBy(id="username")
private	WebElement txt_username;
	
	
	@FindBy(id="password")
private	WebElement txt_password;
	
	
	@FindBy(id="doLogin")
private	WebElement loginButton;
	
	
	
	
public BookRoomLoginPage_PF(WebDriver driver1) {
		
		this.driver2 = driver1;
		PageFactory.initElements(driver1, this);
		
		
		
	}
	

public void gotWebSite() {
	
	driver2.navigate().to("https://automationintesting.online/#/admin");
}


public void enterUserNameAndPassword(String username, String password) {
	txt_username.sendKeys(username);
	txt_password.sendKeys(password);
	
	loginButton.click();
	
	
}




}
