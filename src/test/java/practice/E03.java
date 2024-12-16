package practice;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuKayitPage;
import utilities.ConfigReader;
import utilities.Driver;

public class E03 {

    //1- https://www.testotomasyonu.com/customer-register adresine git.
    //2- Kayıt formundaki tüm alanları Faker kütüphanesini kullanarak doldur.
    //3- Kayıt işlemini tamamla ve başarı mesajını doğrula.
    //4- Çıkış yap.
    //5- https://www.testotomasyonu.com/giris adresine git.
    //6- Az önce kaydettiğin kullanıcı bilgileri ile giriş yap.
    //7- Giriş yaptıktan sonra, kullanıcının isminin sayfanın sağ üst köşesinde göründüğünü doğrula.

    TestotomasyonuKayitPage testotomasyonuKayitPage = new TestotomasyonuKayitPage();


    @Test
    public void kayitTesti(){

        //1- https://www.testotomasyonu.com/customer-register adresine git.
        Driver.getDriver().get(ConfigReader.getProperty("toKayitUrl"));

        //2- Kayıt formundaki tüm alanları Faker kütüphanesini kullanarak doldur.
        Faker faker = new Faker();
        String fakeFirstName = faker.name().firstName();
        String fakeLastName = faker.name().lastName();
        String fakeEmailAdress = faker.internet().emailAddress();
        String fakePassword = faker.internet().password();

        testotomasyonuKayitPage.firstNameBox.sendKeys(fakeFirstName);
        testotomasyonuKayitPage.lastNameBox.sendKeys(fakeLastName);
        testotomasyonuKayitPage.emailAdressBox.sendKeys(fakeEmailAdress);
        testotomasyonuKayitPage.passwordBox.sendKeys(fakePassword);
        testotomasyonuKayitPage.confirmPasswordBox.sendKeys(fakePassword);

        testotomasyonuKayitPage.signUpButton.click();

        //3- Kayıt işlemini tamamla ve başarı mesajını doğrula.

        // kayit islemi yapilinca otomatik olarak giris sayfasina yonlendiriyor
        // test edebilmek icin giris yapmamiz gerekir

        testotomasyonuKayitPage.kayitliEmailBox.sendKeys(fakeEmailAdress);
        testotomasyonuKayitPage.kayitliPasswordBox.sendKeys(fakePassword);
        testotomasyonuKayitPage.signInButton.click();


        //4- Çıkış yap.
        testotomasyonuKayitPage.logoutButton.click();

        //5- https://www.testotomasyonu.com/customer-login adresine git.
        Driver.getDriver().get(ConfigReader.getProperty("toLoginUrl"));

        //6- Az önce kaydettiğin kullanıcı bilgileri ile giriş yap.
        testotomasyonuKayitPage.kayitliEmailBox.sendKeys(fakeEmailAdress);
        testotomasyonuKayitPage.kayitliPasswordBox.sendKeys(fakePassword);
        testotomasyonuKayitPage.signInButton.click();

        //7- Giriş yaptıktan sonra, kullanıcının isminin sayfada göründüğünü doğrula.

        String expectedIsim = fakeFirstName;
        String actualIsim = testotomasyonuKayitPage.kayitliIsimYaziElementi.getText();

        Assert.assertEquals(actualIsim, expectedIsim);

        Driver.quitDriver();




    }



}
