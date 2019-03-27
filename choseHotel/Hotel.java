package choseHotel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Hotel {

	public static void main(String[] args) {
		WebDriver wb = new ChromeDriver();
		wb.get(Website.getUrl());
		wb.manage().window().maximize();
		
		try {
			WebElement searchBar = wb.findElement(By.xpath("//input[@id='citiesInput']"));
			searchBar.click();
			searchBar.sendKeys("Belgrade, Serbia");

			WebElement chekIn = wb.findElement(By.xpath("//input[@placeholder='Check in']"));
			chekIn.click();
			chekIn.sendKeys("04/01/2019");

			WebElement chekOut = wb.findElement(By.xpath("//input[@placeholder='Check out']"));
			chekOut.click();
			chekOut.sendKeys("04/08/2019");

			WebElement searchButton = wb.findElement(By.xpath("//button[contains(text(),'Search')]"));
			searchButton.click();
			Thread.sleep(3000);
			
			List<WebElement> hoteli = wb.findElements(By.xpath("//button[@class='btn btn-primary loader loader btn-block'][contains(text(),'Details')]"));
			hoteli.get(0).click();
			Thread.sleep(6000);
			
			WebElement booking= wb.findElement(By.xpath("//form[1]//div[1]//div[3]//div[2]//span[1]"));
			booking.click();
			Thread.sleep(3000);
			
			WebElement bookOfAGuest = wb.findElement(By.xpath("/html[1]/body[1]/div[5]/div[6]/section[1]/div[5]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/button[1]"));
			bookOfAGuest.click();
			Thread.sleep(3000);
			
			WebElement firstName=wb.findElement(By.name("firstName"));
			firstName.sendKeys("Dejan");
			
			WebElement lastName=wb.findElement(By.name("lastName"));
			lastName.sendKeys("Vukoicic");
			
			WebElement email=wb.findElement(By.name("email"));
			email.sendKeys("dejan@dejan");
			
			WebElement mobile=wb.findElement(By.name("phone"));
			mobile.sendKeys("064111");
			
			WebElement state=wb.findElement(By.name("province"));
			state.sendKeys("Serbia");
			
			WebElement city=wb.findElement(By.name("city"));
			city.sendKeys("Belgrade");
			
			WebElement postal=wb.findElement(By.name("postalcode"));
			postal.sendKeys("123");
			
			Select country = new Select(wb.findElement(By.name("country")));
	        country.selectByVisibleText("Serbia");
			
			
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
