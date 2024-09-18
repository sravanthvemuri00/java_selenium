package StepDefinition;


import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import reusable.BaseCode;

import java.io.IOException;
import java.security.PublicKey;

public class Hook extends BaseCode {
    @Before
    public void start() throws IOException
    {
        launchBrowser();
    }
    @After
    public void after() throws IOException
    {

        System.out.println("execution completed");

    }
    @BeforeStep
    public void before() throws IOException
    {
        System.out.println("before step");
    }
    @AfterStep
    public void afters(Scenario s) throws IOException
    {
        System.out.println("after step");
        byte[] imgbyte=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        s.attach(imgbyte,"image/png","test");

    }
}
