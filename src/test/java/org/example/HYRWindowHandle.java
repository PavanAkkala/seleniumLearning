package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class HYRWindowHandle {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        // Navigate to the website
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        driver.manage().window().maximize();

        String parentWindowHandle = driver.getWindowHandle();
        System.out.println("parentWindowHandle is - " + parentWindowHandle + driver.getCurrentUrl());
        WebElement ele = driver.findElement(By.xpath("//button[@id='newTabBtn']"));
        ele.click();
        Set<String> windowHandless = driver.getWindowHandles();
        for (String windowhandle : windowHandless) {
            if (!windowhandle.equals(parentWindowHandle)) {
                driver.switchTo().window(windowhandle);
            }
            System.out.println(windowhandle + driver.getTitle());
        }

        driver.findElement(By.xpath("//button[@id='alertBox']")).click();

      //  Alert alert = driver.switchTo().alert();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert =    wait.until(ExpectedConditions.alertIsPresent());// This will explicitly calls driver.switchTo().alert(); when an alert is present

        String text = alert.getText();

        System.out.println(text);
        alert.accept();

        driver.switchTo().window(parentWindowHandle);

       String lobo =  driver.findElement(By.xpath("//button[@id='newTabBtn']")).getText();

        System.out.println(lobo);
    }
}
