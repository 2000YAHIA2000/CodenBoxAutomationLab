import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainCodenBoxAutomationLab {
	WebDriver driver = new ChromeDriver();
	String wesiteurl = "https://codenboxautomationlab.com/practice/";
	Random rand = new Random();

	@BeforeTest
	public void setUp() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get(wesiteurl);
	}

	@Test(priority = 1)
	public void radioButton() {
		WebElement radioButton = driver.findElement(By.id("radio-btn-example"));
		List<WebElement> radioButtonElement = radioButton.findElements(By.tagName("input"));
		int x = rand.nextInt(radioButtonElement.size());
		// System.out.println("the random number is = "+x);
		radioButtonElement.get(x).click();
		boolean actul = radioButtonElement.get(x).isSelected();
		boolean excpucted = true;
		Assert.assertEquals(actul, excpucted);

	}

	@Test(priority = 2)
	public void dynamicDropdown() throws InterruptedException {
		WebElement dynamicDropdown = driver.findElement(By.id("autocomplete"));
		String[] countryCodes = { "US", "CA", "MX", // North America
				"BR", "AR", "CO", // South America
				"GB", "FR", "DE", // Europe
				"CN", "JP", "IN", // Asia
				"AU", "NZ", "ZA" // Oceania and Africa
		};
		int x= rand.nextInt(countryCodes.length);
		dynamicDropdown.sendKeys(countryCodes[x]);
		Thread.sleep(1000);
		dynamicDropdown.sendKeys(Keys.chord(Keys.ARROW_DOWN,Keys.ENTER));
		JavascriptExecutor js= (JavascriptExecutor) driver;
		String actual =(String) js.executeScript("return arguments [0].value",dynamicDropdown);
		String actualResulite= actual.toUpperCase();
		boolean actualResuliteBool=actualResulite.contains(countryCodes[x]);
		boolean excputid =true;
		Assert.assertEquals(actualResuliteBool, excputid);
	}

}
