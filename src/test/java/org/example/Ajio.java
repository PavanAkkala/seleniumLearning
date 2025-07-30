package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Ajio {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.ajio.com/?utm_source=Branding&utm_medium=Clicks&utm_campaign=AJIO_Branding_PremiumBrands_NCA_Apr25&gad_source=1&gad_campaignid=22469698957&gbraid=0AAAAADP0DvdLVFioN-tOstpGJKk4lu9xx&gclid=CjwKCAjwyb3DBhBlEiwAqZLe5EJBAlxOfBZ2OVDdeuD0iOJq2yVPMEnUpDdd-o-mZdAmr_kblDO81RoChvkQAvD_BwE");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//span[@id='loginAjio']")).click();
        driver.findElement(By.xpath("//input[@id='mobileNumber']")).sendKeys("7989972253");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(5000);
    }


}
