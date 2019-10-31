package client;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SearchClient {

	WebDriver driver;

	public SearchClient(WebDriver driver) {

		this.driver = driver;
	}

	public void enterSearchTopic(String topic) {

		WebElement searchBar = driver.findElement(By.xpath(FileUtilities.getAUTProperty("Google.TextField.SearchBar")));
		searchBar.sendKeys(topic);
	}

	public void clickGoogleSearch() {

		WebElement googleSearch = driver
				.findElement(By.xpath(FileUtilities.getAUTProperty("Google.Button.GoogleSearch")));
		googleSearch.click();
	}

	public void validateResults() {

		WebElement searchResults = driver
				.findElement(By.xpath(FileUtilities.getAUTProperty("Google.TextField.Results")));
		if (searchResults.isDisplayed()) {
			System.out.println("Search Results coming");
		} else {
			Assert.fail("SearchResults not showing");
		}
	}

}
