package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomOfTest {
	WebDriver driver;
	@FindBy(xpath=("//input[contains(@name,'vchLogin_Name')]"))
	public WebElement userName;
	@FindBy(xpath=("//input[contains(@name,'vchPassword')]"))
	public WebElement password;
	@FindBy(xpath=("//button[contains(@class,'btn btn-danger')]"))
	public WebElement login;
	@FindBy(xpath=("//img[@id='patientBtn']"))
	public WebElement patientBtn;
	@FindBy(xpath=("//iframe[@id='fraCureMD_Menu']"))
	public WebElement frame1;
	@FindBy(xpath=("//iframe[@id='fraCureMD_Body']"))
	public WebElement frame2;
	@FindBy(xpath=("//img[@alt='Add Patient']"))
	public WebElement addPatientBtn;//input[@name='txtVFNAME']
	@FindBy(xpath=("//input[@name='txtVFNAME']"))
	public WebElement firstName;
	@FindBy(xpath=("//input[@name='txtVLNAME']"))
	public WebElement lastName;
	@FindBy(xpath=("//select[@name='cmbVTitle']"))
	public WebElement persontTitle;
	
	@FindBy(xpath=("//select[@name='cmbVSEX']"))
	public WebElement gender;
	
	@FindBy(xpath=("//input[@name='txtDDOB']"))			// Date of birth Xpath
	public WebElement dob;
	
	@FindBy(xpath=("//select[@name='cmbILOCID']"))  
	public WebElement location;
	
	@FindBy(xpath=("//td[@id='tdsave']"))
	public WebElement saveBtn;
	
	@FindBy(xpath=("//iframe[@id='DynamicBHdialogbox']"))  // popupframe path
	public WebElement popupFrame;
	//button[@id='saveAsNewButton']
	@FindBy(xpath=("//button[@id='saveAsNewButton']"))  // Save as New button path
	public WebElement saveAsnew;
	public PomOfTest(WebDriver driver){
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }
	
	 


}
