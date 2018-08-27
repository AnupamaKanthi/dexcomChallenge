import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GenericMethods{

	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
	//Following method will take the screenshot and store the image in below mentioned path//
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
	public static void takeScreenshot(String fileName) throws Exception
	{
		try {
			Robot robot = new Robot();
			BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			ImageIO.write(screenShot, "JPG", new File("c:\\Users\\SUNIL\\Desktop\\Dexcom\\Screenshots\\"+fileName+".jpg"));
		}

		catch (Exception e) {}
	}

	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
	//Following method will fill all the details on register new user page with passed values under argument//
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
	public static void fillDetailsOnRegisterNewUser(RegisterNewUserTestData registerNewUserTestData, WebDriver driver) {
		try {

			//fill the values
			driver.findElement(By.id("user_first_name")).sendKeys(registerNewUserTestData.firstName);
			driver.findElement(By.id("user_last_name")).sendKeys(registerNewUserTestData.lastName);
			driver.findElement(By.id("user_title")).sendKeys(registerNewUserTestData.title);
			driver.findElement(By.id("user_email")).sendKeys(registerNewUserTestData.email);
			driver.findElement(By.id("user_phone_number")).sendKeys(registerNewUserTestData.phoneNumber);
			driver.findElement(By.id("user_business_name")).sendKeys(registerNewUserTestData.businessName);
			driver.findElement(By.id("user_address_1")).sendKeys(registerNewUserTestData.addressLine1);
			driver.findElement(By.id("user_address_2")).sendKeys(registerNewUserTestData.addressLine2);
			driver.findElement(By.id("user_city")).sendKeys(registerNewUserTestData.city);
			driver.findElement(By.id("user_zip")).sendKeys(registerNewUserTestData.zip);

			Select drpState = new Select(driver.findElement(By.id("user_state")));
			drpState.selectByVisibleText(registerNewUserTestData.state);

			//Print the values
			System.out.println("First name is entered as '"+registerNewUserTestData.firstName+"'");
			System.out.println("Last name is entered as '"+registerNewUserTestData.lastName+"'");
			System.out.println("Title is entered as '"+registerNewUserTestData.title+"'");
			System.out.println("Email is entered as '"+registerNewUserTestData.email+"'");
			System.out.println("Phone Number is entered as '"+registerNewUserTestData.phoneNumber+"'");
			System.out.println("Business Name is entered as '"+registerNewUserTestData.businessName+"'");
			System.out.println("Address Line1 is entered as '"+registerNewUserTestData.addressLine1+"'");
			System.out.println("Address Line2 is entered as '"+registerNewUserTestData.addressLine2+"'");
			System.out.println("City is entered as '"+registerNewUserTestData.city+"'");
			System.out.println("Zip is entered as '"+registerNewUserTestData.zip+"'");
			System.out.println("State is entered as '"+registerNewUserTestData.state+"'");

			//select checkbox for agree terms and private policy
			WebElement chkTerms = driver.findElement(By.id("user_agree_1"));							
			chkTerms.click (); 	
			System.out.println("checkbox 'I agree to all terms.' is marked as checked");

			WebElement chkPolicy = driver.findElement(By.id("user_agree_2"));							
			chkPolicy.click (); 	
			System.out.println("checkbox 'I agree to the privacy policy.' is marked as checked");
		} 

		catch (Exception e) {
			System.out.println(e);
		}
	}

	//+++++++++++++++++++++++++++++++++++++++++++++++++++//
	//Following method will click on the Save User button//
	//+++++++++++++++++++++++++++++++++++++++++++++++++++//
	public static void clickSaveUserButton(WebDriver driver)
	{
		try {
			//find submit button and then click
			System.out.println("Click on Save User button");
			driver.findElement(By.xpath("//input[@value='Save User']")).click();
		}

		catch(Exception e) {
			System.out.println(e);
		}
	}

	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
	//Following method will read the messages displayed on top of the register page//
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
	public static void readMessage(WebElement webElement)
	{
		try {
			//find submit button and then click
			System.out.println("Reading the message on Register new user page");
			String text = null;
			text = webElement.getText().toString();

			if(text!=null)
				System.out.println("Message displayed as '"+text+"', as expected");
			else
				System.out.println("Message is expected, not as expected");
		}

		catch(Exception e) {
			System.out.println(e);
		}
	}

}
