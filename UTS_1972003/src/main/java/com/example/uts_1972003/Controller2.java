/**
 * Ilman Nawali 1972003
 */
package com.example.uts_1972003;

import com.example.DAO.PlayerDAO;
import com.example.entity.Player;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller2 implements Initializable {
    public TextField txtId;
    public TextField txtNama;
    public TextField txtUmur;
    public TextField txtKeahlian;
    public TableView<Player> tablePemain;
    private ObservableList<Player> players;
    private Controller1 controller;
    public void setController (Controller1 controller){
        this.controller = controller;
    }

    public void btnOk(ActionEvent actionEvent) throws IOException {
        if (txtId.getText().isEmpty() || txtNama.getText().isEmpty() || txtUmur.getText().isEmpty() || txtKeahlian.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Field Masih Ada Yang Kosong");
            alert.showAndWait();
        } else {
            Player player = new Player();
            player.setId(Integer.valueOf(txtId.getText()));
            player.setNama(txtNama.getText());
            player.setUmur(Integer.valueOf(txtId.getText()));
            player.setKehlian(txtKeahlian.getText());
            PlayerDAO playerDAO = new PlayerDAO();
            playerDAO.addData(player);

            Stage new_stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SquidStage.fxml"));
            Parent root = fxmlLoader.load();
            Controller1 c2 = fxmlLoader.getController();
            c2.setController2(this);

            Scene new_scene = new Scene(root);
            new_stage.setScene(new_scene);
            new_stage.initModality(Modality.WINDOW_MODAL);

            new_stage.show();
            }
    }

    public void btnCancel(ActionEvent actionEvent) {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
