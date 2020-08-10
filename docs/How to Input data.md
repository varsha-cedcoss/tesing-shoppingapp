#How to Input Data?

For any test script, like ManageProducts.java, i have made a separate csv file named ManageProducts.csv. The csv file can be found under src/main/resources.
The data has to be input in this csv file only.



##How to make a Table?
1.To make a table, choose a table name, e.g-Shop_Url
2.Put it in starting cell
3.Now leave that row and column.It means you dont have to write anything in the row and column for the cell in which you have given table name.
4.Now input shop urls in the column next to the cell in which you have given table name, but not in the same row as table name.
5.After inputting shop urls, end the table with table name.Now to end the table , you have to give table name in the next column and the next row where you data has ended.

###Where to put Table name and File Name

1.Firstly, you have to go to src/test/java.Then to TestScripts, and then to the desired script that you want to run,e.g-ManageProducts.java.
2.Then, you will see something like this: @DataProviderParams({ "fileName=InputData.csv", "tableName=ManageProd_ShopNames" })
3.Now, enter the File name and Table name there, for the methods that you want to run.


####Example
In the docs file, a ManageProducts.csv is present.In this csv, i have given table name as "SyncWithShopify".Inside the table, there are 2 shop urls, shopUrl1 and shopUrl2.

Now,our @DataProviderParams will look like this:

@DataProviderParams({ "fileName=ManageProducts.csv", "tableName=SyncWithShopify" })

