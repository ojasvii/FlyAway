package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchFlight {
	
	WebDriver driver;
	
	public By home() {
		return By.xpath("//a[@href='home']");
	}
	
	public By sourceDropdown() {
		return By.xpath("//*[@name='source']");
	}
	
	public By destinationDropdown() {
		return By.xpath("//*[@name='destination']");
	}

	public By fromDest() {
		return By.xpath("(//*[@value='1'])[1]");
	}
	
	public By toDest() {
		return By.xpath("(//*[@value='11'])[2]");
	}
	
	public By submit() {
		return By.xpath("//*[text()='Submit']");
	}
	
	
}
