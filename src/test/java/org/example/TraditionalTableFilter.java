package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class TraditionalTableFilter {


    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        driver.findElement(By.xpath("//tr/th[1]")).click();

        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered']/tbody/tr"));

        // Create a list to store prices of rows that contain "Beans"
        List<String> prices = new ArrayList<>();

        for (WebElement row : rows) {
            String productName = row.findElement(By.xpath("td[1]")).getText();

            if (productName.contains("Beans")) {
                String price = row.findElement(By.xpath("td[2]")).getText();
                prices.add(price);
            }
        }

        for (String price : prices) {
            System.out.println(price);
        }
    }
}
