package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortTraditional {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        // Step 1: Open the URL
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

// Step 2: Click on the column header to sort
        WebElement columnHeader = driver.findElement(By.xpath("//tr/th[1]"));
        columnHeader.click();

// Step 3: Get all cells under the first column
        List<WebElement> columnElements = driver.findElements(By.xpath("//tr/td[1]"));

// Step 4: Store the original text values in a list
        List<String> originalList = new ArrayList<String>();
        for (WebElement element : columnElements) {
            originalList.add(element.getText());
        }

// Step 5: Create a copy of the list and sort it
        List<String> sortedList = new ArrayList<String>(originalList);
        Collections.sort(sortedList);

// Step 6: Print both lists (optional for debugging)
        System.out.println("Original List (Actual): " + originalList);
        System.out.println("Sorted List (Expected): " + sortedList);

// Step 7: Compare both lists using assertions
        Assert.assertEquals(sortedList, originalList);

    }
}
