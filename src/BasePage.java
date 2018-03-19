import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

	private WebDriver driver;
	public BasePage(WebDriver driver){
		
		this.driver = driver;	
	}
	
	
	//enter value to input feild
	
	public void writeValue(By elementloc,String val){
		driver.findElement(elementloc).sendKeys(val);
	}
	
	//get entered Value
	
	public String GetEnteredValue(By elementloc){
		String getVal = driver.findElement(elementloc).getAttribute("value");
		return getVal;
		
	}
}
