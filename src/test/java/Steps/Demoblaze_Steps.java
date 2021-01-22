package Steps;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.AdidasQA.pom.BaseLib;
import com.AdidasQA.pom.DemoblazeHomepage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Demoblaze_Steps extends BaseLib {

	public DemoblazeHomepage demoblazePage;
	String totalPrice=null;
	ArrayList<String> details;
	
	@Given("I launch driver with {string} url")
	public void i_launch_driver_with_url(String demoblazeURL) throws MalformedURLException {
	    // Write code here that turns the phrase above into concrete actions
		super.setUpWeb();
		demoblazePage = new DemoblazeHomepage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//demoblazePage.launchChrome(demoblazeURL);
	}

	@When("I Navigate to {string} categories")
	public void i_Navigate_to_categories(String string) throws MalformedURLException, InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		demoblazePage = new DemoblazeHomepage(driver);
		if(string.equals("Laptop")) {
			demoblazePage.laptopCategories();
			Thread.sleep(2000);
		}
		else {
			demoblazePage.clickHomeicon();
		}
	}

	@When("I click on {string} laptop product link")
	public void i_click_on_laptop_product_link(String laptop) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    if(laptop.equals("Sony vaio i5")) {
	    	demoblazePage.sonyvaioLaptop.click();
	    	System.out.println("Added laptop to cart --> "+laptop);
	    	Thread.sleep(2000);
	    }
	    else if(laptop.equals("Dell i7 8gb")) {
	    	demoblazePage.delli7Laptop.click();
	    	System.out.println("Added laptop to cart --> "+laptop);
	    	Thread.sleep(2000);
	    }
	    else {
	    	System.out.println(laptop+" is other than handled laptops.....");
	    	System.out.println("Please select appropriate laptop....... Navigating to homepage !!");
	    	demoblazePage.clickHomeicon();
	    }
	}

	@When("I Click on {string}")
	public void i_Click_on(String string) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    demoblazePage.clickAddtoCart();
	    Thread.sleep(2000);
	}

	@Then("Handle pop-up window")
	public void handle_pop_up_window() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    driver.switchTo().alert().accept();
	    Thread.sleep(2000);
	    System.out.println("Alert pop-up handled !!!");
	}

	@Then("Go to {string} section")
	public void go_to_section(String section) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		Thread.sleep(1000);
	    switch(section) {
	    case"Home":
	    	demoblazePage.clickHomeicon();
	    	Thread.sleep(2000);
	    	break;
	    case"Cart":
	    	demoblazePage.cartLabel.click();
	    	Thread.sleep(2000);
	    	break;
	    case"Place Order":
	    	demoblazePage.placeorderBttn.click();
	    	Thread.sleep(2000);
	    	break;
	    }
	    System.out.println("Selected section --> "+section);
	}

	@Then("Delete product {string} from cart")
	public void delete_product_from_cart(String productTobeDeleted) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
			Thread.sleep(2000);
	    	String xpath="//*[td="+"'"+productTobeDeleted+"'"+"]/td[4]/a";
	    	driver.findElement(By.xpath(xpath)).click();
	    	System.out.println("Deleted laptop is --> "+productTobeDeleted);
	    	
	    	Thread.sleep(2000);
	    	totalPrice=driver.findElement(By.id("totalp")).getText()+" USD";
	    	totalPrice="Amount: "+totalPrice;
	    	System.out.println("TOTAL PRICE BEFORE PLACING ORDER IS ---> "+totalPrice);
	}

	@Then("Fill the order details form")
	public void fill_the_order_details_form() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		ArrayList<String> countries= new ArrayList<>(Arrays.asList("India","UAE","USA","Japan","China"));
		Random rand=new Random();
		int randInt=rand.nextInt(countries.size());
		
		demoblazePage.nameField.sendKeys("Random Name "+RandomStringUtils.randomAlphabetic(5));
		demoblazePage.countryField.sendKeys(countries.get(randInt));
		demoblazePage.cityField.sendKeys("Random city "+RandomStringUtils.randomAlphabetic(4));
		demoblazePage.creditcardField.sendKeys(RandomStringUtils.randomNumeric(16));
		demoblazePage.monthField.sendKeys("January");
		demoblazePage.yearField.sendKeys("2021");
		
	}

	@Then("I Click on {string} button")
	public void i_Click_on_button(String string) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		Thread.sleep(3000);
	    WebElement purchaseBttn=driver.findElement(By.xpath("//button[contains(text(),'Purchase')]"));
	    purchaseBttn.click();
	    System.out.println("Yayy!! Purchased successfully !!!");
	}
	
	@Then("Capture order details")
	public void capture_order_details() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		Thread.sleep(2000);
		String orderDetails=null;
	    String xpath="//body/div[10]/p[1]";
	    
	    orderDetails=driver.findElement(By.xpath(xpath)).getText();
	    String[] idnAmt=orderDetails.split("\n");
	    details=new ArrayList<String>();
	    for(int i=0;i<idnAmt.length;i++) {
	    	String a =idnAmt[i];
	    	details.add(a);
	    }
	    System.out.println("Product ID is --> "+details.get(0));
	    System.out.println("Product Amount is --> "+details.get(1));
	}
	
	@Then("Assert the purchase amount")
	public void assert_the_purchase_amount() {
	    // Write code here that turns the phrase above into concrete actions
	   System.out.println("Expected pice --> "+totalPrice);
	   System.out.println("Actual price --> "+details.get(1));
	   
	   Assert.assertEquals(totalPrice, details.get(1));
	}

	@Then("Click on Final OK button")
	public void click_on_Final_OK_button() {
	    // Write code here that turns the phrase above into concrete actions
		demoblazePage.finalOKbttn.click();
	}

}
