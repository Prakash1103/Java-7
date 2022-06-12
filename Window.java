package Week5Day2Assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Window {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Download the Driver And Setup the Path
        WebDriverManager.chromedriver().setup();
        //launch the browser
        ChromeDriver driver=new ChromeDriver();
        //get URL
        driver.get("http://www.leafground.com/pages/Window.html");
        //maximize the window
        driver.manage().window().maximize();
        //implicity wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        
        //Click button to open home page in New Window
        driver.findElement(By.id("home")).click();
        
        //Window Handling 
        String parentwindow = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> childwindow=new ArrayList<String>(windowHandles);
        
        //switch to child window
        driver.switchTo().window(childwindow.get(1));
        String currentUrl = driver.getCurrentUrl();
        if(currentUrl.equals("http://www.leafground.com/home.html")) {
        	System.out.println("go to homepage button goes to home page");
        }
        else {
        	System.out.println("go to homepage button does goes to home page");
        }
        driver.close();
        
        //switch to parent window
        driver.switchTo().window(parentwindow);
        
        //Find the number of opened windows
        driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
        Set<String> windowHandles2 = driver.getWindowHandles();
        List<String> childwindow1=new ArrayList<String>(windowHandles2);
        int size = childwindow1.size();
        System.out.println("the number of  window is: "+size);
        
        //Close all except this window
        for (int i = 1; i <size; i++) {
        	driver.switchTo().window(childwindow1.get(i));
        	String currentUrl2 = driver.getCurrentUrl();
        	if(currentUrl2.equals("http://www.leafground.com/home.html")) {
        		System.out.println("it is not child window ");
        		}
        	else {
        		driver.close();
        		}
        	}
        driver.switchTo().window(parentwindow);
        
        //Wait for 2 new Windows to open
        driver.findElement(By.id("color")).click();
        
        //window handling
        Set<String> windowHandles3 = driver.getWindowHandles();
        List<String> childwindow2=new ArrayList<String>(windowHandles3);
        int size2 = childwindow2.size();
        
        //wait
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        System.out.println("the number of windows appeared when waiting is : "+size2);
	}

}
