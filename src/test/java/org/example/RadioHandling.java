package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RadioHandling {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://testautomationpractice.blogspot.com/");

        List<WebElement> lo = driver.findElements(By.xpath("//input[@name='gender' and @type='radio']"));

        System.out.println(lo.size());

        for (int i=0; i<lo.size();i++) {

            String text = lo.get(i).getAttribute("value");

            if(text.equals("male")) {


                lo.get(i).click();

                System.out.println(text);


            }
        }
    }
}
