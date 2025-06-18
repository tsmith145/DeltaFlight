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


public class BookRoomBookingPage_PF {

	private WebDriver driver;
		
   
		
		
	@FindBy(xpath="//a[@id='frontPageLink']")
	private	WebElement frontPageLink;
		
	@FindBy(id="roomName")	
	WebElement txt_roomNumber;
	
	@FindBy(id="type")
	WebElement roomTypeDropDown;
	
	@FindBy(id="accessible")
	WebElement accessibleTrueFalse;
	
	@FindBy(id="roomPrice")
	WebElement roomPriceText;
	
	
	@FindBy(id="wifiCheckbox")
	WebElement wifiCheckBox;
	
	@FindBy(id="safeCheckbox")
	WebElement safeCheckbox;
	
	@FindBy(id="createRoom")
	WebElement createRoomButton;
	
	//
	
	//Select selectRoomAccessibility = new Select(accessibleTrueFalse);
		
	public BookRoomBookingPage_PF(WebDriver driver1) {
			
			this.driver = driver1;
			
			
			
			
		}
	
	public BookRoomBookingPage_PF() {
		
		
		
		
		
		
	}
	
	@SuppressWarnings("deprecation")
	public void validateUserReachedBooking() {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement Category_Body = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("frontPageLink")));
		
		String frontPageSTring =frontPageLink.getText();
		
		String expectedFrontPageText= "Front Page";
		Assert.assertEquals(frontPageSTring, expectedFrontPageText);
		
		  
	}
	
	public void gotWebSite() {
		
		driver.navigate().to("https://automationintesting.online/#/admin");
	}
	public void enterRoomNumber(String numberForRoom) {
		txt_roomNumber.sendKeys(numberForRoom);
		
	}
	
	public void selectRoomType() {
		Select selectRoomType = new Select(roomTypeDropDown);
		selectRoomType.selectByVisibleText("Family");
	}
	
	
	public void setRoomAccessibility() {
		
		Select selectRoomAccessibility = new Select(accessibleTrueFalse);
		selectRoomAccessibility.selectByVisibleText("True");
	}
	
	public void enterRoomPrice(String numberForPrice) {
		txt_roomNumber.sendKeys(numberForPrice);
		
	}
	
	public void checkWifiBox() {
		wifiCheckBox.click();
	}
	
	public void checkSafeBox() {
		safeCheckbox.click();
	}
	
	public void createRoom() {
		createRoomButton.click();
	}
	

}
