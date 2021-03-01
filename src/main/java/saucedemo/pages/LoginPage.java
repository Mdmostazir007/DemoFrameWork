package saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
     WebDriver driver;
	
	// page Object for login page 
	
	By uname = By.id("user-name");
	By pword = By.id("password");
	By loginbutton = By.id("login-button");
	By title = By.xpath("/html/body/div/div/div[1]");
	
	// Contructor
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	
   // page actions
	public void setUserName(String username ){
		driver.findElement(uname).sendKeys(username);
	}
	
	public void setPassword(String password){
		driver.findElement(pword).sendKeys(password);
	}
	
	public void clickLogin(){
		driver.findElement(loginbutton).click();
	}
	
	/**
	 * This is used to get page title
	 * @return
	 */
	public String getLoginPageTitle(){
		 return driver.getTitle();
		 
	}
	
	 /**
	  * This method is used to enter login page 
	  * @param username
	  * @param password
	  */
	public void login(String username, String password){
		this.setUserName(username);
		this.setPassword(password);
		this.clickLogin();
		
	}
	

}
