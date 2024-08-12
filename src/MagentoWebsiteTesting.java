
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//tagname[@attribute = '']
public class MagentoWebsiteTesting {
	
	WebDriver driver = new ChromeDriver();
	String myWebSite = "https://magento.softwaretestingboard.com/";
			
	Random rand = new Random(); // rand is a community standard but could be changed
	String password = "iLoveMyMom+123";
	String logoutPage ="https://magento.softwaretestingboard.com/customer/account/logoutSuccess/";
	String emailAddressToLogin = "";
	@BeforeTest
	public void mysetup() {
//		driver.manage().window().maximize();
		driver.get(myWebSite);
	}
	
	@Test (priority = 1) // (invocationCount = 10	) for redoing the test 10 times 
	public void CreateAnAccount() {
		//xpath == the slowest way // and the id is the fastest way
//		WebElement createAccountPage = driver.findElement(By.xpath("//a[@href = 'https://magento.softwaretestingboard.com/customer/account/create/']"));
		//partialLinkText
//		WebElement createAccountPage = driver.findElement(By.partialLinkText("Account")); // should be a unique word 
		//LinkText
		WebElement createAccountPage = driver.findElement(By.linkText("Create an Account")); // should be a unique word // The easiest one
		createAccountPage.click();
		
		// Example
		String [] theArrayNameforExampleFirstNames = {"firstName1", "firstName2", "firstName3"};
		// firstNames
		String[] first_Names = {"John", "Jane", "Michael", "Emily", "Daniel"};
		// lastNames
		String[] last_Names = {"Smith", "Johnson", "Williams", "Jones", "Brown"};
		
//		rand.nextInt(7);//from 0-6 the bound is 7 
//		System.out.println(firstNames.length);
		int randomIndexForTheFirstName = rand.nextInt(first_Names.length); 
		int randomIndexForTheLastName = rand.nextInt(last_Names.length); 
		
		System.out.println(randomIndexForTheFirstName);
		System.out.println(randomIndexForTheLastName);
		
//		driver.findElement(By.id("first_Names")).sendKeys(firstNames[randomIndexForTheFirstNames]);
		
		WebElement firstName = driver.findElement(By.id("firstname"));
		WebElement lastName = driver.findElement(By.id("lastname"));
		WebElement emailAddress = driver.findElement(By.id("email_address"));
		WebElement passwordInput = driver.findElement(By.id("password"));
		WebElement confirmpassword = driver.findElement(By.id("password-confirmation"));
		WebElement createAccountButton = driver.findElement(By.xpath("//button[@title = 'Create an Account']"));

		String firstname = first_Names[randomIndexForTheFirstName];
		String lastname = last_Names[randomIndexForTheLastName];
		String domainName = "@gmail.com";
		int randomNumber = rand.nextInt(1000);
		
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		emailAddress.sendKeys(firstname + lastname + randomNumber +domainName); // if the code gets long horizontally you can go to Window >> Edit>> Toggle Word Wrap
		passwordInput.sendKeys(password);
		confirmpassword.sendKeys(password);
		createAccountButton.click();
		emailAddressToLogin = firstname + lastname + randomNumber +domainName;
		
	}
	@Test (priority = 2)
	public void LogOut() {
		driver.get(logoutPage);	
	}
	
	@Test (priority = 3)
	public void SigninTest() {
		WebElement LoginPage = driver.findElement(By.linkText("Sign In"));
		WebElement EmailLoginInput = driver.findElement(By.id("email"));
		WebElement passwordLogin = driver.findElement(By.id("pass"));
		WebElement LoginButton = driver.findElement(By.cssSelector("action.login.primary"));
		LoginPage.click();
		EmailLoginInput.sendKeys(emailAddressToLogin);
		passwordLogin.sendKeys(password);
		LoginButton.click();
	}
	
		
	
	
	
}