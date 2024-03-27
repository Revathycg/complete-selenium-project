package Amazon.com.utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import Amazon.com.constants.Constants;



public class ScreenShots {
	static TakesScreenshot takeScreenshot;
	public static void takeScreenShot(WebDriver driver,String imageName) {
		try {
			String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
			takeScreenshot=(TakesScreenshot) driver;
			File screenshot=takeScreenshot.getScreenshotAs(OutputType.FILE);
			String destination=Constants.SCREEN_SHOTS+imageName+"_"+timeStamp+"pmg";
			File finalDestination=new File(destination);
			FileHandler.copy(screenshot, finalDestination);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
}
