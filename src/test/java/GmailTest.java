import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.glass.events.KeyEvent;

public class GmailTest {
	static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException, IOException, AWTException {

		String driverExe = "Driver/chromedriver.exe";
		File _file = new File(driverExe);
		System.setProperty("webdriver.chrome.driver", _file.getAbsolutePath());
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.gmail.com");
		String userName = "Automation1290";
		String password = "Gmail@123";
		driver.findElement(By.id("identifierId")).sendKeys(userName);
		driver.findElement(By.xpath("//button[@type = 'button' and @jsname ='LgbsSe']")).click();
		waitForElement(By.xpath("//input[@type = 'password']"));
		driver.findElement(By.xpath("//input[@type = 'password']")).sendKeys(password);
		driver.findElement(By.xpath("//div[1]/div[1]/div[1]/div[1]/button[1]/div[@class = 'VfPpkd-RLmnJb']")).click();
		Thread.sleep(20000);
		driver.findElement(By.xpath("//div[text() = 'Compose']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys("test@gmail.com");

		driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("testSubject");

		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='Ar Au']//div")).sendKeys("Hi Team");

		driver.findElement(By.xpath("//div[@data-tooltip = 'Attach files']")).click();

		Thread.sleep(3000);
		Robot rb = new Robot();

		StringSelection str = new StringSelection(new File("Images/SamplePNGImage_100kbmb.png").getAbsolutePath());
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);

		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);

		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[text() = 'Send']")).click();
		Thread.sleep(10000);
		driver.quit();
	}

	public static WebElement waitForElement(By element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(element));

	}

}
