package com.booking.exam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.booking.exam.instruments.CreateListPopularHotelsAfterSearch;

public class ResultSearchPage {
	
	private WebDriver driver;

	public ResultSearchPage(WebDriver driver) {
		this.driver = driver;
	}
	

	public CreateListPopularHotelsAfterSearch enterSearch() throws Exception {
		
		searchForm.sendKeys("Montenegro");
		
		Actions builder = new Actions(driver);
		builder.moveToElement(firstItem).build().perform();
		activeItem.click();
		
		Select cIm = new Select(checkinMonthday);
		cIm.selectByValue("22");
		System.out.println("Check in Mont day - Ok");
		
		Select cIyM = new Select(checkinYearMonth);
		cIyM.selectByValue("2016-3");
		System.out.println("Check in Year Mont day - Ok");
		
		Select cOm = new Select(checkoutMonthday);
		cOm.selectByValue("30");
		System.out.println("Check out Mont day - Ok");
		
		Select cOyM = new Select(checkoutYearMonth);
		cOyM.selectByValue("2016-3");
		
		System.out.println("Check out Year Mont day - Ok");
		
		searchButton.click();
		
		
	return PageFactory.initElements(driver, CreateListPopularHotelsAfterSearch.class);
	}
	
	
	@FindBy (xpath = ".//*[@id='destination']")
	public WebElement searchForm;
	
	@FindBy(xpath=".//*[@class='ui-menu-item'][1]")
	public WebElement firstItem;
	
	@FindBy(xpath=".//*[@id='ui-active-menuitem']")
	public WebElement activeItem;
	
	@FindBy (xpath = ".//div[@class='b-date-selector__control b-date-selector__control-dayselector b-selectbox']//select[@class='b-selectbox__element' and @name='checkin_monthday']")
	public WebElement checkinMonthday;
	
	@FindBy (xpath = ".//div[@class='b-date-selector__control b-date-selector__control-monthselector b-selectbox']//select[@class='b-selectbox__element' and @name='checkin_year_month']")
	public WebElement checkinYearMonth;
	
	@FindBy (xpath = ".//div[@class='b-date-selector__control b-date-selector__control-dayselector b-selectbox']//select[@class='b-selectbox__element' and @name='checkout_monthday']")
	public WebElement checkoutMonthday;
	
	@FindBy (xpath = ".//div[@class='b-date-selector__control b-date-selector__control-monthselector b-selectbox']//select[@class='b-selectbox__element' and @name='checkout_year_month']")
	public WebElement checkoutYearMonth;
	
	@FindBy (xpath = ".//button[contains(@class,'b-searchbox-button_legacy') and @type='submit']")
	public WebElement searchButton;
	
 
}
