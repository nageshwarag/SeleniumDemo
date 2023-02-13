package WindowPopup.windowpopup;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class fileUpload {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		String downloadPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91789\\OneDrive\\Desktop\\Selenium\\Driver\\chromedriver.exe");
		
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_        content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.ilovepdf.com/pdf_to_jpg");
		
		
		driver.findElement(By.xpath("//span[text()='Select PDF files']")).click();
		Thread.sleep(3000);
		
		Runtime.getRuntime().exec("C:\\Users\\91789\\OneDrive\\Documents\\fileupload.exe");
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("processTaskTextBtn")));
		
		driver.findElement(By.id("processTaskTextBtn")).click();
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@id='pickfiles']")));
		
		driver.findElement(By.xpath("//a[@id='pickfiles']")).click();
		
		Thread.sleep(5000);
		
		File f = new File(downloadPath+"/Exercise_page-0001.jpg");
		
		if(f.exists())
		{
			Assert.assertTrue(f.exists());
			if(f.delete())
			{
				System.out.println("File Deleted");
			}
		}
		

	}

}
