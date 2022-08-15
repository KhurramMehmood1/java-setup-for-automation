package Lab5;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class lab5autocheck {

	/**
		 * @param args
		 * @throws InterruptedException 
		 */
		public static void main(String[] args) throws InterruptedException
		{
			System.setProperty("webdriver.chrome.driver", "C://Users//4068\\Desktop/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			 driver.get("https://omayo.blogspot.in/");
			 
			 
			 //Actions builder = new Actions(driver);
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(11));
			 //STEP 1:
			 //here we are doing first step to clear both fields and then enter our desire data as well as print that data
			 driver.findElement(By.xpath("//textarea[contains(@id,'ta1')]")).clear(); // clear previous data which is space here
			 driver.findElement(By.xpath("//textarea[contains(@id,'ta1')]")).sendKeys("Khurram mehmood"); // enter new data
			 String data = driver.findElement(By.xpath("//textarea[contains(text(),'The cat')]")).getText();  //get text area text.
			 System.out.println(data); // print entered data in text area field. 
			 driver.findElement(By.xpath("//textarea[contains(text(),'The cat')]")).clear(); // clear previous data
			 driver.findElement(By.xpath("//textarea[contains(text(),'The cat')]")).sendKeys("Mein ic ko show krwana chahta hun"); // enter new data
			//to perform Scroll on application using Selenium
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 WebElement table = driver.findElement(By.xpath("//table[contains(@id,'table1')]//tbody/tr"));
			 js.executeScript("arguments[0].scrollIntoView();", table); // i will scroll my window at a specific element like here is table
			 //STEP 2: 
			 // fetch the table data and show in our console
			 By tableData = By.xpath("//table[contains(@id,'table1')]//tbody/tr");
			 
			 List<WebElement> rowdata = driver.findElements(tableData);
			 for(WebElement row : rowdata) {
			   System.out.println(row.getText());
			 }
			 
			 String getSingleRow = driver.findElement(By.xpath("//table[contains(@id,'table1')]//tbody/tr[2]")).getText(); // this for a specific row 
			 System.out.println(getSingleRow);
			 driver.findElement(By.xpath("//form[contains(@name,'form1')]//input[@type='text']")).sendKeys("bajwa424");
			 driver.findElement(By.xpath("//form[contains(@name,'form1')]//input[@type='password']")).sendKeys("bajwa1234");
			 driver.findElement(By.xpath("//button[text()=' LogIn ']")).click();
			 
			 //STEP 3:
			 WebElement frame1 = driver.findElement(By.xpath("//iframe[contains(@id,'iframe1')]"));
			 driver.switchTo().frame(frame1);
			 driver.switchTo().defaultContent();
			 WebElement frame2 = driver.findElement(By.xpath("//iframe[contains(@id,'iframe2')]"));
			 driver.switchTo().frame(frame2);
			 driver.switchTo().defaultContent();
			 
			 WebElement username = driver.findElement(By.xpath("//input[contains(@name,'userid')]"));
			 js.executeScript("arguments[0].scrollIntoView();", username);
			 (username).sendKeys("bajwa424");
			 driver.findElement(By.xpath("//input[contains(@name,'pswrd')]")).sendKeys("bajwa1234");
			 driver.findElement(By.xpath("//input[@onclick='check(this.form)']")).click();
			 driver.switchTo().alert().accept();
			 
			 
			 //STEP 4: 
//			  Select Hyundai and select doc3 as shown in picture.
			 WebElement MultiSelectBox = driver.findElement(By.id("multiselect1"));
			 js.executeScript("arguments[0].scrollIntoView();", MultiSelectBox);
			 Select selctVeh = new Select(driver.findElement(By.id("multiselect1")));
			 selctVeh.selectByVisibleText("Hyundai");
			 
			 Select drpDoc = new Select(driver.findElement(By.id("drop1")));
			 drpDoc.selectByVisibleText("doc 3");
			 
			 driver.findElement(By.xpath("//input[@id='textbox1']")).clear();
			 driver.findElement(By.xpath("//input[@id='textbox1']")).sendKeys("Kia kr rhy ho");
			 
			 driver.findElement(By.xpath("//button[@id='but2']")).click();
			 driver.findElement(By.xpath("//button[text()='Submit']")).click();
			 driver.findElement(By.xpath("//button[text()='Login']")).click();
			 driver.findElement(By.xpath("//button[text()='Register']")).click();
			 driver.findElement(By.xpath("//input[@id='alert2']")).click();
			 driver.switchTo().alert().accept();
//			 
//			 driver.findElement(By.xpath("//a[text()='Open a popup window']")).click();
//			 
//			 String defaultFrame = driver.getWindowHandle();
//			 for(String openNewWindow : driver.getWindowHandles()) {
//				 driver.switchTo().window(openNewWindow);
//			 }
//			 String getVar1 = driver.findElement(By.xpath("//p[@id='para1']")).getText();
//			 String getVar2 = driver.findElement(By.xpath("//p[@id='para2']")).getText();
//			 System.out.println(getVar1);
//			 System.out.println(getVar2);
//			 Thread.sleep(2000);
//			 driver.close();
//			 driver.switchTo().window(defaultFrame);
//			 driver.findElement(By.xpath("//button[text()='Try it']")).click();
//			 
//			 Actions act = new Actions(driver);
//
//			WebElement ele = driver.findElement(By.xpath("//button[@ondblclick='dblclickAlert()']")); 
//			act.doubleClick(ele).perform();
//			driver.switchTo().alert().accept();
//			
//			driver.findElement(By.xpath("//button[text()='Check this']")).click();
//			
//			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='dte']"))).click();
//			
//			//Step 5
//			driver.findElement(By.xpath("//input[@id='radio1']")).click();
//			driver.findElement(By.xpath("//input[@id='alert1']")).click();
//			driver.switchTo().alert().accept();
//			
//			driver.findElement(By.xpath("//input[@id='checkbox1']")).click();
//			driver.findElement(By.xpath("//input[@id='checkbox2']")).click();
//			WebElement readThisText = driver.findElement(By.xpath("//input[@id='rotb']"));
//			String txt = readThisText.getAttribute("value");
//			System.out.println(txt);
//			driver.findElement(By.xpath("//input[@id='prompt']")).click();
//			driver.switchTo().alert().sendKeys("Salman");
//			driver.switchTo().alert().accept();
//			driver.findElement(By.xpath("//input[@id='confirm']")).click();
//			driver.switchTo().alert().accept();
//			
//			driver.findElement(By.xpath("//input[@class='classone']")).sendKeys("Classone");
//			driver.findElement(By.xpath("//input[@value='Car']")).click();
//			driver.findElement(By.xpath("//input[@value='Bag']")).click();
//			driver.findElement(By.xpath("//input[@value='Book']")).click();
		}

}

