package stepDefinition;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import PageObjectModel.Login;
import PageObjectModel.SignUp;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SignUp_Step {
	
	private ChromeDriver driver;
	private SignUp signUpPage = new SignUp();

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
	
	@Given("navigate to flyaway page with for signup {string}")
	public void navigate_to_flyaway_page_with_for_signup(String string) throws InterruptedException {
		driver.get(string);
		driver.findElement(signUpPage.signInLink()).click();
		Thread.sleep(2000);
	}
	
	@Then("click on signup link")
	public void click_on_signup_link() throws InterruptedException {
		driver.findElement(signUpPage.SignUpLink()).click();
	}
	
	@When("user enter the emailid as {string}")
	public void user_enter_the_emailid_as(String string) throws InterruptedException {
		driver.findElement(signUpPage.email()).sendKeys(string);
	}
	
	@When("user enter the password as {string}")
	public void user_enter_the_password_as(String string) throws InterruptedException {
		driver.findElement(signUpPage.password()).sendKeys(string);
	}
	
	@When("user enter the confirm password as {string}")
	public void user_enter_the_confirm_password_as(String string) throws InterruptedException {
		driver.findElement(signUpPage.confirmPassword()).sendKeys(string);
	}
	
	@When("user enter the name as {string}")
	public void user_enter_the_name_as(String string) throws InterruptedException {
		driver.findElement(signUpPage.name()).sendKeys(string);
	}
	
	@When("user enter the address as {string}")
	public void user_enter_the_address_as(String string) throws InterruptedException {
		driver.findElement(signUpPage.adress()).sendKeys(string);
	}
	
	@When("user enter the city as {string}")
	public void user_enter_the_city_as(String string) throws InterruptedException {
		driver.findElement(signUpPage.city()).sendKeys(string);
	}
	
	@And("click on the signUp button")
	public void click_on_the_signUp_button() throws InterruptedException {
		driver.findElement(signUpPage.signUpButton()).click();
		Thread.sleep(10000);
	}
	
	
	@After
	public void end() {
		driver.quit();
	}

}
