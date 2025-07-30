package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Checkbox2 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://testautomationpractice.blogspot.com/");

        List<WebElement> elements = driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));

        for (WebElement ele:elements) {

            String txt = ele.getAttribute("value");

            if(txt.equals("thursday")) {

                ele.click();
            }
        }
    }
}
