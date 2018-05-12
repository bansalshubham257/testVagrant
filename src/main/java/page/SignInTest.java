package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SignInTest {

	WebDriver driver;
	
	public SignInTest(WebDriver driver){
        this.driver = driver;
    }

 
    public String shouldThrowAnErrorIfSignInDetailsAreMissing() throws InterruptedException {

        driver.findElement(By.linkText("Your trips")).click();
        driver.findElement(By.id("SignIn")).click();
        waitFor(2000);
        driver.switchTo().frame("modal_window");
        driver.findElement(By.id("signInButton")).click();
        String errors1 = driver.findElement(By.id("errors1")).getText();
        return errors1;
    }
    
    private void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}



