package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class SortStream {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        //Click on the column
        WebElement ele = driver.findElement(By.xpath("//tr/th[1]"));
        ele.click();

        //Capture all the elements in the list
        List<WebElement> elementList = driver.findElements(By.xpath("//tr/td[1]"));

        //We are capturing the text of all the webelemts using streams
        // and storing it in a new list   i.e Collector(collectors.toList())
        //Capture the text into new list
        //s->s.getText();
        List<String> originalList = elementList.stream().map(WebElement::getText).collect(Collectors.toList());

        //Sort the original list
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

        System.out.println("Original List (Actual): " + originalList);
        System.out.println("Sorted List (Expected): " + sortedList);

        //Compare both the lists
        Assert.assertEquals(sortedList, originalList);
    }
}
