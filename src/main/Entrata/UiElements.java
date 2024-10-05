package main.Entrata;

public class UiElements {
    public static final String etantraUrl="https://www.entrata.com/b";

    public static String getService(String service){
        return "//div[contains(@class,'dropdown-menu-text---brix') and text()='"+service+"']";
    }
    public static String getCookieAction(String CookieAction){
        return "//a[contains(text(),'"+CookieAction+"')]";
    }
    public static String getProductCategoryList(){
        return "//div[@class='footer-column']/a/h3";
    }
    public static String getProductCategory(String category){
        return "//div[@class='footer-column']/a/h3[text()='"+category+"']";
    }

    public static String getProductSubCategory(String category){
        return "//div[@class='footer-column']//h3[text()='"+category+"']//ancestor::div/a[text()]";
    }
    public static String getProductPoster(){
        return "//div[@class ='product-grid-left']/h1";
    }
    public static String getLoginOption(){
        return "//div[@class='button-wrapper sign-in']/a/div";
    }
    public static String getButton(String buttonName){
        return "//div[@class='nav-button']/a[contains(text(),'"+buttonName+"')]";
    }
    public static String getWatchDemoButton(){
        return "//div[@class='nav-button']//div[contains(text(),'Watch Demo')]";
    }
    public static String getDemoFormElements(String  formKey){
        return "//div[@class='mktoFormRow']//input[@name='"+formKey+"']";
    }

    public static String getDemoFormElementsWarnings(String  formKey){
        return "//div[@class='mktoFormRow']//input[@name='"+formKey+"']//parent::div//div[@id='ValidMsgFirstName']";
    }


}
