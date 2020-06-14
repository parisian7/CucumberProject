package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

public class BrowserUtils {

    public static void switchWindowByTitle(WebDriver driver, String targetTitle){

        Set<String> ids=driver.getWindowHandles();
        for(String id: ids){
            if(!driver.getTitle().equals(targetTitle)){
                driver.switchTo().window(id);
            }
        }
    }

    public static void switchWindowByUrl(WebDriver driver, String url){
        Set<String> ids=driver.getWindowHandles();
        for(String id:ids){
            if(!driver.getCurrentUrl().contains(url)){
                driver.switchTo().window(id);
            }
        }
    }

    public static void closeWindows(WebDriver driver, String parentId){
        Set<String> ids=driver.getWindowHandles();

        for(String id:ids){
            if(!id.equals(parentId)){
                driver.switchTo().window(id);
                driver.close();
            }
        }
    }

    // create a method for fluent wait
    public static WebElement fluentWait(WebDriver driver, long totalSec, long pollingSecond, By locator){

        Wait<WebDriver> wait=new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(totalSec))
                .pollingEvery(Duration.ofSeconds(pollingSecond))
                .ignoring(RuntimeException.class);


        return wait.until(driver1 -> driver1.findElement(locator));
    }

    public static WebElement visibilityOf(WebDriver driver,int timeInSec, WebElement element){

        WebDriverWait wait=new WebDriverWait(driver,timeInSec);

        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement visibilityOfElementLocated(WebDriver driver,int timeInSec, By locator){

        WebDriverWait wait=new WebDriverWait(driver,timeInSec);

        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static String takeScreenShot() {
        //First we cast driver to TakeScreenShot
        //We get the screenshot as File

        File src = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.FILE);
        //We need the destination to store all my screenshots
        //System.getProperty("user.dir") will give the project location
        //System.currentTimeMillis() helps us to give unique name for my screenshot
        String destination=System.getProperty("user.dir")+"\\Screenshot\\"+System.currentTimeMillis()+".png";
        File des =new File(destination);

        //in the two or more try catch blocks the order should be from lower to higher level
        try {
            //copyFile will get the file from source and store to the destination
            FileUtils.copyFile(src,des);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return destination;
    }

}
