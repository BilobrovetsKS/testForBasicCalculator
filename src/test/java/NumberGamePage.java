import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NumberGamePage implements InputFirstMeaning {
    public WebDriver driver;

    public NumberGamePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"buildNumber\"]/option[2]") //*[@id="buildNumber"]/option[2]
    private WebElement buildDemo;

    @FindBy(xpath = "//*[@id=\"rollDiceButton\"]") //*[@id="rollDiceButton"]
    private WebElement rollTheDace;

    @FindBy(xpath = "//*[@id=\"numberGuess\"]") //*[@id="numberGuess"]
    private WebElement numberGuess;

    @FindBy(xpath = "//*[@id=\"submitButton\"]") //*[@id="submitButton"]
    private WebElement submit;

    @FindBy(xpath = "//*[@id=\"feedbackLabel\"]/font/b/i") //*[@id="feedbackLabel"]/font/b/i
    private WebElement answer;

    public void clickBuildDemo() {
        buildDemo.click();
    }

    public void clickRollTheDace() {
        rollTheDace.click();
    }

    public void inputFirst(String meaning) {
        numberGuess.sendKeys(meaning);
    }

    public void submitButton() {
        submit.click();
    }

    public String answer() {
        String rsl = answer.getText();
        return rsl;
    }
}
