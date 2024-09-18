package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reusable.BaseCode;
import reusable.ReadExcel;
import java.io.IOException;
import java.time.Duration;


public class StepDefinition extends BaseCode {
//    WebDriver driver;
//    @Given("user navigate to salesforce application")
//    public void navigateUrl(){
//        driver=new ChromeDriver();
//        driver.get("https://www.saucedemo.com/");
//    }

    @Then("user enter username {string} and password {string}")
    public void userEnterUsernameAndPassword(String arg0, String arg1) {
        driver.findElement(By.xpath("//input[@id=\"user-name\"]")).sendKeys(arg0);
        driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys(arg1);
    }

    @And("user clicks the login button")
    public void userClicksTheLoginButton() throws InterruptedException {
        driver.findElement(By.id("login-button")).click();

        
    }

    @Then("user validates error message")
    public void userValidatesErrorMessage() {
       String s= driver.findElement(By.xpath("//div[@class=\"error-message-container error\"]//h3")).getText();
        System.out.println(s);
    }

    @Then("validate page title")
    public void validatePageTitle() {
        System.out.println("page title : "+driver.getTitle());
    }

    @And("sort with Condition")
    public void sortWithCon() {
        WebElement w = driver.findElement(By.className("product_sort_container"));
        int siz=w.findElements(By.tagName("option")).size();
        int i=siz-1;
        String t="Price (low to high)";
        while(i>=0)
        {
           String r= w.findElements(By.tagName("option")).get(i).getText();
          if(t.equals(r)){
              System.out.println("pass at "+i);
          }
          i--;


        }
    }

    @And("sort with dynamic")
    public void sortWithPrice() {
        WebElement w = driver.findElement(By.className("product_sort_container"));

    }

    @Given("table test")
    public void testDynamicDropdown() {
        WebElement w = driver.findElement(By.xpath("//table[@class=\"wikitable\"]"));
        int c = w.findElements(By.tagName("th")).size();
        int d = w.findElements(By.tagName("tr")).size();
        System.out.println(c+"and"+d);
        for (int i = 0; i <d; i++) {
            String v = w.findElements(By.tagName("tr")).get(i).getText();
            System.out.println(v);
        }


    }

    @Given("mouse hover")
    public void mouseHover() throws InterruptedException {
       Actions ac =new Actions(driver);
       WebElement wb = driver.findElement(By.xpath("//div[@class=\"dropdown\"]"));
       ac.clickAndHold(wb).build().perform();

    }

    @Given("drag and drop")
    public void dragAndDrop() {
        Actions as =new Actions(driver);
        WebElement drag=driver.findElement(By.xpath("//img[@id=\"dragA\"]"));
        WebElement drop=driver.findElement(By.xpath("//div[@id=\"dropBox\"]"));
        as.dragAndDrop(drag,drop).build().perform();
    }

    @Given("drag and drop frame")
    public void dragAndDropFrame() throws InterruptedException {
        Actions as =new Actions(driver);
        WebElement frame=driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(frame);
        driver.findElement(By.xpath("//button[@id=\"btnAlert\"]")).click();
    }

    @When("user enter username and password by excel")
    public void userEnterUsernameAndPasswordByExcel(String sheet, int row, int col) throws IOException {
        driver.findElement(By.cssSelector("input[id='user-name'])")).sendKeys(ReadExcel.getSheet("login",0,0));
        driver.findElement(By.cssSelector("input[id='password'])")).sendKeys(ReadExcel.getSheet("login",0,1));
    }

    @Given("click the button to display an alert")
    public void alertHandling() {
        driver.findElement(By.xpath("//button[@class=\"btn btn-danger\"]")).click();
        driver.switchTo().alert().accept();
        System.out.println("Done");

    }

    @Given("click the button to display a confirm")
    public void clickTheButtonToDisplayAConfirm() {
        driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]")).click();
        String s1=  driver.switchTo().alert().getText();
        System.out.println(s1);
        driver.switchTo().alert().dismiss();
        String s2= driver.findElement(By.cssSelector("#demo")).getText();
        System.out.println(s2);
    }

    @Given("click the button to display the prompt box")
    public void clickTheButtonToDisplayThePromptBox() {
        driver.findElement(By.xpath("//button[@class=\"btn btn-info\"]")).click();
        String s1=  driver.switchTo().alert().getText();
        System.out.println(s1);
        driver.switchTo().alert().sendKeys("sravanth");
        driver.switchTo().alert().accept();

        String s2= driver.findElement(By.cssSelector("#demo1")).getText();
        Assert.assertEquals("You Entered sravanth",s2);
        System.out.println(s2);
    }


    @Given("Button will be displayed in five")
    public void buttonWillBeDisplayedInFive() {
        driver.findElement(By.cssSelector("#alert")).click();
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(3));
        w.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();


    }

    @Given("Button will be displayed in four")
    public void buttonWillBeDisplayedInFour() {

    }

    @Given("Button will be displayed in three")
    public void buttonWillBeDisplayedInThree() {
        driver.findElement(By.cssSelector("#enable_btn")).click();
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(12));
        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@disabled=\"false\"]")));
        String s=driver.findElement(By.xpath("//button[@disabled=\"false\"]")).getText();
        System.out.println(s);


    }

    @Given("Button will be displayed in two")
    public void buttonWillBeDisplayedInTwo() {
        driver.findElement(By.xpath("//button[@id='quote']")).click();
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
        w.until(ExpectedConditions.textToBe(By.cssSelector("#change_text"), "Hello, Learn More Aspirants"));
        String s=driver.findElement(By.xpath("//button[@id='quote']")).getText();
        System.out.println(s);

    }

    @Given("Button will be displayed in one")
    public void buttonWillBeDisplayedInOne() {
        driver.findElement(By.cssSelector("#display-other-button")).click();
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(7));
        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='hidden']")));
        driver.findElement(By.xpath("//button[@id='hidden']")).isDisplayed();
        String s=driver.findElement(By.xpath("//button[@id='hidden']")).getText();
        System.out.println(s);
    }
}
