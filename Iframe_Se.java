package iframe_Se.com;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class Iframe_Se {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/Frames.html");
		driver.findElement(By.xpath("(//a[@class='analystic'])[2]")).click();
		WebElement first_frame = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));		
		driver.switchTo().frame(first_frame);
		WebElement second_frame = driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']"));
		driver.switchTo().frame(second_frame);
		driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("Selenium");
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='Index.html']")).click();	
		Thread.sleep(5000);
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File SRC = ts.getScreenshotAs(OutputType.FILE);
		File DES = new File("C:\\Users\\inbaraj\\eclipse-workspace\\Selenium_Demo\\src\\iframe_Se\\com\\Capture.png");
		FileUtils.copyFile(SRC, DES);

	}

}
