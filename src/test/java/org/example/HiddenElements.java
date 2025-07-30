package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HiddenElements {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.findElement(By.xpath("//a[normalize-space()='Hidden Elements & AJAX']")).click();
        WebElement input1 = driver.findElement(By.id("input1"));
        input1.sendKeys("Visible input");

        // Hidden input
        WebElement input2 = driver.findElement(By.id("input2"));

        // Use JavaScript to set value (bypass visibility)
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='Don';", input2);

        // Read back the value
       // String val = input2.getAttribute("value");
        String val2 = input2.getDomProperty("value");
        System.out.println("Hidden field value: " + val2);
    }
}
