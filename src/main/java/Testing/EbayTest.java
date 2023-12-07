package Testing;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class EbayTest {
	
	WebDriver driver;
	
	public void setUpDriver() {
		
		driver = DriverSetup.getDriver();
		
	}
	
	public void navigateToURL(String url) {
		
		driver.get(url);
		
	}
	
	public void maximize() {
		
		driver.manage().window().maximize();
		
	}
	
	public void clickAdvanced() {
		
		driver.findElement(By.id("gh-as-a")).click();
		
	}
	
	public void advancedSearch() {
		
		driver.findElement(By.id("_nkw")).sendKeys("outdoor toys");
		
		Select select = new Select(driver.findElement(By.id("s0-1-17-4[0]-7[1]-_in_kw")));
		select.selectByVisibleText("Any words, any order");
		
		driver.findElement(By.id("s0-1-17-5[1]-[0]-LH_TitleDesc")).click();
		driver.findElement(By.id("s0-1-17-5[1]-[1]-LH_Complete")).click();
		driver.findElement(By.id("s0-1-17-5[1]-[2]-LH_Sold")).click();
		
		driver.findElement(By.id("s0-1-17-5[5]-[0]-LH_FR")).click();
		driver.findElement(By.id("s0-1-17-5[5]-[1]-LH_RPA")).click();
		driver.findElement(By.id("s0-1-17-5[5]-[2]-LH_AS")).click();
		
		driver.findElement(By.id("s0-1-17-5[6]-[0]-LH_FS")).click();
		
		driver.findElement(By.id("s0-1-17-6[4]-[0]-LH_ItemCondition")).click();
		
		driver.findElement(By.id("s0-1-17-6[7]-[3]-LH_PrefLoc")).click();
		
		driver.findElements(By.xpath("//button[@class='btn btn--primary']")).get(1).click();
		
	}
	
	public void verifyCategory() throws Exception {
		
		Select select = new Select(driver.findElement(By.id("gh-cat")));
		select.selectByValue("220");
		
		driver.findElement(By.id("gh-btn")).click();
		driver.findElement(By.id("gh-btn")).click();
		
	}
	
	public void listHrefs() {
		
		List<WebElement> hrefs = driver.findElements(By.xpath("//*[contains(@href, 'portable')]"));
		
		for(WebElement href : hrefs) {
			
			System.out.println(href.getAttribute("href"));
			
		}
		
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		EbayTest et = new EbayTest();
		
		et.setUpDriver();
		
		et.navigateToURL("http://www.ebay.com");
		
		et.maximize();
		
		Thread.sleep(2000);
		
		et.clickAdvanced();
		
		Thread.sleep(3000);
		
		et.advancedSearch();
		
		Thread.sleep(3000);
		
		et.verifyCategory();
		
		Thread.sleep(1000);
		
		et.listHrefs();

	}

}
