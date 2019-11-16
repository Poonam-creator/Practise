import org.junit.Assert;
import org.junit.Test;
import pageElements.BasketPage;
import pageElements.HomePage;
import pageElements.ProductDescriptionPage;
import pageElements.ResultsPage;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.is;

public class RegrationTestSuite extends Hooks{

    private HomePage homepage = new HomePage();
    private ResultsPage resultsPage = new ResultsPage();
    private ProductDescriptionPage productDescriptionPage = new ProductDescriptionPage();
    BasketPage basketPage = new BasketPage();

    @Test
    public void searchTest(){
        String searchTerm = "laptop";
        homepage.search(searchTerm);
        String actualtitile = resultsPage.getPageTittle();
        resultsPage.getThumbNail();
        Assert.assertEquals("Laptops",actualtitile);
    }
    @Test
    public void filterPriceTest(){
        String priceRange = "£299.00 - £499.00";

        //homepage.search("laptop");
        List<String> expectedList = Arrays.asList(priceRange.replace("£","").split("-"));
        Double min = Double.parseDouble(expectedList.get(0));
        Double max = Double.parseDouble(expectedList.get(1));

       homepage.search("laptop");
        String actualThumbNail = resultsPage.getThumbNail();
        resultsPage.selectPrice(priceRange);
        resultsPage.selectAnyProduct();

        List<Double> actualPricelist = resultsPage.getAllProductPrices();
        Assert.assertEquals("Laptops","actualThumbnail");
    }
    @Test
    public void addProductToBasketTest(){
        homepage.search("cables");
        resultsPage.selectAnyProduct();
        productDescriptionPage.addProductToBasket();
        productDescriptionPage.continueToBasket();
        basketPage.getProductInBasket();
    }
    @Test
    public void selectDpartmentFromSuggetionsTest(){
        String searchterm = "cables";
        homepage.search(searchterm);
        homepage.selectDepartmentFromSuggetions(searchterm);
        String  actual = resultsPage.getThumbNail();
        assertThat(actual, is(equalToIgnoringCase(searchterm)));

    }
    public void selectFromSuggestedTest(){
        String searchterm = "cable";
        homepage.search(searchterm);
        homepage.selectProductFromSuggetions(searchterm);
        resultsPage.selectAnyProduct();
        String actualThumbnail = resultsPage.getThumbNail();
        assertThat(actualThumbnail,is(equalToIgnoringCase(searchterm)));
        assertThat(actualThumbnail,is(equalToIgnoringCase(searchterm)));
    }
    public void selectfromsuggetions(){
        String searchterm = "cable";
       // homepage.selectFromSuggetions(searchterm);
    }

}
