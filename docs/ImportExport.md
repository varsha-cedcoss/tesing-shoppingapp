#Import Export

##How to Reach(Common to all):
1.Goto WIA-Automation
2.Then to testSuite
3.Double click on EmptySuite.xml.

###Exporting Csv and Updating

Code:

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="TestSuite">
	<test name="Demo">
<classes>

<class name="TestScripts.ImportExport">
			
			<!-- start with exporting csv and updating and again importing
			There are 2 parts in this method which you have todo sequence wise:
			1.first you have to export csv and update
			2.secondly you have to manually import updated csv file and run the script after commenting first part in the script
			 -->
			<method name="exportingCsvandUpdating"></method>
			<!-- end with exporting csv and updating and again importing -->
			
</class>
			
</classes>

</test>
</suite>


Steps to run the script:
1.Paste the above code in the EmptySuite.xml file
2.Right click and hover to Run As and click on TestNG Test.
