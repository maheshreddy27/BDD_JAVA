package com.healtasyst.stepdefn;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.healthasyst.base.WebDriverWrapper;
import com.healthasyst.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;



public class LoginStep {

	WebDriver driver;
	//	static {
	//		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	//	}

	@Given("I have browser with OpenEMR page")
	public void i_have_browser_with_open_emr_page() {
		//System.out.println("Given");
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriverWrapper.driver = new ChromeDriver();
		WebDriverWrapper.driver.manage().window().maximize();
		WebDriverWrapper.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebDriverWrapper.driver.get("http://demo.openemr.io/b/openemr/interface/login/login.php?site=default");

	}
	@When("I enter username as {string}")
	public void i_enter_username_as(String username) {
		//WebDriverWrapper.driver.findElement(By.id("authUser")).sendKeys(username);
		LoginPage.enterUsername(username);

	}
	@When("I Enter password as {string}")
	public void i_enter_password_as(String pwd) {
		WebDriverWrapper.driver.findElement(By.id("clearPass")).sendKeys(pwd);

	}
	@When("I select language as {string}")
	public void i_select_language_as(String string) {

	}
	@When("I click on login button")
	public void i_click_on_login_button() {
		WebDriverWrapper.driver.findElement(By.xpath("//button[@class=\"btn btn-login btn-lg\"]")).click();

	}
	@Then("I should get acess to portal with title as {string}")
	public void i_should_get_acess_to_portal_with_title_as(String pageTitle) {
		System.out.println("Then");
		String title=WebDriverWrapper.driver.getTitle();
		Assert.assertEquals(pageTitle, title);

	}
	@Then("I should get error {string}")
	public void i_should_get_error(String expectedError) {
	    String accpected=WebDriverWrapper.driver.findElement(By.xpath("//div[contains(text(),'Invalid username or password')]")).getText();
	    Assert.assertEquals(expectedError, accpected);
	}

}
