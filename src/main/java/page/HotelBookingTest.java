package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HotelBookingTest {

    WebDriver driver;

    @FindBy(linkText = "Hotels")
    private WebElement hotelLink;

    @FindBy(id = "Tags")
    private WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;

    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;
    
    
    public HotelBookingTest(WebDriver driver){
        this.driver = driver;
        
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }
    
    public void clickHotel(){
    	
    	hotelLink.click();
    }
    
    public void setLocality(String locality){

    	localityTextBox.sendKeys(locality);

    }
    
    public void setTraveller(String noOfRooms){

    	travellerSelection.sendKeys(noOfRooms);

    }
    
    public void clickSearch(){
    	
    	searchButton.click();
    }
    
    public void shouldBeAbleToSearchForHotels(String locality,String noOfRooms){

        this.clickHotel();
        this.setLocality(locality);
        this.setTraveller(noOfRooms);
        this.searchButton.click();
        
    }

}
