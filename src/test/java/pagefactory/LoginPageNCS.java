package pagefactory;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageNCS {
	
	private WebDriver driver;
	
	@FindBy(id="username")
    private WebElement _userName;

	@FindBy(id="password")
    private WebElement _password;

    @FindBy(xpath="//button[@type='submit']")
    private WebElement _loginButton;
    
    
    @FindBy(id="flash")
    private WebElement _loginErrorMessage;
    
    private WebDriverWait wait;


    
	public LoginPageNCS(WebDriver driver) {
		
		this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(6));

		PageFactory.initElements(driver, this);
		
		
		
	}


    
   public void gotoTestPage() {
	   driver.navigate().to("https://practice.expandtesting.com/login");
   }
    
    public void inValidUsername() {
    	_userName.sendKeys("asdfasdf");
    	
    }
    
    
    public void inValidPassword() {
    	_password.sendKeys("asdfasdf");
  
    }
    
    public void validUsername() {
    	_password.sendKeys("practice!");
  
    }
    
    public void validPassword() {
    	_password.sendKeys("SuperSecretPassword!");
  
    }
    
    public void hitSubmitButton() {
		/*
		 * wait.until(ExpectedConditions.elementToBeClickable(_loginButton));
		 * ((JavascriptExecutor) driver)
		 * .executeScript("window.scrollTo(0, document.body.scrollHeight)");
		 */
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
    	driver.manage().window().maximize();
    	
    	synchronized (_loginButton) {
        	try {
        		_loginButton.wait(10000);
        	} catch (InterruptedException e) {
        		e.printStackTrace();
        	}
        }

    	//jse.executeScript("arguments[0].scrollIntoView()", _loginButton);
    	
    	
    	
    	
    	_loginButton.click();
    }
    
    public boolean isUsernameErrorValid() {
    	
    	wait.until(ExpectedConditions.elementToBeClickable(_loginButton));
    	String err="Your username is invalid!";
    	 if (_loginErrorMessage.getText().equals(err.trim())) {
    		 return true;
    	 }
    	 
    	 return false;
    }
    
    public boolean isPasswordErrorValid() {
    	String err="Your password is invalid!";
    	 if (_loginErrorMessage.getText().equals(err.trim())) {
    		 return true;
    	 }
    	 
    	 return false;
    }
    
	public String getWebTitle() {
		String websiteTitle = driver.getTitle();
		
		return websiteTitle;
	}
	 


}
