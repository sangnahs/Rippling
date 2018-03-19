import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class VanillaMaskePage extends BasePage {

	
	
	
	public VanillaMaskePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}


	public void EnterZeroCentsVal(String value){
		writeValue(By.id("zeroCents"), value);
	}
	
	public void EnterPhoneNumber(String value){
		writeValue(By.id("phone"), value);
	}
	
	public void EnterNumber(String value){
		writeValue(By.id("numbers"), value);
	}
	
	
	public String getZeroCentValue(String zeroCent){
		
		StringBuilder str = new StringBuilder(zeroCent);
		int idx = str.length() - 3;

		while (idx > 0)
		{
		    str.insert(idx, ".");
		    idx = idx - 8;
		}

		return str.toString();
	}
	
	
	
	public void VerifyZeroCentVal(String expected){
		String getZerocentVal = GetEnteredValue(By.id("zeroCents"));
		getZerocentVal = getZerocentVal.substring(0, getZerocentVal.length()-3);
		Assert.assertEquals(getZerocentVal, getZeroCentValue(expected));
	}
	
	public void VerifyNumber(String expected){
		Assert.assertEquals(GetEnteredValue(By.id("numbers")), expected);
	}
	
	public void VerifyPhoneNumber(String expected){
		
	if(expected.length()>9){
		
		expected = expected.substring(0, 10);
	}
		
		
		String getNumber = GetEnteredValue(By.id("phone"));
		int len = getNumber.length();
		String getNum;
		if(len<=3){
		 getNum = getNumber.substring(1,getNumber.length());
		}
		else if(len<=9){
		 getNum = getNumber.substring(1,3).concat(getNumber.substring(5,getNumber.length()));
		}
		else{
		getNum = getNumber.substring(1,3).concat(getNumber.substring(5,9)).concat(getNumber.substring(10, getNumber.length()));
		}
		Assert.assertEquals(getNum, expected);
	}
}
