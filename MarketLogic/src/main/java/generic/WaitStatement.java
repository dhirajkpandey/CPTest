package generic;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitStatement {
		//Implicit Wait
		public static void fnImplicitWait(WebDriver driver, int time)
		{
			driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		}
		
		//Explicit Wait
		public static void fnExplicitWait(WebDriver driver, int time, WebElement element)
		{
			WebDriverWait wait=new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.visibilityOf(element));
			
			
		}

}