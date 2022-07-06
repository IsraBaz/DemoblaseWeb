package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;

public class CrearUsuario_Steps {
	
	//Objeto Driver
	WebDriver driver;
	
	HomePage homePage;

	@BeforeTest
	public void setUp() {
		homePage = new HomePage(driver);
		driver = homePage.chromeDriverConnection();
		//Url de la aplicación
		homePage.navigateTo("https://www.demoblaze.com/");
		//Maximizar ventana
		driver.manage().window().maximize();	
	}
	
	@Test(dataProvider = "authenticationData")
	public void signUpUser(String newUser, String newPass) {
		
		homePage.elementWait1();
		System.out.println("El localizador texto si se encuentra");
		homePage.clickSignUp();
		System.out.println("Se dio clic al botón Inscribirse");
		/*homePage.insertUsNam("test1");
		System.out.println("Se ingreso correctamente el nuevo usuario");
		homePage.insertPass("pass1");
		System.out.println("Se ingreso correctamente el nuevo paswword");*/
	}
	
	@DataProvider(name = "authenticationData")
	public Object[][] getData() {
		
		Object [][]data = new Object [1][2];
		data[0][0]="testUser";
		data[0][1]="testpassword";
		return data;
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
}
