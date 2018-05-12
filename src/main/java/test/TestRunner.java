package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sun.javafx.PlatformUtil;

import page.FlightBookingTest;
import page.HotelBookingTest;
import page.SignInTest;

public class TestRunner {
	
	WebDriver driver;
	HotelBookingTest hotelBookingTest;
	FlightBookingTest flightBookingTest;
	SignInTest signInTest;
	
	@BeforeTest
	public void setDriver() {
		 setDriverPath();
    	 driver = new ChromeDriver();
    	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@BeforeMethod
    public void launchApplication() {
    	 driver.get("https://www.cleartrip.com/");
    	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
	
	@Test(priority=2)
    public void test_HotelBooking(){
		hotelBookingTest = new HotelBookingTest(driver);
		hotelBookingTest.shouldBeAbleToSearchForHotels("Kempegowda International Airport, Bangalore","1 room, 2 adults");
	}
	
	@Test(priority=1)
    public void test_FlightBooking(){
		flightBookingTest = new FlightBookingTest(driver);
		boolean result = flightBookingTest.testThatResultsAppearForAOneWayJourney();
        //verify that result appears for the provided journey search
        Assert.assertTrue(result);
	}
	
	@Test(priority=0)
    public void test_SignIn() throws InterruptedException{
		signInTest = new SignInTest(driver);
		String error = signInTest.shouldThrowAnErrorIfSignInDetailsAreMissing();
        //verify error message
		Assert.assertTrue(error.contains("There were errors in your submission"));
	}
	
	@AfterTest
	private void closeBrowser() {
		driver.quit();
	}
	
	private void setDriverPath() {
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
    }
	

}
