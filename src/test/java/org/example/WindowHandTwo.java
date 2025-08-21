package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowHandTwo {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        // Navigate to the website
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        String parentWindowHandle = driver.getWindowHandle();
        System.out.println("parentWindowHandle is - "+parentWindowHandle + driver.getCurrentUrl());
        WebElement ele = driver.findElement(By.xpath("//button[normalize-space()='Popup Windows']"));
        ele.click();

        Set<String> windowHandles = driver.getWindowHandles();

        // Convert to List to access by index
        List<String> windowList = new ArrayList<>(windowHandles);

        // Example: switch to 2nd window (index starts at 0)
        driver.switchTo().window(windowList.get(2));
        driver.manage().window().maximize();
        System.out.println("Switched to window: " + driver.getTitle());
    }
}
