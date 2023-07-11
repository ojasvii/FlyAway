package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
	
	WebDriver driver;
	
	public By signInLink() {
		return By.xpath("//a[@href='login']");
	}
	
	public By Username(){
		return By.xpath("//input[@name='email_id']");
		}

	public By Password() {
		return By.xpath("//input[@name='pwd']");
	}
	
	public By LoginButton() {
		return By.xpath("//*[text()='Login']");
	}
	
}


