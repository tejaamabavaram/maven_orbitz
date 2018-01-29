package venkat.journey.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest implements InterfaceConstants {
	public WebDriver driver;
	static
	{
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
		
		}
	@Parameters({"browser"})
	@BeforeMethod(alwaysRun=true)
	public void openApplication(String browser)
	{
		driver = new ChromeDriver();
		//driver = new FirefoxDriver();
		//DesiredCapabilities capabilities = new DesiredCapabilities();
		//capabilities.setBrowserName(browser);
		//driver = new RemoteWebDriver(browser);
		driver.get("https://www.orbitz.com");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@AfterMethod(alwaysRun=true)
	public void closeApplication()
	{
		driver.quit();
	}

}
