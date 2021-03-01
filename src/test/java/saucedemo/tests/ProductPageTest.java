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
import saucedemo.pages.ProductPage;

public class ProductPageTest {
	
	
	WebDriver driver = null; 
	String username = "standard_user";
	String password = "secret_sauce";
	LoginPage lg;
	ProductPage pg;
	
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
		  lg = new LoginPage(driver);
	      lg.login(username, password);
	      pg = new ProductPage(driver);
		}
	
	      
	    @Test(priority = 0) 
	    public void buyItemOneTest(){
		  pg.clickItemOneAddToCart();
 	    }
	    
	    @Test(priority = 1) 
         public void buyItemTwoTest(){
		 pg.clickItemTwoAddToCart();
	    }
	    
	    @Test(priority = 2)
	    public void verifyYourCartTest(){
	    	pg.findYourCart();
	    }
	    
	    @Test(priority = 3)
	    public void verifyProductPageTitleTest(){
	    	String title = pg.getPageTitle();
	    	System.out.println("Product Page Title :"+ title);
	    	Assert.assertEquals(title, "Swag Labs");
	    }
	    
	    
	    @AfterTest
		public void closeBrowser(){
			driver.close();
		}
	

	    
	    
	    
	    
}
