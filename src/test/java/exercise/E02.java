package exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Locale;

public class E02 {

    //1- https://www.testotomasyonu.com/ anasayfasina gidin
    //2- phone icin arama yapin
    //3- Listelenen sonuclardan ilkini tiklayin
    //4- urun ismini kaydedin ve sepete ekleyin
    //5- your cart linkine tiklayin
    //6- kaydettiginiz urun ismi ile sepetteki urun isminin ayni oldugunu test edin
    //7- sayfayi kapatin

    TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();

    @Test
    public void urunSepetiTesti() {
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        //2- phone icin arama yapin
        testotomasyonuPage.aramaKutusu.sendKeys("phone", Keys.ENTER);

        //3- Listelenen sonuclardan ilkini tiklayin
        testotomasyonuPage.ilkUrunElementi.click();

        //4- urun ismini kaydedin ve sepete ekleyin
        String expectedIlkUrunIsimElementi =
                testotomasyonuPage.ilkUrunSayfasindakiIsimElementi.getText().toLowerCase(Locale.ENGLISH);

        testotomasyonuPage.sepeteEklemeButonu.click();

        //5- your cart linkine tiklayin
        testotomasyonuPage.sepetLinki.click();

        //6- kaydettiginiz urun ismi ile sepetteki urun isminin ayni oldugunu test edin
        WebElement sepettekiUrunYazisi =
                Driver.getDriver().findElement(By.xpath("//a[@class='product-title text-center']"));
        String actualSepettekiUrunYazisi = sepettekiUrunYazisi.getText().toLowerCase();


        Assert.assertEquals(actualSepettekiUrunYazisi, expectedIlkUrunIsimElementi);

        //7- sayfayi kapatin

        Driver.quitDriver();
    }
}
