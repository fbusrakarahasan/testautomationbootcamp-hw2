<h1 align="center"> :bookmark_tabs: Enuygun - Test Automation Bootcamp - HW2 </h1>
 

> ##  ``` JUnit Nedir? Notasyonları Nelerdir? JUnit ile Unit Test geliştiriniz.  ```

**JUnit Nedir ?**
---
JUnit, Java programlama dili için bir açık kaynak birim test aracıdır. JUnit aracı, org.junit paketi ile test verilerinin hızlı ve kolay bir şekilde oluşturulmasını olanak sağlar. Kullanım kolaylığı sayesinde karmaşıklığı ortadan kaldırır ve zaman kaybını engeller.
 
**JUnit Notasyonları**
---
JUnit notasyonları aşağıdaki görselde kolayca görülebilmektedir.
  
![v2](https://user-images.githubusercontent.com/102550569/176285706-cd5baf43-754e-4ace-9bfe-f9592ff7fa05.jpg)

**@BeforeClass** tüm test metotlarından önce sadece bir kere çalışır ve bu notasyonun kullanıldığı metot static olarak tanımlanmalıdır. 
**@Before** ve **@After** notasyonları her test metodunun öncesinde ve sonrasında çalışır. 
**@Test** metodu ise testlerimizi çalıştırdığımız metottur. **@AfterClass** metodu tüm testlerin bitmesinin ardından bir kere çalışan metottur. 
Bu notasyonda aynı **@BeforeClass** gibi static olarak tanımlanmalıdır. 
**@Ignore** ise testi yok saymak, çalıştırmamak için kullanılan bir notasyondur. 

Şimdi ufak bir örnekle bu açıklamaları anlamlandıralım.
 
```java
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
```
