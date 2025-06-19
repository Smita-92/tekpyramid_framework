 package Reporting;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class sampleReportTest {
	public ExtentReports report;

	@BeforeSuite
	public void configBS() {
		// spark report config
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM Test suite Reults");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		// add env information and create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER", "CHROME-100");

	}

	@AfterSuite
	public void configAS() {
		report.flush();

	}

	@Test

	public void createcontactTest() {
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		TakesScreenshot edriver=(TakesScreenshot)driver;
		String filepath=edriver.getScreenshotAs(OutputType.BASE64);
		
		ExtentTest test = report.createTest(" createcontactTest");
		test.log(Status.INFO, "Login to app");
		test.log(Status.INFO, "Navigate to contact page");
		test.log(Status.INFO, "Create contact");
		if ("HDFC".equals("HDC")) {
			test.log(Status.PASS, "Contact is created");

		} else {
			test.addScreenCaptureFromBase64String(filepath,"ErrorFile");

		}
		driver.close();
	}

	@Test

	public void createcontactOrg() {
		ExtentTest test = report.createTest("  createcontactOrg");
		test.log(Status.INFO, "Login to app");
		test.log(Status.INFO, "Navigate to contact page");
		test.log(Status.INFO, "Create contact");
		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "Contact is created");

		} else {
			test.log(Status.FAIL, "Contact is created");

		}

	}

	@Test

	public void createcontactPhno() {
		ExtentTest test = report.createTest(" createcontactPhno");
		test.log(Status.INFO, "Login to app");
		test.log(Status.INFO, "Navigate to contact page");
		test.log(Status.INFO, "Create contact");
		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "Contact is created");

		} else {
			test.log(Status.FAIL, "Contact is created");

		}

	}
}
