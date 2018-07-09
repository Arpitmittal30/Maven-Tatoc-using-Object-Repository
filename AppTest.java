package com.qait.automation.tatoc3;


import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
 
//import RepoUtils.Repo_use;
 
public class AppTest {
 
	private Repo_use parser;
	private WebDriver driver;
 
	@BeforeClass
	public void Step01_LaunchHris() throws IOException
	{	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Arpitmittal\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://10.0.1.86/tatoc");
		parser = new Repo_use("Datafile.properties");
	}
 
//	@Test
//	public void EnterValue()
//	{
//		//Lets see how we can find the first name field
//		WebElement FirstName = driver.findElement(parser.getbjectLocator("FirstName"));
//		WebElement LastName = driver.findElement(parser.getbjectLocator("LastName"));
//		FirstName.sendKeys("Virender");
//		LastName.sendKeys("Singh");
//	}
 
	@Test
	public void Step02_ClickOnNextPage()
	{
		WebElement link = driver.findElement(parser.getbjectLocator("PartialLink"));
		link.click();
	}
	@Test
	public void  Step03_GridsGate()
	{
		WebElement link = driver.findElement(parser.getbjectLocator("classsss"));
		link.click();
	}
	@Test
	public void Step04_FrameDungean()
	{	
		WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(parser.getbjectLocator("Id1")));

	String result = driver.findElement(parser.getbjectLocator("Id2")).getAttribute("class");
	Boolean condition = true;
	while(condition) {
		WebElement link = driver.findElement(parser.getbjectLocator("Xpath1"));
		link.click();
		driver.switchTo().frame(driver.findElement(parser.getbjectLocator("Xpath3")));
		String secondresult = driver.findElement(parser.getbjectLocator("Id2")).getAttribute("class");
		driver.switchTo().parentFrame();
		
		if(result.equals(secondresult))
		{
			condition = false;
		}
		
		}
	
	WebElement link = driver.findElement(parser.getbjectLocator("Xpath2"));
	link.click();
	driver.switchTo().defaultContent();		
	}
@Test
public void Step05_Drag() {

	WebElement From = driver.findElement(parser.getbjectLocator("Xpath4"));
	From.click();
	WebElement To = driver.findElement(parser.getbjectLocator("Xpath5"));
	To.click();
	
	Actions act=new Actions(driver);
	
	act.dragAndDrop(From, To).build().perform();
	WebElement link = driver.findElement(parser.getbjectLocator("css1"));
	link.click();	
		}

@Test
public void Step06_PopWindow() {

	WebElement link = driver.findElement(parser.getbjectLocator("css2"));
	link.click();	

	ArrayList<String> str = new ArrayList<String> (driver.getWindowHandles());
	driver.switchTo().window(str.get(1));
	WebElement link1 = driver.findElement(parser.getbjectLocator("css3"));
	link1.sendKeys("Arpit");
	WebElement link2 = driver.findElement(parser.getbjectLocator("css4"));
	link2.click();
	 driver.switchTo().window(str.get(0));
	 WebElement link5 = driver.findElement(parser.getbjectLocator("Xpath9"));
		link5.click();
		
			}
@Test
public void Step07_GridGate() {

	WebElement To = driver.findElement(parser.getbjectLocator("Xpath6"));
	To.click();
	  
	  String s=driver.findElement(parser.getbjectLocator("Xpath7")).getText();
	 
	  String[] tokenValue= s.split("\\s");//
	  String token= tokenValue[1];
	  Cookie cookie= new Cookie("Token",token);
	  driver.manage().addCookie(cookie);
	  WebElement link5 = driver.findElement(parser.getbjectLocator("Xpath9"));
		link5.click();
	
	   }

	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
 
}