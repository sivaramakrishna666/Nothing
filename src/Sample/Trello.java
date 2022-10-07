package Sample;

import java.util.Set;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.interactions.Action;
//import org.openqa.selenium.interactions.Action;
//import org.openqa.selenium.interactions.Actions;

public class Trello {

	public static void main(String[] args) throws InterruptedException {
		//chrome browser launching
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SIVARAM\\Desktop\\A\\driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		//open the URL
		driver.get("https://trello.com/");
		driver.manage().window().maximize();
		
		//login with valid credintials
		WebElement login=driver.findElement(By.xpath("//a[text()='Log in']"));	
		login.click();
		WebElement email=driver.findElement(By.id("user"));
		email.sendKeys("batreddisiva1997@gmail.com");
		
		WebElement login_button_1=driver.findElement(By.id("login"));
		login_button_1.submit();
		
		Thread.sleep(2000);
		String window_id=driver.getWindowHandle();
		driver.switchTo().window(window_id);
		driver.findElement(By.id("password")).sendKeys("Siva@666");
		
		WebElement login_button_2=driver.findElement(By.id("login-submit"));
		login_button_2.submit();
		
		
		Thread.sleep(5000);
		//System.out.println(driver.getTitle());
		//System.out.println(driver.getCurrentUrl());
		//String test=driver.findElement(By.xpath("//h3[text()='YOUR WORKSPACES']")).getText();
		//System.out.println(test);
		//Set<String> st=driver.getWindowHandles();
		//System.out.println(st.size());
		
		//board creation
		driver.findElement(By.xpath("//div[@class='board-tile mod-add']")).click();
		Thread.sleep(5000);
		
		//list A creation
		WebElement input_field=driver.findElement(By.xpath("//div[text()='Board title']/following-sibling::input"));
		input_field.sendKeys("List A");
		Thread.sleep(2000);
		
		WebElement create_button=driver.findElement(By.xpath("//button[text()='Create']"));
		create_button.click();
		
		Thread.sleep(20000);
		WebElement add_list=driver.findElement(By.xpath("//div[@id='board']/div[4]/form/a"));
		add_list.click();
		
		//list B creation
		WebElement add_list_1=driver.findElement(By.xpath("//div[@id='board']/div[4]/form/input"));
		add_list_1.sendKeys("List B");
		
		WebElement addlist=driver.findElement(By.xpath("//div[@id='board']/div[4]/form/div/input"));
		addlist.submit();
		
//		WebElement cross=driver.findElement(By.xpath("//div[@id='board']/div[5]/form/div/a"));
//		cross.click();
		
		//cart creation in list A (i am taking cart name as 'Sivaram')
		Thread.sleep(2000);
		WebElement cart=driver.findElement(By.xpath("//div[@id='board']/div[1]/div/div/div/div[2]/div/input"));
		cart.click();
		
		driver.findElement(By.xpath("//div[@id='board']/div[1]/div/div/div/div/div/textarea")).click();
		driver.findElement(By.xpath("//div[@id='board']/div[1]/div/div/div/div/div/textarea")).sendKeys("Sivaram");
		
		driver.findElement(By.xpath("//div[@id='board']/div[1]/div/div[2]/div/div[2]/div/input")).click();
		
		
		//drag and drop added cart by using Actions class
		Actions act=new Actions(driver);
		
		WebElement source=driver.findElement(By.xpath("//*[text()='Sivaram']"));
		WebElement dest=driver.findElement(By.xpath("//div[@id='board']/div[4]/div"));
		act.dragAndDrop(source, dest).perform();
		
		//refresh the page
		driver.navigate().refresh();
		
		//x and y cordinats of moved element
		WebElement moved=driver.findElement(By.xpath("//div[@id='board']/div[4]/div/div[2]"));
		int x_co=moved.getLocation().getX();
		int y_co=moved.getLocation().getY();
		System.out.println("the X_cordinate of the moved element  :"+x_co);
		System.out.println("the Y_cordinate of the moved element  :"+y_co);

		
		//logout
		WebElement logout=driver.findElement(By.xpath("//*[@class='e+oPMlZ-fzJD3c']/button[3]"));
		logout.click();
		
		Thread.sleep(2000);
		WebElement logout_1=driver.findElement(By.xpath("//div[@class='atlaskit-portal']/section/div/nav/ul/li[11]/button"));
		logout_1.click();
		
		WebElement logout_final=driver.findElement(By.id("logout-submit"));
		logout_final.submit();
		//System.out.println(driver.getTitle());
		
		//driver.switchTo().defaultContent();
		
		//closing the browser
		Thread.sleep(2000);
		driver.quit();
	}

}
