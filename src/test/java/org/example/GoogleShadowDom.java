package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleShadowDom {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/"); // Or the URL containing that element
        driver.manage().window().maximize();
        WebElement shadowHost = driver.findElement(By.xpath("//div[@id='shadow_host']"));
        SearchContext sc = shadowHost.getShadowRoot();
        WebElement getName = sc.findElement(By.cssSelector("#shadow_content"));
        String rev = getName.getText();
        System.out.println(rev);
    }
    }
