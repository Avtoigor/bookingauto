package com.booking.exam.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DestinationSearchResults {

	WebDriver driver;
	public static boolean result;
	
	
	public DestinationSearchResults(WebDriver driver) {
	this.driver=driver;
		}

	public DestinationSearchResults checkForResults() {
		
		result = resultBaner.size()>0;
		System.out.println("is result banner present? : " + result);
		
		
		return this;
		}

	@FindBy (xpath=".//div[contains(@class,'dsf-interests-title')][@data-component][not(contains(@class,'hidden'))]")private List<WebElement> resultBaner;
}