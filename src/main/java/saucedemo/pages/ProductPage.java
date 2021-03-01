package saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

	WebDriver driver;
	
	
	//Locators 
	By boltShirtAddCart = By.xpath("//*[@id='inventory_container']/div/div[3]/div[3]/button");
	By jacketAddCart = By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div/div[4]/div[3]/button");
	By yourcartIcon = By.xpath("/html/body/div/div/div/div[1]/div[3]/a/span");
	  
			
	//constructor
	public ProductPage(WebDriver driver){
		this.driver = driver;
	}
			
	//page actions
	
	 public void clickItemOneAddToCart(){
		driver.findElement(boltShirtAddCart).click();;
	 }
	
     public void clickItemTwoAddToCart(){
		driver.findElement(jacketAddCart).click();
	 }
     
     public void findYourCart(){
    	 driver.findElement(yourcartIcon).isSelected();
     }
     
    
     public String getPageTitle(){
    	 return driver.getTitle();
     }
     
     
     
     
     
	
}
