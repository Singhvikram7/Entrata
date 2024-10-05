******************************************************************************************************************************
Maven commands
--------------------------------------------------------------------------------------------------------------------------------------------
build :- mvn clean install -DskipTests
Run Test Suites :- mvn verify
in case mvn verify does not works Please use below command
mvn clean test -DsuiteXmlFile=testng.xml
_____________________________________________________________________________________________________________________________________________
Instructions :-  In case if Facing issue while running cases please double check you dependency from maven
and try to update if needed
_____________________________________________________________________________________________________________________________________________

________________________________________________________________________________________________________________________
Class level explanation
----------------------------------------------------------------------------------------------------------------------------
InstanciateDriver.java ->class will create instance of driver object which can be used to sync up all
classes with same driver instance

AutomationHelper.Java -> Class contains reusable methods like get WebElement,List of webElement,Explicit wait
,Move action, click etc.

UiElements.Java -> This Class Storing Dom Objects of Entrata in String Form.

EntraEnum.java -> This class contains Names of Multiple Product and methods etc . We can use this class
to Store Unchangable objects. For expamle products of entrata.

EntrataModule.java -> This class contains method to convert UiElements into WebElements , so that code should 
be reausable and easy readable because All the web elements will be stored at same place. also we can
make changes at one place for multiple web elements

EntrataWorkFlow.java -> This class is doing multiple operation and validation for entrata module by use of 
AutomationHelper.java class and EntrataModule.java

EntaraUi.java ->This class is being used to run test cases.

______________________________________________________________________________________________________________________________________
Config.Properties -> It contains browser name and url at one place so that if someone wants to run case in different browser
Then he just simple needs to change browser name in file that's it.
----------------------------------------------------------------------------------------------------------------------------------------


