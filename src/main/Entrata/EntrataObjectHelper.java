package main.Entrata;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EntrataObjectHelper {
    public  EntrataUi ui;
    public  EntrataWorkflow workflow;
    public  EntrataModule module;
    public  UiElements uiElements;
    private static EntrataObjectHelper objectHelper=null;

    public EntrataObjectHelper() {
        ui=new EntrataUi();
        workflow=new EntrataWorkflow();
        module=new EntrataModule();
        uiElements=new UiElements();
    }

    public static EntrataObjectHelper getInstance(){
        if(objectHelper==null){
            objectHelper=new EntrataObjectHelper();
        }
        return objectHelper;
    }
}
