package ch.zehndersystems;


import java.io.IOException;

import ch.zehndersystems.model.Firma;
import ch.zehndersystems.model.Teilnehmer;
import ch.zehndersystems.view.TeilnehmerEditDialogController;
import ch.zehndersystems.view.TeilnehmerOverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {
	
	private Stage primaryStage;
	private BorderPane rootLayout;
    private ObservableList<Teilnehmer> teilnehmerData = FXCollections.observableArrayList();
    private ObservableList<Firma> firmaData = FXCollections.observableArrayList();

    
    public MainApp() {
        // Add some sample data
    	Firma firma1 = new Firma("Test 1","Dorstrasse 36", "8000", "Zürich");
    	Firma firma2 = new Firma("Test 2","Dorstrasse 36", "8000", "Zürich");
    	Firma firma3 = new Firma("Test 3","Dorstrasse 36", "8000", "Zürich");
    	Firma firma4 = new Firma("Test 4","Dorstrasse 36", "8000", "Zürich");
    	Firma firma5 = new Firma("Test 5","Dorstrasse 36", "8000", "Zürich");
    	Firma firma6 = new Firma("Test 6","Dorstrasse 36", "8000", "Zürich");
    	Firma firma7 = new Firma("Test 7","Dorstrasse 36", "8000", "Zürich");
    	Firma firma8 = new Firma("Test 8","Dorstrasse 36", "8000", "Zürich");
    	Firma firma9 = new Firma("Test 9","Dorstrasse 36", "8000", "Zürich");
    	
    	firmaData.add(firma1);
    	firmaData.add(firma2);
    	firmaData.add(firma3);
    	firmaData.add(firma4);
    	firmaData.add(firma5);
    	firmaData.add(firma6);
    	firmaData.add(firma7);
    	firmaData.add(firma8);
    	firmaData.add(firma9);

    	
        teilnehmerData.add(new Teilnehmer("Hans", "Muster", "0445201212", "hans.muster@bluewin.ch",firma1));
        teilnehmerData.add(new Teilnehmer("Ruth", "Mueller", "0445201212", "hans.muster@bluewin.ch",firma2));
        teilnehmerData.add(new Teilnehmer("Heinz", "Kurz", "0445201212", "hans.muster@bluewin.ch", firma3));
        teilnehmerData.add(new Teilnehmer("Cornelia", "Meier", "0445201212", "hans.muster@bluewin.ch",firma4));
        teilnehmerData.add(new Teilnehmer("Werner", "Meyer", "0445201212", "hans.muster@bluewin.ch",firma5));
        teilnehmerData.add(new Teilnehmer("Lydia", "Kunz", "0445201212", "hans.muster@bluewin.ch",firma6));
        teilnehmerData.add(new Teilnehmer("Anna", "Best", "0445201212", "hans.muster@bluewin.ch",firma7));
        teilnehmerData.add(new Teilnehmer("Stefan", "Meier", "0445201212", "hans.muster@bluewin.ch",firma8));
        teilnehmerData.add(new Teilnehmer("Martin", "Mueller", "0445201212", "hans.muster@bluewin.ch",firma9));
        
        
    }
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Kursverwaltung Zehnder Systems");
		
		initRootLayout();
		
		showKursverwaltungOverview();
	}
	
	/**
	 * Show root Layout
	 */
	
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Load Kursverwaltung Overview
     */
    public void showKursverwaltungOverview() {
        try {
            // Load Kursverwaltung overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/kursverwaltung.fxml"));
            AnchorPane kursverwaltungOverview = (AnchorPane) loader.load();
            
            // Give the controller access to the main app.
            TeilnehmerOverviewController controller = loader.getController();
            controller.setMainApp(this);
            
            // Set kursverwaltung overview into the center of root layout.
            rootLayout.setCenter(kursverwaltungOverview);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public boolean showTeilnehmerEditDialog(Teilnehmer teilnehmer) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/TeilnehmerEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Person");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            TeilnehmerEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setTeilnehmer(teilnehmer);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    
    public ObservableList<Teilnehmer> getTeilnehmerData() {
        return teilnehmerData;
    }
    
    public ObservableList<Firma> getFirmaData() {
        return firmaData;
    }
    
    public Stage getPrimaryStage() {
    	return primaryStage;
    }

	public static void main(String[] args) {
		launch(args);
	}
}
