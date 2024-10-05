package main.Entrata;

import main.driverUtil.instanciateDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class AutomationHelper extends instanciateDriver {
//public static WebDriver driver= new ;

    public static WebElement getElement(String path){
        return driver.findElement(By.xpath(path));
    }
    public static List<WebElement> getElements( String path){
        return driver.findElements(By.xpath(path));
    }
    public static String getElementText(WebElement elem){
        return elem.getText();
    }
    public static List<String> getElementsText(List<WebElement> elem){
        return elem.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    public static void explicitWait(String path){
        new WebDriverWait(driver, Duration.ofSeconds(6)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
    }
    public static void moveToElement(WebElement elem){
        Actions action = new Actions(driver);
        action.moveToElement(elem).build().perform();

    }
    public static void moveAndClick(WebElement elem){
        Actions action = new Actions(driver);
        action.moveToElement(elem).click().build().perform();

    }
    public static void click(WebElement elem){
        elem.click();

    }
    public static void takesScreenShot(){
        try {
            File ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(ss, new File("C:\\Entrata\\src\\main\\resources\\ScreenShot"));
        }catch (Exception e){
            System.out.println("Excetion while screen Shot "+e);
        }
    }


}
