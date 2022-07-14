package basePage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	//Objeto est�tico "driver" para la instancia de un solo valor
	protected static WebDriver driver;
	private static WebDriverWait wait;
	
	//Constructor
	public BasePage(WebDriver driver) {
		BasePage.driver = driver;
//		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	//M�todo para iniciar ChromeDriver
	public WebDriver chromeDriverConnection() {
		System.setProperty("webdriver.chrome.driver","./ChromeDriver/chromedriver.exe");
		//wait = new WebDriverWait(driver,10);
		driver = new ChromeDriver();
		return driver;
	}
	
	//M�todo para la URL
	public void navigateTo(String url) {
		driver.get(url);
	}
	
	//M�todo para realizar la acci�n "switch" a otro frame
	public void switchToiFrame(int iFrameIndex) {
		driver.switchTo().frame(iFrameIndex);
	}
	
	//M�todo switchParent
	public void switchToParentFrame() {
		driver.switchTo().parentFrame();
	}
	
	//M�todo para cerrar alertas
	public void dismissAlert() {
		try {
			driver.switchTo().alert().dismiss();	
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

}
