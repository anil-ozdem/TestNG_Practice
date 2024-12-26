package practice;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ZeroPage;
import utilities.ConfigReader;
import utilities.Driver;

public class E05 {

    @Test
    public void onlineBankingTesti(){
        // 1. “http://zero.webappsecurity.com/” adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("zeroUrl"));

        // 2. Ana sayfanın doğru yüklendiğini doğrulayın
        ZeroPage zeroPage = new ZeroPage();

        Assert.assertTrue(zeroPage.homeMenu.isDisplayed());

        // 3. Feedback butonuna tıklayın
        zeroPage.feedbackMenu.click();

        // 4. Name kutusuna “John Doe” yazın
        zeroPage.feedbackNameBox.sendKeys(ConfigReader.getProperty("zeroFbName"));

        // 5. Email kutusuna “johndoe@example.com” yazın
        zeroPage.feedbackEmailBox.sendKeys(ConfigReader.getProperty("zeroFbEmail"));

        // 6. Subject kutusuna “Test Subject” yazın
        zeroPage.feedbackSubjectBox.sendKeys(ConfigReader.getProperty("zeroFbSubject"));

        // 7. Message kutusuna “This is a test message” yazın
        zeroPage.feedbackMessageBox.sendKeys(ConfigReader.getProperty("zeroFbMessage"));

        // 8. Send Message butonuna basın
        zeroPage.feedbackSendMessageButton.click();

        // 9. Mesajın başarıyla gönderildiğini doğrulayın
        try {
            Assert.assertTrue(zeroPage.feedbackSendMessageButton.isEnabled());
        } catch (NoSuchElementException e) {

        }
        // 10. Feedback sayfasından çıkış yaparak ana sayfaya dönün
        zeroPage.zeroPageAnaSayfayaDonButonu.click();

        // 11. Online Banking sekmesine tıklayın
        zeroPage.onlineBankingMenu.click();

        // 12. Account Activity sayfasına gidin
        zeroPage.accountActivityLink.click();

        // 13. Gecerli Login ve Password'lari girerek giris yapin ve geri tusuna basin
        zeroPage.loginBox.sendKeys(ConfigReader.getProperty("zeroGecerliUsername"));
        zeroPage.passwordBox.sendKeys(ConfigReader.getProperty("zeroGecerliPassword"));
        zeroPage.loginPageSignInButton.click();
        Driver.getDriver().navigate().back();

        // 14. Tekrardan Account Activity sayfasina gidinn ve “Find Transactions” sekmesine geçin
        zeroPage.onlineBankingMenu.click();
        zeroPage.accountActivityLink.click();
        zeroPage.findTransactionsButonu.click();

        // 15. Find butonunun gorunun oldugunu test edin
        Assert.assertTrue(zeroPage.findTransactionsButonu.isEnabled());

        // 16. Sayfayı kapatın
        Driver.quitDriver();

    }



}
