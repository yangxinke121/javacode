package org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class webdriver {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Code\\googledriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://www.baidu.com/");

        Thread.sleep(3000);

        WebElement searchBox = driver.findElement(By.id("kw"));

        searchBox.sendKeys("ChromeDriver");
        searchBox.submit();

        Thread.sleep(3000);
        driver.quit();
    }
}
