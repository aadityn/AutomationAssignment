package com.cybage.widgets;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TC022_Widgets_SelectMenus 
{
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\aadityn\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/select-menu");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		TC022_Widgets_SelectMenus tt=new TC022_Widgets_SelectMenus();
				
		//scroll down to the desired element
		tt.Scroll();
		
		//clicking on tabs 
		tt.selectMenus();
		
		//closing the session
		driver.quit();
		
	}
	
	
	public void selectMenus() throws InterruptedException
	{
		//select value
		WebElement sel1=driver.findElement(By.xpath("//div[contains(text(),'Select Value')]/parent::div/following-sibling::div[1]/div/div/div/div[1]"));
		sel1.click();
		driver.findElement(By.xpath("//div[contains(text(),'A root option')]")).click();
		
		//Select Salutation
		WebElement sel2=driver.findElement(By.xpath("//div[contains(text(),'Select One')]/parent::div/following-sibling::div[1]/div/div/div/div[1]"));
		sel2.click();
		driver.findElement(By.xpath("//div[contains(text(),'Mr.')]")).click();
		
		//select using old select method
		WebElement oldselect=driver.findElement(By.xpath("//select[@id='oldSelectMenu']"));
		Select select1= new Select(oldselect);
		oldselect.click();
		select1.selectByVisibleText("Black");
		
		//multiselect dropdown
		WebElement multiselect=driver.findElement(By.xpath("//b[contains(text(),'Multiselect drop down')]/parent::p/following-sibling::div/div/div[1]"));
		multiselect.click();
		driver.findElement(By.xpath("//div[contains(text(),'Blue')]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Black')]")).click();
		
		//standard multiselect 
		WebElement multiselectoldstyle=driver.findElement(By.id("cars"));
		Select selmulti= new Select(multiselectoldstyle);
		Thread.sleep(2000L);
		selmulti.selectByVisibleText("Volvo");
		selmulti.selectByVisibleText("Audi");
		selmulti.selectByVisibleText("Opel");
		
		Thread.sleep(2000L);
		selmulti.deselectByVisibleText("Opel");
	
	}
	
	public void Scroll()
	{
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,300)", "");
	}
}
