package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTests {
	@Test 
	
	public void incorrectusernametest()
	{
		// create driver
		
		System.out.println("Start incorrectusernametest");

		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// sleep for 3 sec
		sleep(3000);

		// maximize chrome window
		driver.manage().window().maximize();

//		open test page
		String url = "https://the-internet.herokuapp.com/login";
		driver.get(url);
		
		// sleep for 3 sec
		sleep(5000);
		
		System.out.println("Page is opened");
//enter username
		
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("ncorrect username");
		
		sleep(3000);
		
		
//enter pawd
		
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("SuperSecretPassword!");
		
		
		sleep(3000);
		
//click login button
		
		WebElement loginButton = driver.findElement(By.tagName("button"));
		loginButton.click();

		sleep(5000);
		
//verification
		
WebElement Errormessage = driver.findElement(By.id("flash"));
String Expectedmessage = "Your username is invalid";
String Actualmessage = Errormessage.getText();

Assert.assertTrue(Actualmessage.contains(Expectedmessage), "Actual message is different from expected message");


//close browser
driver.quit();

} 

@Test 

public void incorrectpasswordtest()
{
// create driver

System.out.println("Start incorrectpasswordtest");

System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
WebDriver driver = new ChromeDriver();

// sleep for 3 sec
sleep(3000);

// maximize chrome window
driver.manage().window().maximize();

//open test page
String url = "https://the-internet.herokuapp.com/login";
driver.get(url);

// sleep for 3 sec
		sleep(5000);
		
		System.out.println("Page is opened");
//enter username
		
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("tomsmith");
		
		sleep(3000);
		
		
//enter pawd
		
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("fghjk");
		
		
		sleep(3000);
		
//click login button
		
		WebElement loginButton = driver.findElement(By.tagName("button"));
		loginButton.click();

		sleep(5000);
		
//verification
		
WebElement Errormessage = driver.findElement(By.id("flash"));
String Expectedmessage = "Your password is invalid";
String Actualmessage = Errormessage.getText();

Assert.assertTrue(Actualmessage.contains(Expectedmessage), "Actual message is different from expected message");


//close browser
driver.quit();
		
		


		
		driver.quit();
		
			}
	
	private void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
