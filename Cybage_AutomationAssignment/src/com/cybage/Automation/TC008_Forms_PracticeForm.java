package com.cybage.Automation;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC008_Forms_PracticeForm 
{
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\aadityn\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
		driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Zoom out to 50% because of Ads getting displayed
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 String zoomJS = "document.body.style.zoom='0.50'";  
		 js.executeScript(zoomJS);
		
		driver.findElement(By.id("firstName")).sendKeys("Aditya");
		driver.findElement(By.id("lastName")).sendKeys("Nadkarni");
		driver.findElement(By.id("userEmail")).sendKeys("aadityn@test.com");
		
		
		WebElement genderselection=driver.findElement(By.id("gender-radio-1"));
		js.executeScript("arguments[0].click()", genderselection);
		
		driver.findElement(By.xpath("//input[@id='userNumber']")).sendKeys("8877665544");
		
		
		//calendar event
		WebElement calendarevent=driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));
		js.executeScript("arguments[0].click()", calendarevent);
		
		
		WebElement month=driver.findElement(By.cssSelector(".react-datepicker__month-select"));
		Select sel1= new Select(month);
		sel1.selectByVisibleText("December");
		
		WebElement year=driver.findElement(By.cssSelector(".react-datepicker__year-select"));
		Select sel= new Select(year);
		sel.selectByVisibleText("1990");
		
		WebElement dateselector=driver.findElement(By.xpath("//div[contains(text(),'21')]"));
		js.executeScript("arguments[0].click()", dateselector);
		
		
		WebElement hobbyselection=driver.findElement(By.xpath("//input[@id='hobbies-checkbox-1']"));
		js.executeScript("arguments[0].click()", hobbyselection);
		
		
		//uploading a single file
		WebElement upload = driver.findElement(By.id("uploadPicture"));
		upload.sendKeys("C:\\Users\\aadityn\\Downloads\\sampleFile.jpeg");
		
		//entering address in the Text Area.
		driver.findElement(By.cssSelector("textarea#currentAddress")).sendKeys("Mumbai");
		
		WebElement submitbtn=driver.findElement(By.xpath("//button[@id='submit']"));
		js.executeScript("arguments[0].click()", submitbtn);
		
		
		if(driver.findElement(By.xpath("//div[contains(text(),'Thanks for submitting the form')]")).getText().contains("Thanks for submitting"))
		{
			System.out.println("Thank you for submitting your personal details");
			
			WebElement Closebtn=driver.findElement(By.xpath("//button[@id='closeLargeModal']"));
			js.executeScript("arguments[0].click()", Closebtn);
			driver.quit();
		}
		else
		{
			System.out.println("There might be something wrong happened, Please do try again");
		}

		
		
		
	}

}
