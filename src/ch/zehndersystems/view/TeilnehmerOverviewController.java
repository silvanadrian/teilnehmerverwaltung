package ch.zehndersystems.view;
import ch.zehndersystems.MainApp;
import ch.zehndersystems.model.Teilnehmer;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TeilnehmerOverviewController {
	@FXML
    private TableView<Teilnehmer> teilnehmerTable;
    @FXML
    private TableColumn<Teilnehmer, String> firstNameColumn;
    @FXML
    private TableColumn<Teilnehmer, String> emailColumn;

    @FXML
    private Label firstNameLabel;
    @FXML
    private Label emailLabel;


    private MainApp mainApp;
    
    public TeilnehmerOverviewController() {
    }
    
    
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
        emailColumn.setCellValueFactory(cellData -> cellData.getValue().getEmailProperty());
        showTeilnehmerDetails(null);
        
        teilnehmerTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showTeilnehmerDetails(newValue));
    }
    
    @FXML
    private void handleDeleteTeilnehmer() {
        int selectedIndex = teilnehmerTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
        	teilnehmerTable.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }

    }
    
    @FXML
    private void handleNewTeilnehmer() {
        Teilnehmer tempTeilnehmer = new Teilnehmer();
        boolean okClicked = mainApp.showTeilnehmerEditDialog(tempTeilnehmer);
        if (okClicked) {
            mainApp.getTeilnehmerData().add(tempTeilnehmer);
        }
    }

    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected person.
     */
    @FXML
    private void handleEditTeilnehmer() {
        Teilnehmer selectedTeilnehmer = teilnehmerTable.getSelectionModel().getSelectedItem();
        if (selectedTeilnehmer != null) {
            boolean okClicked = mainApp.showTeilnehmerEditDialog(selectedTeilnehmer);
            if (okClicked) {
                showTeilnehmerDetails(selectedTeilnehmer);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        teilnehmerTable.setItems(mainApp.getTeilnehmerData());
    }
    
    private void showTeilnehmerDetails(Teilnehmer teilnehmer) {
        if (teilnehmer != null) {
            // Fill the labels with info from the person object.
            firstNameLabel.setText(teilnehmer.getName());
            emailLabel.setText(teilnehmer.getEmail());
        } else {
            // Person is null, remove all the text.
            firstNameLabel.setText("");
            emailLabel.setText("");
        }
    }
    
}
