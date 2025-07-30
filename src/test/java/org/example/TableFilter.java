package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

public class TableFilter {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        // Example: Click to sort by Product name
        driver.findElement(By.xpath("//tr/th[1]")).click();

        // Get all rows (excluding header)
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered']/tbody/tr"));

        // Filter: Get names where country is "USA" (example logic)
        List<String> usaProducts = rows.stream()
                .filter(row -> row.findElement(By.xpath("td[2]")).getText().equalsIgnoreCase("USA"))
                .map(row -> row.findElement(By.xpath("td[1]")).getText())
                .collect(Collectors.toList());

        System.out.println("Products from USA: " + usaProducts);

        //driver.quit();
    }
    }
