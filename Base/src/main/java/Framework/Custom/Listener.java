package Framework.Custom;

import com.google.common.io.Files;

import Framework.Utils.CommonUtils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.*;
import org.testng.annotations.ITestAnnotation;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Listener implements ITestListener, ISuiteListener, IInvokedMethodListener, IRetryAnalyzer,
IAnnotationTransformer, IConfigurationListener, IExecutionListener {


    private static int pass;
    private static int fail;
    private static int skip;

    /**
     * Invoked each time before a test will be invoked.
     * The <code>ITestResult</code> is only partially filled with the references to
     * class, method, start millis and status.
     *
     * @param result the partially filled <code>ITestResult</code>
     * @see ITestResult#STARTED
     */
    @Override
    public void onTestStart(ITestResult result) {}

    /**
     * Invoked each time a test succeeds.
     *
     * @param result <code>ITestResult</code> containing information about the run test
     * @see ITestResult#SUCCESS
     */
    @Override
    public void onTestSuccess(ITestResult result) {
        result.getTestContext().getSkippedTests().removeResult(result.getMethod());
    }

    /**
     * Invoked each time a test fails.
     *
     * @param result <code>ITestResult</code> containing information about the run test
     * @see ITestResult#FAILURE
     */
    @Override
    public void onTestFailure(ITestResult result) {
        result.getTestContext().getSkippedTests().removeResult(result.getMethod());
        System.out.println("Test Case Failed - " + result.getMethod().getMethodName());
        if (DriverManager.getCurrentWebDriver() != null) {
            if (DriverManager.getCaptureScreenShot() == true) {
                Throwable e = result.getThrowable();
                if (e instanceof SQLException || e instanceof IOException) {
                    // Do nothing
                } else {
                    createScreenshot(result);
                }
            }
        }

    }

    /**
     * Invoked each time a test is skipped.
     *
     * @param result <code>ITestResult</code> containing information about the run test
     * @see ITestResult#SKIP
     */
    @Override
    public void onTestSkipped(ITestResult result) {
    }

    /**
     * Invoked each time a method fails but has been annotated with
     * successPercentage and this failure still keeps it within the
     * success percentage requested.
     *
     * @param result <code>ITestResult</code> containing information about the run test
     * @see ITestResult#SUCCESS_PERCENTAGE_FAILURE
     */
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

    /**
     * Invoked after the test class is instantiated and before
     * any configuration method is called.
     *
     * @param context
     */
    @Override
    public void onStart(ITestContext context) {}

    /**
     * Invoked after all the tests have run and all their
     * Configuration methods have been called.
     *
     * @param context
     */
    @Override
    public void onFinish(ITestContext context) {
        pass = context.getPassedTests().size();
        fail = context.getFailedTests().size();
        skip = context.getSkippedTests().size();
    }

    /**
     * This method is invoked before the SuiteRunner starts.
     *
     * @param suite
     */
    @Override
    public void onStart(ISuite suite) {}

    /**
     * This method is invoked after the SuiteRunner has run all
     * the test suites.
     *
     * @param suite
     */
    @Override
    public void onFinish(ISuite suite) {}

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {}

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {}

    private void createScreenshot(final ITestResult result) {
        final WebDriver driver = DriverManager.getCurrentWebDriver();
        if (driver != null) {
            final DateFormat timeFormat = new SimpleDateFormat("MM.dd.yyyy HH-mm-ss");
            final String fileName = result.getMethod().getMethodName() + "_" + timeFormat.format(new Date()) + ".png";
            try {
                File scrFile;

                if (driver.getClass().equals(RemoteWebDriver.class)) {
                    scrFile = ((TakesScreenshot) new Augmenter().augment(driver))
                            .getScreenshotAs(OutputType.FILE);
                } else {
                    scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                }

                String outputDir = result.getTestContext().getOutputDirectory();
                outputDir = outputDir.substring(0, outputDir.lastIndexOf(File.separator)) + "/html";
                final File saved = new File(outputDir, fileName);
                FileUtils.copyFile(scrFile, saved);
                Reporter.log("<br><a href=\"" + fileName + "\" target=\"_blank\"><b>Screenshot</b></a>");
            } catch (IOException e) {
                //TODO
            }
        } else {
            Reporter.log("<br>Couldn't capture screen-shot as WebDriver is null.");
        }
    }

    @Override
    public void onConfigurationFailure(ITestResult result) {}

    @Override
    public void onConfigurationSkip(ITestResult iTestResult) {}

    @Override
    public void onConfigurationSuccess(ITestResult result) {}

    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        IRetryAnalyzer retry = annotation.getRetryAnalyzer();
        if (retry == null) {
            annotation.setRetryAnalyzer(Listener.class);
        }

    }

    private static int MAX_RETRY_COUNT = Config.TEST_CASE_RETRY_COUNT;
    AtomicInteger count = new AtomicInteger(MAX_RETRY_COUNT);

    @Override
    public boolean retry(ITestResult result) {
        boolean retry = false;
        if (count.intValue() > 0) {
            Reporter.log("Test Case Failed : " + result.getMethod().getMethodName() + ", Retrying " + (MAX_RETRY_COUNT - count.intValue() + 1) + " out of " + MAX_RETRY_COUNT);
            System.out.println("Test Case Failed : " + result.getMethod().getMethodName() + ", Retrying " + (MAX_RETRY_COUNT - count.intValue() + 1) + " out of " + MAX_RETRY_COUNT);
            retry = true;
            count.decrementAndGet();
        }
        return retry;
    }

    @Override
    public void onExecutionStart() {}

    @Override
    public void onExecutionFinish() {
      
    }
	
}
