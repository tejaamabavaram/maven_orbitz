package venkat.journey.tests;

import org.testng.annotations.Test;
import venkat.journey.generic.BaseTest;
import venkat.journey.pages.FlightsHomePage;
import venkat.journey.pages.FlightsSearchResultsPage;

public class FlightBookingSteps extends BaseTest{
	@Test
	public void testBookingSteps() throws InterruptedException
	{
		FlightsHomePage homepage = new FlightsHomePage(driver);
		homepage.selectMenuCategory("Flights");
		homepage.selectTripType("One way");
		homepage.selectJourney("Pune", "Mumbai");
		homepage.selectJourneyDate();
		homepage.selectAdultsCount(2);
		homepage.selectChildrenCount(2);
		homepage.clickOnSearchButton();
		
		FlightsSearchResultsPage resultspage = new FlightsSearchResultsPage(driver);
		resultspage.selectPriceFilter("Duration (Longest)");
		resultspage.verifyFlightsList();
		
		
	}

}
