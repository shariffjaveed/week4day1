package week4.day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsFrame 
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
        driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Alert prompt = driver.switchTo().alert();
		prompt.sendKeys("Javeed");
		prompt.accept();
		String verify = driver.findElement(By.xpath("//h2[text()='The prompt() Method']//following::p[2]")).getText();
		if(verify.contains("Javeed"))
			System.out.println("The name printed successfully");
		else
			System.out.println("The name not printed");
}
}
