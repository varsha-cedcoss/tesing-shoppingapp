# WebHookFlow

##How to Reach(Common to all Methods):
1.Goto WIA-Automation
2.Then to testSuite
3.Double click on EmptySuite.xml..

###Creating a New Product and Verifying in Walmart

Code:

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="TestSuite">
	<test name="Demo">
<classes>

<class name="TestScripts.WebHook">
			
			<!-- start with creating a new product -->
			<method name="verifyingNewProductCreatedInWalmart"></method>
			<!-- end with creating a new product -->
</class>

</classes>

</test>
</suite>

Steps to run the script:
1.Paste the above code in the EmptySuite.xml file
2.Right click and hover to Run As and click on TestNG Test.


###Updating Simple Product Attributes and Verifying In Walmart

Code:

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="TestSuite">
	<test name="Demo">
<classes>

<class name="TestScripts.WebHook">
            <!-- start with updating simple products attributes -->
			<method name="updatingSimpleProductAttributesandVerifyingInWalmart"></method>
			<!-- end with updating simple products attributes -->
</class>

</classes>

</test>
</suite>

Steps to run the script:
1.Paste the above code in the EmptySuite.xml file
2.Right click and hover to Run As and click on TestNG Test


###Updating Parameters For Variants and Verifying In Walmart

Code:

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="TestSuite">
	<test name="Demo">
<classes>

<class name="TestScripts.WebHook">
            <!-- start with updating variant product attributes -->
			<method name="updatingParametersForVariantsandVerifyingInWalmart"></method>
			<!-- end with updating variant product attributes -->
</class>

</classes>

</test>
</suite>

Steps to run the script:
1.Paste the above code in the EmptySuite.xml file
2.Right click and hover to Run As and click on TestNG Test


###Verifying Add Variant For Product Having Variants

Code:

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="TestSuite">
	<test name="Demo">
<classes>

<class name="TestScripts.WebHook">
            <!-- start with add variant for products having variant -->
			<method name="verifyingAddVariantForProductHavingVariants"></method>
			<!-- end with add variant for products having variant -->
</class>

</classes>

</test>
</suite>

Steps to run the script:
1.Paste the above code in the EmptySuite.xml file
2.Right click and hover to Run As and click on TestNG Test


###Verifying Duplicate Sku Update

Code:

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="TestSuite">
	<test name="Demo">
<classes>

<class name="TestScripts.WebHook">
            <!-- start with verifyingDuplicateSkuUpdate -->
			<method name="verifyingDuplicateSkuUpdate"></method>
			<!-- end with verifyingDuplicateSkuUpdate -->
</class>

</classes>

</test>
</suite>

Steps to run the script:
1.Paste the above code in the EmptySuite.xml file
2.Right click and hover to Run As and click on TestNG Test



###Verifying Inventory Policy and Inventory Management

Code:

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="TestSuite">
	<test name="Demo">
<classes>

<class name="TestScripts.WebHook">
            <!-- start with inventory policy and inventory management -->
			<method name="verifyingInventoryPolicyandInventoryManagement"></method>
			<!-- end with inventory policy and inventory management -->
</class>

</classes>

</test>
</suite>

Steps to run the script:
1.Paste the above code in the EmptySuite.xml file
2.Right click and hover to Run As and click on TestNG Test



###Verifying Delete Variant

Code:

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="TestSuite">
	<test name="Demo">
<classes>

<class name="TestScripts.WebHook">
            <!-- start with delete variant -->
			<method name="verifyingDeleteVariant"></method>
			<!-- end with delete variant -->
</class>

</classes>

</test>
</suite>

Steps to run the script:
1.Paste the above code in the EmptySuite.xml file
2.Right click and hover to Run As and click on TestNG Test



###Verifying Delete Product

Code:

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="TestSuite">
	<test name="Demo">
<classes>

<class name="TestScripts.WebHook">
            <!-- start with delete product -->
			<method name="verifyingDeleteProduct"></method>
			<!-- end with delete product -->
</class>

</classes>

</test>
</suite>

Steps to run the script:
1.Paste the above code in the EmptySuite.xml file
2.Right click and hover to Run As and click on TestNG Test



###Verifying Inventory Policy and Inventory Management For Variants

Code:

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="TestSuite">
	<test name="Demo">
<classes>

<class name="TestScripts.WebHook">
            <!-- start with inventory policy and inventory management for variants -->
			<method name="verifyingInventoryPolicyandInventoryManagementForVariants"></method>
			<!-- end with inventory policy and inventory management for variants -->
</class>

</classes>

</test>
</suite>

Steps to run the script:
1.Paste the above code in the EmptySuite.xml file
2.Right click and hover to Run As and click on TestNG Test



###Verifying Bulk Inventory Update

Code:

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="TestSuite">
	<test name="Demo">
<classes>

<class name="TestScripts.WebHook">
            <!-- start with bulk inventory update -->
			<method name="verifyingBulkInventoryUpdate"></method>
			<!-- end with bulk inventory update -->
</class>

</classes>

</test>
</suite>

Steps to run the script:
1.Paste the above code in the EmptySuite.xml file
2.Right click and hover to Run As and click on TestNG Test



###Verifying Create Product With Existing Product Type

Code:

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="TestSuite">
	<test name="Demo">
<classes>

<class name="TestScripts.WebHook">
            <!-- start with creating product for existing product type -->
			<method name="verifyingCreateProductWithExistingProductType"></method>
			<!-- end with creating product for existing product type -->
</class>

</classes>

</test>
</suite>

Steps to run the script:
1.Paste the above code in the EmptySuite.xml file
2.Right click and hover to Run As and click on TestNG Test



###Verifying Tags Update for Simple Products

Code:

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="TestSuite">
	<test name="Demo">
<classes>

<class name="TestScripts.WebHook">
            <!-- start with tags update -->
			<method name="verifyingTagsUpdateforSimpleProducts"></method>
			<!-- end with tags update -->
</class>

</classes>

</test>
</suite>

Steps to run the script:
1.Paste the above code in the EmptySuite.xml file
2.Right click and hover to Run As and click on TestNG Test



###Verifying Update Inventory After Creating Order

Code:

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="TestSuite">
	<test name="Demo">
<classes>

<class name="TestScripts.WebHook">
			<!-- start with update inventory after creating order -->
			<method name="VerifyingUpdateInventoryAfterCreatingOrder"></method>
			<!-- end with update inventory after creating order -->
</class>

</classes>

</test>
</suite>

Steps to run the script:
1.Paste the above code in the EmptySuite.xml file
2.Right click and hover to Run As and click on TestNG Test



###Verifying After Refund Inventory Stock is Added Back

Code:

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="TestSuite">
	<test name="Demo">
<classes>

<class name="TestScripts.WebHook">
			<!-- start with after Refund inventory stock is added back  -->
			<method name="verifyingAfterRefundInventoryStockisAddedBack"></method>
			<!-- end with after Refund inventory stock is added back  -->
</class>

</classes>

</test>
</suite>

Steps to run the script:
1.Paste the above code in the EmptySuite.xml file
2.Right click and hover to Run As and click on TestNG Test



###Verifying If Sync Disable Then Not Updating

Code:

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="TestSuite">
	<test name="Demo">
<classes>

<class name="TestScripts.WebHook">
			<!-- start with sync disable then not updating -->
			<method name="verifyingIfSyncDisableThenNotUpdating"></method>
			<!-- end with sync disable then not updating -->
</class>

</classes>

</test>
</suite>

Steps to run the script:
1.Paste the above code in the EmptySuite.xml file
2.Right click and hover to Run As and click on TestNG Test



###Verifying If Sync Disable Then Variant Not Updating

Code:

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="TestSuite">
	<test name="Demo">
<classes>

<class name="TestScripts.WebHook">
			<!-- start with sync disable then variant is not updating -->
			<method name="verifyingIfSyncDisableThenVariantNotUpdating"></method>
			<!-- end with sync disable then variant is not updating -->

</class>

</classes>

</test>
</suite>

Steps to run the script:
1.Paste the above code in the EmptySuite.xml file
2.Right click and hover to Run As and click on TestNG Test



###Verifying No Product Created When Auto Product Create Is Off

Code:

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="TestSuite">
	<test name="Demo">
<classes>

<class name="TestScripts.WebHook">
			<!-- start with no product created when auto product create is disabled -->
			<method name="verifyingNoProductCreatedWhenAutoProductCreateIsOff"></method>
			<!-- end with no product created when auto product create is disabled -->
</class>

</classes>

</test>
</suite>

Steps to run the script:
1.Paste the above code in the EmptySuite.xml file
2.Right click and hover to Run As and click on TestNG Test



###Verifying If Sync Disabled For A Particular Attribute Then Not Updating

Code:

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="TestSuite">
	<test name="Demo">
<classes>

<class name="TestScripts.WebHook">
			<!-- start with  sync disabled for an atttribute then not updating -->
			<method name="verifyingIfSyncDisabledForAParticularAttributeThenNotUpdating"></method>
			<!-- end with  sync disabled for an atttribute then not updating -->
</class>

</classes>

</test>
</suite>

Steps to run the script:
1.Paste the above code in the EmptySuite.xml file
2.Right click and hover to Run As and click on TestNG Test



###Verifying When Import Limit Reached Delete 1 Variant Add 2 Variant Then 1 Variant Should Be Added

Code:

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="TestSuite">
	<test name="Demo">
<classes>

<class name="TestScripts.WebHook">
			<!-- start with Import Limit reached -->
			<method name="verifyingWhenImportLimitReachedDelete1VariantAdd2VariantThen1VariantShouldBeAdded"></method>
			<!-- end with Import Limit reached -->
</class>

</classes>

</test>
</suite>

Steps to run the script:
1.Paste the above code in the EmptySuite.xml file
2.Right click and hover to Run As and click on TestNG Test




###To run all the above script of WebHook in one go

Code:

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="TestSuite">
	<test name="Demo">
<classes>

<class name="TestScripts.WebHook">
            <!-- start with creating a new product -->
			<method name="verifyingNewProductCreatedInWalmart"></method>
			<!-- end with creating a new product -->
			
			<!-- start with updating simple products attributes -->
			<method name="updatingSimpleProductAttributesandVerifyingInWalmart"></method>
			<!-- end with updating simple products attributes -->
			
			<!-- start with updating variant product attributes -->
			<method name="updatingParametersForVariantsandVerifyingInWalmart"></method>
			<!-- end with updating variant product attributes -->
			
			<!-- start with add variant for products having variant -->
			<method name="verifyingAddVariantForProductHavingVariants"></method>
			<!-- end with add variant for products having variant -->
			
			<!-- start with verifyingDuplicateSkuUpdate -->
			<method name="verifyingDuplicateSkuUpdate"></method>
			<!-- end with verifyingDuplicateSkuUpdate -->
			
			<!-- start with inventory policy and inventory management -->
			<method name="verifyingInventoryPolicyandInventoryManagement"></method>
			<!-- end with inventory policy and inventory management -->
			
			<!-- start with delete variant -->
			<method name="verifyingDeleteVariant"></method>
			<!-- end with delete variant -->
			
			<!-- start with delete product -->
			<method name="verifyingDeleteProduct"></method>
			<!-- end with delete product -->
			
			<!-- start with inventory policy and inventory management for variants -->
			<method name="verifyingInventoryPolicyandInventoryManagementForVariants"></method>
			<!-- end with inventory policy and inventory management for variants -->
			
			<!-- start with bulk inventory update -->
			<method name="verifyingBulkInventoryUpdate"></method>
			<!-- end with bulk inventory update -->
			
			<!-- start with creating product for existing product type -->
			<method name="verifyingCreateProductWithExistingProductType"></method>
			<!-- end with creating product for existing product type -->
			
			<!-- start with tags update -->
			<method name="verifyingTagsUpdateforSimpleProducts"></method>
			<!-- end with tags update -->
			
			<!-- start with update inventory after creating order -->
			<method name="VerifyingUpdateInventoryAfterCreatingOrder"></method>
			<!-- end with update inventory after creating order -->
			
			<!-- start with after Refund inventory stock is added back  -->
			<method name="verifyingAfterRefundInventoryStockisAddedBack"></method>
			<!-- end with after Refund inventory stock is added back  -->
			
			<!-- start with sync disable then not updating -->
			<method name="verifyingIfSyncDisableThenNotUpdating"></method>
			<!-- end with sync disable then not updating -->
			
			<!-- start with sync disable then variant is not updating -->
			<method name="verifyingIfSyncDisableThenVariantNotUpdating"></method>
			<!-- end with sync disable then variant is not updating -->
			
			
			<!-- start with no product created when auto product create is disabled -->
			<method name="verifyingNoProductCreatedWhenAutoProductCreateIsOff"></method>
			<!-- end with no product created when auto product create is disabled -->
			
			<!-- start with  sync disabled for an atttribute then not updating -->
			<method name="verifyingIfSyncDisabledForAParticularAttributeThenNotUpdating"></method>
			<!-- end with  sync disabled for an atttribute then not updating -->
			
			<!-- start with Import Limit reached -->
			<method name="verifyingWhenImportLimitReachedDelete1VariantAdd2VariantThen1VariantShouldBeAdded"></method>
			<!-- end with Import Limit reached -->
						
			</class>
</classes>

</test>
</suite>

Steps to run the script:
1.Paste the above code in the EmptySuite.xml file
2.Right click and hover to Run As and click on TestNG Test

