package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.security.Key;
import java.util.List;

public class ScrollOfEcommerceBooks {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.booksbykilo.in/children-books?gad_source=1&gad_campaignid=19706481345&gbraid=0AAAAADAZuCbJcGFMRSLtnCHxVTcHy_S5u&gclid=Cj0KCQjwxdXBBhDEARIsAAUkP6jp86cXaRgmKFHYS5Mtke9HjQx8FahEm7s1NrnrgJfsT0xhReNjbO0aAgtuEALw_wcB");
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
        boolean found = false;

        while (!found) {

            List<WebElement> booksList = driver.findElements(By.xpath("//div[@id='productsDiv']//h3"));

            for (WebElement book:booksList) {

                String title = book.getText();
                if(title.equals("5-minute Bunny Tales for Bedtime"))
                {
                    //book.click();
                    System.out.println("Book Found");
                    found = true;
                    break;
                }
            }
            JavascriptExecutor js = ((JavascriptExecutor) driver);
            //js.executeScript("window.scrollBy(0,document.body.scrollHeight);");
            actions.sendKeys(Keys.END).build().perform();
        }
    }
}
