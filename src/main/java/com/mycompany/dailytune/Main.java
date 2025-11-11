package com.mycompany.dailytune;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        try {
            
            Parent root = FXMLLoader.load(getClass().getResource("/View/DailyTuneView.fxml"));

            Scene scene = new Scene(root, 650, 450);

            

            stage.setTitle("DailyTune - Catatan Lagu Harian");
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}