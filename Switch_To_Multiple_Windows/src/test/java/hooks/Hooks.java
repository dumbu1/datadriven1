package hooks;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import utility.InvokeBrowser;

public class Hooks {


	public static WebDriver driver;
	public static InvokeBrowser obj_invokBrowser;

	//to open browser and url
	@Before
	public void openBrowserAndUrl() {

		obj_invokBrowser=new InvokeBrowser();
		driver=obj_invokBrowser.openUrl(obj_invokBrowser.setDriver());
	}

	@After(order = 1)
	public void attachScreenshotForFailTestCase(Scenario scenario) throws IOException {

		if(scenario.isFailed()) {
			

			File screenshot_with_scenario_name = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String screenshotName= scenario.getName().replace(" ", "_");
			
			Date date=new Date();
			SimpleDateFormat obj_SimpleDateFormat= new SimpleDateFormat("ddmmyyyy_HHmmss");
			String string_Date=obj_SimpleDateFormat.format(date);
			
			File destinationPath=new File(System.getProperty("user.dir")+"/test-output/screenshot/"+screenshotName+"_"+string_Date+".png");
			Files.copy(screenshot_with_scenario_name.toPath(), destinationPath.toPath());
			
			
			
			
			
			//byte[] screenShot=null;
			//try {
			//	screenShot = FileUtils.readFileToByteArray(screenshot_with_scenario_name);
			//} catch (IOException e) {
			//	e.printStackTrace();
			//}
		

			//
			//to attach the screenshot to the report
			//scenario.attach(screenShot,"image/png",scenario.getName());
		


			
			//Copy taken screenshot from source location to destination location

			//try {
			//	
		//	} catch (IOException e) {
		//		e.printStackTrace();
		//	} 

		}
	}

	//to close browser
	@After(order = 0)
	public void closeBrowser() {
		driver.close();
	}

}
