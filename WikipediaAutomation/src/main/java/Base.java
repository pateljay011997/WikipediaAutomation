import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base extends Utilities {
	
	public static WebDriver driver;
	public static List<WebElement> aTagsList;
	public static List<String> allWikiLinksList = new ArrayList<String>(), uniqueWikiLinksList;
	public static String URL;
	
	//Method will give list with all links and list with unique links
	public static String openLink_CreateArrayofLink(String url){
		openBrowserAndURL(url);
		getListOfLinks();
		uniqueWikiLinksList = removeDuplicateLink(allWikiLinksList); //removing duplicates from list and storing unique links in new list
		closeBrowser();
		return allWikiLinksList.toString();
	}
	
	//Method to open browser and open URL
	public static void openBrowserAndURL(String url) {
		System.setProperty("webdriver.gecko.driver", "N:\\QA\\SeleniumJars\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);		
	}
	
	//Method to find all links with wiki/ href
	public static void getListOfLinks() {
		aTagsList = driver.findElements(By.xpath("//div[@id='mw-content-text']//div[@class='mw-parser-output']//a[contains(@href,'wiki/')]"));
		for(int i=0; i<aTagsList.size();i++) {
			WebElement link = aTagsList.get(i);
			String urlLink = link.getAttribute("href");
			allWikiLinksList.add(urlLink);		
		}	
	}
	
	//Method to close browser
	public static void closeBrowser() {
		driver.quit();
	}

}
