package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDom {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement shadowHost = driver.findElement(By.xpath("//div[@id='shadow_host']"));
        SearchContext sc = shadowHost.getShadowRoot();
        WebElement getName = sc.findElement(By.cssSelector("#shadow_content"));
        String rev = getName.getText();
        System.out.println(rev);


    }
}
