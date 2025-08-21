package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class AutoSuggestDropdown {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.redbus.in/");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("//div[text()='From']")).click();


        try{

            driver.findElement(By.xpath("//label[text()='From']/preceding-sibling::input[contains(@class,'inputField')]")).sendKeys("Bang");
        } catch (Exception e) {

            e.printStackTrace();
        }


        List<WebElement> options = driver.findElements(By.xpath("//div[contains(@class,'listItem')]/child::div/descendant::div/child::div[contains(@class,'listHeader')]"));

        System.out.println(options.size());

        for (WebElement option:options) {

            System.out.println(option.getText());

            Thread.sleep(2000);

            if(option.getText().contains("Madiwala")) {

                option.click();
                break;
            }


        }



    }
}
