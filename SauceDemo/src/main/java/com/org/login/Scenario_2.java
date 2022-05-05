package com.org.login;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scenario_2 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","D:/Selenium/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
	driver.get("https://www.saucedemo.com/");
	
	driver.findElement(By.id("user-name")).sendKeys("standard_user");
	driver.findElement(By.id("password")).sendKeys("secret_sauce");
	driver.findElement(By.id("login-button")).click();
	
	Thread.sleep(3000);
	
	List<WebElement> products = driver.findElements(By.className("inventory_item_name"));
	System.out.println(products.size());
	
	int j= products.size();
	boolean ret = false;
	List<String> checkprod = new ArrayList<String>();
	
	String prod = "Sauce Labs Bolt T-Shirt";
    String chkprd;
    System.out.println();
    
	for (int i=0; i<j; i++)
	{
		System.out.println(products.get(i).getText());
		checkprod.add(products.get(i).getText());
		chkprd= checkprod.get(i);
			if 	(chkprd.equals(prod))
			{
				ret = chkprd.equals(prod);
				
			}
			System.out.println();
	}
	
		if 	(ret==true)
		{
			System.out.println( prod + " Product is available");
			
		}
		
		driver.close();
	}
	
	}
	
	
	