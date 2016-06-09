import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by mAd on 08.06.2016.
 */
public class homework4 {
WebDriver ff;
WebDriver ff2;
    @Before
        public void setUp() {
        ff = new FirefoxDriver();
        ff.manage().window().maximize();
        ff2 = new FirefoxDriver();
        ff2.manage().window().maximize();
    }
    @Test
    public void exeTest(){
        ff.get("https://google.com.ua");
        ff.findElement(By.id("lst-ib")).sendKeys("GeeksForLess");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            ff.findElement(By.linkText("GeeksForLess is a North American outsourcing IT company.")).click();


        ff2.get("https://google.com.ua");
        ff2.findElement(By.id("lst-ib")).sendKeys("GeeksForLess");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            String descrip = "";
            ff2.findElement(By.xpath("//*[@id='rso']/div/div[1]/div/div/div/span")).getCssValue(descrip);
            System.out.println(descrip);


        }
    }
    @After
    public void tearDrops(){
        ff.quit();
    }
}
