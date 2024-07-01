package Amazon.com.tests;

import org.testng.annotations.Test;

import Amazon.com.base.Base;
import Amazon.com.pages.LoginPage;
import Amazon.com.utility.Excel;

public class LoginTest extends Base{
LoginPage loginPage;
Excel excel=new Excel();

@Test
public void verifyLogin() {
	loginPage=new LoginPage(driver);
	loginPage.loginDetails();
excel.setExcelFile("excel","sheet3");
String email=excel.getCellData(1, 0);
String password=excel.getCellData(1, 1);
loginPage.enterEmail(email);
loginPage.clickOnContinue();
loginPage.enterPassword(password);
loginPage.clickOnSignIn();
}
}
