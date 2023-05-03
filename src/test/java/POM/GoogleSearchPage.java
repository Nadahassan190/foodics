package POM;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {
    private WebDriver driver;

    @FindBy(name = "q")
    private WebElement searchInput;

    @FindBy(css = "#result-stats")
    private WebElement resultStats;

    @FindBy(css = "#pnnext")
    private WebElement nextPageButton;

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void search(String keyword) {
        searchInput.sendKeys(keyword);
        searchInput.sendKeys(Keys.ENTER);
    }

    public int getResultCount() {
        String text = resultStats.getText();
        String[] parts = text.split(" ");
        String count = parts[1].replaceAll(",", "");
        return Integer.parseInt(count);
    }

    public boolean isNextPageAvailable() {
        return nextPageButton.isEnabled();
    }

    public void goToNextPage() {
        nextPageButton.click();
    }
}