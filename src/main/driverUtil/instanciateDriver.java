package main.driverUtil;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.FileReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class instanciateDriver {
    public static WebDriver driver;
    public static Properties prop = new Properties();
    public static FileReader fr;

    public static void startChromeDriver(String browser, String driverPath) {
        System.setProperty("webdriver.chrome.driver", driverPath);
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(ops);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        ops.setAcceptInsecureCerts(true);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.entrata.com/b");
    }

    @BeforeTest
    public  void setup() throws Exception {
        if (driver == null) {
            fr = new FileReader("C:\\Entrata\\src\\main\\resources\\config\\config.properties");
            prop.load(fr);
        }
        if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
            ChromeOptions ops = new ChromeOptions();
            ops.addArguments("--remote-allow-origins=*");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(ops);
            driver.manage().window().maximize();
        } else if (prop.getProperty("browser").equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        //driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();

    }

    @BeforeMethod
    public void openEtantra() {
        if (!driver.getTitle().equals("Property Management Software | Entrata")) {
            driver.get(prop.getProperty("url"));
        }
        driver.navigate().refresh();
    }
    @AfterMethod
    public void refreshEtantra() {
        driver.navigate().refresh();
    }


    @AfterTest
    public void afterTest(){
        driver.close();
    }

}
