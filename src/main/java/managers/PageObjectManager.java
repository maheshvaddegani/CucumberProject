package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import pageObjects.SearchPage;

public class PageObjectManager {

    private WebDriver driver;
    private SearchPage searchPage;
    private HomePage homePage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public SearchPage getSearchPage() {
        return (searchPage == null) ? searchPage = new SearchPage(driver) : searchPage;
    }

    public HomePage getHomePage() {
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }
}
