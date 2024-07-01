package Amazon.com.utility;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtility {
WebDriver driver;

public GeneralUtility(WebDriver driver) {
	this.driver=driver;}

public void selectByIndex(WebElement element,int index) {
	Select select=new Select(element);
	select.selectByIndex(index);
}
public List <String> getText(List<WebElement> element) {
	List <String>elements=new ArrayList<String>(); 
	for(WebElement data:element) {
		elements.add(data.getText());
	}
		return elements;
	}
}
	




