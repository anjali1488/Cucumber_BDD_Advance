package packageStepDefinitions;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsOfFeatureFile {
	WebDriver driver;
	String expectedLoginTitle = "https://adactinhotelapp.com/";
	String expectedTitle = "Adactin.com - Search Hotel";
	
	
@Given("user is on login page")
public void user_is_on_login_page() {
    // Write code here that turns the phrase above into concrete actions
    
    System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://adactinhotelapp.com/");
	driver.manage().window().maximize();
	//String actualLoginTitle = driver.getTitle();
	//assertEquals(expectedLoginTitle, actualLoginTitle);
	
	System.out.println("Login page is displayed");
}

@When("user enters username and password")
public void user_enters_username_and_password() {
    // Write code here that turns the phrase above into concrete actions
	WebElement uName = driver.findElement(By.id("username"));
    uName.sendKeys("santosh13");
    
    driver.findElement(By.id("password")).sendKeys("Snoopy1234");
}

@When("clicks on login button")
public void clicks_on_login_button() {
    // Write code here that turns the phrase above into concrete actions
	driver.findElement(By.cssSelector("input.login_button[value=Login]")).click();
}

@Then("user is traversed to Search Hotel page")
public void user_is_traversed_to_search_hotel_page() {
    // Write code here that turns the phrase above into concrete actions
	System.out.println("Login successful");
	String actualText = driver.findElement(By.id("username_show")).getAttribute("value");
	
	String expectedText = "Hello santosh13!";
	assertEquals(actualText, expectedText);
	System.out.println("Login successful");
}

@Given("user is on Search Hotel page")
public void user_is_on_search_hotel_page() {
    // Write code here that turns the phrase above into concrete actions
	System.out.println("User is on Search Hotel page");
}

@When("user selects \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\"$")
public void user_selects(String location, String rooms, String chekin, String chekout, String adults) {
    // Write code here that turns the phrase above into concrete actions
	new Select(driver.findElement(By.className("search_combobox"))).selectByValue(location);
	
	
	//Drop down to select Number of Rooms
	 new Select(driver.findElement(By.id("room_nos"))).selectByVisibleText(rooms);
	 
	 //Date picker-Enter check in date
	 WebElement checkinDate = driver.findElement(By.id("datepick_in"));
	 checkinDate.clear();
	 checkinDate.sendKeys(chekin);
	 
	 //Date picker-Enter checkout date
	 WebElement checkoutDate = driver.findElement(By.id("datepick_out"));
	 checkoutDate.clear();
	 checkoutDate.sendKeys(chekout);
     
	 //Select Adults per room
	 new Select(driver.findElement(By.id("adult_room"))).selectByVisibleText(adults);
	 
}

@When("user clicks on search button")
public void user_clicks_on_search_button() {
    // Write code here that turns the phrase above into concrete actions
	driver.findElement(By.id("Submit")).click();
}

@When("search results should be displayed")
public void search_results_should_be_displayed() {
    // Write code here that turns the phrase above into concrete actions
	System.out.println("Successful search page");
}

@When("user selects Hotel \"(.*)\"$")
public void user_selects_Hotel(String Hotel) {
    // Write code here that turns the phrase above into concrete actions
	driver.findElement(By.name(Hotel)).click();
}


@When("user clicks on continue button")
public void user_clicks_on_continue_button() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("continue")).click();
	}

@When("user selects details \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\"$")
public void user_selects_details(String fName, String lName, String bAddress, String cardNum, String cardType, String expMonth, String expYear, String cvv) {
    // Write code here that turns the phrase above into concrete actions
	
	driver.findElement(By.id("first_name")).sendKeys(fName);
	driver.findElement(By.id("last_name")).sendKeys(lName);
	driver.findElement(By.id("address")).sendKeys(bAddress);
	driver.findElement(By.id("cc_num")).sendKeys(cardNum);
	new Select(driver.findElement(By.id("cc_type"))).selectByVisibleText(cardType);
	new Select(driver.findElement(By.id("cc_exp_month"))).selectByVisibleText(expMonth);
	new Select(driver.findElement(By.id("cc_exp_year"))).selectByVisibleText(expYear);
	driver.findElement(By.id("cc_cvv")).sendKeys(cvv);
	
	driver.findElement(By.id("book_now")).click();
	
}
}
