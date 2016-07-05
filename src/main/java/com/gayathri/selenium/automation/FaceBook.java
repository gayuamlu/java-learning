package com.gayathri.selenium.automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

public class FaceBook {
	private static final boolean True = false;
	public static String baseurl = "https://www.facebook.com";
	public static FirefoxDriver driver;

	/*
	 * public void Facebook(){ driver = new FirefoxDriver(); }
	 */
	public static void setSystemProperty(String browser) {

		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "/Users/gayuamlu/Documents/DRIVERS/chromedriver");
			break;
		default:
			System.out.println("Invalid browser");
			break;

		}

	}

	public static void login() {

		driver.get(baseurl);
		driver.findElementById("email").sendKeys("gayu.amlu14@gmail.com");
		driver.findElementById("pass").sendKeys("traitor");
		driver.findElementById("login_form").submit();

		int size = driver.findElements(By.xpath("//span[text()=\"Gayathri\"]")).size();
		if (size == 0) {
			System.out.println("Login not successful");
		}
		/*
		 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); for
		 * (String wind:driver.getWindowHandles()) {
		 * System.out.println(driver.switchTo().window(wind).getTitle());
		 * //System.out.println(driver.getTitle()); }
		 */
		try {
			System.out.println(driver.switchTo().alert().getText());

		} catch (NoAlertPresentException e) {
			System.out.println("Exception thrown : " + e);
		}
	}

	public static void searchProfile() {

		driver.findElementByXPath("//form[@id=\"searchBarClickRef\"]/div/div/div/span/input")
				.sendKeys("Harish Vijendran");

		driver.findElementByXPath("//form[@id=\"searchBarClickRef\"]/div/div/div/span/input").sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String profile = driver.findElementByXPath("//*[@id='fb-timeline-cover-name']").getText();
		if (profile.equals("Harish Vijendran")) {
			System.out.println("Search profile is found " + profile);
		} else {
			System.out.println("Search profile NOT found " + profile);
		}

		driver.findElementByXPath("//*[@id='fbTimelineHeadline']/div[2]/div/div/a[3]").click();

		
		WebElement element = driver.findElementByXPath("//*[@id='timeline-medley']/div/div[2]/div[1]/div/div/h3");
		// Move to the desired element on the webpage using Actions
		/*Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.click(); 
		*/		
		//Scrolldown to the desired element on the webpage using JavascriptExecutor
		JavascriptExecutor js =((JavascriptExecutor)driver);
		js.executeScript("arguments[0],scrollIntoView(true);",element);
		do{
			js.executeScript(document.getElementById());
		}
	}

	public static void main(String[] args) {
		driver = new FirefoxDriver();
		login();
		searchProfile();

	}
}