package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;


public class BookFlightLandingPage {

	 private WebDriver driver;
		
		

	
	@FindBy(xpath="//span[normalize-space()='To']")
    private WebElement _arrivalCityButton;

    @FindBy(xpath="//span[normalize-space()='ATL']")
    private WebElement _departureCityButton;

    @FindBy(xpath="//div[@class='airport-lookup-tablist-container pl-0 pr-0 mt-2']")
    private WebElement _destinationAlertBox;

    @FindBy(id="search_input")
    private  WebElement _destinationTextArea;
	
	//
	
	//Select selectRoomAccessibility = new Select(accessibleTrueFalse);
		
	public BookFlightLandingPage(WebDriver driver) {
			
			this.driver = driver;
			PageFactory.initElements(driver, this);
			
			
		}
	
	public BookFlightLandingPage() {
		
		
	}
	
	public void gotoDeltaWebsite() {
		driver.navigate().to("https://www.delta.com/");
	}
	
	
	public void ChooseDestination()
    {
        _arrivalCityButton.click();



        WebDriverWait wait = new WebDriverWait(driver, 10);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_input")));
      
        

        driver.switchTo().frame(_destinationAlertBox);

        _destinationTextArea.sendKeys("MIA");

    }
	
	
	
	

}
