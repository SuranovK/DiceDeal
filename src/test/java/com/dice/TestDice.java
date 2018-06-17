package com.dice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDice {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		String jobName = "IT";
		String cityName = "Houston";
		String zipCode = "Houston";
		
		driver.manage().window().fullscreen();
		//to maximize screen
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//to hold java code till upload is completed
		driver.get("https://dice.com");
		
		String actualResult = driver.getTitle();
		String expectedTitle = "Job Search for Technology Professionals | Dice.com";
		
		if(expectedTitle.equals(actualResult)) {
			System.out.println("test passed:  " + expectedTitle);
		}else {
			System.out.println("test failed " + actualResult);
		}
		
		
		
		driver.findElement(By.id("search-field-keyword")).clear();
		driver.findElement(By.id("search-field-keyword")).sendKeys(jobName);
		driver.findElement(By.id("search-field-location")).clear();
		driver.findElement(By.id("search-field-location")).sendKeys(zipCode);
		driver.findElement(By.id("findTechJobs")).click();
		
		String count = driver.findElement(By.id("posiCountId")).getText();
		
		
		int countResult = Integer.parseInt(count.replace(",", ""));
		if(countResult > 0) {
			System.out.println("TEST PASSED: search result for " + jobName + " in " + zipCode + " is " + countResult );
		}else {
			System.out.println("TEST FAILED: search result for " + countResult + " in " + zipCode + " is " + countResult );
		}
		
	
		
		
		
		
		
		
		
		driver.close();
		
		
		/*
		 * Test case: Title: dice job search
		 * 
		 * Step 1. Launch browser and navigate to https://dice.com Expected: dice home
		 * page should be displayed
		 * 
		 * Step 2. Insert search keyword and location then click on find tech jobs
		 * Expected: -Search results page should be loaded. -Page title should contain
		 * count of results , along with search keyword. -Count of results should be
		 * displayed on the page.
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */

	}

}
