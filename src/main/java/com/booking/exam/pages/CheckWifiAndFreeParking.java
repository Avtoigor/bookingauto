package com.booking.exam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckWifiAndFreeParking {
	
	public static String freeWiFi;
	public static String freeParking;
	
	private WebDriver driver;

	public CheckWifiAndFreeParking(WebDriver driver) {
		this.driver = driver;
	}
	
	String winHandleBefore = driver.getWindowHandle();
	
	public CheckWifiAndFreeParking getInformationAboutWiFiAdParking() throws InterruptedException {
		
			
		if(driver.getWindowHandles().size()>1){
			   System.out.println("there are to windows opened");
			   driver.close();
			   
			   System.out.println("we just closed one of them");
			   System.out.println("");
			   
			   for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			   }
		
		freeWiFi = wiFiElement.getText();
		System.out.println(freeWiFi);
		
		freeParking = parkingElement.getText();
		System.out.println(freeParking);
		
		return this;
		}
		
		return this;
		}
		
	
	
	@FindBy(xpath = "//span[@class='hp_usp_filter_api_text'][contains(text(), 'Free WiFi')]")
	public WebElement wiFiElement;
	
	@FindBy(xpath = "//span[@class='hp_usp_filter_api_text'][contains(text(), 'Free parking')]")
	public WebElement parkingElement;
}
