package Week5Day2Assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Download the Driver And Setup the Path
        WebDriverManager.chromedriver().setup();
        //launch the browser
        ChromeDriver driver=new ChromeDriver();
        //get URL
        driver.get("http://leaftaps.com/opentaps/control/main");
        //maximize the window
        driver.manage().window().maximize();
        //implicity wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        
        //Enter UserName
        driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
        
        //Enter Password
        driver.findElement(By.id("password")).sendKeys("crmsfa");
        
        //click login 
        driver.findElement(By.className("decorativeSubmit")).click();
        
        //click CRM/SFA
        driver.findElement(By.linkText("CRM/SFA")).click();
        
        //Click on contacts Button
        driver.findElement(By.linkText("Contacts")).click();
        
        //Click on Merge Contacts using Xpath Locator
        driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
        
        //Click on Widget of From Contact
        driver.findElement(By.xpath("//img[@src='/images/fieldlookup.gif']")).click();
        
        //window handling
        String parentwindow = driver.getWindowHandle();
        
        //child window
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> childwindow=new ArrayList<String>(windowHandles);
        driver.switchTo().window(childwindow.get(1));
        
        //Click on First Resulting Contact
        driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]")).click();
        
        //Switch to Parent Window
        driver.switchTo().window(parentwindow);
        
        //Click on Widget of To Contact
        driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[2]")).click();
        
        //Child window Handling
        Set<String> windowHandles2 = driver.getWindowHandles();
        List<String> childwindow1=new ArrayList<String>(windowHandles2);
        driver.switchTo().window(childwindow1.get(1));
        
        //Click on Second Resulting Contact
        driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[2]")).click();
        
        //Switch to parent Window
        driver.switchTo().window(parentwindow);
        
        //Click on Merge button using Xpath Locator
        driver.findElement(By.xpath("//a[text()='Merge']")).click();
        
        //Accept the Alert
        driver.switchTo().alert().accept();
        
        //Verify the title of the page
        String title = driver.getTitle();
        System.out.println("The Title of the page is : "+title);
        

	}

}
