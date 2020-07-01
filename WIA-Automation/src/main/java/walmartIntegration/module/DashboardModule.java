package walmartIntegration.module;

import java.io.IOException;

import walmartIntegration.pages.DashboardPage;

public class DashboardModule {
DashboardPage dash;


	public DashboardModule() {
		dash=new DashboardPage();
	}
	
	
	public void LoggingInAccount() throws InterruptedException {
		dash.LoggingInAccount();
	}
	
	public void ClickingAllLinks() {
		dash.ClickingAllLinks();
	}
	
	public void ClickingAllOptions() throws InterruptedException {
		dash.ClickingAllOptions();
	}
	
	public void VerifyingSyncWithShopify() throws InterruptedException, IOException {
		dash.VerifyingSyncWithShopify();
	}
	
}
