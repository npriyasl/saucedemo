package com.org.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scenario_1 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","D:/Selenium/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
	driver.get("https://www.saucedemo.com/");
	
	driver.findElement(By.id("user-name")).sendKeys("standard_user");
	driver.findElement(By.id("password")).sendKeys("secret_sauce");
	driver.findElement(By.id("login-button")).click();
	
	driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).click();
	driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
	
	WebElement prod= driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
	String prodvalue = prod.getText();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
	
	driver.findElement(By.id("checkout")).click();		
		
	driver.findElement(By.id("first-name")).sendKeys("Priya");
	driver.findElement(By.id("last-name")).sendKeys("N");
	driver.findElement(By.id("postal-code")).sendKeys("600001");
	driver.findElement(By.id("continue")).click();
	
	Thread.sleep(3000);
	WebElement prodcheck = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
	
	String checkvalue= prodcheck.getText();
	
	if (checkvalue.equals(prodvalue)) {
		System.out.println("Product Ordered successfully");
	}
	System.out.println("success");
	
	driver.close();	
	}
}
