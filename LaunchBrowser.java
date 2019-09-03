package com.sjp.webdriver.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LaunchBrowser {
	public static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.navigate().to("https://amazon.in");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println("title=" + title);
		String tagName = driver.findElement(By.cssSelector("#nav-link-shopall > span:nav-line-2")).getText();
		System.out.println("tagName=" + tagName);
		WebElement category = driver.findElement(By.cssSelector("#nav-link-shopall > span:nav-line-2"));
		Actions action = new Actions(driver);
		action.moveToElement(category).perform();
		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}

}
