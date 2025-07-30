package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TradiotionalPagination {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        // Click on the first column header to sort the table by product name
        driver.findElement(By.xpath("//tr/th[1]")).click();

        List<String> prices = new ArrayList<>();

        while (prices.size() < 1) {
            List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered']/tbody/tr"));

            for (WebElement row : rows) {
                String productName = row.findElement(By.xpath("td[1]")).getText();

                if (productName.contains("Rice")) {
                    String price = row.findElement(By.xpath("td[2]")).getText();
                    prices.add(price);
                }
            }

            // If not found, click next page
            if (prices.size() < 1) {
                try {
                    WebElement nextButton = driver.findElement(By.xpath("//a[@aria-label='Next']"));
                    nextButton.click();
                } catch (Exception e) {
                    System.out.println("Reached end of table. 'Rice' not found.");
                    break;
                }
            }
        }

        // Print the prices of "Rice"
        for (String price : prices) {
            System.out.println("Price of Rice: " + price);
        }

    }
}
