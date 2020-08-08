#Manage Products

##How to Reach(Common to all):
1.Goto WIA-Automation
2.Then to testSuite
3.Double click on EmptySuite.xml.

###Verifying Sync With Shopify

Code:

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="TestSuite">
	<test name="Demo">
<classes>
<class name="TestScripts.ManageProducts">
				<!-- start sync with shopify -->
					<method name="verifyingSyncwithShopify"></method>
				<!-- end sync with shopify -->
</class>

</classes>

</test>
</suite>

Steps to run the script:
1.Paste the above code in the EmptySuite.xml file
2.Right click and hover to Run As and click on TestNG Test.

###Verifying Updating Price

Code:

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="TestSuite">
	<test name="Demo">
<classes>
<class name="TestScripts.ManageProducts">
                <!-- start with update price -->
				<method name="verifyingUpdatingPrice"></method>
				<!-- end with update price -->
</class>

</classes>

</test>
</suite>

Steps to run the script:
1.Paste the above code in the EmptySuite.xml file
2.Right click and hover to Run As and click on TestNG Test.

###Verifying Updating Inventory

Code:

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="TestSuite">
	<test name="Demo">
<classes>
<class name="TestScripts.ManageProducts">
                <!-- start with update inventory -->
				<method name="verifyingUpdatingInventory"></method>
				<!-- end with update inventory -->

</class>

</classes>

</test>
</suite>

Steps to run the script:
1.Paste the above code in the EmptySuite.xml file
2.Right click and hover to Run As and click on TestNG Test.

###Verifying Update Status

Code:

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="TestSuite">
	<test name="Demo">
<classes>
<class name="TestScripts.ManageProducts">
                <!-- start with update status -->
				<method name="verifyingUpdateStatus"></method>
				<!-- end with update status -->

</class>

</classes>

</test>
</suite>

Steps to run the script:
1.Paste the above code in the EmptySuite.xml file
2.Right click and hover to Run As and click on TestNG Test.

###To run all the above script of Manage Products in one go

Code:

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="TestSuite">
	<test name="Demo">
<classes>
<class name="TestScripts.ManageProducts">
				<!-- start sync with shopify -->
					<method name="verifyingSyncwithShopify"></method>
				<!-- end sync with shopify -->
				
				<!-- start with update price -->
				<method name="verifyingUpdatingPrice"></method>
				<!-- end with update price -->
				
				<!-- start with update inventory -->
				<method name="verifyingUpdatingInventory"></method>
				<!-- end with update inventory -->
				
				<!-- start with update status -->
				<method name="verifyingUpdateStatus"></method>
				<!-- end with update status -->
				
			</class>
</classes>

</test>
</suite>

Steps to run the script:
1.Paste the above code in the EmptySuite.xml file
2.Right click and hover to Run As and click on TestNG Test.

