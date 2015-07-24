package com.booking.exam;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.booking.exam.pages.DestinationSearchResults;
import  com.booking.exam.pages.HomePageBooking;
import com.booking.exam.pages.ResultSearchPage;
import com.booking.exam.instruments.CreateListPopularHotelsAfterSearch;
import com.booking.exam.instruments.FrameworkBooking;


public class BaseExamTest extends FrameworkBooking {

	@BeforeMethod
	public void setUp() throws InterruptedException {
		driver = startDriver();
		driver.get("http://www.booking.com");
		Thread.sleep(3000);
		
	}

	
	@Test (priority = 1)
	public void HomePageBooking() throws Exception {
		
		PageFactory.initElements(driver, HomePageBooking.class)
		.openLoginForm()
		.logIn();
		
		Assert.assertEquals(HomePageBooking.userFirstNameLogOn, HomePageBooking.userFirstNameUsedForLogOn, "Users First Name Is Not Valid");
	
		Assert.assertEquals(HomePageBooking.userLastNameLogOn, HomePageBooking.userLastNameUsedForLogOn, "Users Last Name Is Not Valid");
	
	}
		

	@Test (priority = 2)
	public void FindAndVerifyMontenegro () throws Exception {
		
		PageFactory.initElements(driver, ResultSearchPage.class)
		.enterSearch()
		.createListPopularHotels();
		Assert.assertTrue(CreateListPopularHotelsAfterSearch.savedResultList.contains("Splendid Conference & Spa Resort") , "Hotel 'Splendid Conference & Spa Resort' is not present on list popular hotels");

	}
	
	
	@Test (priority = 3)
	
	public void CheckWifiAndFreeParking () throws Exception {
		PageFactory.initElements(driver, ResultSearchPage.class)
		.enterSearch()
		.chekWifiAndFreeParking()
		.getInformationAboutWiFiAdParking();
		
		Assert.assertTrue(com.booking.exam.pages.CheckWifiAndFreeParking.freeWiFi.contains("Free WiFi"), "Hotel Is Not Present free WiFi");
		
		Assert.assertTrue(com.booking.exam.pages.CheckWifiAndFreeParking.freeParking.contains("Free parking"), "Hotel Is Not Present free Parking");
	
	}
	

	@Test (priority = 4)
	public void DiscoverNewDestination() throws Exception {
		
		PageFactory.initElements(driver, HomePageBooking.class)
		.openLoginForm()
		.logIn()
		.discoverNewDestinations()
		.enterLvivAndDropDownLVIVRegionUkraine()
		.checkForResults();
		
		Assert.assertTrue(DestinationSearchResults.result, "There were no search results");
	}



//	@Test (priority = 5)
//	
//	public void GrabAndCheckIsTheSameAsNumberExelAndPage () {
//		.getUrl()
//		.GrabVisibleTownNameDestinations()
//		.saveExel
//		Assert.assertTrue (Check if The number of entries in excel is the same as number of visible destinations on the page)
//			}
	
	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();

	}

}
