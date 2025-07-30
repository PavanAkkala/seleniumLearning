package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class OrangeHRMWindowHandles {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        // Navigate to the website
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();



        String parentWindowHandle = driver.getWindowHandle();
        WebElement ele = driver.findElement(By.xpath("//button[normalize-space()='Popup Windows']"));
        ele.click();

        List<String> handlesList = new ArrayList<>(driver.getWindowHandles());
       // driver.switchTo().window(handlesList.get(0)); // original
        driver.switchTo().window(handlesList.get(2)); // first new
        driver.manage().window().maximize();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[text()='Downloads']")).click();
       // driver.switchTo().window(handlesList.get(2));
        driver.switchTo().window(parentWindowHandle);

        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView;");


        }



    }
