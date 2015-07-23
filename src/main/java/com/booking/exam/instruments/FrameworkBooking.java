package com.booking.exam.instruments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FrameworkBooking {
	protected WebDriver driver;
	protected boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }
		public WebDriver startDriver() {
		
			driver = new FirefoxDriver();
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    driver.manage().window().maximize();
		    
		    return driver;
		}
	}

