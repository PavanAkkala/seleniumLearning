package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.decorators.WebDriverDecorator;

import java.util.List;

public class Practice {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");

        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr"));

      //  boolean productFound = false;

        for (WebElement row : rows) {
            // Get the product name from the 2nd column
            String name = row.findElement(By.xpath("td[2]")).getText();

            // Match the product name dynamically (case-insensitive)
            if (name.equalsIgnoreCase("Tablet")) {
                // Click the checkbox in the same row (4th column)
                WebElement checkbox = row.findElement(By.xpath("td[4]/input[@type='checkbox']"));
                checkbox.click();
               // System.out.println("Clicked checkbox for: " + productName);
                //productFound = true;
                break; // stop after finding the first match
            }
        }

    }
}


/*


public void selectProductCheckbox(String productName) {
    // Get all rows from the table
    List<WebElement> rows = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr"));

    boolean productFound = false;

    for (WebElement row : rows) {
        // Get the product name from the 2nd column
        String name = row.findElement(By.xpath("td[2]")).getText();

        // Match the product name dynamically (case-insensitive)
        if (name.equalsIgnoreCase(productName)) {
            // Click the checkbox in the same row (4th column)
            WebElement checkbox = row.findElement(By.xpath("td[4]//input[@type='checkbox']"));
            checkbox.click();
            System.out.println("Clicked checkbox for: " + productName);
            productFound = true;
            break; // stop after finding the first match
        }
    }

    if (!productFound) {
        System.out.println("Product not found: " + productName);
    }
}

 */
