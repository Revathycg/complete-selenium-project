package Amazon.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Amazon.com.utility.Excel;

public class LoginPage {
	Excel excel=new Excel();
	
WebDriver driver;
@FindBy(xpath = "//input[@id='ap_email']")
private WebElement emailId;
@FindBy(xpath = "//input[@id='continue']")
private WebElement clickField;
@FindBy(xpath = "//input[@id='ap_password']")
private WebElement passwordField;
@FindBy(xpath = "//input[@id='signInSubmit']")
private WebElement signIn;
@FindBy(xpath = "(//span[@class='nav-line-1 nav-progressive-content'])[2]")
private WebElement accountText;
@FindBy(xpath = "(//span[@class='nav-action-inner'])[1]")
private WebElement signInButton;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
public void enterEmail(String mailId) {
	emailId.clear();
	emailId.sendKeys(mailId);
}
public void clickOnContinue() {
	clickField.click();
}
public void enterPassword(String password ) {
	passwordField.sendKeys(password);
}
public void clickOnSignIn() {
	signIn.click();
}
public void loginDetails() {
	Actions actions=new Actions(driver);
	actions.moveToElement(accountText).build().perform();
	signInButton.click();
	
}
}
