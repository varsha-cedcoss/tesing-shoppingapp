package Listeners;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.relevantcodes.extentreports.ExtentTest;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListeners implements ITestListener, ISuiteListener, IInvokedMethodListener {

	// This belongs to ISuiteListener and will execute before the Suite start

	HashMap<String, String> tcname_status = new HashMap<String, String>();
	
	int pass=0;
	int skip=0;
	int fail=0;

	@Override

	public void onStart(ISuite arg0) {

		Reporter.log("About to begin executing Suite " + arg0.getName(), true);

	}

	// This belongs to ISuiteListener and will execute, once the Suite is finished

	@Override

	public void onFinish(ISuite arg0) {

		Reporter.log("About to end executing Suite " + arg0.getName(), true);
		insertTrendsRecords();
		insertExecutionRecords();
	}
	
	
	public void insertExecutionRecords()
	{
		 Calendar cal = Calendar.getInstance();
	     SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	     System.out.println( sdf.format(cal.getTime()) );
		
		System.out.println("Pass : "+pass+" ,Fail : "+fail+" ,Skip : "+skip);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		dateFormat.format(date);

		
		 RestAssured.baseURI ="http://localhost:8080/reports_wia/";
		 RequestSpecification request = RestAssured.given();
		 
		 
		    Header h1= new Header("Content-Type", "application/json");
		    List<Header> list = new ArrayList<Header>();
		    list.add(h1);


		    Headers header = new Headers(list);
		    request.headers(header);
		 
		 JSONObject requestParams = new JSONObject();
		 requestParams.put("Servicename", "Walmart Integration App"); // Cast
		 requestParams.put("pass", pass);
		 requestParams.put("fail", fail);
		 requestParams.put("skip", skip);
		 dateFormat.format(date).toString().replace("/", ""+"/WalmartIntegrationApp.html_"+sdf.format(cal.getTime()));

		 request.body(requestParams.toJSONString());
		 
		 Response response = request.post("/insertRecordsServices");
		 
		 int statusCode = response.getStatusCode();
		 System.out.println("insertExecutionRecords StatusCode is : "+statusCode+" Report Name : "+"WalmartIntegrationApp.html_"+sdf.format(cal.getTime()));

	}

	public void insertTrendsRecords() {

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		dateFormat.format(date);

			// Insert values
			for (Map.Entry<String, String> entry : tcname_status.entrySet()) {
				 RestAssured.baseURI ="http://localhost:8080/reports_wia/";
				 RequestSpecification request = RestAssured.given();
				 
				 
				    Header h1= new Header("Content-Type", "application/json");
				    List<Header> list = new ArrayList<Header>();
				    list.add(h1);


				    Headers header = new Headers(list);
				    request.headers(header);
				 
				 JSONObject requestParams = new JSONObject();
				 requestParams.put("TC_name", entry.getKey()); // Cast
				 requestParams.put("TC_Status", entry.getValue());
				 requestParams.put("trends_ServiceList", "Walmart Integration App");

				 request.body(requestParams.toJSONString());
				 
				 Response response = request.post("/insertRecordsTrends");
				 
				 int statusCode = response.getStatusCode();
				 System.out.println("insertTrendsRecords StatusCode is : "+statusCode);
			}
	}

	// This belongs to ITestListener and will execute before starting of Test
	// set/batch

	public void onStart(ITestContext arg0) {

		Reporter.log("About to begin executing Test " + arg0.getName(), true);

	}

	// This belongs to ITestListener and will execute, once the Test set/batch is
	// finished

	public void onFinish(ITestContext arg0) {

		Reporter.log("Completed executing test " + arg0.getName(), true);

	}

	// This belongs to ITestListener and will execute only when the test is pass

	public void onTestSuccess(ITestResult arg0) {

		// This is calling the printTestResults method

		printTestResults(arg0);
		pass++;

	}

	// This belongs to ITestListener and will execute only on the event of fail test

	public void onTestFailure(ITestResult arg0) {

		// This is calling the printTestResults method

		fail++;
		printTestResults(arg0);

	}

	// This belongs to ITestListener and will execute before the main test start
	// (@Test)

	public void onTestStart(ITestResult arg0) {

		System.out.println("The execution of the main test starts now");

	}

	// This belongs to ITestListener and will execute only if any of the main
	// test(@Test) get skipped

	public void onTestSkipped(ITestResult arg0) {

		skip++;
		printTestResults(arg0);

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

	}

	// This is the method which will be executed in case of test pass or fail

	// This will provide the information on the test

	private void printTestResults(ITestResult result) {

		Reporter.log("Test Method resides in " + result.getTestClass().getName(), true);

		String[] splitForClassName = result.getTestClass().getName().split(".");

		String[] arrOfStr = (result.getTestClass().getName()).split("\\.");

		String className = arrOfStr[1];

		Reporter.log("Test Method name is " + result.getMethod().getMethodName(), true);

		String methodName = result.getMethod().getMethodName();

		String allParamas = null;

		if (result.getParameters().length != 0) {

			String params = "";

			for (Object parameter : result.getParameters()) {
				params +=  "_"+parameter.toString();

			}

			Reporter.log("Test Method had the following parameters :" + params, true);

			allParamas = params;
		}

		System.out.println("All params  : " + allParamas);

		String status = null;

		switch (result.getStatus()) {

		case ITestResult.SUCCESS:

			status = "Pass";

			break;

		case ITestResult.FAILURE:

			status = "Failed";

			break;

		case ITestResult.SKIP:

			status = "Skipped";

		}

		Reporter.log("Test Status: " + status, true);

		tcname_status.put(className + methodName + ":" + allParamas, status);

	}

	// This belongs to IInvokedMethodListener and will execute before every method
	// including @Before @After @Test

	public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {

		String textMsg = "About to begin executing following method : " + returnMethodName(arg0.getTestMethod());

		Reporter.log(textMsg, true);

	}

	// This belongs to IInvokedMethodListener and will execute after every method
	// including @Before @After @Test

	public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {

		String textMsg = "Completed executing following method : " + returnMethodName(arg0.getTestMethod());

		Reporter.log(textMsg, true);

	}

	// This will return method names to the calling function

	private String returnMethodName(ITestNGMethod method) {

		return method.getRealClass().getSimpleName() + "." + method.getMethodName();

	}
}
