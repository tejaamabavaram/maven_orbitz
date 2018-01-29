package venkat.journey.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import venkat.journey.generic.BaseTest;

public class FlightsSearchResultsPage extends BaseTest {
	public FlightsSearchResultsPage(WebDriver driver)
	{
		//this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[text()='PNQ - BOM']")
	private List<WebElement> flightsList;
	
	@FindBy(xpath="//select[@name='sort']")
	private WebElement priceDropdown;
	
	
	
	public List<WebElement> getFlightsList() {
		return flightsList;
	}
	
	public void verifyFlightsList()
	{
		int count=0;
		for(int i=1;i<flightsList.size();i++)
		{
			Reporter.log("Flights List:"+flightsList.get(i).getText(),true);
			count++;
		}
		Reporter.log("Total Available flights:"+count,true);
	}


	public void selectPriceFilter(String option) {
		Select select = new Select(priceDropdown);
		select.selectByVisibleText(option);
		System.out.println("fliter selected");
		
	}
	

}
