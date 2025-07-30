package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class WndowHand {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        // Navigate to the website
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        String parentWindowHandle = driver.getWindowHandle();
        System.out.println("parentWindowHandle is - "+parentWindowHandle + driver.getCurrentUrl());
        WebElement ele = driver.findElement(By.xpath("//button[normalize-space()='Popup Windows']"));
        ele.click();
       Set<String> windowHandless = driver.getWindowHandles();
        for(String windowhandle: windowHandless) {
            if(!windowhandle.equals(parentWindowHandle)) {
                driver.switchTo().window(windowhandle);
            }
            System.out.println(windowhandle + driver.getTitle());
        }


    }
}
