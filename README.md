# Assesment

# General
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
9. Make sure your webdriver is mapped correctly under the Browser Class. Also make sure test StaticData.xls is mapped correctly (src/Excell) mapped in DATA class under utility package
10. To view test results: click on "test-output" folder and open index.html page. Scroll down to under Results and click on "SHOW" next to "passed methods". To view more detail report,please open emailable-report.html (in here you will see the order reference number in step 5)
11. jxl-2.6.12.jar must be added to the build path manually of project. It is stored under "src/Excell"

Approach to this project
1. Was to use a Test-Driven Development approach. 
Reason: Tests should be easy to read and be maintain separately from the selenium framework.
2. Page Object Model was used to create selenium framework, it will make the maintenance a bit easier.
3. Also adding tests is easy when the framework has been built. For example, go to any of the tests and type "Pages.", now you can select a page, after page is selected type a dot, now you can choose what you can do on that page. This reads easy and anyone who is less technical can now also assist in creating tests or a developer can now run it locally and enter the inputs he wants to test with.
4. My approach in this assignment was just to get through the basic flow and confirm that I can place an order. As soon as you have a basic test then you can expand your coverage and add additional tests.
5. All tests can run in chrome and Firefox. I was brave and attempted IE as well, the biggest challenge with IE is that it needs to see the element on the page. Due to time, I decided to rather use Firefox.
6. I think all pairs testing technique will works wonders to get coverage between restaurant and dishes 
7. Please see comments in tests and TestNG.xml
8. Questions from a testing point of view: What is most popular flow?, what is most popular desktop size?, How much of users use their phones (app and browser)to order? Android vs Iphone Users? How many users are using IE and IE Edge. Any google analytics stats that would assist? If I was part of a team I would as the developers how they would recommend to test?( because I have found it very helpful to have different testing view point).

Thank you for taking the time to review this project. 