package exercise;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuFormPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class E01 {
    TestotomasyonuFormPage testotomasyonuFormPage = new TestotomasyonuFormPage();

    //1 - https://testotomasyonu.com/form adresine gidin
    //2- Sirt Agrisi ve Carpinti checkbox’larini secin
    //3- Sirt Agrisi ve Carpinti checkbox’larininin seçili olduğunu test edin
    //4- Seker ve Epilepsi checkbox’larininin seçili olmadigini test edin
    //5- sayfayi kapatin

    @Test
    public void checkBoxTesti() {

        //1 - https://testotomasyonu.com/form adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("toFormUrl"));

        //2- Sirt Agrisi ve Carpinti checkbox’larini secin
        testotomasyonuFormPage.sirtAgrisiCheckBox.click();
        testotomasyonuFormPage.carpintiCheckBox.click();


        //3- Sirt Agrisi ve Carpinti checkbox’larininin seçili olduğunu test edin

        Assert.assertTrue(testotomasyonuFormPage.sirtAgrisiCheckBox.isSelected());
        Assert.assertTrue(testotomasyonuFormPage.carpintiCheckBox.isSelected());

        //4- Seker ve Epilepsi checkbox’larininin seçili olmadigini test edin
        Actions actions = new Actions(Driver.getDriver());
        ReusableMethods.bekle(1);
        actions.sendKeys(Keys.PAGE_DOWN);

        Assert.assertFalse(testotomasyonuFormPage.sekerCheckBox.isSelected());
        Assert.assertFalse(testotomasyonuFormPage.epilepsiCheckBox.isSelected());

        //5- sayfayi kapatin
        Driver.quitDriver();


    }
}
