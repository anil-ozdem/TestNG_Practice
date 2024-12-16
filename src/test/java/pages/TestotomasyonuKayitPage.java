package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TestotomasyonuKayitPage {

    public TestotomasyonuKayitPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//input[@id='firstName']")
    public WebElement firstNameBox;

    @FindBy(xpath = "//input[@id='lastName']")
    public WebElement lastNameBox;

    @FindBy(xpath = "//input[@id='signupemail']")
    public WebElement emailAdressBox;

    @FindBy(xpath = "//input[@id='signuppassword']")
    public WebElement passwordBox;

    @FindBy(xpath = "//input[@id='comfirmPassword']")
    public WebElement confirmPasswordBox;

    @FindBy(xpath = "//button[@id='btn-submit-form']")
    public WebElement signUpButton;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement kayitliEmailBox;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement kayitliPasswordBox;

    @FindBy(xpath = "//button[@id='submitlogin']")
    public WebElement signInButton;

    @FindBy(xpath = "//span[.='Logout']")
    public WebElement logoutButton;

    @FindBy(xpath = "(//h3)[1]")
    public WebElement kayitliIsimYaziElementi;
}
