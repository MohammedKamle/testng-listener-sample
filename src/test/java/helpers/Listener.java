package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {
    RemoteWebDriver driver = null;

    @Override
    public void onTestSuccess(ITestResult result) {
        driver = (RemoteWebDriver) result.getAttribute("driver");
        driver.executeScript("lambda-status=" + "passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        driver = (RemoteWebDriver) result.getAttribute("driver");
        driver.executeScript("lambda-status=" + "failed");
    }
}
