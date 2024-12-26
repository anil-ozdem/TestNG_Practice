package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ZeroPage {

    public ZeroPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//button[@id='signin_button']")
    public WebElement anaSayfaSignInButton;

    @FindBy(xpath = "//input[@id='user_login']")
    public WebElement loginBox;

    @FindBy(xpath = "//input[@id='user_password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//input[@name='submit']")
    public WebElement loginPageSignInButton;

    @FindBy(xpath = "(//*[@class='dropdown-toggle'])[2]")
    public WebElement usernameDdm;

    @FindBy(xpath = "//*[@id='onlineBankingMenu']")
    public WebElement onlineBankingMenu;

    @FindBy(xpath = "//*[@id='account_summary_link']")
    public WebElement accountSummary;

    @FindBy(xpath = "((//tbody)/tr)[4]//td")
    public List<WebElement> checkingSatiriList;

    @FindBy(xpath = "//*[@id='pay_bills_tab']")
    public WebElement tabMenuPayBillsSekmesi;

    @FindBy(xpath = "//a[.='Add New Payee']")
    public WebElement addNewPayeeSekmesi;

    @FindBy(xpath = "//*[@id='np_new_payee_name']")
    public WebElement payeeNameKutusu;

    @FindBy(xpath = "//*[@id='np_new_payee_address']")
    public WebElement payeeAdresKutusu;

    @FindBy(xpath = "//*[@id='np_new_payee_account']")
    public WebElement accountKutusu;

    @FindBy(xpath = "//*[@id='np_new_payee_details']")
    public WebElement payeeDetailsKutusu;

    @FindBy(xpath = "//*[@id='add_new_payee']")
    public WebElement addButonu;

    @FindBy(xpath = "//*[@id='alert_content']")
    public WebElement sonucYazisi;

    @FindBy(xpath = "//*[.='Purchase Foreign Currency']")
    public WebElement purchaseForeignCurrencySekmesi;

    @FindBy(xpath = "//*[@id='pc_currency']")
    public WebElement currencyDdm;

    @FindBy(xpath = "//*[@id='logout_link']")
    public WebElement logout;

    @FindBy(id = "homeMenu")
    public WebElement homeMenu;

    @FindBy(id = "feedback")
    public WebElement feedbackMenu;

    @FindBy(xpath = "//input[@id='name']")
    public WebElement feedbackNameBox;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement feedbackEmailBox;

    @FindBy(xpath = "//input[@id='subject']")
    public WebElement feedbackSubjectBox;

    @FindBy(xpath = "//*[@id='comment']")
    public WebElement feedbackMessageBox;

    @FindBy(xpath = "//*[@name='submit']")
    public WebElement feedbackSendMessageButton;

    @FindBy(xpath = "//*[@class='brand']")
    public WebElement zeroPageAnaSayfayaDonButonu;

    @FindBy(id = "account_activity_link")
    public WebElement accountActivityLink;

    @FindBy(xpath = "//li[@class='ui-state-default ui-corner-top']")
    public WebElement findTransactionsButonu;

    @FindBy(xpath = "//*[@id='aa_fromDate']")
    public WebElement dateBox;

    @FindBy(xpath = "//*[@id='aa_toDate']")
    public WebElement toDateBox;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement findButton;

    @FindBy(xpath = "//*[@*='ui-icon ui-icon-circle-triangle-w']")
    public WebElement prevButton;

}
