package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

public class TableFilterTwo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        WebElement ele = driver.findElement(By.xpath("//tr/th[1]"));
        ele.click();

        //Capture all the elements in the list
        List<WebElement> elementList = driver.findElements(By.xpath("//tr/td[1]"));

       List<String> price = elementList.stream().filter(s->s.getText().contains("Beans")).map(s->getPriceVeggie(s)).collect(Collectors.toList());
       price.forEach(a-> System.out.println(a));

    }

    private static String getPriceVeggie(WebElement s) {

      String priceValue =  s.findElement(By.xpath("following-sibling::td[1]")).getText();
      return priceValue;

    }
}
