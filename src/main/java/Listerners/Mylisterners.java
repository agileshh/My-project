package Listerners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Mylisterners implements ITestListener
{
    @Override
    public void onStart(ITestContext context)
    {
        Reporter.log("Test Started: " + context.getName(), true);
    }

    @Override
    public void onTestStart(ITestResult result)
    {
        Reporter.log("Test Started: " + result.getName(), true);
    }

    @Override
    public void onTestSkipped(ITestResult result)
    {
        String skipped = result.getName();
        System.out.println(skipped);
    }

    @Override
    public void onTestSuccess(ITestResult result)
    {
        Reporter.log("Test Passed: " + result.getName(), true);
    }

    @Override
    public void onTestFailure(ITestResult result)
    {
        Reporter.log("Test Failed: " + result.getName(), true);
        Reporter.log(String.valueOf(result.getThrowable()));
    }

    @Override
    public void onFinish(ITestContext context)
    {
        Reporter.log("Test Finished: " + context.getName(), true);
    }
}
