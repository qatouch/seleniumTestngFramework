package com.qatouch.apitestsync;
import org.testng.annotations.Test;

import org.testng.AssertJUnit;
import org.testng.ITestResult;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class GoogleTest {
	public static WebDriver driver;
	public String projectKey="*************PROJECTKEY*****************";
	public String testRunId = "************TESTRUNKEY******************";
	public String run_result_tc_id;
	public String newstatus = "1";
	public String failstatus = "5";
	public String newcomments="Updated from QA Touch API - with CaseID";
	
	
	@BeforeSuite
	public void openBrowser()
	{
 
		driver = new FirefoxDriver();
		System.setProperty("webdriver.gecko.driver","//Users//dckap//Activities//java-workspace//lib");
		driver.get("https://www.google.com/");
	    System.out.println("We are currently on the following URL:" +driver.getCurrentUrl());
	}
	
	@Test
    public void isSearchExist() {
		run_result_tc_id="1";
       boolean flag = driver.findElement(By.name("q")).isDisplayed();
        Assert.assertTrue(flag);
	}
	
    @Test    
	public void titleTest() {
        	run_result_tc_id="3";
    		driver.get("https://www.google.com/");
            String title = driver.getTitle();
            System.out.println("page title:" + title);
            AssertJUnit.assertEquals(title, "Googlet");
        }
	     
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
    
	
	// Sync Test Results to QA Touch
   @AfterMethod
   public void addResultForTestCase(ITestResult result) {

	 
	   System.out.println(result);
	 
	   if (result.isSuccess()) {
 		   System.out.println("Success");
  
            QaTouchAPIClient.addTestRunStatus(testRunId,projectKey,run_result_tc_id, newstatus, newcomments);
        }
        else  {
        	System.out.println("Fail");
            QaTouchAPIClient.addTestRunStatus(testRunId,projectKey,run_result_tc_id, failstatus, newcomments);
        }
    }  
}
	