package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class NextLevlDropdown {

        public static void main(String[] args) {

            WebDriver driver = new ChromeDriver();

            // Navigate to the website
            driver.get("https://testautomationpractice.blogspot.com/");
            driver.manage().window().maximize();

            // Locate the dropdown element
            WebElement countryDropdown = driver.findElement(By.xpath("//select[@id='country']"));

            // Scroll into view using JavaScriptExecutor
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", countryDropdown);

            // Create Select object
            Select select = new Select(countryDropdown);

            // Get and print all options
            List<WebElement> options = select.getOptions();
            System.out.println("Total options in the dropdown: " + options.size());

            for (WebElement option : options) {
                System.out.println(option.getText());
            }

            // Select an option by visible text
            String countryToSelect = "India";
            select.selectByVisibleText(countryToSelect);
            System.out.println("Selected value: " + countryToSelect);

            // ✅ Optional: Validate selected value
            WebElement selectedOption = select.getFirstSelectedOption();
            System.out.println("Confirmed selected: " + selectedOption.getText());

            // Close the browser
            driver.quit();
        }
    }

