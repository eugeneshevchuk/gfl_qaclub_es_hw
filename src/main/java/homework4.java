import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by mAd on 08.06.2016.
 */
public class homework4 {
    public static WebDriver ff = null;
    ArrayList alDescriptions = new ArrayList();

    @Before
        public void setUp() {
        ff = new FirefoxDriver();
        ff.manage().window().maximize();
    }

    @Test
    public void exeTest01() {
        ff.get("https://google.com.ua");
        ff.findElement(By.id("lst-ib")).sendKeys("GeeksForLess");
        WebElement myDynamicElement = (new WebDriverWait(ff, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='st']")));

        ff.findElement(By.linkText("GeeksForLess is a North American outsourcing IT company.")).click();

    }


    @Test
    public void exeTest02() {
        ff.get("https://google.com.ua");
        ff.findElement(By.id("lst-ib")).sendKeys("GeeksForLess");
       // ff.findElement(By.id("lst-ib")).sendKeys(Keys.ENTER);

        WebElement myDynamicElement2 = (new WebDriverWait(ff, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='st']")));

        for (int i = 1; i < 10; i++) {
            alDescriptions.add(ff.findElement(By.xpath("//*[@id='rso']/div/div["+String.valueOf(i)+"]/div/div/div/span")).getText());
        }

        for(int i=0; i<alDescriptions.size(); i++){
            System.out.println(i+") "+alDescriptions.get(i));
        }
    }

    @After
    public void tearDrops(){
        ff.close();
    }
}
