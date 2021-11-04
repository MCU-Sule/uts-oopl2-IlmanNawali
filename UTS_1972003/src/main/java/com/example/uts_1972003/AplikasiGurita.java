/**
 * Ilman Nawali 1972003
 */
package com.example.uts_1972003;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AplikasiGurita extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AplikasiGurita.class.getResource("SquidStage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Squid Game Application");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}