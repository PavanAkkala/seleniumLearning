package org.example;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InnerIframe {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.automationtesting.in/Frames.html");
        driver.manage().window().maximize();
        WebElement el = driver.findElement(By.xpath("//a[normalize-space()='Iframe with in an Iframe']"));
        el.click();

        WebElement el1 = driver.findElement(By.xpath("//div[@id='Multiple']/child::iframe"));
        driver.switchTo().frame(el1); // switch to outer frame

        WebElement el2 = driver.findElement(By.xpath("//h5[contains(text(),'Nested iFrames')]/../child::iframe"));
        driver.switchTo().frame(el2);

        driver.findElement(By.xpath("//h5[normalize-space()='iFrame Demo']/following-sibling::div/child::div/input[@type='text']")).sendKeys("Don Reddy");
    }
}
