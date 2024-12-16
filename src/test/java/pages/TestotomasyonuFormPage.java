package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TestotomasyonuFormPage {

    public TestotomasyonuFormPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//select[@class='form-control'])[1]")
    public WebElement gunDdm;

    @FindBy(xpath = "(//select[@class='form-control'])[2]")
    public WebElement ayDdm;

    @FindBy(xpath = "(//select[@class='form-control'])[3]")
    public WebElement yilDdm;

    @FindBy(xpath = "//input[@id='gridCheck5']")
    public WebElement sirtAgrisiCheckBox;

    @FindBy(xpath = "//input[@id='gridCheck4']")
    public WebElement carpintiCheckBox;

    @FindBy(xpath = "//input[@id='hastalikCheck2']")
    public WebElement sekerCheckBox;

    @FindBy(xpath = "//input[@id='hastalikCheck7']")
    public WebElement epilepsiCheckBox;


}