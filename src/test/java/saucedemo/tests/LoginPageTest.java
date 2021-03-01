package saucedemo.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import saucedemo.pages.LoginPage;

public class LoginPageTest {
	
	WebDriver driver = null; 
	String username = "standard_user";
	String password = "secret_sauce";
	LoginPage lp;
	
	@BeforeTest
	public void openBrowser(){
		 
		WebDriverManager.chromedriver().setup();
		  ChromeOptions options = new ChromeOptions();
		  options.addArguments("start-maximized");
		  options.addArguments("enable-automation");
		  options.addArguments("--no-sandbox");
		  options.addArguments("--disable-infobars");
		  options.addArguments("--disable-dev-shm-usage");
		  options.addArguments("--disable-browser-side-navigation");
		  options.addArguments("--disable-gpu");
		  driver = new ChromeDriver(options);
		  driver.get("https://www.saucedemo.com/");
		}
	
	   @Test(priority =0) 
	   public void VerifyLoginPageTest(){
	    lp  = new LoginPage(driver);
		lp.login(username, password);
       }
	
	   @Test(priority =1) 
	   public void VerifyLoginPageTitleTest(){
	    lp  = new LoginPage(driver);
		String title = lp.getLoginPageTitle();
		Assert.assertEquals(title,"Swag Labs");
       }
	
	   @AfterTest
	   public void closeBrowser(){
		driver.close();
	    }
	
	
	
	
}
