package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTests {
@Test
	public void loginTest() {
		// create driver
		
		System.out.println("Start login test");

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
//		enter username
				
				WebElement username = driver.findElement(By.id("username"));
				username.sendKeys("tomsmith");
				
				sleep(3000);
				
				
//		enter pawd
				
				WebElement password = driver.findElement(By.name("password"));
				password.sendKeys("SuperSecretPassword!");
				
				
				sleep(3000);
				
//		click login button
				
				WebElement loginButton = driver.findElement(By.tagName("button"));
				loginButton.click();

				sleep(5000);
				
//		verification:
//			new url
				String Expectedurl = "https://the-internet.herokuapp.com/secure";
						String Actualurl=driver.getCurrentUrl();
				Assert.assertEquals(Actualurl, Expectedurl, "Actual url is not the same as expected URL");
				
//			logout button is visble 
				WebElement logoutButton = driver.findElement(By.xpath("//div[@id='content']//a[@href='/logout']"));
				Assert.assertTrue(logoutButton.isDisplayed(), "logou button is not present");
				
//			successful login message
				WebElement successmessage = driver.findElement(By.cssSelector("div#flash"));
				String Expectedmessage = "You logged into a secure area!";
						String Actualmessage = successmessage.getText();	
						//Assert.assertEquals(Actualmessage, Expectedmessage, "Actual is not same as expected");
						Assert.assertTrue(Actualmessage.contains(Expectedmessage), "Actual message does not contain expected message");
				
				//Close browser
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
