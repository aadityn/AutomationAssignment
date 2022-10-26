package com.cybage.widgets;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC016_Widget_datepicker 
{
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\aadityn\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/date-picker");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		TC016_Widget_datepicker wd= new TC016_Widget_datepicker();
		
		//scrolling down
		wd.Scrolldown();
		
		//Selecting Date from calendar
		wd.CalendarDate();
		
		//selecting date and time from Calendar
		wd.CalendarDateTime();
		
		Thread.sleep(2000L);
		driver.quit();
	}
	
	
	public void Scrolldown()
	{
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,300)", "");
	}
	
	
	public void CalendarDate()
	{
				//calendar event
				WebElement calendarevent=driver.findElement(By.xpath("//input[@id='datePickerMonthYearInput']"));
				calendarevent.click();
				
				WebElement year=driver.findElement(By.cssSelector(".react-datepicker__year-select"));
				Select sel= new Select(year);
				sel.selectByVisibleText("1990");
				
				WebElement month=driver.findElement(By.cssSelector(".react-datepicker__month-select"));
				Select sel1= new Select(month);
				sel1.selectByVisibleText("December");
								
				WebElement dateselector=driver.findElement(By.xpath("//div[contains(text(),'21')]"));
				dateselector.click();
		
		
	}
	
	public void CalendarDateTime()
	{
				WebElement calendartime=driver.findElement(By.xpath("//input[@id='dateAndTimePickerInput']"));
				WebDriverWait wait= new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.elementToBeClickable(calendartime));
				//calendar event

				calendartime.sendKeys(Keys.CONTROL,"a");
				calendartime.sendKeys(Keys.BACK_SPACE);
				calendartime.sendKeys("April 23, 1995 3:15 PM",Keys.ENTER);
				
	}

}
