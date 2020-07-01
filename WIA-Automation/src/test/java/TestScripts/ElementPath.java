package TestScripts;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementPath {
        WebDriver driver;

    //Web Elements Locator

    @FindBy(how = How.XPATH, using = "//*[contains(@class,'shopify-button') and text()='Install App']")
    public WebElement InstallAppButton;

    @FindBy(how = How.XPATH, using = "//*[@class='ui-app-store-hero__cta']/child::a[contains(text(),'Add app')]")
    public WebElement AddAppButton;

    @FindBy(how = How.XPATH, using = "//*[contains(@class,'marketing-input-wrapper')]/child::span[contains(text(),'Your store’s URL')]/following-sibling::input")
    public WebElement ShopifyUrlTextbox;

    @FindBy(how = How.XPATH, using = "//label[contains(@class,'next-label') and text()='Email']/following-sibling::input")
    public WebElement ShopifyLoginMail;

    @FindBy(how = How.XPATH, using = "//button[contains(@class,'ui-button') and text()='Next']")
    public WebElement NextButton;

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'next-field__connected-wrapper ui-password')]/child::input")
    public WebElement ShopifyPassword;

    @FindBy(how = How.XPATH, using = "//button[contains(@class,'ui-button') and text()='Log in']")
    public WebElement LoginButton;

    @FindBy(how = How.XPATH, using = "//span[contains(@class,'Polaris-Navigation__Text') and text()='Product']")
    public WebElement Product_Module;

    @FindBy(how = How.XPATH, using = "//li[@class='Polaris-Navigation__Item']/a[contains(text(),'Manage Products')]")
    public WebElement Product_ManageProduct;
    @FindBy(how = How.XPATH, using = "(//span[@class='Polaris-Checkbox'])[1]")
    public WebElement FirstCheckbox;
    @FindBy(how = How.XPATH, using = "//li[@class='next']/a[contains(text(),'»')]")
    public WebElement Pagination;
    @FindBy(how = How.XPATH, using = "//div[@class='action-summary']/following::a[contains(@class,'select_all_link')]")
    public WebElement SelectAllItems;
    @FindBy(how = How.XPATH, using = "//button[contains(@class,'Polaris-Button Polaris-Button--primary')]/following::span[contains(@class,'Polaris-Button__Content')]/child::span[contains(text(),'Ok')]")
    public WebElement Okbutton;
    @FindBy(how = How.XPATH, using = "//div[@class='actions-bulk']/following::select[@id='product_select']")
    public WebElement BulkActionDropdown;
    @FindBy(how = How.XPATH, using = "//div[@class='actions-bulk']/following::select[@id='product_select']/child::option[contains(text(),'Sync With Shopify')]")
    public WebElement SyncwithShopify;
    @FindBy(how = How.XPATH, using = "//div[@class='custom_polaris_bulk_action']/div/child::div[@class='actions-bulk']/child::button")
    public WebElement ActionButton;
    @FindBy(how = How.XPATH, using = "//button[@id='sync-yes']/span")
    public WebElement SyncButton;
    @FindBy(how = How.XPATH, using = "//div[@class='actions-bulk']/following::select[@id='product_select']/child::option[contains(text(),'Update Inventory')]")
    public WebElement UpdateInventory;
    @FindBy(how = How.XPATH, using = "//div[@class='actions-bulk']/following::select[@id='product_select']/child::option[contains(text(),'Update Price')]")
    public WebElement UpdatePrice;
    @FindBy(how = How.XPATH, using = "//div[@class='Polaris-Banner__Heading']/span[@id='errorHeading']")
    public WebElement ErrorMessage;
    @FindBy(how = How.XPATH, using = "//span[@class='Polaris-Button__Content']/child::span[contains(text(),'Back To Previous')]")
    public WebElement BacktoPreviousButton;
    @FindBy(how = How.XPATH, using = "//div[@class='Polaris-Page-Header__PrimaryAction']/following::span/child::span[contains(text(),'Update Status')]")
    public WebElement UpdateStatusButton;
    @FindBy(how = How.XPATH, using = "//div[@class='custom-message-wrap  pt-15']/child::div/child::div/child::div")
    public WebElement ErrorMessageforUpdateStatus;

    @FindBy(how = How.XPATH, using = "//span[contains(@class,'Polaris-Navigation__Text') and text()='Dashboard']")
    public WebElement Dashboard;
    @FindBy(how = How.XPATH, using = "//li[@class='Polaris-Navigation__Item']/a[contains(text(),'Category Mapping')]")
    public WebElement Product_CategoryMapping;
    @FindBy(how = How.XPATH, using = "//ul[@class='Polaris-Navigation__List']//a[contains(text(),'Attribute Mapping')]")
    public WebElement Product_AttributeMapping;
    @FindBy(how = How.XPATH, using = "//ul[@class='Polaris-Navigation__List']//a[contains(text(),'Product Taxcode')]")
    public WebElement Product_ProductTaxcode;
    @FindBy(how = How.XPATH, using = "//ul[@class='Polaris-Navigation__List']//a[contains(text(),'Repricing')]")
    public WebElement Product_Repricing;
    @FindBy(how = How.XPATH, using = "//ul[@class='Polaris-Navigation__List']//a[contains(text(),'Lag Time')]")
    public WebElement Product_LagTime;
    @FindBy(how = How.XPATH, using = "//ul[@class='Polaris-Navigation__List']//a[contains(text(),'Share Product')]")
    public WebElement Product_ShareProduct;
    @FindBy(how = How.XPATH, using = "//ul[@class='Polaris-Navigation__List']//a[contains(text(),'Not In App Products')]")
    public WebElement Product_NotInAppProducts;
    @FindBy(how = How.XPATH, using = "//span[contains(@class,'Polaris-Navigation__Text') and text()='Import Products']")
    public WebElement ImportProducts;
    @FindBy(how = How.XPATH, using = "//span[contains(@class,'Polaris-Navigation__Text') and text()='Walmart Feeds']")
    public WebElement WalmartFeeds;
    @FindBy(how = How.XPATH, using = "//span[contains(@class,'Polaris-Navigation__Text') and text()='Order']")
    public WebElement Order;
    @FindBy(how = How.XPATH, using = "//li[@class='Polaris-Navigation__Item']/a[contains(text(),'Sales Order')]")
    public WebElement Order_SalesOrder;
    @FindBy(how = How.XPATH, using = "//ul[@class='Polaris-Navigation__List']//a[contains(text(),'Failed Order')]")
    public WebElement Order_FailedOrder;
    @FindBy(how = How.XPATH, using = "//span[contains(@class,'Polaris-Navigation__Text') and text()='Import Export']")
    public WebElement ImportExport;
    @FindBy(how = How.XPATH, using = "//li[@class='Polaris-Navigation__Item']/a[contains(text(),'Product Update')]")
    public WebElement ImportExport_ProductUpdate;
    @FindBy(how = How.XPATH, using = "//li[@class='Polaris-Navigation__Item']/a[contains(text(),'Retire Product')]")
    public WebElement ImportExport_RetireProduct;
    @FindBy(how = How.XPATH, using = "//ul[@class='Polaris-Navigation__List']//a[contains(text(),'Upload Product')]")
    public WebElement ImportExport_UploadProduct;
    @FindBy(how = How.XPATH, using = "//ul[@class='Polaris-Navigation__List']//a[contains(text(),'Advanced Attributes')]")
    public WebElement ImportExport_AdvancedAttributes;
    @FindBy(how = How.XPATH, using = "//ul[@class='Polaris-Navigation__List']//a[contains(text(),'Shipping Exceptions')]")
    public WebElement ImportExport_ShippingExceptions;
    @FindBy(how = How.XPATH, using = "//span[contains(@class,'Polaris-Navigation__Text') and text()='Promotion']")
    public WebElement Promotion;
    @FindBy(how = How.XPATH, using = "//li[@class='Polaris-Navigation__Item']/a[contains(text(),'Manage Promotion')]")
    public WebElement Promotion_ManagePromotion;
    @FindBy(how = How.XPATH, using = "//li[@class='Polaris-Navigation__Item']/a[contains(text(),'Promotion Feed')]")
    public WebElement Promotion_PromotionFeed;

    @FindBy(how = How.XPATH, using = "//div[@class='input-container']/div/div/child::input")
    public WebElement shopifyurl;

    @FindBy(how = How.XPATH, using = "//div[@class='Polaris-ResourceItem']/child::a[contains(@href,'facebook-marketplace')]")
    public WebElement FacebookMarketplaceLink;
    
    @FindBy(how = How.XPATH, using = "//div[@class='Polaris-ResourceItem']/child::a[contains(@href,'wish-marketplace')]")
    public WebElement WishMarketplaceLink;
    
    @FindBy(how = How.XPATH, using = "//div[@class='Polaris-ResourceItem']/child::a[contains(@href,'etsy-marketplace')]")
    public WebElement EtsyMarketplaceLink;
    @FindBy(how = How.XPATH, using = "//div[@class='Polaris-ResourceItem']/child::a[contains(@href,'sears-marketplace')]")
    public WebElement SearsMarketplaceLink;
    @FindBy(how = How.XPATH, using = "//div[@class='Polaris-ResourceItem']/child::a[contains(@href,'tophatter-marketplace')]")
    public WebElement TophatterMarketplaceLink;
    
    @FindBy(how = How.XPATH, using = "(//div[@class='Polaris-Stack__Item']/child::a)[1]")
    public WebElement AllProductsLink;
    @FindBy(how = How.XPATH, using = "(//div[@class='Polaris-Stack__Item']/child::a)[2]")
    public WebElement AllOrdersLink;
    
    @FindBy(how = How.XPATH, using = "//span[@class='Polaris-Button__Content']/child::span[contains(text(),'Know More')]")
    public WebElement KnowMoreLink;
    
    @FindBy(how = How.XPATH, using = "(//div[@class='Polaris-ResourceItem']/child::a[contains(@href,'/view?id=11')])[2]")
    public WebElement PauseSalesLink;
    
    @FindBy(how = How.XPATH, using = " (//div[@class='Polaris-ResourceItem__Content']/child::p[contains(text(),'Tax systems')])[1]")
    public WebElement TaxSystemsLink;
    
    @FindBy(how = How.XPATH, using = "  (//div[@class='Polaris-ResourceItem__Content']/child::p[contains(text(),'Restricted Product')])[1]")
    public WebElement RestrictedProductLink;
   
    @FindBy(how = How.XPATH, using = "  (//div[@class='Polaris-ResourceItem__Content']/child::p[contains(text(),'Import/Export')])[1]")
    public WebElement ImportExportLink;
    
    @FindBy(how = How.XPATH, using = "  //ul[@class='list-inline']/following::li[@class='twitter']/a")
    public WebElement TwitterLink;
    
    @FindBy(how = How.XPATH, using = "  //ul[@class='list-inline']/following::li[@class='facebook']/a")
    public WebElement FacebookLink;

    @FindBy(how = How.XPATH, using = "  //ul[@class='list-inline']/following::li[@class='linkedin']/a")
    public WebElement LinkedinLink;
    
    @FindBy(how = How.XPATH, using = "  //ul[@class='list-inline']/following::li[@class='youtube']/a")
    public WebElement YoutubeLink;
    
    @FindBy(how = How.XPATH, using = " //div[@class='Polaris-TextContainer']/p")
    public WebElement RightContent;
}
