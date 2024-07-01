package Amazon.com.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



import Amazon.com.constants.Constants;
import Amazon.com.utility.ScreenShots;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
protected WebDriver driver;
Properties properties=new Properties();

public Base() {
	try {
		FileInputStream fi=new FileInputStream(Constants.CONFIG_FILE_PATH);
		properties.load(fi);
		
	} catch (Exception e) {
	e.printStackTrace();
	}
}
public void initialize(String browser,String url) {
	if(browser.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	else if(browser.equals("edge")){
		WebDriverManager.chromedriver().setup();
		driver=new EdgeDriver();
	}
	else if(browser.equals("firfox")) {
		WebDriverManager.chromedriver().setup();
		driver=new FirefoxDriver();
	}
	driver.get("https://www.amazon.in/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICT_WAIT));
	driver.manage().deleteAllCookies();
}
@BeforeMethod
public void launchbrowser() {
	String browser=properties.getProperty("browser");
	String url=properties.getProperty("url");
	initialize(browser,url);
}
@AfterMethod
public void terminateSession(ITestResult itestresult) {
	if(itestresult.getStatus()==ITestResult.FAILURE) {
		ScreenShots.takeScreenShot(driver,itestresult.getName());
		driver.close();
	}
}

}
