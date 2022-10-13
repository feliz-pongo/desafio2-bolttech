package StepsDefinitions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


public class Bolttech {
	
	public static  WebDriver webDM ; 

	static 
	{
		
		Map<String, String> mobileEmulation = new HashMap<String, String>();
		mobileEmulation.put("deviceName", "Nexus 5");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
		System.setProperty("webdriver.chrome.driver","C:\\Users\\feliz.pongo\\Documents\\chrwd\\chromedriver.exe");
		if( webDM == null) 
			webDM = new ChromeDriver(chromeOptions); 
	}
	@Given("acessou o site da bolttech")
	public  void iniciarOsite()
	{
		webDM.get("https://www.bolttech.co.th/en/device-protection");
	}

	@When("verficar a exitencia da lista de preços")
	public void comfirmPriceList()

	{
		try {

			webDM.findElement(By.xpath("//*[@id=\"onetrust-banner-sdk\"]")).click();
			WebDriverWait webwait= new WebDriverWait(webDM, Duration.ofSeconds(60));
			String xpath ="/html/body/div[1]/edi-fragment[1]/edi-fragment/edi-section/edi-device-protection-form//form/edi-device-detection//div/div/div[3]/edi-dropdown//fieldset/div/span";
			WebElement list = webwait.until(ExpectedConditions.visibilityOfElementLocated( By.xpath(xpath))) ;
		
		}catch(NoSuchElementException elemEx)
		{
			elemEx.printStackTrace();
			System.exit(1);
		}
		
	}
	
	@And("Escolher um preço de compra de dispositivos apartir da lista de preços (.*)")
	public void escolherPreco(String preco) {
		
	}
}
