package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Pagination {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");

        for(int i=1; i<4; i++) {

            WebElement active = driver.findElement(By.xpath("//ul[@id='pagination']/li/a[text()='2']"));
            active.click();
        }

        String name = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[1]/td[2]")).getText();

        if(name.equals("Bluetooth Speaker")) {

            WebElement doi = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[1]//td/input"));
            doi.click();
        }
    }
}
