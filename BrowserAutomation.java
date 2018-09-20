package WebSearch.stepDefinitions.demo;
import cucumber.api.java.After;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.CucumberOptions;
import cucumber.api.java.en.When;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:websearch.feature",
        glue = "classpath:WebSearch.stepDefinitions.demo",
        tags =  {"@Suceesfulsearch", "@Unsuccessfulsearch"}
)
public class BrowserAutomation {
    private  WebDriver driver ;


    @Given("^I am on the Google search page$")
    public void i_am_on_the_Google_search_page() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        System.setProperty("webdriver.chrome.driver", "C:\\chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https:\\www.google.com");
    }

    @When("^I search for \"([^\"]*)\"$")
    public void i_search_for(String query) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys(query);
        element.submit();
    }

    @Then("^the page should display results of  \"([^\"]*)\"$")
    public void the_page_should_display_results_of(String titleStartsWith) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        new WebDriverWait(driver,10L).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("apple");
            }
        });
    //throw  noSearchResultsFound( titleStartsWith);
    }
   // private static IllegalArgumentException noSearchResultsFound(String titleStartsWith ) {
    //    return new IllegalArgumentException("No results found for "+ titleStartsWith);
  //  }

    @After()
    public void closeBrowser() {
        driver.quit();
    }



}
