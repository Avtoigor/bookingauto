package com.booking.exam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.booking.exam.instruments.ReadString;

public class HomePageBooking {

	public static String userFirstNameLogOn;
	public static String userLastNameLogOn;

	public static String userFirstNameUsedForLogOn;
	public static String userLastNameUsedForLogOn;

	private WebDriver driver;

	public HomePageBooking(WebDriver driver) {
		this.driver = driver;
	}

	public HomePageBooking openLoginForm() {

		callLoginForm.click();
		return this;
	}

	public HomePageBooking logIn() throws Exception {
		ReadString rs = new ReadString(
				"D://Users/Igor/Documents/Automation_Malkos_Course/loginBookingParameters.txt");

		userFirstNameUsedForLogOn = rs.getFirstName();
		userLastNameUsedForLogOn = rs.getLastName();

		username.sendKeys(rs.getUserName());
		
		password.sendKeys(rs.getPassword());
		
		submitButton.click();
		// Thread.sleep(12000);

		userFirstNameLogOn = userFirstName.getText();
		userLastNameLogOn = userLastName.getText();

		return this;
		// return PageFactory.initElements(driver, HomePageBooking.class);
	}

	@FindBy(xpath = ".//div[@id='user_form']//span[@class='uc-option__text']")
	public WebElement callLoginForm;
	
	@FindBy(xpath = ".//div[contains(@class,'user-access-menu-lightbox--user-center')]//div[contains(@class,'form-shown-section')]//*[contains(@class,'user_access_email') and @name='username']")
	public WebElement username;
	
	@FindBy(xpath = ".//div[contains(@class,'user-access-menu-lightbox--user-center')]//div[contains(@class,'form-shown-section')]//*[contains(@class,'user_signup_password') and @name='password']")
	public WebElement password;
	
	@FindBy(xpath = ".//div[contains(@class,'user-access-menu-lightbox--user-center')]//div[contains(@class,'form-shown-section')]//*[contains(@class,'bootstrapped-input') and @type='submit']")
	public WebElement submitButton;
	
	@FindBy(xpath = ".//span[@class='header_name user_firstname']")
 	public WebElement userFirstName;

	@FindBy(xpath = ".//span[@class='header_name user_lastname']")
	public WebElement userLastName;

	
}
