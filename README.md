# seleniumTestngFramework
Java, Selenium, TestNG Framework, and test automation execution environment.

# Sync Selenium Java Test Automation Results with QA Touch


QA Touch API endpoints connect with Selenium Webdriver, which creates robust, browser-based regression automation suites and tests, scales and distributes scripts across many environments, and syncs your automation test results to QA Touch. The steps are below:

# Prerequisites:

Java, Selenium, TestNG Framework, and test automation execution environment.

We will see how to set up the syncing of test results of the sample automation project, Selenium, Java, and TestNG framework to QA Touch. The screenshots and the execution steps mentioned in the article are based on Eclipse IDE.
Download the sample project from the Github repository from Selenium Java - TestNG - QA Touch Integration Sample and import it into your test automation environment. 
Execute the test and ensure without any errors because of the environment changes.  

# Sync Test Results from Java Selenium TestNG to QA Touch

Next, we are going to set up the synchronization of the test results process. The steps are below:
1. Login in QA Touch.
2. Click the Project in which you want to sync the test automation results.
3. Create a test run for the test automation execution.
4. In this sample project, we have a single test case. Add the test case code from QA Touch. For example, it is TC0001.
5. Go to your sample test automation project, open the test script file, and update the value for the variable run_result_tc_id with your test case ID. For example, if your test case ID is TC001 then update the value as run_result_tc_id="1"; and Save it. The snippet will look like below:

@Test
   public void isSearchExist() {
		run_result_tc_id="1";
      boolean flag = driver.findElement(By.name("q")).isDisplayed();
       Assert.assertTrue(flag);
	}


