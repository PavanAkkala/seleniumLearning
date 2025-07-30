package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Checkboes {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        WebElement li = driver.findElement(By.xpath("//select[@id='country']"));
        Select select = new Select(li);
        JavascriptExecutor js1 = ((JavascriptExecutor) driver);
        js1.executeScript("arguments[0].scrollIntoView();", li);
        List<WebElement> options = select.getOptions();
        // int sz2 = size1.size(); or
        System.out.println(options.size());

        for (WebElement we : options) {

            System.out.println(we.getText());

            if(we.getText().contains("India")) {

                we.click();
            }

        }

        //select.selectByVisibleText("India");
        System.out.println("Selected value: India");

    }
}
