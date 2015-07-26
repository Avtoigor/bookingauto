package com.booking.exam.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GrabVisibleTownNameDestinations {

	public static int countVisibleTownsOnWeb;
	public static int countVisibeTownsOnfile;
	
	public GrabVisibleTownNameDestinations (WebDriver driver) {
	}
	
public GrabVisibleTownNameDestinations saveVisibleTowns() {
					countVisibleTownsOnWeb = townList.size();
					System.out.println("Get are" + countVisibleTownsOnWeb + "on the web");
					return this;
		}
	
public GrabVisibleTownNameDestinations saveListToExel(String saveDirectory){
		
		//Creating new workbook
		 XSSFWorkbook workbook = new XSSFWorkbook();
		//creating a blank sheet
		 XSSFSheet sheet = workbook.createSheet("GrabTowns");

		 int rowNum=0;
		 for(WebElement item: townList){
			 Row r=sheet.createRow(rowNum++);
		      int cellIndex = 0;
			 r.createCell(cellIndex++).setCellValue(item.getText());
		 }
			 
			 try {
				FileOutputStream out = new FileOutputStream(saveDirectory);
				workbook.write(out);
				out.close();
				//System.out.println("savedDraftToFile method passed");
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("There are "+ countVisibleTownsOnWeb + " visible towns on the page");
			  
			}
			
			 return this;
		
	}

	public GrabVisibleTownNameDestinations countExcelRows(String filepath){
		int counFileRow = 0;
		try {
            FileInputStream file = new FileInputStream(new File(filepath));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            
            XSSFSheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                Iterator <Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    cellIterator.next();
                    counFileRow++;
                }
            }
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		
		countVisibeTownsOnfile = counFileRow;
		System.out.println("Get are" + countVisibeTownsOnfile + "on the file");
		
		return this;
	}

	@FindBy (xpath=".//*[@id='popularDestinations']//h3/a") public List<WebElement> townList;
}
