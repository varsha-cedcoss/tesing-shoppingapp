package GoogleIntegration.module;

import GoogleIntegration.pages.ImportUpload_Page;

public class ImportUpload_Module {
	ImportUpload_Page impP;
	
	public ImportUpload_Module() {
		impP=new ImportUpload_Page();
	}
	
	public void goToImportUploadSection(){
		impP.goToImportUploadSection();
	}
	
	public void importingProductFromDefaultProfile(){
		impP.importingProductFromDefaultProfile();
	}
	
	public void uploadingDefaultProfileProductFromAppToGoogle() {
		impP.uploadingDefaultProfileProductFromAppToGoogle();
	}
	
	public void uploadingCustomProfileProduct(String profileName) {
		impP.uploadingCustomProfileProduct(profileName);
	}
	
}
