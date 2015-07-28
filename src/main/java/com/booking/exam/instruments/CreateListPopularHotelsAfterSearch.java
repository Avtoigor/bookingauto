package com.booking.exam.instruments;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.booking.exam.pages.CheckWifiAndFreeParking;


public class CreateListPopularHotelsAfterSearch {
	public static List<String> savedResultList = new ArrayList<String>();
	private WebDriver driver;

	public CreateListPopularHotelsAfterSearch(WebDriver driver) {
		this.driver = driver;
	}

	public CreateListPopularHotelsAfterSearch createListPopularHotels() throws Exception {
		
		List<WebElement> elements = driver.findElements(By
				.xpath(".//div[@class='popular-hotels clearfix']//a[@class='ph_name']"));
		

		XSSFWorkbook workbook = new XSSFWorkbook();
		
		// //Create a blank sheet
		XSSFSheet sheet = workbook.createSheet("Result Popular Hotels List");
		int rownum = 0;
		for (WebElement item : elements) {
			savedResultList.add(item.getText());
			System.out.println(item.getText());
			
			Row row = sheet.createRow(rownum++);
			Cell cell = row.createCell(0);
			cell.setCellValue(item.getText());
			
		}

		try {
			FileOutputStream out = new FileOutputStream(
					new File(
							"files/ResultPopularHotelsList.xlsx"));
			workbook.write(out);
			out.close();
			System.out.println("ResultPopularHotelsList.xlsx Successfully created");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return this;
	
	}

	public CheckWifiAndFreeParking chekWifiAndFreeParking() throws Exception {
		splendidConferenceSpaResort.click();
		
		return PageFactory.initElements(driver, CheckWifiAndFreeParking.class);
	}
	
//	@FindBy(xpath = ".//div[@class='popular-hotels clearfix']//a[@class='ph_name' and contains(text(),'Splendid Conference & Spa Resort')]")
//	public WebElement splendidConferenceSpaResort;
	
//	@FindBy(xpath = "//div[@class='box featbox']//a[contains(text(), 'Splendid Conference & Spa Resort')]")
//	public WebElement splendidConferenceSpaResort;

	@FindBy(xpath = ".//*[contains(text(),'Popular')]/..//a[contains(@href,'/hotel/me/') and contains (text(), 'Splendid Conference & Spa Resort')]")
	public WebElement splendidConferenceSpaResort;
	
}

