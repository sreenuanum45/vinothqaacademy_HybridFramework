package projectutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataPicker {

public static void dateSelector(WebElement dp, RemoteWebDriver driver) throws Throwable {
	  int ExceptedYear=2025 ;
 String Exceptedmonth="june";
 int day=5;
 driver.executeScript("arguments[0].scrollintoview", dp);
	dp.click();
	while(true) {
		String temp=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		int currentyear=Integer.parseInt(temp);
		if(ExceptedYear>currentyear) {
			driver.findElement(By.xpath("//a//span[text()='Next']")).click();
			Thread.sleep(1000);
		}
		else if(ExceptedYear<currentyear) {
			driver.findElement(By.xpath("//a//span[text()='Prev']")).click();
			Thread.sleep(1000);
		}
		else {
			break;
		}
	}
	while(true) {
		String currentmonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		if(currentmonth.equalsIgnoreCase("january")) {
			break;
		}
		else {

			driver.findElement(By.xpath("//a//span[text()='Next']")).click();
		}
	}
	while(true) {
		String currentmonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		if(currentmonth.equalsIgnoreCase(Exceptedmonth)) {
			break;
		}
		else{
			driver.findElement(By.xpath("//a//span[text()='Next']")).click();
			Thread.sleep(1000);
		}
	}
	driver.findElement(By.linkText(""+day)).click();
	
}
	public static void extractDates(String input) {
		// Define a regex pattern to match dates in mm-dd-yyyy format
		Pattern pattern = Pattern.compile("\\b(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])-(\\d{4})\\b");
		Matcher matcher = pattern.matcher(input);

		while (matcher.find()) {
			// Print the matched date
			System.out.println("Found date: " + matcher.group());
		}
	}
	
	
}
