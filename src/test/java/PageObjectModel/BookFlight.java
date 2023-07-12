package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookFlight {
	
	WebDriver driver;
	
	public By bookFlightLink() {
		return By.xpath("//a[@href='bookflight?id=7']");
	}
	
	public By completePurchase() {
		return By.xpath("//a[@href='completepurchase']");
	}
	
	public By purchaseConfirmation() {
		return By.xpath("//h3[contains(text(),'FLYAWAY - BOOKING CONFIRMATION')]");
	}
	

}
