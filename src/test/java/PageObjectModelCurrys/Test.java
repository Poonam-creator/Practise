package PageObjectModelCurrys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.DriverManager;
public class Test {
    public static WebDriver driver ;
    @org.junit.Test
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C://Users//hp//Downloads//chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.currys.co.uk");
    }


}