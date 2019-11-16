package pageElements;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.RandomNumberHelper;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.fail;

public class ResultsPage extends Driver {

    public String getPageTittle(){
        return driver.findElement(By.className("pageTitle")).getText();
    }

    public String getThumbNail(){
    return driver.findElement(By.className("current")).getText();
    }

    public String selectAnyProduct(){
        List<WebElement> webElements = driver.findElements(By.className("productTitle"));
        if(webElements.size() == 0){
            fail("you have 0 product to select");
        }
        int ProductCount = webElements.size();
        int randomNumber = new RandomNumberHelper().generateRandomNumber(ProductCount);
        String productSelected = webElements.get(randomNumber).getText();
        webElements.get(randomNumber).click();
        return productSelected;

    }
    public void selectPrice(String priceRange) {
        int counter = 0;
        List<WebElement> filters = driver.findElements(By.className("dc-filter__option-list"));
        for (WebElement filter : filters) {
            if (filter.getText().equalsIgnoreCase(priceRange)) {
                counter++;
                filter.click();
                break;
            }
            if (counter == 0) {
                fail(" Price range not match for " + priceRange);

            }
            try {
                Thread.sleep(9000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
        public List<Double> getAllProductPrices () {
            List<Double> collactedPrices = new ArrayList<>();

            List<WebElement> priceLists = driver.findElements(By.className("price"));
            for (WebElement productPriceList : priceLists) {
                String princeInString = productPriceList.getText().replace("£", "");
                Double priceInDouble = Double.parseDouble(princeInString);
                collactedPrices.add(priceInDouble);
            }
            if (collactedPrices.size() == 0) {
                fail("Nothing collacted, may be pricecount = 0");
            }
            return collactedPrices;

        }

    }

