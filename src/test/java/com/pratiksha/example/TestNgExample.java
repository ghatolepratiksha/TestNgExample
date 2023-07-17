package com.pratiksha.example;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNgExample {
	
	WebDriver driver;
	
	@BeforeClass
	public void before() {
		System.setProperty("webdriver.chrome.driver", "/testNgMavenExample/src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void callEcommerce() {
		driver.get("https://www.amazon.in/");
		WebElement username=driver.findElement(By.id("user_email_Login"));
		WebElement password=driver.findElement(By.id("user_password"));
		WebElement login=driver.findElement(By.name("commit"));
		username.sendKeys("test@gmail.com");
		password.sendKeys("P@ssw0rd");
		login.click();
		driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("watches for women");
		driver.findElement(By.xpath("//*[@id='nav-search-submit-button']")).click();
		List<WebElement> findElements = driver.findElements(By.xpath("//*[@class='s-main-slot s-result-list s-search-results sg-row']/div[@data-component-type='s-search-result']"));
		for(WebElement test : findElements) {
			System.out.println(test.getText());
		}
		findElements.get(0).click();
		driver.findElement(By.xpath("//*[@id='add-to-cart-button']")).click();
		driver.findElement(By.xpath("\"//*[@id='nav-cart-count']\"")).click();
		driver.findElement(By.xpath("\"//*[@class='a-button-text a-declarative']\"")).click();
		driver.findElement(By.xpath("//*[@id='quantity_2']")).click();
		driver.findElement(By.xpath("\"//input[@data-action='delete']\"")).click();
		driver.findElement(By.xpath("//div[contains(@class ,'logout')]//div[contains(text(),'Logout')]"));
	}
	
	@AfterClass
    public void closeUp()
    {
        driver.close();
    }
}
