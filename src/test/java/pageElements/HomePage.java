package pageElements;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends Driver {
    public static String searchitem;

    public void search(String item){
        driver.findElement(By.id("search")).clear();
        driver.findElement(By.id("search")).clear();

        searchitem = item;
        enterSearchItem(item);
        clickSearch();

       // driver.findElement(By.id("search")).sendKeys(item);
    }
    public void enterSearchItem(String item){
        driver.findElement(By.id("search")).sendKeys(item);
    }


    public void clickSearch(){
        driver.findElement(By.className("dc-button-text")).click();
    }


    public void selectDepartmentFromSuggetions(String item){
    driver.findElement(By.className("dc-search-suggestions"));
    }

    public void selectProductFromSuggetions(String item){
        driver.findElement(By.className("dc-search-suggestions__suggestion dc-search-suggestions__suggestion--sayt"));
    }

    public void selectFromSuggetions(String item,By by){
        List<WebElement> suggetionsList = driver.findElements(by);
    }

    }
