package stepDefinitions;

import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import org.junit.Assert;
import pageObjects.HomePage;
import pageObjects.SearchPage;
import testDataTypes.SearchTerm;


public class SearchPageSteps {
    TestContext testContext;
    HomePage homePage;
    SearchPage searchPage;

    public SearchPageSteps(TestContext testContext){
        this.testContext = testContext;
        searchPage = testContext.getPageObjectManager().getSearchPage();
        homePage = testContext.getPageObjectManager().getHomePage();
    }


    @Given("I navigate to google")
    public void iNavigateToGoogle() {
        homePage.navigateTo_HomePage();
        homePage.click_IAgree();
    }

    @When("I enter {string} in search")
    public void iEnterInSearch(String searchTerm) {
        SearchTerm term = FileReaderManager.getInstance().getJsonReader().getSearchTermByName(searchTerm);
        testContext.scenarioContext.setContext(Context.SEARCH_TERM, term);
        homePage.enter_SearchTerm(term.description);
    }

    @And("I click on search button")
    public void iClickOnSearchButton() {
        homePage.click_googleSearch();
    }

    @Then("I should see the search results for cucumber")
    public void iShouldSeeTheSearchResultsForCucumber() {
    }

    @And("Verify the Search Term")
    public void verifyTheSearchTerm() {
        SearchTerm searchTermExpected = (SearchTerm)testContext.scenarioContext.getContext(Context.SEARCH_TERM);
        String searchTermActual = searchPage.get_SearchTerm();
        Assert.assertEquals(searchTermExpected.description, searchTermActual);
    }
}
