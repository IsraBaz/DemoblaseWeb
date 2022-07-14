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
	
	//Objeto estático "driver" para la instancia de un solo valor
	protected static WebDriver driver;
	private static WebDriverWait wait;
	
	//Constructor
	public BasePage(WebDriver driver) {
		BasePage.driver = driver;
//		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	//Método para iniciar ChromeDriver
	public WebDriver chromeDriverConnection() {
		System.setProperty("webdriver.chrome.driver","./ChromeDriver/chromedriver.exe");
		//wait = new WebDriverWait(driver,10);
		driver = new ChromeDriver();
		return driver;
	}
	
	//Método para la URL
	public void navigateTo(String url) {
		driver.get(url);
	}
	
	//Método para realizar la acción "switch" a otro frame
	public void switchToiFrame(int iFrameIndex) {
		driver.switchTo().frame(iFrameIndex);
	}
	
	//Método switchParent
	public void switchToParentFrame() {
		driver.switchTo().parentFrame();
	}
	
	//Método para cerrar alertas
	public void dismissAlert() {
		try {
			driver.switchTo().alert().dismiss();	
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

}
