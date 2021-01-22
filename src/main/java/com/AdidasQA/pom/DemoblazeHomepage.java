package com.AdidasQA.pom;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoblazeHomepage extends BaseLib {

	WebDriver driver;
	public DemoblazeHomepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Laptops')]")
    private static WebElement Laptops;
	@FindBy(xpath="//a[contains(text(),'Sony vaio i5')]")
    public static WebElement sonyvaioLaptop;
	@FindBy(xpath="//a[contains(text(),'Dell i7 8gb')]")
    public static WebElement delli7Laptop;
	@FindBy(xpath="//a[contains(text(),'Add to cart')]")
    private static WebElement addToCart;
	@FindBy(id="nava")
    private WebElement homeIcon;
	@FindBy(id="cartur")
    public WebElement cartLabel;
	@FindBy(xpath="//button[contains(text(),'Place Order')]")
    public WebElement placeorderBttn;
	
	@FindBy(id="name")
    public WebElement nameField;
	@FindBy(id="country")
    public WebElement countryField;
	@FindBy(id="city")
    public WebElement cityField;
	@FindBy(id="card")
    public WebElement creditcardField;
	@FindBy(id="month")
    public WebElement monthField;
	@FindBy(id="year")
    public WebElement yearField;
	@FindBy(xpath="//button[contains(text(),'OK')]")
    public WebElement finalOKbttn;
	
	public void launchChrome(String demoblazeURL) {
		demoblazeURL="https://www.demoblaze.com/index.html";
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();

		System.out.println("Launching Chrome Driver..!");
		System.setProperty("webdriver.chrome.driver", "./exefile/chromedriver.exe");
		driver = new ChromeDriver(desiredCapabilities);
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to(demoblazeURL);
	}
	public void laptopCategories() {
		Laptops.click();
		System.out.println("Navigated to Laptop categories");
	}
	
	public void clickAddtoCart() {
		addToCart.click();
		System.out.println("Product added to cart successfully !!!");
	}
	
	public void clickHomeicon() {
		homeIcon.click();
		System.out.println("Homeicon clicked !!!");
	}
}
