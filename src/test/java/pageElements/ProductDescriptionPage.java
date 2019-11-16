package pageElements;

import driver.Driver;
import org.openqa.selenium.By;

public class ProductDescriptionPage extends Driver {
    public void addProductToBasket(){
        driver.findElement(By.className("Button-hYXUXp fIBPaH")).click();
    }
    public void continueToBasket(){
        driver.findElement(By.className("Button-hYXUXp sc-htoDjs fFDyiO")).click();
    }

}
