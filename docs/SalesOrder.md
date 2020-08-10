#Sales Order

##How to Reach(Common to all):
1.Goto WIA-Automation
2.Then to testSuite
3.Double click on EmptySuite.xml.

### Updating Order Status Through Link

Code:

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="TestSuite">
	<test name="Demo">
<classes>
<class name="TestScripts.SalesOrder">
            <!-- start with updating order status through the link given on top of the page -->
			<method name="updatingOrderStatusThroughLink"></method>
			<!-- end with updating order status through the link given on top of the page -->

</class>

</classes>

</test>
</suite>


Steps to run the script:
1.Paste the above code in the EmptySuite.xml file
2.Right click and hover to Run As and click on TestNG Test.



### Fetching Orders

Code:

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="TestSuite">
	<test name="Demo">
<classes>
<class name="TestScripts.SalesOrder">
            <!-- start with fetching orders -->
			<method name="fetchingOrders"></method>
			<!-- end with fetching orders -->

</class>

</classes>

</test>
</suite>


Steps to run the script:
1.Paste the above code in the EmptySuite.xml file
2.Right click and hover to Run As and click on TestNG Test.


### Sync Shipment

Code:

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="TestSuite">
	<test name="Demo">
<classes>
<class name="TestScripts.SalesOrder">
            <!-- start with syncing shipment -->
			<method name="syncShipment"></method>
			<!-- end with syncing shipment -->
</class>

</classes>

</test>
</suite>


Steps to run the script:
1.Paste the above code in the EmptySuite.xml file
2.Right click and hover to Run As and click on TestNG Test.


###To run all the above script of Sales Order in one go

Code:

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="TestSuite">
	<test name="Demo">
<classes>
<class name="TestScripts.SalesOrder">
             <!-- start with updating order status through the link given on top of the page -->
			<method name="updatingOrderStatusThroughLink"></method>
			<!-- end with updating order status through the link given on top of the page -->
			
			<!-- start with fetching orders -->
			<method name="fetchingOrders"></method>
			<!-- end with fetching orders -->
			
			<!-- start with syncing shipment -->
			<method name="syncShipment"></method>
			<!-- end with syncing shipment -->
</class>

</classes>

</test>
</suite>

Steps to run the script:
1.Paste the above code in the EmptySuite.xml file
2.Right click and hover to Run As and click on TestNG Test.


