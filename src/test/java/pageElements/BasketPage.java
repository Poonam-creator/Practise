package pageElements;

import driver.Driver;
import org.openqa.selenium.By;

public class BasketPage extends Driver {
    public String getProductInBasket(){
        return driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/div[1]/div[1]/div[2]/div[2]/div[1]/a[1]")).getText();
    }
}
