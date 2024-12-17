package practice;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ZeroPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class E04 {

    // 1. “http://zero.webappsecurity.com/” adresine gidin
    // 2. Ana sayfanın doğru yüklendiğini doğrulayın
    // 3. Sign in butonuna tıklayın
    // 4. Kullanıcı adı alanına “username” yazın
    // 5. Şifre alanına “password” yazın
    // 6. Sign in butonuna tıklayın
    // 7. Başarılı giriş yapıldığını doğrulayın
    // 8. Online Banking menüsüne tıklayın
    // 9. “Account Summary” sayfasını açın
    // 10. Checking Account detaylarını görüntüleyin
    // 11. Pay Bills sekmesine gidin
    // 12. “Add New Payee” formunu doldurun (Ad, Adres, Hesap No, Detaylar)
    // 13. “Add” butonuna basın
    // 14. Yeni ödeme alıcısının başarıyla eklendiğini doğrulayın
    // 15. Purchase Foreign Currency sekmesine gidin
    // 16. “Currency” dropdown menüsünü açın
    // 17. Dropdown menüsünden “Eurozone” seçeneğini seçin
    // 18. “Eurozone (euro)” seçildiğini doğrulayın
    // 19. Dropdown menüsünde toplamda 16 seçenek olduğunu doğrulayın
    // 20. Dropdown menüsünde "Australia (dollar)" seçeneğinin bulunduğunu doğrulayın
    // 21. Logout yaparak hesabınızdan çıkış yapın
    // 22. Sayfayı kapatın

    ZeroPage zeroPage = new ZeroPage();

    @Test
    public void zeroTest01() {
        // 1. “http://zero.webappsecurity.com/” adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("zeroUrl"));

        // 2. Ana sayfanın doğru yüklendiğini doğrulayın
        String expectedUrl = "http://zero.webappsecurity.com/";
        String actualUrlTest = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrlTest, expectedUrl);

        // 3. Sign in butonuna tıklayın
        zeroPage.anaSayfaSignInButton.click();

        // 4. Kullanıcı adı alanına “username” yazın
        zeroPage.loginBox.sendKeys("username");

        // 5. Şifre alanına “password” yazın
        zeroPage.passwordBox.sendKeys("password");

        // 6. Sign in butonuna tıklayın
        zeroPage.loginPageSignInButton.click();

        // 7. Sayfada geri gelip, başarılı giriş yapıldığını doğrulayın
        Driver.getDriver().navigate().back();
        Assert.assertTrue(zeroPage.usernameDdm.isDisplayed());

        // 8. Online Banking menüsüne tıklayın
        zeroPage.onlineBankingMenu.click();

        // 9. “Account Summary” sayfasını açın
        zeroPage.accountSummary.click();

        // 10. Checking Account detaylarını görüntüleyin
        System.out.println("Checking Credit Cart : " + zeroPage.checkingSatiriList.get(1).getText());
        System.out.println("Checking Balance : " + zeroPage.checkingSatiriList.get(2).getText());

        // 11. Pay Bills sekmesine gidin
        zeroPage.tabMenuPayBillsSekmesi.click();

        // 12. “Add New Payee” formunu doldurun (Ad, Adres, Hesap No, Detaylar)
        Faker faker = new Faker();
        zeroPage.addNewPayeeSekmesi.click();
        zeroPage.payeeNameKutusu.sendKeys(faker.name().fullName());
        zeroPage.payeeAdresKutusu.sendKeys(faker.address().fullAddress());
        zeroPage.accountKutusu.sendKeys(faker.finance().iban());
        zeroPage.payeeDetailsKutusu.sendKeys(faker.phoneNumber().cellPhone());

        // 13. “Add” butonuna basın
        zeroPage.addButonu.click();

        // 14. Yeni ödeme alıcısının başarıyla eklendiğini doğrulayın
        Assert.assertTrue(zeroPage.sonucYazisi.isDisplayed());

        // 15. Purchase Foreign Currency sekmesine gidin
        zeroPage.purchaseForeignCurrencySekmesi.click();

        // 16. “Currency” dropdown menüsünü açın
        Select select = new Select(zeroPage.currencyDdm);

        // 17. Dropdown menüsünden “Eurozone” seçeneğini seçin
        select.selectByValue("EUR");

        // 18. “Eurozone (euro)” seçildiğini doğrulayın
        String expectedSecim = "Eurozone (euro)";
        String actualSecim = select.getFirstSelectedOption().getText();

        Assert.assertEquals(actualSecim, expectedSecim);

        // 19. Dropdown menüsünde toplamda 16 seçenek olduğunu doğrulayın
        int expectedDdmSayi = 16;
        int actualDdmSayi = select.getOptions().size();

        Assert.assertEquals(actualDdmSayi,expectedDdmSayi);

        // 20. Dropdown menüsünde "Australia (dollar)" seçeneğinin bulunduğunu doğrulayın
        List<WebElement> dropdownElementleriList = select.getOptions();
        List<String> optionYazilariList = ReusableMethods.stringListeyeDonustur(dropdownElementleriList);
        System.out.println(optionYazilariList.get(1));
        String expectedDdmYaziIcerik = "Australia (dollar)";

        Assert.assertTrue(optionYazilariList.contains(expectedDdmYaziIcerik));

        // 21. Logout yaparak hesabınızdan çıkış yapın
        zeroPage.usernameDdm.click();
        zeroPage.logout.click();

        // 22. Sayfayı kapatın
        Driver.quitDriver();
    }
}
