package pojo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {
	static WebDriver driver;
	
	public static WebDriver LaunchApplication(String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup(); 
			    driver = new ChromeDriver();	
		}
		else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup(); 
		    driver = new EdgeDriver();	
		}
	
	    driver.get("https://www.naaptol.com/");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
	    return driver;
		}
		
	}

		
		
		
		



