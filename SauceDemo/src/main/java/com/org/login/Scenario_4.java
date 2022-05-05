package com.org.login;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.io.FileHandler;

import com.google.common.io.Files;

public class Scenario_4 {

	public static void main (String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver","D:/Selenium/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.saucedemo.com/");
		
		TakesScreenshot sc = (TakesScreenshot)driver;
		File srcFile = sc.getScreenshotAs(OutputType.FILE);
		File to = new File("D:/Sel Practice/SauceDemo/Screenshot/login.png");
		Files.copy(srcFile, to);
		
		System.out.println("Login page screenshot");
		
		WebElement Uname = driver.findElement(By.id("user-name"));
		System.out.println("Username Enabled: " + Uname.isEnabled());
		
		WebElement Pwd = driver.findElement(By.id("password"));
		System.out.println("Password Enabled: " + Pwd.isEnabled());
		
		WebElement Login = driver.findElement(By.id("login-button"));
		System.out.println("Login Button Enabled: " + Login.isEnabled());
		
		Uname.sendKeys("standard_user");
		Pwd.sendKeys("secret_saucea");
		Login.click();
		
		String ErrMsg = "Epic sadface: Username and password do not match any user in this service";
		
		//WebElement error = driver.findElement(By.xpath("//button[@class='error-button']"));
		WebElement error1 = driver.findElement(By.xpath("//h3[text()='Epic sadface: Username and password do not match any user in this service']"));
		//System.out.println(error.getText());
		System.out.println(error1.getText());
		String a = error1.getText();
		
	    if (ErrMsg.matches(a)) {
	    	System.out.println("Error Message is Displayed correctly");
	    	File srcFile1 = sc.getScreenshotAs(OutputType.FILE);
			File to1 = new File("D:/Sel Practice/SauceDemo/Screenshot/errormessage.png");
			Files.copy(srcFile1, to1);
	    		    }
	    else 
	    {
	    	System.out.println("Incorrect error message displayed");
	    	File srcFile1 = sc.getScreenshotAs(OutputType.FILE);
			File to1 = new File("D:/Sel Practice/SauceDemo/Screenshot/errormessage.png");
			Files.copy(srcFile1, to1);
	    }
	    	
	    driver.close();
	}
}
