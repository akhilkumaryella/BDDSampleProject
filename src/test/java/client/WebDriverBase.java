package client;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverBase implements ElemetRepository{
	
	public static WebDriver driver;
	
	public static WebDriver getChromeDriver() {
	
		
		String chromeDriver = FileUtilities.getDriverProperty("chrome.driverLoc");
        String chromeBinary = FileUtilities.getDriverProperty("chrome.binaryLoc");
        System.setProperty("webdriver.chrome.driver", chromeDriver);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        options.addArguments("disable-popup-blocking");
        options.addArguments("disable-extensions");
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
        desiredCapabilities.setCapability("chrome.binary", chromeBinary);
        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
        desiredCapabilities.setJavascriptEnabled(true);
        desiredCapabilities.setBrowserName(BROWSER_CHROME);
        
        driver = new ChromeDriver(options);
        
        return driver;
	}
	

}
