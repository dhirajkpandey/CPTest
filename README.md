# CPTest
This project was created using java and TestNG
To run this project following steps are needed:-

Step 1. Download Eclipse from url-"https://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/oxygenm2"

Step 2. Before launching eclipse make sure that jdk version 1.8.0 or above is installed and java path is set in Environment variables.

3. Extract downloaded eclipse and inside the folder click on eclipse icon

4. In eclipse-> Click on Help Menu-> Eclipse Marketplace->Search for plugin "testng for eclipse" and install it.

5. Install plugin "git for eclipse" following above step

6. Restart eclipse again

7. Click on File Menu->import-> a wizard will open->select Git->Projects from Git and clcik Next->in next screen select Clone URI 
   in next screen enter URI "https://github.com/dhirajkpandey/CPTest" enter user name and password(Please check email for username password)

8. In next screen check master and click next-> select destination directory->select option "Import existing Eclipse project" ->next->Finish 

9. If project branch is showing error click src folder under project-> click test package under scr folder -> click CardValidatorTest.java
    there may be error because TestNG library is not added into build path, if error is showing for @Test annotation then hover mouse on 
    @Test and click Add TestNG library.

10. To run project right click on project ->Run As->TestNG Test->project will run and visa and master type card number will be stored in 
      OutPutFile.txt file under project root, if data is not visible in the file please open file in eclipse right click and refresh            it, test report will be generated in test-ouput folder under project root
11. To view test report click on test-output folder in local path where project is stored in file explorer and click on emailable-report.
