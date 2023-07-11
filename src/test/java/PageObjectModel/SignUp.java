package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUp {
	
	WebDriver driver;
	
	public By signInLink() {
		return By.xpath("//a[@href='login']");
	}
	
	public By SignUpLink() {
		return By.xpath("//a[@href='signup']");
	}
	
	public By email() {
		return By.xpath("//*[@name='email_id']");
	}
	
	public By password() {
		return By.xpath("//*[@name='pwd']");
	}
	
	public By confirmPassword() {
		return By.xpath("//*[@name='pwd2']");
	}
	
	public By name() {
		return By.xpath("//*[@name='name']");
	}
	
	public By adress() {
		return By.xpath("//*[@name='address']");
	}
	
	public By city() {
		return By.xpath("//*[@name='city']");
	}
	
	public By signUpButton() {
		return By.xpath("//*[text()='Signup']");
	}

}
