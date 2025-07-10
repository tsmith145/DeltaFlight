package pagefactory;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;


public class BookFlightLandingPage {

	 private WebDriver driver;
		
	 private WebDriverWait wait;

	
	@FindBy(xpath="//span[normalize-space()='To']")
    private WebElement _arrivalCityButton;

    @FindBy(xpath="//span[normalize-space()='ATL']")
    private WebElement _departureCityButton;

    @FindBy(xpath="//div[@class='airport-lookup-tablist-container pl-0 pr-0 mt-2']")
    private WebElement _destinationAlertBox;

    @FindBy(id="search_input")
    private  WebElement _destinationTextArea;
    
    ////div[@class='tab-content']//li[2]
    @FindBy(xpath="//div[@class='tab-content']//li[2]")
    private WebElement _citySelectionValue;
	
  @FindBy(css=".search-flyout-close")
    private WebElement _closeDestinationTextAreaButton;
  
  @FindBy(xpath="//a[@aria-label='19 July 2025, Saturday']")
  private WebElement _july19Date;
  
  @FindBy(xpath="//a[@aria-label='25 July 2025, Friday']")
  private WebElement _july25Date;
  
  
  @FindBy(css=".calDateSeparator")
  private WebElement _datePicker;
  
  @FindBy(xpath="//button[@value='done']")
  private WebElement _datePickerCloseOut;
  
  ////b[normalize-space()='Your username is invalid!']
  
  
  @FindBy(id="selectTripType")
  private WebElement _tripTypeSpinner;
 
  
  @FindBy(id="onetrust-accept-btn-handler")
  private WebElement _popUp;
  
  
  @FindBy(xpath="//div[@class='idp-error-tooltip']")
  private WebElement _topPagePopUp;
  
  

  @FindBy(id="ui-list-selectTripType0")
  private WebElement _roundTripValue;
  
  @FindBy(id="btnSubmit")
  private WebElement _submitSearchButton;
  
  @FindBy(id="ui-list-selectTripType2")
  private WebElement multiCitySelect;
  
	JavascriptExecutor js;

	//Select selectRoomAccessibility = new Select(accessibleTrueFalse);
		
	public BookFlightLandingPage(WebDriver driver) {
			
			this.driver = driver;
			PageFactory.initElements(driver, this);
			
			wait = new WebDriverWait(driver, Duration.ofSeconds(7));
			
			
		}
	
	public BookFlightLandingPage() {
		
		
	}
	
	public void gotoDeltaWebsite() {
		driver.navigate().to("https://www.delta.com/");
		driver.manage().window().maximize();
	}
	
	public void acceptPopup() {
		/*
		 * driver.manage().window().maximize(); Wait<WebDriver> wait = new
		 * WebDriverWait(driver, Duration.ofSeconds(12));
		 * 
		 * 
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
		 * "onetrust-accept-btn-handler")));
		 */
			 
		
		
		

		 js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", _popUp);
		
	
		
		
	}
	
	public void selectRoundTrip() {
		
		
		 Select select = new Select(_tripTypeSpinner);
		 
	
		 
		 select.selectByVisibleText("Round Trip");
		
		// _topPagePopUp.click();
		//_roundTripValue.click();
		
	}
	
public void searchMultiCity() {

		Select select = new Select(_tripTypeSpinner);
		
		List<WebElement> selectElements = select.getOptions();
		
		for (WebElement e:selectElements ) {
			System.out.println(e.getText());
		}
	
		
		driver.findElement(By.id("selectTripType-val")).click();
		//wait.until(ExpectedConditions.elementToBeClickable(By.id("ui-list-selectTripType2")));
		
		js.executeScript("arguments[0].click();", multiCitySelect);
		//select.selectByVisibleText("Multi-City");
		
	}

	
	public void ChooseDestination()
    {
		/*
		 * _arrivalCityButton.click();
		 * 
		 * 
		 * 
		 * WebDriverWait wait = new WebDriverWait(driver, 10);
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_input"
		 * )));
		 * 
		 * driver.manage().window().setSize(new Dimension(1024, 768));
		 * 
		 * _destinationTextArea.sendKeys("HOU");
		 * _closeDestinationTextAreaButton.click();
		 */
		
	  //span[@id='selectTripType-val']

	//   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='To']")));

		 	_arrivalCityButton.click();

	  
	    
	// destination city text Alert box
	    _destinationTextArea.sendKeys("NYC");
	    _destinationTextArea.sendKeys(Keys.ENTER);
	    
      
        
     
        
        

	   
	   
	    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_input")));
	    //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

	///close the arriving city alert box (the x button)
	    _closeDestinationTextAreaButton.click();

    }
	
	
	
	public void chooseDates () {
		

		   _datePicker.click();

		// the date July 21st
		  driver.manage().window().maximize();
		  
		  
		  
		   _july19Date.click();

		// the date July 25st
		  //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("25")));
		 
		   
		   synchronized (_datePicker) { try { _datePicker.wait(3000);
			 } catch (InterruptedException e) { e.printStackTrace(); } }
		 
			//_july25Date.click();
			JavascriptExecutor js =  (JavascriptExecutor)driver;
			
			js.executeScript("arguments[0].click();", _july25Date);
			
		    
		  //button[@value='done']elementToBeClickable
		    _datePickerCloseOut.click();
		  //  driver.findElement(By.cssSelector(".donebutton")).click();
		  //  driver.findElement(By.id("btn-book-submit")).click();
	}
	
	
	public void submitSearch() {
		
		JavascriptExecutor js =  (JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].click();", _submitSearchButton);
		
	
	}
	
	
	
	

}
