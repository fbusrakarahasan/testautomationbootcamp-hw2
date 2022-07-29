import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.*;

public class UnitTest {
    WebDriver driver;

    @Before /* Test işlemi başlamadan yapılacak işlemler */
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\system\\Desktop\\EnuygunBootcamp-HW2\\chromedriver.exe"); //chromedriver path'i eklendi.
        driver = new ChromeDriver(); //chromedriver nesnesi tanımlandı.
        driver.get("https://demoqa.com/webtables");  //ilgili siteye gidilir.
    }

    @Test /* Test işlemi*/
    public void searchBoxTesting() {
        WebElement searchElement = driver.findElement(By.id("searchBox")); //arama kutusu elementi tanımlandı.
        boolean searchDisplayed = searchElement.isDisplayed(); //arama kutusu elementi görünür oldu mu?
        Assert.assertTrue(searchDisplayed); /* Arama kutusu görünür ise Test pass, değil ise fail olarak işaretleyecek. */
    }

    @After /* Test işlemi tamamlandığında yapılacak işlemler */
    public void teardown() {
        driver.quit(); //driver nesnesi kapatıldı.
    }
}
