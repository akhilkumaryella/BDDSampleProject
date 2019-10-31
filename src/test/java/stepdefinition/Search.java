package stepdefinition;

import org.openqa.selenium.WebDriver;

import client.FileUtilities;
import client.SearchClient;
import client.WebDriverBase;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Search {

	WebDriver driver = WebDriverBase.getChromeDriver();

	public SearchClient searchClient = new SearchClient(driver);

	@Given("^open google URL$")
	public void open_google_URL() {

		driver.get(FileUtilities.getAUTProperty("site.url"));
	}

	@Given("^enter \"([^\"]*)\"$")
	public void enter(String topic) {

		searchClient.enterSearchTopic(topic);
	}

	@When("^click GoogleSearch$")
	public void click_GoogleSearch() {

		searchClient.clickGoogleSearch();
	}

	@Then("^cricket results coming$")
	public void cricket_results_coming() {

		searchClient.validateResults();
	}
	
	@After
	public void closeDriver() {
		
		driver.close();
	}

}
