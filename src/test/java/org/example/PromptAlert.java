package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PromptAlert {

        public static void main(String[] args) {

            WebDriver driver = new ChromeDriver();

            driver.get("https://demoqa.com/alerts");
            driver.manage().window().maximize();

            // Click the button that triggers the prompt alert
            driver.findElement(By.id("promtButton")).click();

            // Switch to the alert
            Alert promptAlert = driver.switchTo().alert();

            // Get the alert text
            System.out.println("Alert text: " + promptAlert.getText());

            // Send input to the prompt
            promptAlert.sendKeys("Don");

            // Accept the prompt
            promptAlert.accept();

            System.out.println("Prompt accepted after input.");

           // driver.quit();
        }
    }

