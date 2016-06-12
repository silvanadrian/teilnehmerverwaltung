package ch.zehndersystems.view;

import ch.zehndersystems.MainApp;
import ch.zehndersystems.model.Teilnehmer;
import javafx.fxml.FXML;

public class RootLayoutController {
	// Reference to the main application
    private MainApp mainApp;
    

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }



    /**
     * Closes the application.
     */
    @FXML
    private void handleExit() {
        System.exit(0);
    }
}
