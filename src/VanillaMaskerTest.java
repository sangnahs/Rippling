import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;


public class VanillaMaskerTest  {

	public static WebDriver driver;
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	// enter values of zeroCents, OnlyNumber, phone
	/*String zeroCents = "123123";
	String onlyNumber = "12345";
	String phone ="12345656587697";
	
	*/
	
	
	
	@BeforeMethod
	public void GoToApp() throws IOException{
		
		
		driver = new ChromeDriver();
		driver.get("https://vanilla-masker.github.io/vanilla-masker/demo.html");
		driver.manage().window().maximize();
			}
	
	@DataProvider
	 
    public Object[][] Data() throws Exception{
 
         Object[][] testObjArray = ExcelUtils.getTableArray("C://Users//c5253597//workspace//RipplingAssignment1//Data//Data.xlsx","Sheet1");
 
         return (testObjArray);
 
		}
	
	@org.testng.annotations.Test(dataProvider="Data")
	public void Test(String zeroCents,String onlyNumber,String phone){
		VanillaMaskePage vmPage = new VanillaMaskePage(driver);
		
		//enter and verify ZeroCentvalue
		vmPage.EnterZeroCentsVal(zeroCents);
		vmPage.VerifyZeroCentVal(zeroCents);
		
		//enter and verify Number value
		vmPage.EnterNumber(onlyNumber);
		vmPage.VerifyNumber(onlyNumber);
		
		//enter and verify phone number value
		vmPage.EnterPhoneNumber(phone);
		vmPage.VerifyPhoneNumber(phone);
		
	}
	
	
	
}
