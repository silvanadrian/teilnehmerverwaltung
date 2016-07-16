package ch.zehndersystems.view;
import ch.zehndersystems.MainApp;
import ch.zehndersystems.model.Firma;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class FirmaOverviewController {
	@FXML
    private TableView<Firma> firmaTable;
    @FXML
    private TableColumn<Firma, String> corpNameColumn;
    @FXML
    private TableColumn<Firma, String> addressColumn;
    @FXML
    private TableColumn<Firma, String> zipColumn;
    @FXML
    private TableColumn<Firma, String> cityColumn;
    
    @FXML
    private Label corpNameLabel;
    @FXML
    private Label addressLabel;
    @FXML
    private Label zipLabel;
    @FXML
    private Label cityLabel;


    private MainApp mainApp;
    
    public FirmaOverviewController() {
    }
    
    
    @FXML
    private void initialize() {
    	corpNameColumn.setCellValueFactory(cellData -> cellData.getValue().getCorpNameProperty());
    	addressColumn.setCellValueFactory(cellData -> cellData.getValue().getAddressProperty());
    	zipColumn.setCellValueFactory(cellData -> cellData.getValue().getZipcodeProperty());
    	cityColumn.setCellValueFactory(cellData -> cellData.getValue().getCityProperty());

        showFirmaDetails(null);
        
        firmaTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showFirmaDetails(newValue));
    }
    
    @FXML
    private void handleDeleteFirma() {
        int selectedIndex = firmaTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
        	firmaTable.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Firma Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }

    }
    
    @FXML
    private void handleNewFirma() {
        Firma tempFirma = new Firma();
        boolean okClicked = mainApp.showFirmaEditDialog(tempFirma);
        if (okClicked) {
            mainApp.getFirmaData().add(tempFirma);
        }
    }

    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected person.
     */
    @FXML
    private void handleEditFirma() {
        Firma selectedFirma = firmaTable.getSelectionModel().getSelectedItem();
        if (selectedFirma != null) {
            boolean okClicked = mainApp.showFirmaEditDialog(selectedFirma);
            if (okClicked) {
                showFirmaDetails(selectedFirma);
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
        firmaTable.setItems(mainApp.getFirmaData());
    }
    
    private void showFirmaDetails(Firma firma) {
        if (firma != null) {
            // Fill the labels with info from the person object.
            corpNameLabel.setText(firma.getCorpName());
            addressLabel.setText(firma.getAddress());
            cityLabel.setText(firma.getCity());
            zipLabel.setText(firma.getZipcode());
        } else {
            // Person is null, remove all the text.
            corpNameLabel.setText("");
            addressLabel.setText("");
            cityLabel.setText("");
            zipLabel.setText("");
        }
    }
    
}
