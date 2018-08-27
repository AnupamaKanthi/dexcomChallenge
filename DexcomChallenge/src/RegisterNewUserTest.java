import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterNewUserTest {

	public static WebDriver driver = null;

	//Before method
	@Before
	public void setup() {
		try {
			System.setProperty("webdriver.chrome.driver", "C://Users//SUNIL//Desktop//Dexcom//chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://shrouded-lowlands-66853.herokuapp.com/");
			driver.manage().window().maximize();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	@Test
	public void Test() {
		try {

			System.out.println("******** Varifying test step A01 scenario ********");
			Thread.sleep(5000);

			//read for the header "Register New User" is displayed
			if(driver.findElement(By.xpath("//h1[contains(text(),'Register New User')]")).getText().toString().equals("Register New User"))
				System.out.println("'Register new user' page is displayed, as expected");
			else
				System.out.println("'Register new user' is NOT displayed, not as expected");

			//Take screenshot
			GenericMethods.takeScreenshot("A01");



			System.out.println("******** Varifying test step A02 scenario ********");
			System.out.println("Fill all the details on the Register page except First name");
			RegisterNewUserTestData regTestData = new RegisterNewUserTestData();
			regTestData.declaireTestData();

			System.out.println("Do not pass any value for First Name");
			regTestData.firstName = " ";
			GenericMethods.fillDetailsOnRegisterNewUser(regTestData, driver);

			//Click on Save User button
			GenericMethods.clickSaveUserButton(driver);

			//Verify message displays indicating that the First Name field requires a value.
			WebElement element = driver.findElement(By.xpath("//li[contains(text(),'First Name cannot be blank')]"));
			GenericMethods.readMessage(element);

			//take the screenshot
			GenericMethods.takeScreenshot("A02");



			System.out.println("******** Varifying test step A03 scenario ********");
			//Refresh the page to clear all the data
			System.out.println("Page is reloaded to clear all the data");
			driver.get("https://shrouded-lowlands-66853.herokuapp.com/");
			Thread.sleep(5000);

			System.out.println("Pass 16 characters for the First Name");
			regTestData.firstName = "abcdefghijklmnop";
			driver.findElement(By.id("user_first_name")).sendKeys(regTestData.firstName);
			String readFirstName = driver.findElement(By.id("user_first_name")).getAttribute("value").toString();

			System.out.println("Attemted to enter First Name as "+regTestData.firstName);
			System.out.println("Actual value First Name recorded as "+readFirstName);

			//Verify maximum 15 characters can be entered
			if(readFirstName.length()==15)
				System.out.println("Only 15 characters are entered, as expected");
			else
				System.out.println(readFirstName.length()+" characters are entered, but MAX 15 is expected");

			//take the screenshot
			GenericMethods.takeScreenshot("A03");



			System.out.println("******** Varifying test step A04 scenario ********");
			//Refresh the page to clear all the data
			System.out.println("Page is reloaded to clear all the data");
			driver.get("https://shrouded-lowlands-66853.herokuapp.com/");
			Thread.sleep(5000);

			//Do not select Suffix and fill all the other fields with valid values
			System.out.println("Do not select Suffix and fill all the other fields with valid values");
			regTestData.declaireTestData();
			GenericMethods.fillDetailsOnRegisterNewUser(regTestData, driver);

			//take the screenshot
			GenericMethods.takeScreenshot("A04");



			System.out.println("******** Varifying test step A05 scenario ********");
			//Click on Save User button
			GenericMethods.clickSaveUserButton(driver);
			Thread.sleep(5000);

			//Verify the app navigates to the Success page. 
			//Verify message displays indicating Success
			element = driver.findElement(By.xpath("//h1[contains(text(),'Success! You have signed up.')]"));
			GenericMethods.readMessage(element);

			//take the screenshot
			GenericMethods.takeScreenshot("A05");



			System.out.println("******** Varifying test step A06 scenario ********");
			//Navigate to the testing page by loading test URL
			System.out.println("Navigate to the testing page by loading test URL");
			driver.get("https://shrouded-lowlands-66853.herokuapp.com/");
			Thread.sleep(5000);



			System.out.println("******** Varifying test step A07 scenario ********");
			//Fill all the details and pass title with at-least one number
			System.out.println("Fill all the details and pass title with atleast one number");
			regTestData.declaireTestData();

			regTestData.title = "title123";
			GenericMethods.fillDetailsOnRegisterNewUser(regTestData, driver);

			//Click on Save User button
			GenericMethods.clickSaveUserButton(driver);

			//Verify message displays indicating that the Title can only contain letters and spaces
			element = driver.findElement(By.xpath("//li[contains(text(),'Title can only contain letters and spaces')]"));
			GenericMethods.readMessage(element);

			//take the screenshot
			GenericMethods.takeScreenshot("A07");



			System.out.println("******** Varifying test step A08 scenario ********");
			//Refresh the page to clear all the data
			System.out.println("Page is reloaded to clear all the data");
			driver.get("https://shrouded-lowlands-66853.herokuapp.com/");
			Thread.sleep(5000);

			//Fill all the details and pass title with at-least one space
			System.out.println("Fill all the details and pass title with atleast one space");
			regTestData.declaireTestData();

			regTestData.title = "test title";
			GenericMethods.fillDetailsOnRegisterNewUser(regTestData, driver);

			//Click on Save User button
			GenericMethods.clickSaveUserButton(driver);
			Thread.sleep(5000);

			//Verify success message is displayed
			System.out.println("Verify the app navigates to the Success page.");
			element = driver.findElement(By.xpath("//h1[contains(text(),'Success! You have signed up.')]"));
			GenericMethods.readMessage(element);

			//take the screenshot
			GenericMethods.takeScreenshot("A08");
		}

		catch(Exception e) {
			System.out.println(e);
		}
	}

	//Stop the browser
	@After
	public void closeBrowser() {
		try {
			if (driver != null)
				driver.close();
			System.out.println();
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

} 