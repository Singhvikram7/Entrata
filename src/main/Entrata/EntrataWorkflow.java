package main.Entrata;

import main.driverUtil.instanciateDriver;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.sql.SQLOutput;
import java.util.List;

public class EntrataWorkflow extends instanciateDriver {
    static EntrataModule module = new EntrataModule();
//    public EntrataWorkflow(){
//        module=new EntrataModule();
//    }

    public static List<String> getProductListOfEtantra() {
        try {
            AutomationHelper.moveToElement(module.getServiceElement("Products"));
            List<String> productCategory = AutomationHelper.getElementsText(module.getProductCategoryElements());
            System.out.println(productCategory);
            Thread.sleep(4000);
            return productCategory;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public void verifyDriverTitle(String title) {
        try {
            // String title="Property Management Software | Entrata";
            System.out.println("Info Title is >>> "+driver.getTitle());
            if (driver.getTitle().equals(title)) {
                // System.out.println(driver.getTitle());
                System.out.println("Pass>>> Title got matched ");
                Assert.assertTrue(true);
            } else {
                System.out.println("Fail>>> Title did not got matched ");
                Assert.assertTrue(false);
            }
           // Assert.assertEquals(driver.getTitle(), title, "UI Title Got matched");
        } catch (Exception e) {
            System.out.println("Exception occurred while verifying Title");
            e.printStackTrace();
        }
    }

    public void clickOnSignInButton() {
        try {
            AutomationHelper.moveAndClick(module.getButton("Sign In"));
        } catch (Exception e) {
            System.out.println("Exception occurred while Clicking on SignIn Button");
            e.printStackTrace();
        }
    }

    public void navigateToSignInPage() {
        try {
            clickOnSignInButton();
            verifyDriverTitle("Entrata Sign In");
            AutomationHelper.takesScreenShot();
//            System.out.println(driver.getCurrentUrl());
//            driver.navigate().to(driver.getCurrentUrl());
        } catch (Exception e) {
            System.out.println("Exception occurred while Navigating on SignIn Button");
            e.printStackTrace();
        }
    }

    public void verifySignInMethods() {
        List<String> optionList = AutomationHelper.getElementsText(module.getLoginOption());
        try {
            for (EtantraEnum.signInOption option : EtantraEnum.signInOption.values()) {
                String opt = option.getOption();
                if (optionList.contains(opt)) {
                    System.out.println("Info >>> Login method is " + opt);
                    System.out.println("Pass>> Login method is present");
                    Assert.assertTrue(true);
                } else {
                    System.out.println("Fail>> Login method is not present");
                    Assert.assertTrue(false);
                }
                AutomationHelper.takesScreenShot();
            }
        } catch (Exception e) {
            System.out.println("Exception occurred while verifying product List");
            e.printStackTrace();
        }
    }

    public void verifyUserCanNavigateEachProductCategory() {
        try {
            for (EtantraEnum.etantraProducts product : EtantraEnum.etantraProducts.values()) {
                AutomationHelper.moveToElement(module.getServiceElement("Products"));
                System.out.println("Info>>> Checking page for product " + product.getProduct());
                AutomationHelper.moveAndClick(module.getProductCategoryElement(product.getProduct()));
                AutomationHelper.explicitWait(UiElements.getProductPoster());
                String poster = AutomationHelper.getElementText(module.getProductPoster());
                if (!poster.contains(product.getProduct())) {
                    System.out.println("Fail>>> User can not navigate for product " + product.getProduct());
                    Assert.assertTrue(false);
                } else {
                    System.out.println("Pass>>> User can navigate for product " + product.getProduct());
                    Assert.assertTrue(true);
                }
                driver.navigate().back();
            }
        } catch (Exception e) {
            System.out.println("Exception occurred while verifying product page Navigation");
            e.printStackTrace();
        }
    }

    public void navigateToWatchDemo() {
        try {
            AutomationHelper.moveAndClick(module.getWatchDemoButtonElement());
            verifyDriverTitle("Entrata | Optimize Property Management with One Platform");
        } catch (Exception e) {
            System.out.println("Exception occurred while navigating to watch demo page ");
            e.printStackTrace();
        }
    }

    public void verifyWarningInEachBoxOfForm() {
        String[] boxList = {"FirstName", "LastName", "Email", "Company", "Phone", "Title" };
        for (String arr : boxList) {
            AutomationHelper.moveAndClick(module.getDemoFormElement(arr));
            AutomationHelper.explicitWait(UiElements.getDemoFormElementsWarnings(arr));
            if (!module.getDemoFormElementsWarnings(arr).isDisplayed()) {
                Assert.assertTrue(false);
            } else {
                String warning = AutomationHelper.getElementText(module.getDemoFormElementsWarnings(arr));
                System.out.println("Warning " + warning + " got displayed when click on demo form box " + arr);
            }
            AutomationHelper.takesScreenShot();
        }
    }
}
