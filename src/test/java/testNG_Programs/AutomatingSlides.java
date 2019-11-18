package testNG_Programs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


@Test
public class AutomatingSlides 
{
	WebDriver driver;
	public void testSlider() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nagaswetha.korlapati\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://jqueryui.com/slider");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement frame=driver.findElement(By.xpath("(//*[contains(@class,'demo')])[2]"));
		driver.switchTo().frame(frame);
		WebElement slider=driver.findElement(By.xpath("//div[contains(@class,'slider')]"));
		int x=slider.getLocation().getX();
		int y=slider.getLocation().getY();
		System.out.println("X:"+x+"Y:"+y);
		Actions a =new Actions(driver);
		a.dragAndDropBy(slider, x+400, y).build().perform();
		a.dragAndDropBy(slider, x-200, y).build().perform();
		driver.switchTo().defaultContent();
		driver.findElement(By.linkText("Vertical slider")).click();
		WebElement vframe=driver.findElement(By.xpath("//iframe[contains(@class,'demo')]"));
		driver.switchTo().frame(vframe);
		WebElement vslider=driver.findElement(By.xpath("//div[@id='slider-vertical']/span"));
		int xco=vslider.getLocation().getX();
		int yco=vslider.getLocation().getY();
		System.out.println("X"+xco+"Y"+yco);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		a.dragAndDropBy(vslider, xco, yco+50).build().perform();;
		Thread.sleep(5000);
		driver.close();
		
	}
	
}

