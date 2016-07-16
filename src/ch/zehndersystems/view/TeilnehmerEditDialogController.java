package ch.zehndersystems.view;

import ch.zehndersystems.MainApp;
import ch.zehndersystems.model.Firma;
import ch.zehndersystems.model.Teilnehmer;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TeilnehmerEditDialogController {
	@FXML
    private TextField firstnameField;
	@FXML
    private TextField lastnameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField telephoneField;
    @FXML
    private ComboBox<Firma> firmaField;
    
    private MainApp mainApp;

    private Stage dialogStage;
    private Teilnehmer teilnehmer;
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

    
    public void setTeilnehmer(Teilnehmer teilnehmer) {
        this.teilnehmer = teilnehmer;

        firstnameField.setText(teilnehmer.getFirstname());
        lastnameField.setText(teilnehmer.getLastname());
        emailField.setText(teilnehmer.getEmail());
        telephoneField.setText(teilnehmer.getTelephone());
        firmaField.setItems(mainApp.getFirmaData());
        firmaField.setValue(teilnehmer.getFirma());
    }

    public boolean isOkClicked() {
        return okClicked;
    }


    @FXML
    private void handleOk() {
        if (isInputValid()) {
            teilnehmer.setFirstname(firstnameField.getText());
            teilnehmer.setLastname(lastnameField.getText());
            teilnehmer.setEmail(emailField.getText());
            teilnehmer.setTelephone(telephoneField.getText());
            teilnehmer.setFirma(firmaField.getValue());


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
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    /**
     * Validates the user input in the text fields.
     * 
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (firstnameField.getText() == null || firstnameField.getText().length() == 0) {
            errorMessage += "Kein valider Vorname!\n"; 
        }
        if (lastnameField.getText() == null || lastnameField.getText().length() == 0) {
            errorMessage += "Kein valider Nachname!\n"; 
        }
        if (telephoneField.getText() == null || telephoneField.getText().length() == 0) {
            errorMessage += "Keine valide Telefonnummer!\n"; 
        }
        if (emailField.getText() == null || emailField.getText().length() == 0) {
            errorMessage += "Keine valide E-Mail Adresse!\n"; 
        }
        if (firmaField.getValue() == null) {
            errorMessage += "Keine valide Firma!\n"; 
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
