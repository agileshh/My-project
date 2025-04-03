package Utils; //make utils method as

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class Extend_report
{
    public static void generatereport()
    {
        ExtentReports extendReports = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir")+"\\target\\Extentreportfile\\extend.html");



    }
}
