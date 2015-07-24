package com.booking.exam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DiscoverNewDestination {
	private WebDriver driver;

	public DiscoverNewDestination(WebDriver driver) {
		this.driver = driver;
	}

	public DestinationSearchResults enterLvivAndDropDownLVIVRegionUkraine() throws Exception {
		
		searchField.clear();
		searchField.sendKeys("Lviv");
		Thread.sleep(1000);
		searchSecondOption.click();
		submitButton.click();
		
		return PageFactory.initElements(driver, DestinationSearchResults.class);
		
	}

	@FindBy(xpath = ".//input[contains(@id,'search')]") 
		private WebElement searchField;
	
	@FindBy(xpath = ".//*[@id='ac_destinations']/div/div[2]")
		private WebElement searchSecondOption;
	
	@FindBy(xpath = ".//*[@id='dsf_button']")
		private WebElement submitButton;

}
