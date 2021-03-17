package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class StepDefinitions {

    private WebDriver driver;
    //private int int1,int2;

    @Given("I have entered {int} into the calculator")
    public void i_have_entered_into_the_calculator(Integer int1) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Selenium\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://www.marshu.com/articles/calculate-addition-calculator-add-two-numbers.php");
        driver.manage().window().maximize();
        Thread.sleep(1000);  // Let the user actually see something!
        WebElement searchBox = driver.findElement(By.name("n01"));
        searchBox.sendKeys(String.valueOf(int1));
        searchBox.sendKeys(Keys.ENTER);

        Thread.sleep(1000);  // Let the user actually see something!


    }

    @Given("I have also entered {int} into the calculator")
    public void i_have_also_entered_into_the_calculator(Integer int2) throws InterruptedException {
        Thread.sleep(1000);
        WebElement searchBox = driver.findElement(By.name("n02"));
        searchBox.sendKeys(String.valueOf(int2));
        searchBox.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
    }
    @When("I press add")
    public void i_press_add() throws InterruptedException {


        Thread.sleep(1000);  // Let the user actually see something!
        WebElement searchBox = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/form/p[4]/input"));
        searchBox.click();
        Thread.sleep(1000);
    }



    @Then("the result should be {int} on the screen")
    public void the_result_should_be_on_the_screen(Integer int1) throws InterruptedException {
    WebElement answer = driver.findElement(By.name("answer"));
        Assertions.assertEquals(int1, 247);
        Thread.sleep(1000);
        driver.quit();
    }

}
