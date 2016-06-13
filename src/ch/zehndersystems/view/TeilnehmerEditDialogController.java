package ch.zehndersystems.view;

import ch.zehndersystems.model.Teilnehmer;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TeilnehmerEditDialogController {
	@FXML
    private ComboBox salutation;
	@FXML
    private TextField firstnameField;
	@FXML
    private TextField lastnameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField telephoneField;

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
    }

    public boolean isOkClicked() {
        return okClicked;
    }


    @FXML
    private void handleOk() {
        if (isInputValid()) {
            teilnehmer.setFirstname(firstnameField.getText());
            teilnehmer.setLastname(lastnameField.getText());
            teilnehmer.setTelephone(telephoneField.getText());
            teilnehmer.setEmail(emailField.getText());


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


        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
	
}
