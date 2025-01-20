package test;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;

import utility.Reports;
import utility.Screenshot;

public class Listeners extends BaseTest implements ITestListener {
	
	private ExtentReports reports;
	public void onTestStart(ITestResult result) {
		
		System.out.println(result.getName()+"Started");
	}
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getName()+"Passed");
	
	}
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getName()+"Failure");
		try {
			Screenshot.takeScreenshot(driver, result.getName());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		 	
	}
	public void ITestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getName()+"Skipped");

	}
	public void onTestFinish(ITestContext result) {
		reports.flush();
		driver.close();
	}
	public void onStart(ITestContext result) {
		reports = Reports.createReport();
	}
	


}
