package stepDefinition;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import PageObjectModel.BookFlight;
import PageObjectModel.Login;
import PageObjectModel.SearchFlight;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BookFlight_Step {
	
	private ChromeDriver driver;
	private Login page = new Login();
	private SearchFlight sf = new SearchFlight();
	private BookFlight bf = new BookFlight();

	private ExtentSparkReporter spark;
	private ExtentReports extent;
	private ExtentTest logger;

	@Before
	public void begin() {
		
		 ChromeOptions option = new ChromeOptions();
         option.addArguments("--remote-allow-origins=*");
         
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
	//	options.addArguments("--remote-allow-origins=*")
	}
	
	@Given("navigate to flyaway {string}")
	public void navigate_to_flyaway(String string) throws InterruptedException {
		driver.get(string);
		Thread.sleep(2000);
	}
	
	@When("user logged in using username and password {string} {string}")
	public void user_logged_in_using_username(String string, String string1) {
		driver.findElement(page.signInLink()).click();
		driver.findElement(page.Username()).sendKeys(string);
		driver.findElement(page.Password()).sendKeys(string1);
	}


	@Then("it will redirect to dashboard page")
	public void it_will_redirect_to_dashboard_page() {
		driver.findElement(page.LoginButton()).click();
		String dashboardUrl = driver.getCurrentUrl();
		String expectedUrl = "http://localhost:8080/FlyAway/dashboard";
		Assert.assertEquals(dashboardUrl, expectedUrl);
		System.out.println("Dashboard URL : " + dashboardUrl);
	}
	
	
	@And("click on home link now")
	public void click_on_home_link_now() {
		driver.findElement(sf.home()).click();
	}
	
//	And click on book flight
//	And Verify the message "<message>"
//	Then verify the booking confirmation message "<confirmation>"
	
	@And("click on book flight")
	public void click_on_book_flight() {
		driver.findElement(bf.bookFlightLink()).click();
	}
	
	@And("Verify the message {string}")
	public void Verify_the_message(String string) {
		String actualMessage = driver.findElement(bf.completePurchase()).getText();
		System.out.println("Message to book flight" + actualMessage);
		String expectedMessage = string;
		Assert.assertEquals(actualMessage, expectedMessage);
	}
	
	@Then("verify the booking confirmation message {string}")
	public void verify_the_booking_confirmation_message(String string) {
		String actualBookConfirmation = driver.findElement(bf.purchaseConfirmation()).getText();
		System.out.println("Booking confirmaiton message" + actualBookConfirmation);
		String expectedConfirmationMessage = string;
		Assert.assertEquals(actualBookConfirmation, expectedConfirmationMessage);
	}

}
