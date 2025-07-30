package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementReference {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        WebElement ele = driver.findElement(By.xpath("//a[text()='Udemy Courses']"));
        ele.click();
        Thread.sleep(5000);
        driver.navigate().back();
        try {

            ele.click();
        } catch (StaleElementReferenceException e) {

            ele = driver.findElement(By.xpath("//a[text()='Udemy Courses']"));
            ele.click();
        }
    }

    }
