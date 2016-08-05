package ch.zehndersystems.view;

import ch.zehndersystems.MainApp;

import javafx.fxml.FXML;

public class RootLayoutController {
	
	@FXML private TeilnehmerOverviewController teilnehmerTabPageController;
	@FXML private FirmaOverviewController firmaTabPageController;

	// Reference to the main application
    private MainApp mainApp;
    
    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        teilnehmerTabPageController.setMainApp(mainApp);
        firmaTabPageController.setMainApp(mainApp);
    }



    /**
     * Closes the application.
     */
    @FXML
    private void handleExit() {
        System.exit(0);
    }
}
