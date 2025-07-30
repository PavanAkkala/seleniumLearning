package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InnerShadowDom {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://testautomationpractice.blogspot.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement shadowHost = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("shadow_host")));

       // WebElement shadowHost = driver.findElement(By.xpath("//div[@id='shadow_host']"));
        SearchContext sc = shadowHost.getShadowRoot();
        //nested Shadow
        WebElement nestedHost = sc.findElement(By.cssSelector("#nested_shadow_host"));
        SearchContext pc = nestedHost.getShadowRoot();

        WebElement input = pc.findElement(By.cssSelector("input[type='text']"));
        input.sendKeys("Don Reddy");

    }
}
