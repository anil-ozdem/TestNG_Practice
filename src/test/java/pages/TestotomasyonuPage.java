package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TestotomasyonuPage {

    /*
        Page class'larinda locate yapabilmesi icin
        WebDriver objemizi bu class'a tanitmamiz gerekiyor

        Bu tanitma islemini yapmak icin constructor ici tercih edilmis
        bu islemin sebebi,
        Test class'larindan page class'ina ulasmak icin
        obje olusturma yontemini kullanmamizdir
        Test class'inda page class'indan obje olusturmak icin
        constructor calistiginda, consturctor icine koydugumuz
        initElements() calisir ve page class'ina WebDriver objemizi tanitir

        Bir page class'i olusturdugumuzda
        ILK YAPILMASI GEREKEN ISLEM
        constructor'i gorunur hale getirip
        icersinde initElements() method'u ile WebDriver'i tanitmak olacaktir
     */

    public TestotomasyonuPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "global-search")
    public WebElement aramaKutusu;

    @FindBy (className = "product-count-text")
    public WebElement aramaSonucElementi;

    @FindBy(xpath = "(//*[@class='prod-img'])[1]")
    public WebElement ilkUrunElementi;

    @FindBy(xpath = "//div[@class=' heading-sm mb-4']")
    public WebElement ilkUrunSayfasindakiIsimElementi;

    @FindBy(xpath = "(//span[.='Account'])[1]")
    public WebElement accountLinki;

    @FindBy(id = "email")
    public WebElement emailKutusu;

    @FindBy(id = "password")
    public WebElement passwordKutusu;

    @FindBy(id = "submitlogin")
    public WebElement loginButonu;

    @FindBy(xpath = "//span[.='Logout']")
    public WebElement logoutButonu;

    @FindBy(xpath = "//button[@class='add-to-cart']")
    public WebElement sepeteEklemeButonu;

    @FindBy(xpath = "(//span[@class='menu-icon-text'])[3]")
    public WebElement sepetLinki;






}
