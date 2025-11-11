package Controller;

import Model.DailyTuneEntry; 
import java.awt.Desktop;
import java.net.URI;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory; 

public class DailyTuneController implements Initializable {

   
    @FXML
    private TextField titleField;
    @FXML
    private TextField artistField;
    @FXML
    private DatePicker datePicker;
    @FXML
    private Hyperlink songLink;

    
    @FXML
    private TableView<DailyTuneEntry> tableView; 
    @FXML
    private TableColumn<DailyTuneEntry, String> titleColumn; 
    @FXML
    private TableColumn<DailyTuneEntry, String> artistColumn; 
    @FXML
    private TableColumn<DailyTuneEntry, LocalDate> dateColumn; 

    
    private ObservableList<DailyTuneEntry> dataList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        artistColumn.setCellValueFactory(new PropertyValueFactory<>("artist"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        
        
        tableView.setItems(dataList);
    }   

    @FXML
    void OpenLink(ActionEvent event) {
        System.out.println("Tombol OpenLink diklik");
        try {
            if (Desktop.isDesktopSupported()) {
                
                Desktop.getDesktop().browse(new URI("https://open.spotify.com"));
                
            } else {
                System.out.println("Desktop tidak mendukung operasi browse.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    
    @FXML
    void handleAdd(ActionEvent event) {
        
        String title = titleField.getText();
        String artist = artistField.getText();
        LocalDate date = datePicker.getValue();

        
        if (title.isEmpty() || artist.isEmpty() || date == null) {
            System.out.println("Data belum lengkap!"); 
            return;
        }

       
        DailyTuneEntry newEntry = new DailyTuneEntry(title, artist, date);

        
        dataList.add(newEntry);

        
        clearFields();
    }

    @FXML
    void handleDelete(ActionEvent event) {
        
        
        DailyTuneEntry selected = tableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            
            dataList.remove(selected);
        } else {
            System.out.println("Pilih data yang ingin dihapus");
        }
    }

    @FXML
    void handleEdit(ActionEvent event) {
        
        System.out.println("Tombol Edit diklik");
    }
    
    private void clearFields() {
        titleField.clear();
        artistField.clear();
        datePicker.setValue(null);
    }
}