package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class DropDowns {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
       List <WebElement> ele = driver.findElements(By.xpath("(//input[contains(@id,'day') and @type='checkbox'])[1]"));
        JavascriptExecutor js = ((JavascriptExecutor)driver);
        js.executeScript("arguments[0].scrollIntoView();",ele);

    }


}
