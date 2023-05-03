package StepDefinitions.Home;
import POM.GoogleSearchPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchSteps {
    private WebDriver driver;
    private GoogleSearchPage searchPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/chromedriver");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("I am on the Google search page")
    public void iAmOnTheGoogleSearchPage() {
        driver.get("https://www.google.com/");
        searchPage = new GoogleSearchPage(driver);
    }

    @When("I search for {string}")
    public void iSearchFor(String keyword) {
        searchPage.search(keyword);
    }

    @Then("I see the number of results on the page")
    public void iSeeTheNumberOfResultsOnThePage() {
        int count = searchPage.getResultCount();
        Assert.assertTrue(count > 0);
    }

    @When("I go to the next page")
    public void iGoToTheNextPage() {
        Assert.assertTrue(searchPage.isNextPageAvailable());
        searchPage.goToNextPage();
    }

    @Then("I see the same number of results on the next page")
    public void iSeeTheSameNumberOfResultsOnTheNextPage() {
        int count1 = searchPage.getResultCount();
        searchPage.goToNextPage();
        int count2 = searchPage.getResultCount();
        Assert.assertEquals(count1, count2);
    }

    @Then("I see different search suggestions")
    public void iSeeDifferentSearchSuggestions() {
        // TODO: Implement this step
    }
}