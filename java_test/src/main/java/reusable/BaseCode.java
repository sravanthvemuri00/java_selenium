package reusable;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Objects;
import java.util.Properties;

public class BaseCode {
   public static WebDriver driver;
    public  static void launchBrowser() throws IOException {
        FileInputStream fis=new FileInputStream(new File("C:\\Intellij\\java_test\\src\\main\\resources\\config.properties"));
        Properties pro =new Properties();
        pro.load(fis);

        if (pro.getProperty("browser").equals("edge")){
            driver = new EdgeDriver();
        }
        else if (pro.getProperty("browser").equals("chrome")){
            driver = new ChromeDriver();
        }
        else{
            throw new InvalidArgumentException("enter correct browser");
        }

        driver.get(pro.getProperty("environment"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));



    }
}
