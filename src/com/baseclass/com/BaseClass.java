package com.baseclass.com;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseClass {
	
	//Browser Launch
	
   public static WebDriver driver;

	public static WebDriver Getbrowser(String type) {
		
		  if (type.equalsIgnoreCase("chrome")) {
				
			 // System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
				
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mr. karthik\\eclipse-workspace\\Selenium\\Driver\\chromedriver.exe");
				
				driver=new ChromeDriver();

			
				}
		  else if  (type.equalsIgnoreCase("firefox")) {
				
				System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "\\Driver\\geckodriver.exe");
				
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mr. karthik\\eclipse-workspace\\Selenium\\Driver\\chromedriver.exe");
				
				driver=new FirefoxDriver();
			
		}
		  //driver methods-maximize
		  driver.manage().window().maximize();
		  
		  //return
		  
		  return driver;
	}
		
		  
	
	//driver methods-get,getcurrenturl,gettitle
	
	public static void Browseropen(String linkurl) {
		
		driver.get(linkurl);
		
	}
	
	public static void Currenturl() {
		
		driver.getCurrentUrl();
		
	}
                                                                                                                                 	
	public static void Title() {
		
		driver.getTitle();
		
	}
		
	//driver methods -navigate
	
public static void Moveto(String linkname) {
	
	driver.navigate().to(linkname);
	
}

public static void Moveback() {
	
	driver.navigate().back();
	
}


public static void Moveforward() {
	
	driver.navigate().forward();
	
}

public static void Pagerestore() {
	
	driver.navigate().refresh();
	
}

      //alert
public static void Simplealert() {
		
	 Alert Salert = driver.switchTo().alert();
	 Salert.accept();
	 }

public static void Confirmalert() {
	
	Alert calert = driver.switchTo().alert();
	calert.accept();
	
}

public static void Promptalert() {
	
	Alert palert = driver.switchTo().alert();
	palert.accept();
	
}

     //actions

public static void Actionclick(WebElement element) {
	
Actions ac=new Actions(driver);

ac.click(element).build().perform();

}

public static void Actioncontextclick(WebElement element) {
	
	
	Actions ac=new Actions(driver);
	ac.contextClick(element).build().perform();
	
}

public static void Actiondoubleclick(WebElement element) {
	
	Actions ac=new Actions(driver);
	ac.doubleClick(element).build().perform();
	
}

public static void perfrormMove(WebElement element) {
	
	Actions ac=new Actions(driver);
	ac.moveToElement(element).build().perform();
}

public static void Performdrag(WebElement source,WebElement target) {
	Actions ac=new Actions(driver);
	ac.dragAndDrop(source,target).build().perform();
}

              //Frames

public static void Switchmainframe(WebElement mframe) {
	
	mframe.click();
	driver.switchTo().frame(0);
	
	}
public static void Switchtomainpage(WebElement nframe) {
	
	nframe.click();
	driver.switchTo().defaultContent();
}

             //robot

public static void Automatedown() throws AWTException {
	
	Robot r=new Robot();
	r.keyPress(KeyEvent.VK_DOWN);
	r.keyRelease(KeyEvent.VK_DOWN);
}

public static void automateenter() throws AWTException {
	
	Robot r=new Robot();
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);

	
}

         //window handle

public static void ManageWindow() {
	
	driver.getWindowHandle();
	
}
	public static void Managewindows() {
		
		driver.getWindowHandles();
	}
	
	       //Drop Down

public static void Selectfromlist(WebElement element) {
	
Select s=new Select(element);

List<WebElement> options = s.getOptions();

for (WebElement alloptions : options) {
	
	String text = alloptions.getText();
	
	System.out.println(text);
}

}

    //Select Methods-display,select,enable

public static void Elementvisible(WebElement element) {
	
	element.isDisplayed();
	
}

public static void Elementselect(WebElement element) {
	
	element.isSelected();
	
}

public static void Elementview(WebElement element) {
	
	element.isEnabled();
	
}


//Select by-index ,value,text

public static void Selectfromdropdown(WebElement element,String options,String input) {
	
	Select s=new Select(element);
	if (options.equalsIgnoreCase("index")) {
		
		int parseInt = Integer.parseInt(input);
		s.selectByIndex(parseInt);
		
	}
	else if (options.equalsIgnoreCase("value")) {
		s.selectByValue(input);
		
	}
	else if (options.equalsIgnoreCase("text")) {
		
		s.selectByVisibleText(input);
		
	}
}

       //Select methods-All selected,first selected

        //all selected

public static void Toselectall(WebElement element) {
	
	Select s=new Select(element);
	List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
	
	for (WebElement allsoptions : allSelectedOptions) {
		String text = allsoptions.getText();
		System.out.println(text);
	}
	
}

        //first selected

public static void Firstselect(WebElement element) {
	
	Select s=new Select(element);
	WebElement firstSelectedOption = s.getFirstSelectedOption();
	String text = firstSelectedOption.getText();
	System.out.println(text);
}


       //get attribute

public static void Togetattribute(By searchbutton) {
	
	WebElement element = driver.findElement(searchbutton);
	
	System.out.println(element);
}
	

          // wait

public static void Timeiwait() {
	     
	        //implicilty wait
	driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	
}
	  
	   //explicit wait

public static void Timeewait(WebElement element) {
	
WebDriverWait wait=new WebDriverWait(driver, 60);
	
wait.until(ExpectedConditions.visibilityOf(element));

	
}
	
     //fluent wait

public static void Timefwait() {
	
	Wait wait1=new FluentWait(driver).withTimeout(60,TimeUnit.SECONDS).pollingEvery(10, TimeUnit.SECONDS).ignoring(null);
}
	
	
     //Takes Screenshot

 public static void Takephoto() throws IOException {
	 
	 TakesScreenshot ts=(TakesScreenshot) driver;
	 
	 File source = ts.getScreenshotAs(OutputType.FILE);
	 
	 File destination=new File("C:\\Users\\Mr. karthik\\eclipse-workspace\\Selenium\\screenshot\\name.png");
	 
	 FileUtils.copyFile(source, destination);
	
}

      //Scroll UP & down
 
 public static void Navigatedown() {
	 
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 
	 // scroll down 
	 js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	 
 }
	 //scroll by pixels
public static void Navigateppixels() {
	 
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 
	 js.executeScript("window.scrollBy(0,1000)");
}
	 
	
	 
	 //scroll to top 
public static void Navigateupdown(WebElement element) {
	 
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("arguments[0].scrollIntoView();",element) ;
	 
	}
 
 //input values sendkeys click buttton click
 
            //send keys 
 
 public static void Giveinput(WebElement element,String value) {
	 
	 element.sendKeys(value);
	
 }
          //button-click
 
 public static void Submit(WebElement element) {
	 
	 element.click();
	
}
 
          //check box
 
 public static void Declaration(WebElement element) {
	element.click();
}
       //driver methods -close 
 
 public static void Sessionclose() {
	 
	 driver.close();
	
}
      //driver methods -quit
 
 public static void Sessionterminate() {
	
	 driver.quit();
}
 
 
 
}
