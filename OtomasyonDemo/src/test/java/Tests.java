import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.apache.logging.log4j.Logger;


public class Tests extends DriverManager {
    Methods methods = new Methods();
    private static final Logger logger = LogManager.getLogger(Tests.class);

    @Test
    public void SeturOtomasyonTesti() {
        By cerezKapama = By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");
        By nereyeGideceksin = By.cssSelector("[placeholder='Otel Adı Veya Konum']");
        By UsttekiSecenek = By.cssSelector(".ListStyle__ListWrapper-sc-u8yzic-0 > div:nth-of-type(1) strong");
        By TarihSec = By.cssSelector(".HotelBookerDatePicker__BookerSearchBarDateRangeInputWrapper-sc-1larvt5-0 .SearchBarInputStyle__SearchBarInputWrapper-sc-h1ifqh-1 > .styled__StyledCustomIcon-sc-d0bnog-0 > .Icon__IconWrapper-sc-etcw2b-0 > [xmlns='http://www.w3.org/2000/svg']");
        By TarihIlerleme = By.cssSelector(".DatePickerStyle__NavNextButton-sc-1yq2271-2 [xmlns='http://www.w3.org/2000/svg']");
        By IlkGun = By.cssSelector("[aria-label='Choose Çarşamba, 1 Kasım 2023 as your check-in date. It’s available.'] > .helpers__CalenderDay-sc-1l68pts-0");
        By SonGun = By.cssSelector("[aria-label='Choose Salı, 7 Kasım 2023 as your check-out date. It’s available.'] > .helpers__CalenderDay-sc-1l68pts-0");
        By KisiSayisi = By.cssSelector(".kmspwW [xmlns='http://www.w3.org/2000/svg']");
        By KisiArttirma = By.cssSelector(".SearchGuestStyle__GuestScrollWrapper-sc-txpuig-14 > div:nth-of-type(1) button:nth-of-type(2) path:nth-of-type(1)");
        By aramaButonu = By.xpath("//button[@class='styled__StyledButton-sc-1i7jkmi-0 iRHtqU']");

        By[] digerBolgelerLocators = {
                By.xpath("//div[@class='styled__DesktopItems-sc-xe39ep-2 coVbSa']//span[@class='styled__Label-sc-1t0ekn5-2 cnyeXv']/span[.='Alanya  (95)']"),
                By.xpath("//div[@class='styled__DesktopItems-sc-xe39ep-2 coVbSa']//span[@class='styled__Label-sc-1t0ekn5-2 cnyeXv']/span[.='Manavgat  (92)']"),
                By.xpath("//div[@class='styled__DesktopItems-sc-xe39ep-2 coVbSa']//span[@class='styled__Label-sc-1t0ekn5-2 cnyeXv']/span[.='Kemer  (99)']"),
                By.xpath("//div[@class='styled__DesktopItems-sc-xe39ep-2 coVbSa']//span[@class='styled__Label-sc-1t0ekn5-2 cnyeXv']/span[.='Side  (70)']")
        };


        methods.waitSeconds(2);
        methods.click(cerezKapama);
        logger.info("Sayfa açıldı, çerez kabul düğmesine tıklandı.");


        // URL kontrolü
        String currentURL = methods.getCurrentURL();
        Assertions.assertEquals("https://www.setur.com.tr/", currentURL);

        methods.click(nereyeGideceksin);
        methods.sendKeys(nereyeGideceksin, "Antalya");
        methods.click(UsttekiSecenek);
        methods.click(TarihSec);
        methods.click(TarihIlerleme);
        methods.click(IlkGun);
        methods.click(SonGun);
        methods.click(KisiSayisi);
        methods.click(KisiArttirma);

        boolean isAramaButonuVisible = methods.isElementVisibleWithoutLog(aramaButonu);
        Assertions.assertTrue(isAramaButonuVisible);

        methods.click(aramaButonu);

        // "Antalya" kelimesi kontrolü
        boolean containsAntalya = methods.doesPageContainText("Antalya");
        Assertions.assertTrue(containsAntalya);

        for (By locator : digerBolgelerLocators) {
            if (methods.isElementVisibleWithoutLog(locator)) {
                methods.click(locator);
                break; // İlk bulunan seçeneği seç çık
            }
        }

        methods.waitSeconds(8);
        methods.clickRandomDigerBolge();

        logger.info("Rastgele bir diğer bölge seçildi.");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        int scrollAmount = 7500;
        js.executeScript("window.scrollBy(0, " + scrollAmount + ");");
        methods.waitSeconds(3);
    }
}