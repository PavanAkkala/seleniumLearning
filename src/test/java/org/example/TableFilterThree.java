package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

public class TableFilterThree {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        // Click on the first column header to sort
        driver.findElement(By.xpath("//tr/th[1]")).click();

        // Get all rows
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered']/tbody/tr"));

        // Filter by "Beans", get the price from the second column
        List<String> prices = rows.stream()
                .filter(row -> row.findElement(By.xpath("td[1]")).getText().contains("Beans"))
                .map(row -> row.findElement(By.xpath("td[2]")).getText())
                .collect(Collectors.toList());

        prices.forEach(System.out::println);

    }
}
