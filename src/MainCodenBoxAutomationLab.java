import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.ui.Select;
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

	@Test(priority = 1, enabled = false)
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

	@Test(priority = 2, enabled = false)
	public void dynamicDropdown() throws InterruptedException {
		WebElement dynamicDropdown = driver.findElement(By.id("autocomplete"));
		String[] countryCodes = { "US", "CA", "MX", // North America
				"BR", "AR", "CO", // South America
				"GB", "FR", "DE", // Europe
				"CN", "JP", "IN", // Asia
				"AU", "NZ", "ZA" // Oceania and Africa
		};
		int x = rand.nextInt(countryCodes.length);
		dynamicDropdown.sendKeys(countryCodes[x]);
		Thread.sleep(1000);
		dynamicDropdown.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String actual = (String) js.executeScript("return arguments [0].value", dynamicDropdown);
		String actualResulite = actual.toUpperCase();
		boolean actualResuliteBool = actualResulite.contains(countryCodes[x]);
		boolean excputid = true;
		Assert.assertEquals(actualResuliteBool, excputid);
	}

	@Test(priority = 3, enabled = false)
	public void select() {
		WebElement selectElement = driver.findElement(By.id("dropdown-class-example"));
		Select select = new Select(selectElement);
		// select.selectByVisibleText("API");
		// select.selectByValue("option2");
		int randomChose = rand.nextInt(1, 4);
		select.selectByIndex(randomChose);
	}

	@Test(priority = 4, enabled = false)
	public void checkBoxs() {
		WebElement checkBox = driver.findElement(By.id("checkbox-example"));
		List<WebElement> checkBoxList = checkBox.findElements(By.xpath("//input[@type='checkbox']"));
		int randomChose = rand.nextInt(checkBoxList.size());
		checkBoxList.get(randomChose).click();

	}

	@Test(priority = 5, enabled = false)
	public void switchWindow() {
		driver.findElement(By.id("openwindow")).click();
		List<String> windowHandlesList = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(windowHandlesList.get(1));
		WebElement tecanolgey = driver.findElement(By.id("menu-item-9675"));
		tecanolgey.click();
		driver.switchTo().window(windowHandlesList.get(0));
	}

	@Test(priority = 6, enabled = false)
	public void switchOpenTab() throws InterruptedException {
		driver.findElement(By.id("opentab")).click();
		List<String> windowHandlesList = new ArrayList<>(driver.getWindowHandles());
		System.out.println(windowHandlesList.size());
		driver.switchTo().window(windowHandlesList.get(1));

	}

	@Test(priority = 7, enabled = false)
	public void switchAlert() {
		driver.findElement(By.id("alertbtn")).click();
		driver.switchTo().alert().accept();
	}

	@Test(priority = 8, enabled = false)
	public void getDataFromTable() {
		WebElement table = driver.findElement(By.id("product"));
		List<WebElement> tableelements = table.findElements(By.tagName("td"));

		for (int i = 1; i < tableelements.size(); i = i + 3) {
			System.out.println(tableelements.get(i).getText());
		}
	}

	@Test(priority = 9, enabled = false)
	public void isDisplayed() {
		boolean x = rand.nextBoolean();
		WebElement showbutton = driver.findElement(By.id("show-textbox"));
		WebElement headbutton = driver.findElement(By.id("hide-textbox"));
		boolean expected;
		if (x) {
			headbutton.click();
			expected = false;
		} else {
			showbutton.click();
			expected = true;
		}
		WebElement serachbutton = driver.findElement(By.id("displayed-text"));
		boolean actual = serachbutton.isDisplayed();
		// System.out.println(actual+" "+expected);
		Assert.assertEquals(actual, expected);

	}

	@Test(priority = 10, enabled = false)
	public void isEnabled() {
		boolean x = rand.nextBoolean();
		WebElement enablebutton = driver.findElement(By.id("enabled-button"));
		WebElement hidebutton = driver.findElement(By.id("hide-textbox"));
		boolean expected;
		if (x) {
			hidebutton.click();
			expected = false;
		} else {
			enablebutton.click();
			expected = true;
		}
		WebElement serachbutton = driver.findElement(By.id("displayed-text"));
		boolean actual = serachbutton.isEnabled();
		// System.out.println(actual+" "+expected);
		Assert.assertEquals(actual, expected);

	}

	@Test(priority = 11)
	public void mouseHover() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,1750)");

	}

	@Test(priority = 12)
	public void calendr() throws InterruptedException {
	WebElement openCaulender=driver.findElement(By.linkText("Booking Calendar"));
	openCaulender.click();
	List<String> windowHandlesList = new ArrayList<>(driver.getWindowHandles());
	driver.switchTo().window(windowHandlesList.get(1));
	Thread.sleep(3000);
	List<WebElement> list=driver.findElements(By.xpath("//a[@href='javascript:void(0)']"));
	System.out.println(list.size());
	
	
	
	}
}