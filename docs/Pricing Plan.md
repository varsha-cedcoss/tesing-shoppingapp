# PricingPlan

##How to Reach(Common to all):
1.Goto WIA-Automation
2.Then to testSuite
3.Double click on EmptySuite.xml.

###Verifying Pricing Plan Annually And Monthly



Code:

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="TestSuite">
	<test name="Demo">
<classes>

<class name="TestScripts.PricingPlan">
			
			<!-- start with pricing plan annually and monthly -->
			<method name="verifyingPricingPlanAnnuallyAndMonthly"></method>
			<!-- end with pricing plan annually and monthly -->
			
			</class>

</classes>

</test>
</suite>


Steps to run the script:
1.Paste the above code in the EmptySuite.xml file
2.Right click and hover to Run As and click on TestNG Test.


