# Assesment

# Environment Setup
1. Download Java jdk (jdk-12.0.1) and set Java Path
(https://javatutorial.net/set-java-home-windows-10)
2. Download Maven and set Maven Path (Set MAVEN_HOME And M2_HOME)
(https://www.mkyong.com/maven/how-to-install-maven-in-windows/)
3. Download IDE - I downloaded "Eclipse for java developers" in this project
4. Download TestNG plugin in Eclipse (http://dl.bintray.com/testng-team/testng-p2-release)
5. Install Maven plugin in Eclipse (It is usually already installed )
6. Do a Maven project update for get the latest Selenium and TestNG jar files 
(Right click on your project, then click MAVEN and then click UPDATE)
7. If you prefer git interface , download plugin egit in Eclipse (egit - http://download.eclipse.org/egit/updates)
8. To install plugins in Eclipse go to HELP and then INSTALL NEW SOFTWARE
9. Make sure your webdriver is mapped correthly under the Browser Class
10. To view test results: click on "test-output" folder and open index.html page. Scroll down to under Results and click on "SHOW" next to "passed methods". To view more detail report,please open emailable-report.html (in here you will see the order reference number in step 5)
11. jxl-2.6.12.jar  must be added to the build path manually of project. look under src/Excell