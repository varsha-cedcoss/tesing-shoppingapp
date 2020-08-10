#DashBoard

##How to Reach(Common to all):
1.Goto WIA-Automation
2.Then to testSuite
3.Double click on EmptySuite.xml.

###Clicking All Options

Code:

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="TestSuite">
	<test name="Demo">
<classes>

<class name="TestScripts.DashBoard">
			
			<!-- start with clicking all options -->
			<method name="clickingAllOptions"></method>
			<!-- end with cllicking all options -->

</class>

</classes>

</test>
</suite>


Steps to run the script:
1.Paste the above code in the EmptySuite.xml file
2.Right click and hover to Run As and click on TestNG Test.

###Clicking All Links

Code:

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="TestSuite">
	<test name="Demo">
<classes>

<class name="TestScripts.DashBoard">
            <!-- start with clicking all links -->
			<method name="clickingAllLinks"></method>
			<!-- end with clicking all links -->
</class>

</classes>

</test>
</suite>


Steps to run the script:
1.Paste the above code in the EmptySuite.xml file
2.Right click and hover to Run As and click on TestNG Test.

###To run all the above script of DashBoard in one go

Code:

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="TestSuite">
	<test name="Demo">
<classes>

<class name="TestScripts.DashBoard">

            <!-- start with clicking all options -->
			<method name="clickingAllOptions"></method>
			<!-- end with cllicking all options -->
			
			<!-- start with clicking all links -->
			<method name="clickingAllLinks"></method>
			<!-- end with clicking all links -->
						
			</class>
</classes>

</test>
</suite>


Steps to run the script:
1.Paste the above code in the EmptySuite.xml file
2.Right click and hover to Run As and click on TestNG Test.
