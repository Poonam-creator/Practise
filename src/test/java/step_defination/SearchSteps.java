package step_defination;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageElements.HomePage;
import pageElements.ResultsPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static pageElements.HomePage.searchitem;

public class SearchSteps {
    private HomePage homePage = new HomePage();
    private ResultsPage resultsPage = new ResultsPage();

    @Given("^user is on homepage$")
    public void user_is_on_homepage()  {
        homePage.openBrowser();
   String actual = homePage.getCurrentUrl();
    assertThat(actual, is(endsWith("gbuk/index.html")));
    }



    @When("^user search for \"([^\"]*)\"$")
    public void user_search_for(String searchitem)  {
        homePage.search(searchitem);
    }

    @Then("^user should see respective products$")
    public void user_should_see_respective_products() {
        String actualThumbnail = resultsPage.getThumbNail();
        String actualTitle = resultsPage.getPageTittle();

        assertThat(actualTitle,is(equalToIgnoringCase(searchitem)));
        assertThat(actualThumbnail, is(equalToIgnoringCase(searchitem)));
    }
    //2nd
    @When("^user enter product for search \"([^\"]*)\"$")
    public void user_enter_product_for_search(String searchitem) {
        homePage.search(searchitem);
    }
    @Then("^user should see respective laptops$")
    public void user_should_see_respective_laptops() {
        String actualThumbnail = resultsPage.getThumbNail();
        String actualTitle = resultsPage.getPageTittle();

        assertThat(actualTitle,is(equalToIgnoringCase(searchitem)));
        assertThat(actualThumbnail, is(equalToIgnoringCase(searchitem)));
    }

    @Then("^select any product$")
    public void select_any_product() {
        resultsPage.selectAnyProduct();
    }


}
