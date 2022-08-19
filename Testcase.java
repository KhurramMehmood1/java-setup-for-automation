package Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Pages.PomOfTest;


public class Testcase {
	WebDriver driver;
	WebDriverWait wait;
	String defaulwinHandle;
	//PageObjectss PageFac= PageFactory.initElements(driver,PageObjectss.class);
	public PomOfTest objPom; // publically decleared object of pom class
	
	  @BeforeTest
	  public void urlHit() {
		  	System.setProperty("webdriver.chrome.driver", "C://Users//4068\\Desktop/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://baseline01.curemd.com/curemd/datLogin.asp");
			objPom = new PomOfTest(driver); //Object Pomtest class
//			String expactedTitle = "omayo (QAFox.com)";
//			String actualtitle = driver.getTitle();
//			Assert.assertEquals(expactedTitle, actualtitle);
//			System.out.println(actualtitle);
			   
	  }
	  @Test (priority=0)
	  public void Login(){
		//STEP 1:
			 objPom.userName.sendKeys("ChargeModifiers");
			 objPom.password.sendKeys("SuPPort.2014");
			 objPom.login.click();
			 
			 
//			 JavascriptExecutor js = (JavascriptExecutor) driver;
//			 WebElement table = driver.findElement(By.xpath("//table[contains(@id,'table1')]//tbody/tr"));
//			 js.executeScript("arguments[0].scrollIntoView();", table); // i will scroll my window at a specific element like here is table
	  }
	  @Test (priority=0)
	  public void addPateint(){
		  for(String NewWinHandle : driver.getWindowHandles()) {
				 driver.switchTo().window(NewWinHandle);
			 }

			 driver.switchTo().frame(objPom.frame1);
			 
			 wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			 wait.until(ExpectedConditions.elementToBeClickable(objPom.patientBtn)).click();
			 //String defaulwinHandle = driver.getWindowHandle();
			 defaulwinHandle = driver.getWindowHandle();
			 driver.switchTo().window(defaulwinHandle);
			 driver.switchTo().frame(objPom.frame2);
			 wait.until(ExpectedConditions.elementToBeClickable(objPom.addPatientBtn)).click();
			 objPom.firstName.sendKeys("Khurram");
			 objPom.lastName.sendKeys("Bajwa");
			 Select titleOfMember = new Select(objPom.persontTitle);
			 //titleOfMember.selectByVisibleText("Dr"); // get by text 
			 titleOfMember.selectByIndex(1);		// get by index
			 Select gender = new Select(objPom.gender);
			 //titleOfMember.selectByVisibleText("Male"); // get by text 
			 gender.selectByIndex(1);		// get by index
			 objPom.dob.sendKeys("01011999");
			 Select location = new Select(objPom.location);
			 //titleOfMember.selectByVisibleText("Male"); // get by text 
			 location.selectByIndex(1);
			 
			 try{
				 objPom.saveBtn.click();
				 
				 }catch (Exception e) {
					 defaulwinHandle = driver.getWindowHandle();
					 driver.switchTo().window(defaulwinHandle);
					 objPom.saveAsnew.click();
				 throw(e);
				 }
	  }
	  

	  @AfterTest
	  public void windowClose(){
		 // driver.quit();
	  }
}
