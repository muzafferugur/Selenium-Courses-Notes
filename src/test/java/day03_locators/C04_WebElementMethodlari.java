package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_WebElementMethodlari {
    public static void main(String[] args) {

        /*
        1- amazon.com a gidip arama kutusunu locate edin
        2- arama kutusunun tagname inin input olduğunu test edin
        3- arama kutusunun name attribute'nun değerinin field-keywords olduğunu test edin
         */

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1- amazon.com a gidip arama kutusunu locate edin
        driver.get("https://amazon.com");
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));

        //2- arama kutusunun tagname inin input olduğunu test edin
        String expectedAramaKutusuTagName = "input";
        String actualAramaKutusuTagName = aramaKutusu.getTagName();

        if (expectedAramaKutusuTagName.equals(actualAramaKutusuTagName)) {
            System.out.println("Tagname testi PASSED");
        } else System.out.println("Tagname testi FAILED");

        //3- arama kutusunun name attribute'nun değerinin field-keywords olduğunu test edin
        String expectedAttributeName = "field-keywords";
        String actualAttributeName = aramaKutusu.getAttribute("name");

        if (expectedAramaKutusuTagName.equals(actualAramaKutusuTagName)) {
            System.out.println("name attribute'nun değeri testi PASSED");

        } else System.out.println("name attribute'nun değeri testi FAILED");

        //konudan bağımsız
        System.out.println("konum : " + aramaKutusu.getLocation());
        System.out.println("webelementin yüksekliği :" + aramaKutusu.getSize().height);


        driver.close();

/*
<input type="text" id="twotabsearchtextbox" value=""
name="field-keywords" autocomplete="off" placeholder="Search Amazon"
class="nav-input nav-progressive-attribute" dir="auto" tabindex="0" aria-label="Search Amazon" spellcheck="false">

webElementIsmi.getTagName()-->daha önce locate ettiğimiz bir webelemetin tagname'ini döndürür
webElementIsmi.getAttribute(attributeIsmi)--> daha önce locate ettiğimiz  bir webelemetin istediğim attribute değerini döndürür.
 */

    }
}
