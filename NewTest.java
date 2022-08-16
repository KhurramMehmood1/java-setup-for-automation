package Lab6;

import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;

public class NewTest {
	WebDriver driver;
  @BeforeTest
  public void urlHit() {
	  	System.setProperty("webdriver.chrome.driver", "C://Users//4068\\Desktop/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject");
		   
  }
  @Test (priority=0)
  public void mangerLogin(){
	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Bank Manager Login']"))).click(); 
//	  WebElement manager = driver.findElement(By.xpath("//button[text()='Bank Manager Login']"));
//	  (manager).click();
  }
  @Test (priority=1)
  public void addCustomer(){
	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@ng-class='btnClass1']"))).click(); 

  }
  @Test (priority=2)
  public void customerInputData(){
	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@ng-model='fName']")));
	  driver.findElement(By.xpath("//input[@ng-model='fName']")).sendKeys("Khurram");
	  driver.findElement(By.xpath("//input[@ng-model='lName']")).sendKeys("Bajwa");
	  driver.findElement(By.xpath("//input[@ng-model='postCd']")).sendKeys("12345");
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  driver.switchTo().alert().accept();
  }
  @Test (priority=3)
  public void openAccount(){
	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@ng-class='btnClass2']"))).click();
  }
  @Test (priority=4)
  public void accountInput(){
	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name='userSelect']"))).click();
	  Select selctname = new Select(driver.findElement(By.xpath("//select[@name='userSelect']")));
	  selctname.selectByVisibleText("Khurram Bajwa");
	  driver.findElement(By.xpath("//select[@name='currency']")).click();
  }
}
