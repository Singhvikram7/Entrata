package main.Entrata;

import main.driverUtil.instanciateDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class EntrataUi extends instanciateDriver {
    EntrataWorkflow workflow = new EntrataWorkflow();

    @Test(priority = 1)
    public void verifyDriverTitle() {
        /*
        This Method is verifying That When user goes into Etantra page When user have landed into correct
        Title page or not
         */
        try {
            workflow.verifyDriverTitle("Property Management Software | Entrata");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test(priority = 2)
    public  void veryFyAllProductListDisplayed() {
        /*
        This case verify that if in Product dropdown section Whether all product categories are getting displayed or not
         */
        List<String> productList = workflow.getProductListOfEtantra();
        try {
            for (EtantraEnum.etantraProducts product : EtantraEnum.etantraProducts.values()) {
                String prod = product.getProduct();
                System.out.println("Info>>> Prod category :- " +prod);
                if (productList.contains(prod)) {
                    System.out.println("Pass >>> Prod category "+prod+" is getting displayed ");
                    Assert.assertTrue(true);
                } else {
                    System.out.println("Fail >>> Prod category " + prod + " is not getting displayed ");
                    Assert.assertTrue(false);
                }
            }
        } catch (Exception e) {
            System.out.println("Exception occurred while verifying product List");
            e.printStackTrace();
        }
    }

    @Test(priority = 3)
    public void verifySignInMethods() {
        /*
        This case is verifying user click on SignIn button Then there are two Login methods
        Property Manager Login and Resident Login
         */
        try {
            workflow.navigateToSignInPage();
            workflow.verifySignInMethods();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 4)
    public void verifyUserCanNavigateEachProductCategory() {
        /*
        This case will verify user opens product drop down at that time user is able to navigate Entrata products such as
        Property Management,Accounting,Utilities etc.
         */
        try {
            workflow.verifyUserCanNavigateEachProductCategory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test(priority = 5)
    public void verifyWarningOfWatchDemoInEachBoxOfForm() {
        /*This Test case will go to Watch demo section beside signIn button and it will verify
        When user is clicking on or interacting with form boxes without making any changes such as FirstName , Last Name
        Then any Warning is getting displayed or not such as(<This field is required>) for mandatory field
        * */
        try {
            workflow.navigateToWatchDemo();
            workflow.verifyWarningInEachBoxOfForm();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
