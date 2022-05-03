import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.BeforeClass;

import java.time.Duration;


public class LoginTest {

    private static CalculatorPage PageFirst;
    private static CalculatorPage PageSecond;
    private static NumberGamePage PageThird;
    private static WebDriver driverFirst;
    private static WebDriver driverSecond;
    private static WebDriver driverThird;


    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfigProperties.getProperty("chromeDriver"));
        driverFirst = new ChromeDriver();
        driverSecond = new ChromeDriver();
        driverThird = new ChromeDriver();
        PageFirst = new CalculatorPage(driverFirst);
        PageSecond = new CalculatorPage(driverSecond);
        PageThird = new NumberGamePage(driverThird);
        driverFirst.manage().window().maximize();
        driverSecond.manage().window().maximize();
        driverThird.manage().window().maximize();
        driverFirst.get(ConfigProperties.getProperty("calculatorPage"));
        driverSecond.get(ConfigProperties.getProperty("calculatorPage"));
        driverThird.get(ConfigProperties.getProperty("theNumberGame"));
        driverFirst.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driverSecond.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driverThird.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        JavascriptExecutor js1 = (JavascriptExecutor) driverFirst;
        JavascriptExecutor js2 = (JavascriptExecutor) driverSecond;
        JavascriptExecutor js3 = (JavascriptExecutor) driverThird;
        js1.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        js2.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        js3.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    @Test
    public void TestCaseFirst() {
        PageFirst.inputFirst("2");
        PageFirst.inputSecond("3");
        PageFirst.clickOperationSubtract();
        PageFirst.clickCalculate();
        Assert.assertEquals("-1", PageFirst.answer());
        driverFirst.close();
    }

    @Test
    public void TestCaseSecond() {
        PageSecond.inputFirst("gs");
        PageSecond.inputSecond("bu");
        PageSecond.clickOperationConcatenate();
        PageSecond.clickCalculate();
        Assert.assertEquals("gsbu", PageSecond.answer());
        driverSecond.close();
    }

    @Test
    public void TestCaseThird() {
        PageThird.clickBuildDemo();
        PageThird.clickRollTheDace();
        PageThird.inputFirst("string");
        PageThird.submitButton();
        Assert.assertEquals("string: Not a number!", PageThird.answer());
        driverThird.close();
    }
}
