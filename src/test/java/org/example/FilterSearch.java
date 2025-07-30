package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class FilterSearch {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        WebElement input = driver.findElement(By.xpath("//input[@id='search-field']"));
        input.sendKeys("Rice");

        List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));
        System.out.println(veggies.size());

      List<WebElement> filteredList =   veggies.stream().filter(veggie->veggie.getText().contains("Rice")).collect(Collectors.toList());
        System.out.println("Filtered items count (should match total): " + filteredList.size());

        for (WebElement ve : filteredList) {
            System.out.println("Filtered Item: " + ve.getText());
        }

        Assert.assertEquals(veggies.size(), filteredList.size(),
                "Mismatch! Some non-'Rice' items might be displayed.");
       // Assert.assertEquals(veggies.size(),filteredList.size());


    }


}
