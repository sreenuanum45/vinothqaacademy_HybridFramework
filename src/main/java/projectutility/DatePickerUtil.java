package projectutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DatePickerUtil {
    // Method to select a date from the date picker
    public static void selectDate(RemoteWebDriver driver, By dateInputLocator, String dateToSelect, By nextMonthButton, By dayLocator) {
        // Click on the date input field to open the date picker
        WebElement dateInput = driver.findElement(dateInputLocator);
        dateInput.click();

        // Convert the date string to a LocalDate object
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate desiredDate = LocalDate.parse(dateToSelect, formatter);

        // Get the current month and year displayed in the date picker
        String currentMonthYear = driver.findElement(By.cssSelector(".ui-datepicker-title")).getText();
        DateTimeFormatter currentFormatter = DateTimeFormatter.ofPattern("MMMM yyyy");
        LocalDate currentDate = LocalDate.parse(currentMonthYear, currentFormatter);

        // Navigate to the desired month and year
        while (desiredDate.getYear() != currentDate.getYear() || desiredDate.getMonthValue() != currentDate.getMonthValue()) {
            if (desiredDate.isAfter(currentDate)) {
                driver.findElement(nextMonthButton).click();
            } else {
                driver.findElement(By.cssSelector(".ui-datepicker-prev")).click(); // Adjust the locator for the previous button if needed
            }
            currentMonthYear = driver.findElement(By.cssSelector(".ui-datepicker-title")).getText();
            currentDate = LocalDate.parse(currentMonthYear, currentFormatter);
        }

        // Select the day
        List<WebElement> days = driver.findElements(dayLocator);
        for (WebElement day : days) {
            if (day.getText().equals(String.valueOf(desiredDate.getDayOfMonth()))) {
                day.click();
                break;
            }
        }
    }
}
