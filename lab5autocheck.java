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
			 WebElement MultiSelectBox = driver.findElement(By.xpath("//select[contains(@id,'multiselect')]"));
			 js.executeScript("arguments[0].scrollIntoView();", MultiSelectBox);
			 Select selctVeh = new Select(driver.findElement(By.xpath("//select[contains(@id,'multiselect')]")));
			 selctVeh.selectByVisibleText("Hyundai");
			 
			 Select dropD = new Select(driver.findElement(By.xpath("//select[contains(@id,'drop')]")));
			 dropD.selectByVisibleText("doc 3");
			 
			 WebElement input = driver.findElement(By.xpath("//input[@value='Selenium WebDriver']"));
			 (input).clear();
			 js.executeScript("arguments[0].scrollIntoView();", input);
			 (input).sendKeys("Kia kr rhy ho");
			 driver.findElement(By.xpath("//button[text()='Button2']")).click();
			 driver.findElement(By.xpath("//button[text()='Submit']")).click();
			 driver.findElement(By.xpath("//button[text()='Login']")).click();
			 driver.findElement(By.xpath("//button[text()='Register']")).click();
			 driver.findElement(By.xpath("//input[@value='ClickAfterTextDissappears']")).click();
			 driver.switchTo().alert().accept();
			 
			 driver.findElement(By.xpath("//a[text()='Open a popup window']")).click();
			 
			 String defaulwinHandle = driver.getWindowHandle();
			 for(String NewWinHandle : driver.getWindowHandles()) {
				 driver.switchTo().window(NewWinHandle);
			 }
			 String text1 = driver.findElement(By.xpath("//p[contains(@class,'main')]")).getText();
			 String text2 = driver.findElement(By.xpath("//p[contains(@class,'sub')]")).getText();
			 System.out.println(text1);
			 System.out.println(text2);
			 Thread.sleep(2000);
			 driver.close();
			 driver.switchTo().window(defaulwinHandle);
			 driver.findElement(By.xpath("//input[@id='uploadfile']")).sendKeys("C:\\Users\\4068\\Pictures\\Capture12.PNG");
			 driver.findElement(By.xpath("//button[text()='Try it']")).click();
			 
			 Actions act = new Actions(driver);

			WebElement btn = driver.findElement(By.xpath("//button[@ondblclick='dblclickAlert()']")); 
			act.doubleClick(btn).perform();
			driver.switchTo().alert().accept();
			
			driver.findElement(By.xpath("//button[text()='Check this']")).click();
			//wait
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='dte']"))).click();
			
			//STEP 5:
			//Now, Select your gender, click on the button ‘ClickToGetAlert’ handle alert
			//Select color blue an deselect orange.

			driver.findElement(By.xpath("//input[@value='male']")).click();
			driver.findElement(By.xpath("//input[@value='ClickToGetAlert']")).click();
			driver.switchTo().alert().accept();
			
			driver.findElement(By.xpath("//input[@value='orange']")).click();
			driver.findElement(By.xpath("//input[@value='blue']")).click();
			WebElement readThisText = driver.findElement(By.xpath("//input[@id='rotb']"));
			String txt = readThisText.getAttribute("value");
			System.out.println(txt);
			driver.findElement(By.xpath("//input[@id='prompt']")).click();
			//Thread.sleep(2000);
			driver.switchTo().alert().sendKeys("Khurram bajwa");
			//Thread.sleep(2000);
			driver.switchTo().alert().accept();
			driver.findElement(By.xpath("//input[@id='confirm']")).click();
			//Thread.sleep(2000);
			driver.switchTo().alert().accept();
			//Thread.sleep(2000);
			WebElement vehicle = driver.findElement(By.xpath("//input[@class='classone']"));
			js.executeScript("arguments[0].scrollIntoView();", vehicle);
			(vehicle).sendKeys("Classone");
			driver.findElement(By.xpath("//input[@value='Car']")).click();
			driver.findElement(By.xpath("//input[@value='Bag']")).click();
			driver.findElement(By.xpath("//input[@value='Book']")).click();
			WebElement doubleClickBtn = driver.findElement(By.xpath("//p[@id='testdoubleclick']")); 
			act.doubleClick(doubleClickBtn).perform();
			driver.findElement(By.xpath("//a[text()='Gmail']")).click();
			
		}

}

