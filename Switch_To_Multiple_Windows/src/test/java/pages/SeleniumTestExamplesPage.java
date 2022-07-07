package pages;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonMethods.SeleniumSpecificMethods;
import utility.ExcelReader;

public class SeleniumTestExamplesPage {

	WebDriver driver;
	public SeleniumTestExamplesPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}


	@FindBy(xpath = "//input[@name='text']")
	private WebElement text_Input_Text_Here;


	@FindBy(xpath = "//input[@id='submitbtn']")
	private WebElement button_submit;


	public void fillTheForm(String textToEnter) {
		SeleniumSpecificMethods.enterText_TextField(text_Input_Text_Here, textToEnter);
		SeleniumSpecificMethods.click(button_submit);

	}


	public void fillTheForm() {

		ExcelReader obj_ExcelReader=new ExcelReader("data", "names");

		for (HashMap<String,String> singleData : obj_ExcelReader.getExcelData()) {


			SeleniumSpecificMethods.enterText_TextField(text_Input_Text_Here, singleData.get("names"));

			System.out.println(singleData.get("names"));

			SeleniumSpecificMethods.click(button_submit);
		}
	}
}
