package org.example;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

@Listeners(helpers.Listener.class)
public class SampleTest {

    protected static ThreadLocal<RemoteWebDriver> threadLocalDriver = new ThreadLocal<>();

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
        String username = System.getenv("LT_USERNAME") == null ? "Your LT Username" : System.getenv("LT_USERNAME");
        String authkey = System.getenv("LT_ACCESS_KEY") == null ? "Your LT AccessKey" : System.getenv("LT_ACCESS_KEY");
        ;
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "MacOS Catalina");
        caps.setCapability("browserName", "Safari");
        caps.setCapability("version", "latest");
        caps.setCapability("build", "testng-listener-sample");
        caps.setCapability("name", m.getName() + " - " + this.getClass().getName());
        caps.setCapability("plugin", "git-testng");
        caps.setCapability("terminal", true);
        caps.setCapability("network", true);
        caps.setCapability("visual", true);
        caps.setCapability("video", true);
        caps.setCapability("console", true);
        caps.setCapability("performance", true);




        String[] Tags = new String[] { "Feature", "Falcon", "Severe" };
        caps.setCapability("tags", Tags);

        //driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
        threadLocalDriver.set(new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps));

    }

    @Test
    public void test1() throws InterruptedException {
        ITestResult result = Reporter.getCurrentTestResult();
        result.setAttribute("driver", threadLocalDriver.get());


        String spanText;
        System.out.println("Loading Url");

        threadLocalDriver.get().get("https://lambdatest.github.io/sample-todo-app/");

        System.out.println("Checking Box");
        threadLocalDriver.get().findElement(By.name("li1")).click();

        System.out.println("Checking Another Box");
        threadLocalDriver.get().findElement(By.name("li2")).click();

        System.out.println("Checking Box");
        threadLocalDriver.get().findElement(By.name("li3")).click();

        System.out.println("Checking Another Box");
        threadLocalDriver.get().findElement(By.name("li4")).click();

        Thread.sleep(150);
        System.out.println("TestFinished");
    }

    @Test
    public void test2() throws InterruptedException {
        ITestResult result = Reporter.getCurrentTestResult();
        result.setAttribute("driver", threadLocalDriver.get());

        String spanText;
        System.out.println("Loading Url");

        threadLocalDriver.get().get("https://lambdatest.github.io/sample-todo-app/");

        System.out.println("Checking Box");
        threadLocalDriver.get().findElement(By.name("li1")).click();

        System.out.println("Checking Another Box");
        threadLocalDriver.get().findElement(By.name("li2")).click();

        System.out.println("Checking Box");
        threadLocalDriver.get().findElement(By.name("li3")).click();

        System.out.println("Checking Another Box");
        threadLocalDriver.get().findElement(By.name("li4")).click();

        Thread.sleep(150);
        System.out.println("TestFinished");
    }

    @Test
    public void test3() throws InterruptedException {
        ITestResult result = Reporter.getCurrentTestResult();
        result.setAttribute("driver", threadLocalDriver.get());

        String spanText;
        System.out.println("Loading Url");

        threadLocalDriver.get().get("https://lambdatest.github.io/sample-todo-app/");

        System.out.println("Checking Box");
        threadLocalDriver.get().findElement(By.name("li1")).click();

        System.out.println("Checking Another Box");
        threadLocalDriver.get().findElement(By.name("li2")).click();

        System.out.println("Checking Box");
        threadLocalDriver.get().findElement(By.name("li3")).click();

        System.out.println("Checking Another Box");
        threadLocalDriver.get().findElement(By.name("li41")).click();

        Thread.sleep(150);
        System.out.println("TestFinished");
    }


    @AfterMethod
    public void tearDown() {
        threadLocalDriver.get().quit();
    }

}