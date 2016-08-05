package ch.zehndersystems.view;

import ch.zehndersystems.model.Firma;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FirmaEditDialogController {
	
	@FXML
    private TextField corpnameField;
	@FXML
    private TextField addressField;
    @FXML
    private TextField zipField;
    @FXML
    private TextField cityField;

    private Stage dialogStage;
    private Firma firma;
    private boolean okClicked = false;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    
    public void setFirma(Firma firma) {
        this.firma = firma;
        
        corpnameField.setText(firma.getCorpName());
        addressField.setText(firma.getAddress());
        zipField.setText(firma.getZipcode());
        cityField.setText(firma.getCity());
    }

    public boolean isOkClicked() {
        return okClicked;
    }


    @FXML
    private void handleOk() {
        if (isInputValid()) {
            firma.setCorpName(corpnameField.getText());
            firma.setAddress(addressField.getText());
            firma.setZipcode(zipField.getText());
            firma.setCity(cityField.getText());


            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     * 
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (corpnameField.getText() == null || corpnameField.getText().length() == 0) {
            errorMessage += "Kein valider Firmenname!\n"; 
        }
        if (addressField.getText() == null || addressField.getText().length() == 0) {
            errorMessage += "Kein valide Adresse!\n"; 
        }
        if (zipField.getText() == null || zipField.getText().length() == 0) {
            errorMessage += "Keine valide PLZ!\n"; 
        }
        if (cityField.getText() == null || cityField.getText().length() == 0) {
            errorMessage += "Keine valide Stadt!\n"; 
        }


        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Ungültige Felder");
            alert.setHeaderText("Bitte ungültige Felder korrigieren");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
	
}
