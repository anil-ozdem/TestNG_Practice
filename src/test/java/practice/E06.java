package practice;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;
import java.util.Locale;

public class E06 {
    TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();

    @Test
    public void test01() {
        // 1. “https://www.testotomasyonu.com” adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // 2. Ana sayfanın doğru yüklendiğini doğrulayın (örneğin, sayfa başlığını kontrol ederek)
        String expectedUrl = "Test Otomasyonu";
        String actualUrl = Driver.getDriver().getTitle();

        Assert.assertTrue(actualUrl.contains(expectedUrl));
        // 3. Arama çubuğuna “phone” yazın ve aratin
        testotomasyonuPage.aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // 4. Arama sonuçlarının “phone” ile ilgili ürünleri içerdiğini doğrulayın
        List<String> strList = ReusableMethods.stringListeyeDonustur(testotomasyonuPage.aramaSonucundaBulunanUrunlerList);
        boolean sonucDogruMu = true;
        for (String eachListe : strList){
            if (!eachListe.toLowerCase().contains("phone")){
                sonucDogruMu =false;
                break;
            }

        }
        Assert.assertTrue(sonucDogruMu);

        // 6. İlk ürünü seçin
        testotomasyonuPage.ilkUrunElementi.click();

        // 7. Ürün detay sayfasının doğru yüklendiğini doğrulayın (örneğin, ürün başlığını kontrol ederek)
        String expectedUrunBasligi = "phone";
        String actualUrunBasligi = testotomasyonuPage.ilkUrunSayfasindakiIsimElementi.getText().toLowerCase(Locale.ENGLISH);

        Assert.assertTrue(actualUrunBasligi.contains(expectedUrunBasligi));

        // 8. “Sepete Ekle” butonuna tıklayın
        testotomasyonuPage.sepeteEklemeButonu.click();

        // 9. Sepet sayfasına gidin
        testotomasyonuPage.sepetLinki.click();

        // 10. Sepette seçilen ürünün doğru bir şekilde göründüğünü doğrulayın
        String expectedSepettekiUrun = actualUrunBasligi;
        String actualSepettekiUrun = testotomasyonuPage.sepettekiUrunIsmi.getText().toLowerCase();

        Assert.assertEquals(actualSepettekiUrun,expectedSepettekiUrun);

        // 11. Tarayıcıyı kapatın
        Driver.quitDriver();

        }
}


