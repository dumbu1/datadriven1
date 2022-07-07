package commonMethods;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.InvokeBrowser;

public class SeleniumSpecificMethods {
	
	//-----------------------------Windows related-----------------------------------

	/***
	 * @author Krishna Mohan
	 * to get the current browser. It will call static property utility.InvokeBrowser.driver
	 * @return WebDriver
	 */
	
		public static WebDriver getDriver() {
			
			return InvokeBrowser.driver;
		}	
		
		/***
		 * to maximize the window
		 * @author Krishna Mohan
		 */
		public static void windowMaximize() {
			SeleniumSpecificMethods.getDriver().manage().window().maximize();
		}
	
	
	
		
		
	
	public static void validate_PageTitle(String expectedPageTitle) {
		
		Assert.assertEquals("window title "+expectedPageTitle+" doesnot match",expectedPageTitle, SeleniumSpecificMethods.getDriver().getTitle());
		
	}
	
	
	
	
	
	//-----------------------shifting window focus--------------------------------------
	
	/***
	 * @author Krishna Mohan
	 * to get all the window handles.
	 * @return Object[]
	 */
	
	public static Object[] getAllWindowHandles() {
		Set<String> windowHandles=SeleniumSpecificMethods.getDriver().getWindowHandles();
		Object[] arrayOfWindows=windowHandles.toArray();
		
		return arrayOfWindows;
		
	}
	/***
	 * for switching to last window
	 * @author Krishna Mohan
	 */
	public static void switch_To_Last_Window() {
		Set<String> windowHandles=SeleniumSpecificMethods.getDriver().getWindowHandles();
		
		//converting Set<String> to Object array, so that it can be used to navigate to specific page through index
		//Object[] arrayOfWindows=windowHandles.toArray();
		
		for (String windowHandle : windowHandles) {
			SeleniumSpecificMethods.getDriver().switchTo().window(windowHandle);
		}
		
		SeleniumSpecificMethods.windowMaximize();
	//return arrayOfWindows;
	}
	
	/***
	 * to shift the focus to respective window
	 * @param windows
	 * @param pageIndexNumber
	 */
	public static void switch_To_Specific_Window(Object[] windows,int pageIndexNumber) {
		
		SeleniumSpecificMethods.getDriver().switchTo().window((String)windows[pageIndexNumber]);
	}
		
	
	
	
	
	//------------------------------webelement actions related--------------------------
	
	
	/***
	 * @author Krishna Mohan
	 * To click on webelement
	 * @param link
	 */
	public static void click(WebElement link ) {
		link.click();
	}
	
	/***
	 * To enter data in text field
	 * @author Krishna Mohan
	 * @param textBox
	 * @param dataToEnter
	 */
	public static void enterText_TextField(WebElement textBox,String dataToEnter) {
		textBox.sendKeys(dataToEnter);
	}
	
	/***
	 * to check the text in a page
	 * @author Krishna Mohan
	 * @param element
	 * @param expectedText
	 */
	public static void check_Text(WebElement element,String expectedText) {
		Assert.assertEquals("expected page not opened",expectedText, element.getText());
	}
	
	//--------------------------------lable------------------------------------
	
	
	public static String getText_lable(WebElement element) {
		return element.getText();
	}
	
		
		
	}

