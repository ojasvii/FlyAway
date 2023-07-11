package stepDefinition;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import PageObjectModel.Login;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_Step {
	private ChromeDriver driver;
	private Login page = new Login();

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

	@Given("navigate to flyaway page with {string}")
	public void navigate_to_flyaway_page_with(String string) throws InterruptedException {
		driver.get(string);
		Thread.sleep(2000);
	}

	@When("user logged in using username as {string}")
	public void user_logged_in_using_username_as(String string) {
		driver.findElement(page.signInLink()).click();
		driver.findElement(page.Username()).sendKeys(string);
	}

	@When("user logged in using password as {string}")
	public void user_logged_in_using_password_as(String string) {
		driver.findElement(page.Password()).sendKeys(string);
	}

	@Then("dashboard page should be displayed")
	public void dashboard_page_should_be_displayed() {
		driver.findElement(page.LoginButton()).click();
		String dashboardUrl = driver.getCurrentUrl();
		String expectedUrl = "http://localhost:8080/FlyAway/dashboard";
		Assert.assertEquals(dashboardUrl, expectedUrl);
		System.out.println("Dashboard URL : " + dashboardUrl);
	}

	@After
	public void end() {
		driver.quit();
	}
}