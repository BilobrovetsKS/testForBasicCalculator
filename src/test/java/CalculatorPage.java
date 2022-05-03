import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CalculatorPage implements InputFirstMeaning, InputSecondMeaning {
    public WebDriver driver;

    public CalculatorPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"selectBuild\"]/option[1]") //*[@id="selectBuild"]/option[1]
    private WebElement buildPrototype;

    @FindBy(xpath = "//*[contains(@id, 'number1Field')]") //*[@id="number1Field"]
    private WebElement firstNumber;

    @FindBy(xpath = "//*[contains(@id, 'number2Field')]") //*[@id="number2Field"]
    private WebElement secondNumber;

    @FindBy(xpath = "//*[@id=\"selectOperationDropdown\"]/option[2]") //*[@id="selectOperationDropdown"]/option[2]
    private WebElement operationSubtract;

    @FindBy(xpath = "//*[@id=\"selectOperationDropdown\"]/option[5]") //*[@id="selectOperationDropdown"]/option[5]
    private WebElement operationConcatenate;

    @FindBy(xpath = "//*[contains(@id, 'calculateButton')]") //*[@id="calculateButton"]
    private WebElement calculate;

    @FindBy(xpath = "//*[contains(@id, 'numberAnswerField')]") //*[@id="numberAnswerField"]
    private WebElement answer;

    public void clickLoginBtn() {
        buildPrototype.click();
    }

    public void inputFirst(String meaning) {
        firstNumber.sendKeys(meaning);
    }

    public void inputSecond(String meaning) {
        secondNumber.sendKeys(meaning);
    }

    public void clickOperationSubtract() {
        operationSubtract.click();
    }

    public void clickOperationConcatenate() {
        operationConcatenate.click();
    }

    public void clickCalculate() {
        calculate.click();
    }

    public String answer() {
        String rsl = answer.getAttribute("value");
        return rsl;
    }
}
