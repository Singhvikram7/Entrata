package main.Entrata;
import org.openqa.selenium.WebElement;

import java.util.List;

public class EntrataModule {
   // public ;

    public  WebElement getServiceElement(String service){
        try {
            return AutomationHelper.getElement(UiElements.getService(service));
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    public WebElement getCookieActionElement(String CookieAction){
        return AutomationHelper.getElement(UiElements.getCookieAction(CookieAction));
    }
    public  List<WebElement> getProductCategoryElements(){
        try {
            return AutomationHelper.getElements(UiElements.getProductCategoryList());
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }

    public WebElement getProductSubCategoryElement(String category){
        return AutomationHelper.getElement(UiElements.getProductSubCategory(category));
    }
    public WebElement getProductPoster(){
        try {
            return AutomationHelper.getElement(UiElements.getProductPoster());
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    public List<WebElement> getLoginOption(){
        try {
            return AutomationHelper.getElements(UiElements.getLoginOption());
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }

    public WebElement getButton(String buttonName){
        try {
            return AutomationHelper.getElement(UiElements.getButton(buttonName));
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    public WebElement getProductCategoryElement(String category){
        try {
            return AutomationHelper.getElement(UiElements.getProductCategory(category));
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }

    public WebElement getDemoFormElement(String formKey){
        try {
            return AutomationHelper.getElement(UiElements.getDemoFormElements(formKey));
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    public WebElement getDemoFormElementsWarnings(String formKey){
        try {
            return AutomationHelper.getElement(UiElements.getDemoFormElementsWarnings(formKey));
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    public WebElement getWatchDemoButtonElement(){
        try {
            return AutomationHelper.getElement(UiElements.getWatchDemoButton());
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
}
